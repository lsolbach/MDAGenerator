package org.soulspace.mda.generator.ant;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GeneratorContext {

	private Date timestamp = new Date();
	
	private String name = "";

  private String basename = "";

  private String imports = "";
  
  private String prefix = "";
  
  private String suffix = "";

  private String extension = "";

  private String stereotype = "";

  private String subdir = "";

  private String namespaceReplacement = "";

  private String namespacePrefix = "";

  private String namespaceSuffix = "";

  private List<String> namespaceIncludes = new ArrayList<String>();
  
  private List<String> namespaceExcludes = new ArrayList<String>();
  
  private Map<String, String> paramMap = new HashMap<String, String>();
  
  /**
   * @return Returns the name.
   */
  public String getName() {
    return name;
  }

  /**
   * @param name
   *          The name to set.
   */
  public void setName(String name) {
    this.name = name;
  }

	/**
	 * @return the basename
	 */
	public String getBasename() {
		return basename;
	}

	/**
	 * @param basename the basename to set
	 */
	public void setBasename(String basename) {
		this.basename = basename;
	}

  /**
   * 
   * @return
   */
  public String getImports() {
		return imports;
	}

  /**
   * 
   * @param imports
   */
	public void setImports(String imports) {
		this.imports = imports;
	}

  /**
   * @return Returns the suffix.
   */
  public String getSuffix() {
    return suffix;
  }

  /**
   * @param suffix
   *          The suffix to set.
   */
  public void setSuffix(String suffix) {
    this.suffix = suffix;
  }

  /**
   * @return Returns the extension.
   */
  public String getExtension() {
    return extension;
  }

  /**
   * @param extension
   *          The extension to set.
   */
  public void setExtension(String extension) {
    this.extension = extension;
  }

  /**
   * 
   * @return
   */
  public String getStereotype() {
    return stereotype;
  }
  
  /**
   * 
   * @param stereotype
   */
  public void setStereotype(String stereotype) {
    this.stereotype = stereotype;
  }
  
  /**
	 * @return the subdir
	 */
	public String getSubdir() {
		return subdir;
	}

	/**
	 * @param subdir the subdir to set
	 */
	public void setSubdir(String subdir) {
		this.subdir = subdir;
	}

	/**
   * @return Returns the namespaceReplacement.
   */
  public String getNamespaceReplacement() {
    return namespaceReplacement;
  }

  /**
   * @param namespaceReplacement The namespaceReplacement to set.
   */
  public void setNamespaceReplacement(String namespaceReplacement) {
    this.namespaceReplacement = namespaceReplacement;
  }
  
  /**
   * @return Returns the namespacePrefix.
   */
  public String getNamespacePrefix() {
    return namespacePrefix;
  }

  /**
   * @param namespacePrefix The namespacePrefix to set.
   */
  public void setNamespacePrefix(String namespacePrefix) {
    this.namespacePrefix = namespacePrefix;
  }

  /**
   * @return Returns the namespaceSuffix.
   */
  public String getNamespaceSuffix() {
    return namespaceSuffix;
  }

  /**
   * @param namespaceSuffix The namespaceSuffix to set.
   */
  public void setNamespaceSuffix(String namespaceSuffix) {
    this.namespaceSuffix = namespaceSuffix;
  }

  /**
   * @return Returns the prefix.
   */
  public String getPrefix() {
    return prefix;
  }

  /**
   * @param prefix The prefix to set.
   */
  public void setPrefix(String prefix) {
    this.prefix = prefix;
  }

	/**
	 * @return the timestamp
	 */
	public String getTimestamp() {
		return timestamp.toString();
	}

	/**
	 * @return the symbols
	 */
	public Map<String, String> getParamMap() {
		return paramMap;
	}

	/**
	 * @param symbols the symbols to set
	 */
	public void setParamMap(Map<String, String> paramMap) {
		this.paramMap = paramMap;
	}

	public void addParam(Param param) {
		paramMap.put(param.getName(), param.getValue());
	}

	/**
	 * @return the namespaceIncludes
	 */
	public List<String> getNamespaceIncludes() {
		return namespaceIncludes;
	}

	/**
	 * @param namespaceIncludes the namespaceIncludes to set
	 */
	public void setNamespaceIncludes(List<String> namespaceIncludes) {
		this.namespaceIncludes = namespaceIncludes;
	}

	/**
	 * @return the namespaceExcludes
	 */
	public List<String> getNamespaceExcludes() {
		return namespaceExcludes;
	}

	/**
	 * @param namespaceExcludes the namespaceExcludes to set
	 */
	public void setNamespaceExcludes(List<String> namespaceExcludes) {
		this.namespaceExcludes = namespaceExcludes;
	}

}
