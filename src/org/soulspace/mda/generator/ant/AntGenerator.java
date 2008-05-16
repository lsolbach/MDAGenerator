/*
 * Created on Feb 21, 2005
 */
package org.soulspace.mda.generator.ant;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.oro.text.regex.MatchResult;
import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.util.FileUtils;
import org.soulspace.template.TemplateEngine;
import org.soulspace.template.datasource.impl.BeanDataSource;
import org.soulspace.template.impl.TemplateEngineImpl;
import org.soulspace.template.util.RegExHelper;
import org.soulspace.template.util.StringHelper;
import org.soulspace.util.CollectionUtils;
import org.soulspace.xmi.repository.elements.IClassifier;

/**
 * @author soulman
 * Base class for ant generators
 * 
 */
public abstract class AntGenerator {

	private GeneratorContext genContext;

	protected TemplateEngine engine;

  protected BeanDataSource dataSource;
  
  /**
   * Constructor
   */
  public AntGenerator() {
    super();
    genContext = new GeneratorContext();
  }

  public GeneratorContext getGeneratorContext() {
		return genContext;
	}
  
  /**
   * @return Returns the name.
   */
  public String getName() {
    return genContext.getName();
  }

  /**
   * @param name
   *          The name to set.
   */
  public void setName(String name) {
  	genContext.setName(name);
  }

	/**
	 * @return the basename
	 */
	public String getBasename() {
		return genContext.getBasename();
	}

	/**
	 * @param basename the basename to set
	 */
	public void setBasename(String basename) {
		genContext.setBasename(basename);
	}

  /**
   * 
   * @return
   */
  public String getImports() {
		return genContext.getImports();
	}

  /**
   * 
   * @param imports
   */
	public void setImports(String imports) {
		genContext.setImports(imports);
	}

  /**
   * @return Returns the suffix.
   */
  public String getSuffix() {
    return genContext.getSuffix();
  }

  /**
   * @param suffix
   *          The suffix to set.
   */
  public void setSuffix(String suffix) {
    genContext.setSuffix(suffix);
  }

  /**
   * @return Returns the extension.
   */
  public String getExtension() {
    return genContext.getExtension();
  }

  /**
   * @param extension
   *          The extension to set.
   */
  public void setExtension(String extension) {
    genContext.setExtension(extension);
  }

  /**
   * 
   * @return
   */
  public String getStereotype() {
    return genContext.getStereotype();
  }
  
  /**
   * 
   * @param stereotype
   */
  public void setStereotype(String stereotype) {
    genContext.setStereotype(stereotype);
  }
  
  /**
   * @return Returns the namespaceReplacement.
   */
  public String getNamespaceReplacement() {
    return genContext.getNamespaceReplacement();
  }

  /**
   * @param namespaceReplacement The namespaceReplacement to set.
   */
  public void setNamespaceReplacement(String namespaceReplacement) {
    genContext.setNamespaceReplacement(namespaceReplacement);
  }
  
  /**
   * @return Returns the namespacePrefix.
   */
  public String getNamespacePrefix() {
    return genContext.getNamespacePrefix();
  }

  /**
   * @param namespacePrefix The namespacePrefix to set.
   */
  public void setNamespacePrefix(String namespacePrefix) {
    genContext.setNamespacePrefix(namespacePrefix);
  }

  /**
   * @return Returns the namespaceSuffix.
   */
  public String getNamespaceSuffix() {
    return genContext.getNamespaceSuffix();
  }

  /**
   * @param namespaceSuffix The namespaceSuffix to set.
   */
  public void setNamespaceSuffix(String namespaceSuffix) {
    genContext.setNamespaceSuffix(namespaceSuffix);
  }

  /**
   * @return Returns the prefix.
   */
  public String getPrefix() {
    return genContext.getPrefix();
  }

  /**
   * @param prefix The prefix to set.
   */
  public void setPrefix(String prefix) {
    genContext.setPrefix(prefix);
  }

  
  public void setNamespaceIncludes(String namespaceIncludes) {
  	String[] nsIncludes = namespaceIncludes.split(",");
  	genContext.setNamespaceIncludes(CollectionUtils.asArrayList(nsIncludes));
  }
  
  public void setNamespaceExcludes(String namespaceExcludes) {
  	String[] nsExcludes = namespaceExcludes.split(",");
  	genContext.setNamespaceExcludes(CollectionUtils.asArrayList(nsExcludes));  	
  }
  
  public void addConfiguredParam(Param param) {
  	genContext.addParam(param);
  	System.out.println("Adding symbol " + param.getName() + ", value " + param.getValue());;
  }
  
  /**
   * @return Returns the TemplateEngine.
   */
  public TemplateEngine getEngine(File templateDir) {
    if(templateDir == null) {
      throw new BuildException("Template directory not set");
    }

	  if (engine != null) {
	  	return engine;
	  }
	  
    engine = new TemplateEngineImpl();
    String[] importTemplateNames = null;
    String[] templates = null;
    try {
		  if(isSet(genContext.getImports())) {
		  	importTemplateNames = genContext.getImports().split(",");
		  	templates = new String[importTemplateNames.length + 1];
		  	for (int i = 0; i < importTemplateNames.length; i++) {
		      String template = FileUtils.readFully(new FileReader(templateDir
		          .getAbsolutePath()
		          + "/" + importTemplateNames[i] + ".tinc"));
		      templates[i] = template;
				}
			  String template = FileUtils.readFully(new FileReader(templateDir
			      .getAbsolutePath()
			      + "/" + genContext.getName() + ".tmpl"));
			  templates[importTemplateNames.length] = template;
		    engine.loadTemplates(templates);
		  } else {
			  String template = FileUtils.readFully(new FileReader(templateDir
			      .getAbsolutePath()
			      + "/" + genContext.getName() + ".tmpl"));
		    engine.loadTemplate(template);		  	
		  }
    } catch (Exception e) {
      engine = null;
      throw new BuildException(e);
    }

    return engine;
  }

  /**
   * Setter for the DataSource
   * @param ds
   */
  public void setDataSource(BeanDataSource ds) {
    dataSource = ds;
  }

  boolean generateForStereotype(IClassifier classifier) {
  	boolean generate = false;
  	
  	if (classifier.getStereotypes().contains("external")) {
      generate = false;
    }
  	
  	if(isSet(genContext.getStereotype())) {
  		String[] incStereotypes = genContext.getStereotype().split(",");
    	for (String incStereotype : incStereotypes) {
    		if(classifier.getStereotypeMap().containsKey(incStereotype)) {
    			generate = true;    			
    		}
  		}
  	} else {
  		generate = true;
  	}
  	return generate;
  }
  
  boolean generateForNamespace(IClassifier classifier) {
  	boolean generate = false;
  	if(genContext.getNamespaceIncludes().size() == 0
  			&& genContext.getNamespaceExcludes().size() == 0
  			&& !classifier.getNamespace().startsWith("java")) {
  		generate = true;
  	}
  	if(genContext.getNamespaceIncludes().size() > 0) {
  		for(String namespace : genContext.getNamespaceIncludes()) {
  			if(classifier.getNamespace().startsWith(namespace)) {
  				generate = true;
  			}
  		}
  	}
  	if(genContext.getNamespaceExcludes().size() > 0) {
  		for(String namespace : genContext.getNamespaceExcludes()) {
  			if(classifier.getNamespace().startsWith(namespace)) {
  				generate = false;
  			}
  		}
  	}
  	return generate;
  }
  
  /**
   * 
   * @param gt
   * @param classifier
   */
  public void generate(MdaGeneratorTask gt, IClassifier classifier) {
  	if(!generateForNamespace(classifier) || !generateForStereotype(classifier)) {
  		// no generation needed
  		return;
  	}
    String output;
    Map<String, String> userSections = null;
    File templateDir = gt.getTemplateDir();
    dataSource = gt.getDataSource();

    engine = getEngine(templateDir);

    // TODO fix exception handling?
    try {
      userSections = readUserSections(getPath(gt, classifier, true));
      BeanDataSource myDS = new BeanDataSource(classifier);
      myDS.add("GenContext", genContext);
      myDS.add("USERSECTIONS", userSections);

      output = engine.generate(myDS);
      createPackagePath(gt, classifier);
      writeFile(getPath(gt, classifier, false), output);
    } catch (Exception e1) {
      System.out.println("Exception while processing template " + genContext.getName() + "!");
      e1.printStackTrace();
    }
  }

  protected void createPackagePath(String path) {
    File file = new File(path);
    if (!file.exists()) {
      file.mkdirs();
    }
  }

//FIXME refactor to use JavaUtils instead of TemplateEngine StringHelper

  protected void createPackagePath(MdaGeneratorTask gt, IClassifier classifier) {
    StringBuilder sb = new StringBuilder();
    if (gt.getDestDir() != null) {
      sb.append(gt.getDestDir().getAbsolutePath() + File.separator);
    }
    if(genContext.getSubdir() != null) {
    	sb.append(genContext.getSubdir() + File.separatorChar);
    }
    
    if(StringHelper.isSet(genContext.getNamespaceReplacement())) {
      sb.append(genContext.getNamespaceReplacement().replace('.', File.separatorChar) + File.separatorChar);    	
    } else {
      if(StringHelper.isSet(genContext.getNamespacePrefix())) {
        sb.append(genContext.getNamespacePrefix() + File.separatorChar);
      }
      sb.append(classifier.getNamespace().replace('.', File.separatorChar) + File.separatorChar);
      if(StringHelper.isSet(genContext.getNamespaceSuffix())) {
        sb.append(genContext.getNamespaceSuffix() + File.separatorChar);
      }      
    }
    
  	File file = new File(sb.toString());
    if (!file.exists()) {
      file.mkdirs();
    }
  }

  protected String getPath(String prefix, String filename, String suffix,
      String extension) {
    StringBuilder sb = new StringBuilder();
    if (filename == null) {
      throw new BuildException("no filename set!");
    }

    if (prefix != null) {
      sb.append(prefix + File.separator);
    }
    sb.append(filename.replace('.', File.separatorChar));

    if (suffix != null) {
      sb.append(suffix);
    }

    if (extension != null) {
      sb.append(extension);
    }
    return sb.toString();
  }

  protected String getPath(File prefix, String filename, String suffix,
      String extension) {
    StringBuilder sb = new StringBuilder();
    if (filename == null) {
      throw new BuildException("no filename set!");
    }

    if (prefix != null) {
      sb.append(prefix.getAbsolutePath() + File.separator);
    }
    sb.append(filename.replace('.', File.separatorChar));

    if (suffix != null) {
      sb.append(suffix);
    }

    if (extension != null) {
      sb.append(extension);
    }
    return sb.toString();
  }

  protected String getPath(MdaGeneratorTask gt, IClassifier cf, boolean backup) {
    StringBuilder sb = new StringBuilder();

    if(!backup) {
    	if (gt.getDestDir() != null) {
    		sb.append(gt.getDestDir().getAbsolutePath() + File.separator);
    	}
    } else {
    	if (gt.getBackupDir() != null) {
    		sb.append(gt.getBackupDir().getAbsolutePath() + File.separator);
    	}    	
    }
    if(genContext.getSubdir() != null) {
    	sb.append(genContext.getSubdir() + File.separatorChar);
    }

    if(StringHelper.isSet(genContext.getNamespaceReplacement())) {
      sb.append(genContext.getNamespaceReplacement().replace('.', File.separatorChar) + File.separatorChar);    	
    } else {
      if(StringHelper.isSet(genContext.getNamespacePrefix())) {
        sb.append(genContext.getNamespacePrefix() + File.separatorChar);
      }
      sb.append(cf.getNamespace().replace('.', File.separatorChar) + File.separatorChar);
      if(StringHelper.isSet(genContext.getNamespaceSuffix())) {
        sb.append(genContext.getNamespaceSuffix() + File.separatorChar);
      }      
    }
    
    if(StringHelper.isSet(genContext.getPrefix())) {
      sb.append(genContext.getPrefix());
    }
    if(!StringHelper.isSet(genContext.getBasename())) {
      sb.append(cf.getName());    	
    } else {
    	sb.append(genContext.getBasename());
    }
    if(StringHelper.isSet(genContext.getSuffix())) {
      sb.append(genContext.getSuffix());
    }
    
    if(StringHelper.isSet(genContext.getExtension())) {
      sb.append(".");
      sb.append(genContext.getExtension());
    }

    return sb.toString();
  }
  
  protected boolean writeFile(String filename, String content) {
    File file = new File(filename);
    PrintWriter pw;
    try {
      pw = new PrintWriter(new FileOutputStream(file));
      pw.print(content);
      pw.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

    return true;
  }

  protected Map<String, String> readUserSections(String filename) {
    Map<String, String> userSections = new HashMap<String, String>();
    String line = null;
    String name = "";
    MatchResult result = null;

    BufferedReader in = null;
    try {
      in = new BufferedReader(new FileReader(filename));
    } catch (FileNotFoundException e) {
      System.out.println("File " + filename + " not found.");
      return userSections;
    }

    try {
      StringBuffer sb = null;
      while ((line = in.readLine()) != null) {
        // match user section
        if ((result = RegExHelper.match(line, "^.*USER-BEGIN\\((.*)\\)$")) != null) {
          name = result.group(1);
          sb = new StringBuffer(64);
        } else if ((result = RegExHelper.match(line, "^.*USER-END\\(" + name
            + "\\)$")) != null) {
          userSections.put(name, sb.toString() + "\n");
          name = "";
        } else if (!name.equals("")) {
          sb.append(line);
        }
      }
    } catch (IOException e1) {
      e1.printStackTrace();
    }

    return userSections;
  }

  boolean isSet(String s) {
    if(s == null || s.equals("")) {
      return false;
    }
    return true;
  }
  
}