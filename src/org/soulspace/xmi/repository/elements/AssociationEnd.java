/*
 * Created on Feb 9, 2005
 */
package org.soulspace.xmi.repository.elements;

import java.util.ArrayList;
import java.util.List;


/**
 * @author soulman
 *
 */
public class AssociationEnd extends Classifier implements IAssociationEnd {

  private boolean navigable;
  private String methodSuffix;
  private IClassifier type;
  private String visibility;
  private String changeability;
  private String aggregation;
  private String targetScope;
  private String ordering;
  private List<IAttribute> qualifiers = new ArrayList<IAttribute>();
  private IMultiplicity multiplicity;
  private IAssociation association;
  private IAssociationEnd sourceEnd;
  private boolean derived = false;
  
  /**
   * Consturctor
   */
  public AssociationEnd() {
    super();
  }
  
  /* (non-Javadoc)
   * @see org.soulspace.xmi.uml.IAssociationEnd#getType()
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
   * @see org.soulspace.xmi.uml.IAssociationEnd#isNavigatable()
   */
  public boolean isNavigable() {
    return navigable;
  }

  /**
   * @param isNavigatable The isNavigatable to set.
   */
  public void setNavigable(boolean isNavigable) {
    this.navigable = isNavigable;
  }
  
  public boolean isDerived() {
  	return derived;
  }
  
  public void setDerived(boolean derived) {
  	this.derived = derived;
  }

  /* (non-Javadoc)
   * @see org.soulspace.xmi.uml.IAssociationEnd#getMethodSuffix()
   */
  public String getMethodSuffix() {
    return methodSuffix;
  }
  
  public void setMethodSuffix(String methodSuffix) {
    this.methodSuffix = methodSuffix;
  }

  /* (non-Javadoc)
   * @see org.soulspace.xmi.uml.IAssociationEnd#getAggregation()
   */
  public String getAggregation() {
    return aggregation;
  }

  /**
   * @param aggregation The aggregation to set.
   */
  public void setAggregation(String aggregation) {
    this.aggregation = aggregation;
  }
  
  /* (non-Javadoc)
   * @see org.soulspace.xmi.uml.IAssociationEnd#getChangeability()
   */
  public String getChangeability() {
    return changeability;
  }

  /**
   * @param changeability The changeability to set.
   */
  public void setChangeability(String changeability) {
    this.changeability = changeability;
  }
  
  /* (non-Javadoc)
   * @see org.soulspace.xmi.uml.IAssociationEnd#getOrdering()
   */
  public String getOrdering() {
    return ordering;
  }

  /**
   * @param ordering The ordering to set.
   */
  public void setOrdering(String ordering) {
    this.ordering = ordering;
  }
  
  /* (non-Javadoc)
   * @see org.soulspace.xmi.uml.IAssociationEnd#getTargetScope()
   */
  public String getTargetScope() {
    return targetScope;
  }

  /**
   * @param targetScope The targetScope to set.
   */
  public void setTargetScope(String targetScope) {
    this.targetScope = targetScope;
  }
  
  /* (non-Javadoc)
   * @see org.soulspace.xmi.uml.IAssociationEnd#getVisibility()
   */
  public String getVisibility() {
    return visibility;
  }
  
  /**
   * @param visibility The visibility to set.
   */
  public void setVisibility(String visibility) {
    this.visibility = visibility;
  }

  /* (non-Javadoc)
   * @see org.soulspace.xmi.uml.IAssociationEnd#getMultiplicity()
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

	public IAssociationEnd getSourceEnd() {
		return sourceEnd;
	}

	public void setSourceEnd(IAssociationEnd sourceEnd) {
		this.sourceEnd = sourceEnd;
	}
	
  /*
   *  (non-Javadoc)
   * @see org.soulspace.xmi.repository.elements.IAssociationEnd#getAssociation()
   */
	public IAssociation getAssociation() {
		return association;
	}

	/**
	 * Set the association.
	 * @param association The association to set.
	 */
	public void setAssociation(IAssociation association) {
		this.association = association;
	}

	/**
	 * @return the qualifiers
	 */
	public List<IAttribute> getQualifiers() {
		return qualifiers;
	}

	/**
	 * @param qualifiers the qualifiers to set
	 */
	public void setQualifiers(List<IAttribute> qualifiers) {
		this.qualifiers = qualifiers;
	}
	
	/**
	 * 
	 * @param attribute the qualifier to add
	 */
	public void addQualifier(IAttribute attribute) {
		this.qualifiers.add(attribute);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((aggregation == null) ? 0 : aggregation.hashCode());
		result = prime * result
				+ ((association == null) ? 0 : association.hashCode());
		result = prime * result
				+ ((changeability == null) ? 0 : changeability.hashCode());
		result = prime * result + (derived ? 1231 : 1237);
		result = prime * result
				+ ((methodSuffix == null) ? 0 : methodSuffix.hashCode());
		result = prime * result
				+ ((multiplicity == null) ? 0 : multiplicity.hashCode());
		result = prime * result + (navigable ? 1231 : 1237);
		result = prime * result + ((ordering == null) ? 0 : ordering.hashCode());
		result = prime * result
				+ ((targetScope == null) ? 0 : targetScope.hashCode());
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
		final AssociationEnd other = (AssociationEnd) obj;
		if (aggregation == null) {
			if (other.aggregation != null)
				return false;
		} else if (!aggregation.equals(other.aggregation))
			return false;
		if (changeability == null) {
			if (other.changeability != null)
				return false;
		} else if (!changeability.equals(other.changeability))
			return false;
		if (derived != other.derived)
			return false;
		if (methodSuffix == null) {
			if (other.methodSuffix != null)
				return false;
		} else if (!methodSuffix.equals(other.methodSuffix))
			return false;
		if (multiplicity == null) {
			if (other.multiplicity != null)
				return false;
		} else if (!multiplicity.equals(other.multiplicity))
			return false;
		if (navigable != other.navigable)
			return false;
		if (ordering == null) {
			if (other.ordering != null)
				return false;
		} else if (!ordering.equals(other.ordering))
			return false;
		if (targetScope == null) {
			if (other.targetScope != null)
				return false;
		} else if (!targetScope.equals(other.targetScope))
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
