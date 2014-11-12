/*
 * Created on Nov 21, 2004
 */
package org.soulspace.mdlrepo.metamodel.impl;

import org.soulspace.mdlrepo.metamodel.IAssociation;
import org.soulspace.mdlrepo.metamodel.IAssociationEnd;
import org.soulspace.mdlrepo.metamodel.IClassifier;



/**
 * @author soulman
 *
 */
public class Association extends Classifier implements IAssociation {

  private String fromRole = "";
  private String toRole = "";
  private boolean fromNavigable = false;
  private boolean toNavigable = false;

  // TODO reference Classifier or AssociationEnd? (AssociationEnd seems more plausible, the classifier is in ae.type)
  private IClassifier from;
  private IClassifier to;
  private IAssociationEnd fromEnd;
  private IAssociationEnd toEnd;

  
  /**
   * Constructor
   */
  public Association() {
    super();
  }

	/**
	 * @return Returns the from.
	 */
	public IClassifier getFrom() {
		return from;
	}

	/**
	 * @param from The from to set.
	 */
	public void setFrom(IClassifier from) {
		this.from = from;
	}

	/**
	 * @return Returns the fromNavigable.
	 */
	public boolean getFromNavigable() {
		return fromNavigable;
	}

	/**
	 * @param fromNavigable The fromNavigable to set.
	 */
	public void setFromNavigable(boolean fromNavigable) {
		this.fromNavigable = fromNavigable;
	}

	/**
	 * @return Returns the fromRole.
	 */
	public String getFromRole() {
		return fromRole;
	}

	/**
	 * @param fromRole The fromRole to set.
	 */
	public void setFromRole(String fromRole) {
		this.fromRole = fromRole;
	}

	/**
	 * @return Returns the to.
	 */
	public IClassifier getTo() {
		return to;
	}

	/**
	 * @param to The to to set.
	 */
	public void setTo(IClassifier to) {
		this.to = to;
	}

	/**
	 * @return Returns the toNavigable.
	 */
	public boolean getToNavigable() {
		return toNavigable;
	}

	/**
	 * @param toNavigable The toNavigable to set.
	 */
	public void setToNavigable(boolean toNavigable) {
		this.toNavigable = toNavigable;
	}

	/**
	 * @return Returns the toRole.
	 */
	public String getToRole() {
		return toRole;
	}

	/**
	 * @param toRole The toRole to set.
	 */
	public void setToRole(String toRole) {
		this.toRole = toRole;
	}

	public IAssociationEnd getFromEnd() {
		return fromEnd;
	}

	public IAssociationEnd getToEnd() {
		return toEnd;
	}

	public void setFromEnd(IAssociationEnd fromEnd) {
		this.fromEnd = fromEnd;
	}

	public void setToEnd(IAssociationEnd toEnd) {
		this.toEnd = toEnd;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (fromNavigable ? 1231 : 1237);
		result = prime * result + ((fromRole == null) ? 0 : fromRole.hashCode());
		result = prime * result + (toNavigable ? 1231 : 1237);
		result = prime * result + ((toRole == null) ? 0 : toRole.hashCode());
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
		final Association other = (Association) obj;
		if (from == null) {
			if (other.from != null)
				return false;
		} else if (!from.equals(other.from))
			return false;
		if (fromEnd == null) {
			if (other.fromEnd != null)
				return false;
		} else if (!fromEnd.equals(other.fromEnd))
			return false;
		if (fromNavigable != other.fromNavigable)
			return false;
		if (fromRole == null) {
			if (other.fromRole != null)
				return false;
		} else if (!fromRole.equals(other.fromRole))
			return false;
		if (to == null) {
			if (other.to != null)
				return false;
		} else if (!to.equals(other.to))
			return false;
		if (toEnd == null) {
			if (other.toEnd != null)
				return false;
		} else if (!toEnd.equals(other.toEnd))
			return false;
		if (toNavigable != other.toNavigable)
			return false;
		if (toRole == null) {
			if (other.toRole != null)
				return false;
		} else if (!toRole.equals(other.toRole))
			return false;
		return true;
	}

}
