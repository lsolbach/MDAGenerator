/*
 * Created on Jan 12, 2005
 */
package org.soulspace.mdlrepo.metamodel.impl;

import java.util.List;

import org.soulspace.mdlrepo.metamodel.IAttribute;
import org.soulspace.mdlrepo.metamodel.IClassifier;
import org.soulspace.mdlrepo.metamodel.IMultiplicity;
import org.soulspace.mdlrepo.metamodel.IStereotype;


/**
 * @author soulman
 *
 */
public class Attribute extends Classifier implements IAttribute {

  private IClassifier type;
  private String visibility;
  private String changeability;
  private String ownerScope;
  private IMultiplicity multiplicity;
  private boolean derived = false;
  
  public Attribute() {
    super();
  }
  
  /**
   * @param typeClass The typeClass to set.
   */
  public void setType(IClassifier type) {
    this.type = type;
  }
  
  /**
   * @return Returns the changeability.
   */
  public String getChangeability() {
    return changeability;
  }

  /**
   * @return Returns the ownerScope.
   */
  public String getOwnerScope() {
    return ownerScope;
  }

  /**
   * @return Returns the type.
   */
  public IClassifier getType() {
    return type;
  }
  
  /**
   * @return Returns the visibility.
   */
  public String getVisibility() {
    return visibility;
  }
  
  public String toString() {
    return getQualifiedName();
  }

  /**
   * @param changeability The changeability to set.
   */
  public void setChangeability(String changeability) {
    this.changeability = changeability;
  }

  /**
   * @param ownerScope The ownerScope to set.
   */
  public void setOwnerScope(String ownerScope) {
    this.ownerScope = ownerScope;
  }

  /**
   * @param visibility The visibility to set.
   */
  public void setVisibility(String visibility) {
    this.visibility = visibility;
  }
  
  /* (non-Javadoc)
   * @see org.soulspace.xmi.repository.IAttribute#getMultiplicity()
   */
  public IMultiplicity getMultiplicity() {
   return multiplicity;
  }

  /**
   * @param multiplicity The multiplicity to set.
   */
  public void setMultiplicity(IMultiplicity multiplicity) {
    this.multiplicity = multiplicity;
  }
  
  public boolean isDerived() {
  	return derived;
  }
  
  public void setDerived(boolean derived) {
  	this.derived = derived;
  }

	public boolean checkOverloaded(IAttribute a) {
    if(a == null)
      return false;
    if(!getName().equals(a.getName()))
      return false;
    if(!changeability.equals(a.getChangeability()))
      return false;
    if(!visibility.equals(a.getVisibility()))
      return false;
    if(!ownerScope.equals(a.getOwnerScope()))
      return false;
    if(!type.equals(a.getType()))
      return false;

    return true;    
  }

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((changeability == null) ? 0 : changeability.hashCode());
		result = prime * result + (derived ? 1231 : 1237);
		result = prime * result
				+ ((multiplicity == null) ? 0 : multiplicity.hashCode());
		result = prime * result
				+ ((ownerScope == null) ? 0 : ownerScope.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result
				+ ((visibility == null) ? 0 : visibility.hashCode());
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
		final Attribute other = (Attribute) obj;
		if (changeability == null) {
			if (other.changeability != null)
				return false;
		} else if (!changeability.equals(other.changeability))
			return false;
		if (derived != other.derived)
			return false;
		if (multiplicity == null) {
			if (other.multiplicity != null)
				return false;
		} else if (!multiplicity.equals(other.multiplicity))
			return false;
		if (ownerScope == null) {
			if (other.ownerScope != null)
				return false;
		} else if (!ownerScope.equals(other.ownerScope))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (visibility == null) {
			if (other.visibility != null)
				return false;
		} else if (!visibility.equals(other.visibility))
			return false;
		return true;
	}
  
}
