/*
 * Classifier.java
 */
package org.soulspace.xmi.repository.elements;

import org.soulspace.xmi.util.XmiHelper;

/**
 * Base class for Classifiers
 * 
 * @author Solbach (Last update: $Author$, $Date$)
 * @version $Revision$
 */
/**
 * @author soulman
 *  
 */
public class Classifier extends NamedElement implements IClassifier {

  protected String qualifiedName = "";;

  /**
   * @param id
   */
  public Classifier() {
    super();
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.soulspace.xmi.uml.IClassifier#setName(java.lang.String)
   */
  public void setName(String name) {
    super.setName(name);
    if (XmiHelper.isSet(getNamespace())) {
      qualifiedName = getNamespace() + "." + name;
    } else {
      qualifiedName = name;
    }
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.soulspace.xmi.uml.IClassifier#getQualifiedName()
   */
  public String getQualifiedName() {
    return qualifiedName;
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.soulspace.xmi.uml.IClassifier#setQualifiedName()
   */
  public void setQualifiedName(String qualifiedName) {
    this.qualifiedName = qualifiedName;
  }

  public String getQualifiedNameAsPath() {
  	if(qualifiedName != null) {
  		return qualifiedName.replace('.', '/');
  	}
  	return "";
  }

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((qualifiedName == null) ? 0 : qualifiedName.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		final Classifier other = (Classifier) obj;
		if (qualifiedName == null) {
			if (other.qualifiedName != null)
				return false;
		} else if (!qualifiedName.equals(other.qualifiedName))
			return false;
		return true;
	}
  
}