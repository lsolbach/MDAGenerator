/*
 * Created on Mar 3, 2005
 */
package org.soulspace.mdlrepo.metamodel.impl;

import java.util.ArrayList;
import java.util.List;

import org.soulspace.mdlrepo.metamodel.IAssociationEnd;
import org.soulspace.mdlrepo.metamodel.IDependency;
import org.soulspace.mdlrepo.metamodel.IInterface;
import org.soulspace.mdlrepo.metamodel.IOperation;

/**
 * @author soulman
 * 
 */
public class Interface extends Classifier implements IInterface {

	private List<IInterface> superInterfaceList = new ArrayList<IInterface>();
	private List<IOperation> operationList = new ArrayList<IOperation>();
	private List<IDependency> dependencyList = new ArrayList<IDependency>();
	private List<IDependency> reverseDependencyList = new ArrayList<IDependency>();
	private List<IAssociationEnd> associations = new ArrayList<IAssociationEnd>();

	public Interface() {
		super();
	}

	public List<IInterface> getSuperInterfaces() {
		return superInterfaceList;
	}

	public void addSuperInterface(IInterface i) {
		superInterfaceList.add(i);
	}

	public List<IOperation> getOperations() {
		return operationList;
	}

	public void addOperation(IOperation o) {
		operationList.add(o);
	}

	public void addDependency(IDependency d) {
		dependencyList.add(d);
	}

	public List<IDependency> getDependencies() {
		return dependencyList;
	}

	public void addReverseDependency(IDependency d) {
		reverseDependencyList.add(d);
	}

	public List<IDependency> getReverseDependencies() {
		return reverseDependencyList;
	}

	public List<IAssociationEnd> getAssociations() {
		return associations;
	}

	public void addAssociation(IAssociationEnd ae) {
		associations.add(ae);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
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
		final Interface other = (Interface) obj;
		return true;
	}

}
