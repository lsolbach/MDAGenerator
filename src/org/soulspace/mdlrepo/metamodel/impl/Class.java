/*
 * Class.java
 */
package org.soulspace.mdlrepo.metamodel.impl;

import java.util.ArrayList;
import java.util.List;

import org.soulspace.mdlrepo.metamodel.IAssociationEnd;
import org.soulspace.mdlrepo.metamodel.IAttribute;
import org.soulspace.mdlrepo.metamodel.IClass;
import org.soulspace.mdlrepo.metamodel.IClassifier;
import org.soulspace.mdlrepo.metamodel.IDependency;
import org.soulspace.mdlrepo.metamodel.IInterface;
import org.soulspace.mdlrepo.metamodel.IOperation;
import org.soulspace.mdlrepo.metamodel.IParameter;

/**
 * Model class
 * 
 * @author Solbach (Last update: $Author$, $Date$)
 * @version $Revision$
 */
public class Class extends Classifier implements IClass {

	String visibility;

	boolean isAbstract;

	List<IAttribute> attributes = new ArrayList<IAttribute>();

	List<IOperation> operations = new ArrayList<IOperation>();

	List<IAssociationEnd> associations = new ArrayList<IAssociationEnd>();

	List<IClass> superClasses = new ArrayList<IClass>();

	List<IClass> subClasses = new ArrayList<IClass>();

	List<IInterface> interfaces = new ArrayList<IInterface>();

	List<IDependency> dependencies = new ArrayList<IDependency>();

	List<IDependency> reverseDependencies = new ArrayList<IDependency>();

	/**
	 * @param namespace
	 * 
	 */
	public Class() {
		super();

	}

	/**
	 * @return Returns the isAbstract.
	 */
	public boolean getAbstract() {
		return isAbstract;
	}

	/**
	 * @return Returns the visibility.
	 */
	public String getVisibility() {
		return visibility;
	}

	/**
	 * @param visibility
	 *            The visibility to set.
	 */
	public void setVisibility(String visibility) {
		this.visibility = visibility;
	}

	/**
	 * @param isAbstract
	 *            The isAbstract to set.
	 */
	public void setAbstract(boolean isAbstract) {
		this.isAbstract = isAbstract;
	}

	public List<IAssociationEnd> getAssociations() {
		return associations;
	}

	public void addAssociation(IAssociationEnd ae) {
		associations.add(ae);
	}

	/**
	 * @return Returns the attributes.
	 */
	public List<IAttribute> getAttributes() {
		return attributes;
	}

	public void addAttribute(IAttribute attr) {
		attributes.add(attr);
	}

	/**
	 * @return Returns the interfaces.
	 */
	public List<IInterface> getInterfaces() {
		return interfaces;
	}

	/**
	 * @param interfaces
	 *            The interfaces to set.
	 */
	public void setInterfaces(List<IInterface> interfaces) {
		this.interfaces = interfaces;
	}

	/**
	 * @return Returns the operations.
	 */
	public List<IOperation> getOperations() {
		return operations;
	}

	public void addOperation(IOperation o) {
		operations.add(o);
	}

	/**
	 * @return Returns the superClasses.
	 */
	public List<IClass> getSuperClasses() {
		return superClasses;
	}

	public void addSuperClass(IClass sc) {
		superClasses.add(sc);
	}

	/**
	 * @return Returns the subClasses.
	 */
	public List<IClass> getSubClasses() {
		return subClasses;
	}

	public void addSubClass(IClass sc) {
		subClasses.add(sc);
	}

	public String toString() {
		return getQualifiedName();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.soulspace.xmi.uml.IClass#getAllAssociation()
	 */
	public List<IAssociationEnd> getAllAssociations() {
		List<IAssociationEnd> allAssociations = new ArrayList<IAssociationEnd>();
		for (IClass c : getSuperClasses()) {
			allAssociations = addUnique(allAssociations, c.getAllAssociations());
		}

		for (IAssociationEnd ae : getAssociations()) {
			if (allAssociations.contains(ae)) {
//				System.out
//						.println("DEBUG: dropping duplicate association " + ae);
				break;
			} else {
				IAssociationEnd overridden = null;
				for (IAssociationEnd superAe : allAssociations) {
					if (ae.checkOverride(superAe)) {
						overridden = superAe;
					}
				}
				if (overridden != null) {
//					System.out.println("DEBUG: overriding association "
//							+ overridden + " with " + ae);
					allAssociations.remove(overridden);
				}
				allAssociations.add(ae);
			}
		}
		// allAssociations = addUnique(allAssociations, getAssociations());
		return allAssociations;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.soulspace.xmi.uml.IClass#getAllAttributes()
	 */
	public List<IAttribute> getAllAttributes() {
		List<IAttribute> allAttributes = new ArrayList<IAttribute>();
		for (IClass c : getSuperClasses()) {
			allAttributes = addUnique(allAttributes, c.getAllAttributes());
		}
		for (IAttribute attr : getAttributes()) {
			if (allAttributes.contains(attr)) {
//				System.out
//						.println("DEBUG: dropping duplicate attribute " + attr);
				break;
			} else {
				IAttribute overridden = null;
				for (IAttribute superAttr : allAttributes) {
					if (attr.checkOverride(superAttr)) {
						overridden = superAttr;
					}
				}
				if (overridden != null) {
//					System.out.println("DEBUG: overriding attribute "
//							+ overridden + " with " + attr);
					allAttributes.remove(overridden);
				}
				allAttributes.add(attr);
			}
		}
		// allAttributes = addUnique(allAttributes, getAttributes());
		return allAttributes;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.soulspace.xmi.uml.IClass#getAllOperations()
	 */
	public List<IOperation> getAllOperations() {
		List<IOperation> allOperations = new ArrayList<IOperation>();
		for (IClass c : getSuperClasses()) {
			allOperations = addUnique(allOperations, c.getAllOperations());
		}
		for (IOperation op : getOperations()) {
			if (allOperations.contains(op)) {
//				System.out.println("DEBUG: dropping duplicate operation " + op);
				break;
			} else {
				IOperation overridden = null;
				for (IOperation superOp : allOperations) {
					if (op.checkOverride(superOp)) {
					} else {
					}
				}
				if (overridden != null) {
//					System.out.println("DEBUG: overriding operation "
//							+ overridden + " with " + op);
					allOperations.remove(overridden);
				}
				allOperations.add(op);
			}
		}
		// allOperations = addUnique(allOperations, getOperations());
		return allOperations;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.soulspace.xmi.uml.IClass#getReferencedTypes()
	 */
	public List<IClassifier> getReferencedTypes() {
		List<IClassifier> referencedTypes = new ArrayList<IClassifier>();

		for (IAttribute a : getAttributes()) {
			if (a.getType() != null
					&& !a.getType().getNamespace().startsWith("java.lang")
					&& !referencedTypes.contains(a.getType())) {
				referencedTypes.add(a.getType());
			}
		}

		for (IAssociationEnd ae : getAssociations()) {
			if (ae.isNavigable() && ae.getType() != null
					&& !ae.getType().getNamespace().startsWith("java.lang")
					&& !referencedTypes.contains(ae.getType())) {
				referencedTypes.add(ae.getType());
				if (Integer.parseInt(ae.getMultiplicity().getHigh()) > 1) {
					// TODO: Add java.util.Collection as type?
				}
			}
		}

		for (IOperation o : getOperations()) {
			for (IParameter p : o.getParameters()) {
				if (p.getType() != null
						&& !p.getType().getNamespace().startsWith("java.lang")
						&& !referencedTypes.contains(p.getType())) {
					referencedTypes.add(p.getType());
				}
			}
		}

		for (IClass c : getSuperClasses()) {
			if (!referencedTypes.contains(c)) {
				referencedTypes.add(c);
			}
		}

		for (IDependency d : getDependencies()) {
			if (!referencedTypes.contains(d.getSupplier())) {
				referencedTypes.add(d.getSupplier());
			}
		}

		return referencedTypes;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.soulspace.xmi.uml.IClass#getAllReferencedTypes()
	 */
	public List<IClassifier> getAllReferencedTypes() {
		List<IClassifier> allReferencedTypes = new ArrayList<IClassifier>();
		// Set<IClassifier> allReferencedTypes = new HashSet<IClassifier>();
		for (IClass c : getSuperClasses()) {
			allReferencedTypes = addUnique(allReferencedTypes, c
					.getAllReferencedTypes());
			// allReferencedTypes.addAll(c.getAllReferencedTypes());
		}
		allReferencedTypes = addUnique(allReferencedTypes, getReferencedTypes());
		// allReferencedTypes.addAll(getReferencedTypes());
		return allReferencedTypes;
	}

	public List<IDependency> getDependencies() {
		return dependencies;
	}

	public List<IDependency> getAllDependencies() {
		List<IDependency> allDependencies = new ArrayList<IDependency>();
		for (IClass c : getSuperClasses()) {
			allDependencies = addUnique(allDependencies, c.getDependencies());
		}
		allDependencies = addUnique(allDependencies, getDependencies());

		return allDependencies;
	}

	public void addDependency(IDependency d) {
		dependencies.add(d);
	}

	public List<IDependency> getReverseDependencies() {
		return reverseDependencies;
	}

	public List<IDependency> getAllReverseDependencies() {
		List<IDependency> allReverseDependencies = new ArrayList<IDependency>();
		for (IClass c : getSuperClasses()) {
			allReverseDependencies = addUnique(allReverseDependencies, c.getReverseDependencies());
		}
		allReverseDependencies = addUnique(allReverseDependencies, getReverseDependencies());

		return allReverseDependencies;
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
		result = prime * result + (isAbstract ? 1231 : 1237);
		result = prime * result
				+ ((visibility == null) ? 0 : visibility.hashCode());
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
		final Class other = (Class) obj;
		if (isAbstract != other.isAbstract)
			return false;
		if (visibility == null) {
			if (other.visibility != null)
				return false;
		} else if (!visibility.equals(other.visibility))
			return false;
		return true;
	}

	private <T> List<T> addUnique(List<T> l1, List<T> l2) {
		for (T element : l2) {
			if (!l1.contains(element)) {
				l1.add(element);
			}
		}
		return l1;
	}

}