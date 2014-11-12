/*
 * Created on Nov 19, 2004
 */
package org.soulspace.mdlrepo.metamodel.impl;

import java.util.ArrayList;
import java.util.List;

import org.soulspace.mdlrepo.metamodel.IAssociationEnd;
import org.soulspace.mdlrepo.metamodel.IDataType;

/**
 * @author soulman
 * 
 */
public class DataType extends Classifier implements IDataType {

	List<IAssociationEnd> associations = new ArrayList<IAssociationEnd>();

	/**
	 * @param namespace
	 */
	public DataType() {
		super();
	}

	public List<IAssociationEnd> getAssociations() {
		return associations;
	}

	public void addAssociation(IAssociationEnd ae) {
		associations.add(ae);
	}

	public String toString() {
		return getQualifiedName();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
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
		final DataType other = (DataType) obj;
		return true;
	}

}
