/*
 * Created on Feb 8, 2005
 */
package org.soulspace.xmi.repository.elements;


/**
 * @author soulman
 *
 */
public class TagDefinition extends NamedElement implements ITagDefinition {

  private int multiplicityLow = 1;
  private int multiplicityHigh = 1;
  
  public TagDefinition() {
    super();
  }
  
  /* (non-Javadoc)
   * @see org.soulspace.xmi.uml.ITagDefinition#getMultiplicityLow()
   */
  public int getMultiplicityLow() {
    return multiplicityLow;
  }

  /**
   * @param multiplicityLow The multiplicityLow to set.
   */
  public void setMultiplicityLow(int multiplicityLow) {
    this.multiplicityLow = multiplicityLow;
  }
  
  /* (non-Javadoc)
   * @see org.soulspace.xmi.uml.ITagDefinition#getMultiplicityHigh()
   */
  public int getMultiplicityHigh() {
    return multiplicityHigh;
  }

  /**
   * @param multiplicityHigh The multiplicityHigh to set.
   */
  public void setMultiplicityHigh(int multiplicityHigh) {
    this.multiplicityHigh = multiplicityHigh;
  }

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + multiplicityHigh;
		result = prime * result + multiplicityLow;
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
		final TagDefinition other = (TagDefinition) obj;
		if (multiplicityHigh != other.multiplicityHigh)
			return false;
		if (multiplicityLow != other.multiplicityLow)
			return false;
		return true;
	}
  
  
}
