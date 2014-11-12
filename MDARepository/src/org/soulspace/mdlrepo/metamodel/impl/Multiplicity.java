/*
 * Created on Feb 9, 2005
 */
package org.soulspace.mdlrepo.metamodel.impl;

import org.soulspace.mdlrepo.metamodel.IMultiplicity;


/**
 * @author soulman
 *
 */
public class Multiplicity extends Element implements IMultiplicity {

  private String low;
  private String high;
  
  /* (non-Javadoc)
   * @see org.soulspace.xmi.uml.IMultiplicity#getMultiplicityLow()
   */
  public String getLow() {
    return low;
  }

  /**
   * @param low The low to set.
   */
  public void setLow(String low) {
    this.low = low;
  }
  
  /* (non-Javadoc)
   * @see org.soulspace.xmi.uml.IMultiplicity#getMultiplicityHigh()
   */
  public String getHigh() {
    return high;
  }

  /**
   * @param high The high to set.
   */
  public void setHigh(String high) {
    this.high = high;
  }

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((high == null) ? 0 : high.hashCode());
		result = prime * result + ((low == null) ? 0 : low.hashCode());
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
		final Multiplicity other = (Multiplicity) obj;
		if (high == null) {
			if (other.high != null)
				return false;
		} else if (!high.equals(other.high))
			return false;
		if (low == null) {
			if (other.low != null)
				return false;
		} else if (!low.equals(other.low))
			return false;
		return true;
	}
  
}
