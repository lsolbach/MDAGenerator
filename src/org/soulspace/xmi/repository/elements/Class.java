/*
 * Class.java
 */
package org.soulspace.xmi.repository.elements;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


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
  public boolean isAbstract() {
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
  public List getAllAssociations() {
    // TODO remove overloaded Associations
    List allAssociations = new ArrayList();
    
    Iterator it = getSuperClasses().iterator();
    while (it.hasNext()) {
      IClass c = (IClass) it.next();
      allAssociations.addAll(c.getAllAssociations());
    }
    allAssociations.addAll(getAssociations());
    return allAssociations;
  }

  /* (non-Javadoc)
   * @see org.soulspace.xmi.uml.IClass#getAllAttributes()
   */
  public List getAllAttributes() {
    // TODO remove overloaded Attributes
    List allAttributes = new ArrayList();

    Iterator it = getSuperClasses().iterator();
    while (it.hasNext()) {
      IClass c = (IClass) it.next();
      allAttributes.addAll(c.getAllAttributes());
    }
    allAttributes.addAll(getAttributes());
    return allAttributes;
  }

  /* (non-Javadoc)
   * @see org.soulspace.xmi.uml.IClass#getAllOperations()
   */
  public List<IOperation> getAllOperations() {
    // TODO remove overloaded Operations
    List<IOperation> allOperations = new ArrayList<IOperation>();
    Iterator<IClass> it = getSuperClasses().iterator();
    while (it.hasNext()) {
      IClass c = (IClass) it.next();
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

    Iterator i = getAttributes().iterator();
    while (i.hasNext()) {
      IAttribute a = (IAttribute) i.next();
      if(a.getType() != null && !a.getType().getNamespace().startsWith("java.lang")) {
        referencedTypes.add(a.getType());
      }
    }

    i = getAssociations().iterator();
    while (i.hasNext()) {
      IAssociationEnd ae = (IAssociationEnd) i.next();
      if(ae.isNavigable()
      		&& ae.getType() != null
      		&& !ae.getType().getNamespace().startsWith("java.lang")) {
    	  referencedTypes.add(ae.getType());    		      	  	
    	  if(Integer.parseInt(ae.getMultiplicity().getHigh()) > 1) {
    	  	// TODO: Add java.util.Collection as type?
    	  }
      }
    }
    
    i = getOperations().iterator();
    while (i.hasNext()) {
      IOperation o = (IOperation) i.next();
      Iterator i2 = o.getParameters().iterator();
      while (i2.hasNext()) {
        Parameter p = (Parameter) i2.next();
        if(p.getType() != null && !p.getType().getNamespace().startsWith("java.lang")) {
          referencedTypes.add(p.getType());
        }
      }
    }
    
    i = getSuperClasses().iterator();
    while (i.hasNext()) {
			IClassifier c = (IClassifier) i.next();
			referencedTypes.add(c);
		}
    return referencedTypes;
  }

  /* (non-Javadoc)
   * @see org.soulspace.xmi.uml.IClass#getAllReferencedTypes()
   */
  public Collection<IClassifier> getAllReferencedTypes() {
    Set<IClassifier> allReferencedTypes = new HashSet<IClassifier>();

    Iterator it = getSuperClasses().iterator();
    while (it.hasNext()) {
      IClass c = (IClass) it.next();
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

    Iterator<IClass> it = getSuperClasses().iterator();
    while (it.hasNext()) {
      IClass c = (IClass) it.next();
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