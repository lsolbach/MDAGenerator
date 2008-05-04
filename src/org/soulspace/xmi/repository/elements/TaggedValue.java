/*
 * Created on Feb 8, 2005
 */
package org.soulspace.xmi.repository.elements;


/**
 * @author soulman
 *
 */
public class TaggedValue extends NamedElement implements ITaggedValue {

  private String value;
  
  public TaggedValue() {
    super();
  }
    
  /* (non-Javadoc)
   * @see org.soulspace.xmi.uml.ITaggedValue#getValue()
   */
  public String getValue() {
    return value;
  }

  /**
   * @param value The value to set.
   */
  public void setValue(String value) {
    this.value = value;
  }

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((value == null) ? 0 : value.hashCode());
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
		final TaggedValue other = (TaggedValue) obj;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}
  
}
