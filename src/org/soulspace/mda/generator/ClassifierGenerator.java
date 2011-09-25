/*
 * Created on Feb 21, 2005
 */
package org.soulspace.mda.generator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.oro.text.regex.MatchResult;
import org.apache.tools.ant.BuildException;
import org.soulspace.mdlrepo.metamodel.IClassifier;
import org.soulspace.mdlrepo.metamodel.IPackage;
import org.soulspace.template.TemplateEngine;
import org.soulspace.template.datasource.DataSource;
import org.soulspace.template.datasource.impl.BeanDataSourceImpl;
import org.soulspace.template.impl.TemplateEngineImpl;
import org.soulspace.template.util.RegExHelper;
import org.soulspace.template.util.StringHelper;
import org.soulspace.util.CollectionUtils;

/**
 * @author soulman Base class for ant generators
 * 
 */
public class ClassifierGenerator {

	protected GeneratorContext genContext;

	protected TemplateEngine engine;

	protected DataSource dataSource;

	protected Pattern pattern;

	/**
	 * Constructor
	 */
	public ClassifierGenerator() {
		super();
		genContext = new GeneratorContext();
	}

	public ClassifierGenerator(GeneratorContext genContext) {
		super();
		this.genContext = genContext;
	}

	public GeneratorContext getGeneratorContext() {
		return genContext;
	}

	public void getGeneratorContext(GeneratorContext genContext) {
		this.genContext = genContext;
	}

	public void setName(String name) {
		genContext.setName(name);
	}

	public void setBasename(String basename) {
		genContext.setBasename(basename);
	}

	public void setImports(String imports) {
		genContext.setImports(imports);
	}

	public void setSuffix(String suffix) {
		genContext.setSuffix(suffix);
	}

	public void setSubdir(String subdir) {
		genContext.setSubdir(subdir);
	}

	public void setExtension(String extension) {
		genContext.setExtension(extension);
	}

	public void setStereotype(String stereotype) {
		genContext.setStereotype(stereotype);
	}

	public void setNamespaceReplacement(String namespaceReplacement) {
		genContext.setNamespaceReplacement(namespaceReplacement);
	}

	public void setNamespacePrefix(String namespacePrefix) {
		genContext.setNamespacePrefix(namespacePrefix);
	}

	public void setNamespaceSuffix(String namespaceSuffix) {
		genContext.setNamespaceSuffix(namespaceSuffix);
	}

	public void setUseNameAsNamespace(boolean useNameAsNamespace) {
		genContext.setUseNameAsNamespace(useNameAsNamespace);
	}

	public void setPrefix(String prefix) {
		genContext.setPrefix(prefix);
	}

	public void setEncoding(String encoding) {
		genContext.setEncoding(encoding);
	}

	public void setGenerationFilterPattern(String generationFilterPattern) {
		genContext.setGenerationFilterPattern(generationFilterPattern);
		if (StringHelper.isSet(generationFilterPattern)) {
			pattern = Pattern.compile(generationFilterPattern, Pattern.DOTALL);
		}
	}

	public void setUserSection(String userSection) {
		genContext.setUserSection(userSection);
	}

	public void setNamespaceIncludes(String namespaceIncludes) {
		String[] nsIncludes = namespaceIncludes.split(",");
		genContext
				.setNamespaceIncludes(CollectionUtils.asArrayList(nsIncludes));
	}

	public void setNamespaceExcludes(String namespaceExcludes) {
		String[] nsExcludes = namespaceExcludes.split(",");
		genContext
				.setNamespaceExcludes(CollectionUtils.asArrayList(nsExcludes));
	}

	public void addConfiguredParam(Param param) {
		genContext.addParam(param);
	}

	public void setExcludeStereotypes(String excludeStereotypes) {
		String[] stereotypes = excludeStereotypes.split(",");
		genContext.setExcludeStereotypes(CollectionUtils
				.asArrayList(stereotypes));
	}

	public void setIncludeStereotypes(String includeStereotypes) {
		String[] stereotypes = includeStereotypes.split(",");
		genContext.setIncludeStereotypes(CollectionUtils
				.asArrayList(stereotypes));
	}

	/**
	 * @return Returns the TemplateEngine.
	 */
	public TemplateEngine getEngine(GenerationContext ctx) {
		File[] templateDirs;
		if (ctx.getTemplateDir() == null && ctx.getTemplateDirs() == null) {
			throw new GeneratorException("Template directory not set");
		} else if (ctx.getTemplateDirs() != null) {
			templateDirs = getTemplateDirs(ctx.getTemplateDirs());
		} else {
			templateDirs = new File[] { ctx.getTemplateDir() };
		}

		if (engine != null) {
			return engine;
		}

		engine = new TemplateEngineImpl();
		String[] importTemplateNames = null;
		String[] templates = null;

		try {
			if (isSet(genContext.getImports())) {
				importTemplateNames = genContext.getImports().split(",");
				templates = new String[importTemplateNames.length + 1];
				File[] templateFiles = new File[importTemplateNames.length + 1];
				for (int i = 0; i < importTemplateNames.length; i++) {
					templateFiles[i] = locateFile(templateDirs,
							importTemplateNames[i].trim(), ".tinc");
				}
				templateFiles[importTemplateNames.length] = locateFile(
						templateDirs, genContext.getName(), ".tmpl");
				engine.loadTemplates(templateFiles);
			} else {
				engine.loadTemplate(locateFile(templateDirs, genContext
						.getName(), ".tmpl"));
			}
		} catch (Exception e) {
			engine = null;
			System.err.println("Error creating a template engine for template " + genContext.getName());
			throw new RuntimeException(
					"Error creating a template engine for template "
							+ genContext.getName(), e);
		}

		return engine;
	}

	File[] getTemplateDirs(List<String> templateDirNames) {
		File[] templateDirs = new File[templateDirNames.size()];
		for (int i = 0; i < templateDirNames.size(); i++) {
			File file = new File(templateDirNames.get(i).trim());
			if (!file.exists() || !file.isDirectory()) {
				throw new RuntimeException("Error validating directory "
						+ templateDirNames.get(i));
			}
			templateDirs[i] = file;
		}
		return templateDirs;
	}

	File locateFile(File[] templateDirs, String basename, String extension) {
		for (File templateDir : templateDirs) {
			File file = new File(templateDir.getAbsolutePath() + "/" + basename
					+ extension);
			if (file.exists()) {
				return file;
			}
		}
		throw new RuntimeException("Error locating file " + basename
				+ extension);
	}

	/**
	 * Setter for the DataSource
	 * 
	 * @param ds
	 */
	public void setDataSource(BeanDataSourceImpl ds) {
		dataSource = ds;
	}

	boolean mustGenerate(IClassifier classifier) {
		return generateForNamespace(classifier)
				&& generateForStereotype(classifier)
				&& !checkForProfile(classifier);
	}

	boolean checkForProfile(IClassifier classifier) {
		return classifier.getProfileElement();
	}

	boolean generateForStereotype(IClassifier classifier) {
		if (!genContext.getExcludeStereotypes().isEmpty()) {
			for (String excStereotype : genContext.getExcludeStereotypes()) {
				if (classifier.getStereotypeMap().containsKey(
						excStereotype.trim())) {
					return false;
				}
			}
		}
		if (classifier.getStereotypes().contains("external")) {
			return false;
		}
		if (!isSet(genContext.getStereotype())) {
			return true;
		}
		String st = genContext.getStereotype();
		if (st.equals("NONE")) {
			if (classifier.getStereotypeMap().isEmpty()) {
				return true;
			} else {
				return false;
			}
		}
		if (st.equals("ALL")) {
			if (classifier.getStereotypeMap().isEmpty()) {
				return false;
			} else {
				return true;
			}
		}

		boolean generate = false;
		String[] incStereotypes = genContext.getStereotype().split(",");
		for (String incStereotype : incStereotypes) {
			if (classifier.getStereotypeMap().containsKey(incStereotype.trim())) {
				generate = true;
			}
		}

		return generate;
	}

	boolean generateForNamespace(IClassifier classifier) {
		boolean generate = false;
		String namespace = "";
		if(genContext.getUseNameAsNamespace()) {
			namespace = classifier.getQualifiedName();
		} else {
			namespace = classifier.getNamespace();
		}
		if (!namespace.startsWith("java")) {
			generate = true;
		}
		if (genContext.getNamespaceExcludes().size() > 0) {
			for (String ns : genContext.getNamespaceExcludes()) {
				if (namespace.startsWith(ns.trim())) {
					generate = false;
				}
			}
		}
		if (genContext.getNamespaceIncludes().size() > 0) {
			for (String ns : genContext.getNamespaceIncludes()) {
				if (namespace.startsWith(ns.trim())) {
					generate = true;
				}
			}
		}
		return generate;
	}

	public void generate(GenerationContext ctx, IClassifier classifier) {
		generate(ctx, classifier, null);
	}
	
	/**
	 * 
	 * @param gt
	 * @param classifier
	 */
	public void generate(GenerationContext ctx, IClassifier classifier, BeanDataSourceImpl ds) {
		if (!mustGenerate(classifier)) {
			// no generation needed
			return;
		}
		String output;
		Map<String, String> userSections = null;
		// dataSource = ctx.getDataSource();

		engine = getEngine(ctx);
		BeanDataSourceImpl myDS;
		// TODO fix exception handling?
		if(ds != null) {
			myDS = new BeanDataSourceImpl(classifier, ds);
		} else {
			myDS = new BeanDataSourceImpl(classifier);			
		}
		if (isSet(genContext.getUserSection())) {
			userSections = readUserSections(getPath(ctx, classifier, true));
			myDS.add("USERSECTIONS", userSections);
		}
		try {
			myDS.add("GenContext", genContext);

			output = engine.generate(myDS);

			if (acceptWrite(output)) {
				createPackagePath(ctx, classifier);
				writeFile(getPath(ctx, classifier, false), output);
			}
		} catch (Exception e) {
			System.err.println("Exception while processing template "
					+ genContext.getName() + " for classifier "
					+ classifier.getName() + "!");
			throw new RuntimeException("Exception while processing template "
					+ genContext.getName() + " for classifier "
					+ classifier.getName() + "!", e);
		}
	}

	protected void createPackagePath(String path) {
		File file = new File(path);
		if (!file.exists()) {
			file.mkdirs();
		}
	}

	// FIXME refactor to use JavaUtils instead of TemplateEngine StringHelper
	protected void createPackagePath(GenerationContext ctx,
			IClassifier classifier) {
		StringBuilder sb = new StringBuilder();
		if (ctx.getDestDir() != null) {
			sb.append(ctx.getDestDir().getAbsolutePath() + File.separator);
		}
		if (StringHelper.isSet(genContext.getSubdir())) {
			sb.append(genContext.getSubdir() + File.separatorChar);
		}

		if (StringHelper.isSet(genContext.getNamespaceReplacement())) {
			sb.append(genContext.getNamespaceReplacement().replace('.',
					File.separatorChar)
					+ File.separatorChar);
		} else {
			if (StringHelper.isSet(genContext.getNamespacePrefix())) {
				sb.append(genContext.getNamespacePrefix().replace('.',
						File.separatorChar)
						+ File.separatorChar);
			}
			sb.append(classifier.getNamespace()
					.replace('.', File.separatorChar)
					+ File.separatorChar);
			if (classifier instanceof IPackage
					&& genContext.getUseNameAsNamespace()) {
				sb.append(classifier.getName().replace('.', File.separatorChar)
						+ File.separatorChar);
			}
			if (StringHelper.isSet(genContext.getNamespaceSuffix())) {
				sb.append(genContext.getNamespaceSuffix().replace('.',
						File.separatorChar)
						+ File.separatorChar);
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

	protected String getPath(GenerationContext ctx, IClassifier cf,
			boolean backup) {
		StringBuilder sb = new StringBuilder();

		if (!backup) {
			if (ctx.getDestDir() != null) {
				sb.append(ctx.getDestDir().getAbsolutePath() + File.separator);
			}
		} else {
			if (ctx.getBackupDir() != null) {
				sb
						.append(ctx.getBackupDir().getAbsolutePath()
								+ File.separator);
			}
		}
		if (StringHelper.isSet(genContext.getSubdir())) {
			sb.append(genContext.getSubdir() + File.separatorChar);
		}

		if (StringHelper.isSet(genContext.getNamespaceReplacement())) {
			sb.append(genContext.getNamespaceReplacement().replace('.',
					File.separatorChar)
					+ File.separatorChar);
		} else {
			if (StringHelper.isSet(genContext.getNamespacePrefix())) {
				sb.append(genContext.getNamespacePrefix().replace('.',
						File.separatorChar)
						+ File.separatorChar);
			}
			sb.append(cf.getNamespace().replace('.', File.separatorChar)
					+ File.separatorChar);
			if (cf instanceof IPackage && genContext.getUseNameAsNamespace()) {
				sb.append(cf.getName().replace('.', File.separatorChar)
						+ File.separatorChar);
			}
			if (StringHelper.isSet(genContext.getNamespaceSuffix())) {
				sb.append(genContext.getNamespaceSuffix().replace('.',
						File.separatorChar)
						+ File.separatorChar);
			}
		}

		if (StringHelper.isSet(genContext.getPrefix())) {
			sb.append(genContext.getPrefix());
		}
		if (!StringHelper.isSet(genContext.getBasename())) {
			sb.append(cf.getName());
		} else {
			sb.append(genContext.getBasename());
		}
		if (StringHelper.isSet(genContext.getSuffix())) {
			sb.append(genContext.getSuffix());
		}

		if (StringHelper.isSet(genContext.getExtension())) {
			sb.append(".");
			sb.append(genContext.getExtension());
		}

		return sb.toString();
	}

	protected boolean writeFile(String filename, String content) {
		File file = new File(filename);
		PrintWriter pw;
		try {
			pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(
					file), genContext.getEncoding()));
			pw.print(content);
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
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
				if ((result = RegExHelper.match(line, "^.*"
						+ genContext.getUserSection() + "-BEGIN\\((.*)\\).*$")) != null) {
					name = result.group(1);
					sb = new StringBuffer(64);
				} else if ((result = RegExHelper.match(line, "^.*"
						+ genContext.getUserSection() + "-END\\(" + name
						+ "\\).*$")) != null) {
					userSections.put(name, sb.toString());
					sb = null;
					name = "";
				} else if (sb != null) { // ) {
					sb.append(line + "\n");
				}
			}
		} catch (IOException e) {
			System.err.println("Error parsing user sections on file "
					+ filename);
			throw new RuntimeException("Error parsing user sections on file "
					+ filename, e);
		}

		return userSections;
	}

	boolean isSet(String s) {
		if (s == null || s.equals("")) {
			return false;
		}
		return true;
	}

	protected boolean acceptWrite(String generated) {
		if (pattern == null) {
			return true;
		}
		Matcher matcher = pattern.matcher(generated);
		return !matcher.matches();
	}

}