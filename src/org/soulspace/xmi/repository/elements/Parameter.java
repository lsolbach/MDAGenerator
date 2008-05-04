/*
 * Created on Feb 12, 2005
 */
package org.soulspace.xmi.repository.elements;


/**
 * @author soulman
 *
 */
public class Parameter extends Classifier implements IParameter {

  private IClassifier type;
  private String kind;
  
  /**
   * 
   */
  public Parameter() {
    super();
  }

  /* (non-Javadoc)
   * @see org.soulspace.xmi.uml.IParameter#getType()
   */
  public IClassifier getType() {
    return type;
  }

  /**
   * @param type The type to set.
   */
  public void setType(IClassifier type) {
    this.type = type;
  }

  /* (non-Javadoc)
   * @see org.soulspace.xmi.uml.IParameter#getKind()
   */
  public String getKind() {
    return kind;
  }
  
  /**
   * @param kind The kind to set.
   */
  public void setKind(String kind) {
    this.kind = kind;
  }

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((kind == null) ? 0 : kind.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		final Parameter other = (Parameter) obj;
		if (kind == null) {
			if (other.kind != null)
				return false;
		} else if (!kind.equals(other.kind))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
  
}
