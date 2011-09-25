/*
 * Package.java
 */
package org.soulspace.mdlrepo.metamodel.impl;

import java.util.ArrayList;
import java.util.List;

import org.soulspace.mdlrepo.metamodel.IActor;
import org.soulspace.mdlrepo.metamodel.IAssociation;
import org.soulspace.mdlrepo.metamodel.IClass;
import org.soulspace.mdlrepo.metamodel.IDataType;
import org.soulspace.mdlrepo.metamodel.IDependency;
import org.soulspace.mdlrepo.metamodel.IInterface;
import org.soulspace.mdlrepo.metamodel.IPackage;
import org.soulspace.mdlrepo.metamodel.IUseCase;

/**
 * Model element Package
 * 
 * @author Solbach (Last update: $Author$, $Date$)
 * @version $Revision$
 */
public class Package extends Classifier implements IPackage {

	private List<IClass> classes = new ArrayList<IClass>();
	private List<IInterface> interfaces = new ArrayList<IInterface>();
	private List<IDataType> dataTypes = new ArrayList<IDataType>();
	private List<IPackage> packages = new ArrayList<IPackage>();
	private List<IActor> actorList = new ArrayList<IActor>();
	private List<IUseCase> useCaseList = new ArrayList<IUseCase>();
	private List<IAssociation> associations = new ArrayList<IAssociation>();
	private List<IDependency> dependencies = new ArrayList<IDependency>();
	private List<IDependency> reverseDependencies = new ArrayList<IDependency>();

	/**
    * 
    */
	public Package() {
		super();
	}

	/**
	 * @return Returns the classes.
	 */
	public List getClasses() {
		return classes;
	}

	public void addClass(IClass c) {
		classes.add(c);
	}

	/**
	 * @return Returns the dataTypes.
	 */
	public List getDataTypes() {
		return dataTypes;
	}

	public void addDataType(IDataType dt) {
		dataTypes.add(dt);
	}

	/**
	 * @return Returns the interfaces.
	 */
	public List getInterfaces() {
		return interfaces;
	}

	public void addInterface(IInterface i) {
		interfaces.add(i);
	}

	public String toString() {
		return getQualifiedName();
	}

	public List getPackages() {
		return packages;
	}

	public void addPackage(IPackage p) {
		packages.add(p);
	}

	public List getAssociations() {
		return associations;
	}

	public void addAssociation(IAssociation a) {
		associations.add(a);
	}

	public List<IUseCase> getUseCases() {
		return useCaseList;
	}

	public void addUseCase(IUseCase uc) {
		useCaseList.add(uc);
	}

	public List<IActor> getActors() {
		return actorList;
	}

	public void addActor(IActor a) {
		actorList.add(a);
	}

	public List<IDependency> getDependencies() {
		return dependencies;
	}

	public void addDependency(IDependency d) {
		dependencies.add(d);
	}

	public List<IDependency> getReverseDependencies() {
		return reverseDependencies;
	}

	public void addReverseDependency(IDependency d) {
		reverseDependencies.add(d);
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
		final Package other = (Package) obj;
		return true;
	}

}
