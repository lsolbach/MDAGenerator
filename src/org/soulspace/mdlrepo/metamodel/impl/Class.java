/*
 * Class.java
 */
package org.soulspace.mdlrepo.metamodel.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

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

  List<IAttribute> attributes = new ArrayList<IAttribute>();

  List<IOperation> operations = new ArrayList<IOperation>();
  
  List<IAssociationEnd> associations = new ArrayList<IAssociationEnd>();

  List<IClass> superClasses = new ArrayList<IClass>();

  List<IClass> subClasses = new ArrayList<IClass>();

  List<IInterface> interfaces = new ArrayList<IInterface>();
  
  List<IDependency> dependencies = new ArrayList<IDependency>();

  String visibility;

  boolean isAbstract;

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
   * @param visibility The visibility to set.
   */
  public void setVisibility(String visibility) {
    this.visibility = visibility;
  }

  /**
   * @param isAbstract
   *          The isAbstract to set.
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
   *          The interfaces to set.
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
   * @return Returns the superClasses.
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

  /* (non-Javadoc)
   * @see org.soulspace.xmi.uml.IClass#getAllAssociation()
   */
  public Collection<IAssociationEnd> getAllAssociations() {
    // TODO remove overloaded Associations
    Set allAssociations = new HashSet<IAssociationEnd>();
    for(IClass c : getSuperClasses()) {
      allAssociations.addAll(c.getAllAssociations());
    }
    allAssociations.addAll(getAssociations());
    return allAssociations;
  }

  /* (non-Javadoc)
   * @see org.soulspace.xmi.uml.IClass#getAllAttributes()
   */
  public Collection<IAttribute> getAllAttributes() {
    // TODO remove overloaded Attributes
    Set allAttributes = new HashSet<IAttribute>();
    for(IClass c : getSuperClasses()) {
      allAttributes.addAll(c.getAllAttributes());
    }
    allAttributes.addAll(getAttributes());
    return allAttributes;
  }

  /* (non-Javadoc)
   * @see org.soulspace.xmi.uml.IClass#getAllOperations()
   */
  public Collection<IOperation> getAllOperations() {
    // TODO remove overloaded Operations
    Set<IOperation> allOperations = new HashSet<IOperation>();
    for(IClass c : getSuperClasses()) {
      allOperations.addAll(c.getAllOperations());
    }
    allOperations.addAll(getOperations());
    return allOperations;
  }

  /* (non-Javadoc)
   * @see org.soulspace.xmi.uml.IClass#getReferencedTypes()
   */
  public Collection<IClassifier> getReferencedTypes() {
    Set<IClassifier> referencedTypes = new HashSet<IClassifier>();

    for(IAttribute a : getAttributes()) {
      if(a.getType() != null && !a.getType().getNamespace().startsWith("java.lang")) {
        referencedTypes.add(a.getType());
      }
    }
    
    for(IAssociationEnd ae : getAssociations()) {
      if(ae.isNavigable()
      		&& ae.getType() != null
      		&& !ae.getType().getNamespace().startsWith("java.lang")) {
    	  referencedTypes.add(ae.getType());    		      	  	
    	  if(Integer.parseInt(ae.getMultiplicity().getHigh()) > 1) {
    	  	// TODO: Add java.util.Collection as type?
    	  }
      }
    }
    
    for(IOperation o : getOperations()) {
    	for(IParameter p : o.getParameters()) {
        if(p.getType() != null && !p.getType().getNamespace().startsWith("java.lang")) {
          referencedTypes.add(p.getType());
        }
    	}
    }
    
    for(IClass c : getSuperClasses()) {
			referencedTypes.add(c);
    }
    
    for(IDependency d : getDependencies()) {
    	referencedTypes.add(d.getSupplier());
    }
    
    return referencedTypes;    
  }

  /* (non-Javadoc)
   * @see org.soulspace.xmi.uml.IClass#getAllReferencedTypes()
   */
  public Collection<IClassifier> getAllReferencedTypes() {
    Set<IClassifier> allReferencedTypes = new HashSet<IClassifier>();

    for(IClass c : getSuperClasses()) {
    	allReferencedTypes.addAll(c.getAllReferencedTypes());
    }
    allReferencedTypes.addAll(getReferencedTypes());
    return allReferencedTypes;
  }

  public List<IDependency> getDependencies() {
    return dependencies;
  }

  public List<IDependency> getAllDependencies() {
    List<IDependency> allDependencies = new ArrayList<IDependency>();

    for(IClass c : getSuperClasses()) {
    	allDependencies.addAll(c.getDependencies());
    }
    allDependencies.addAll(getDependencies());

    return allDependencies;
  }

  public void addDependency(IDependency d) {
    dependencies.add(d);
  }

	/* (non-Javadoc)
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

}