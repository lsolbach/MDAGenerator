/*
 * Package.java
 */
package org.soulspace.mdlrepo.metamodel.impl;

import java.util.ArrayList;
import java.util.List;

import org.soulspace.mdlrepo.metamodel.IAssociation;
import org.soulspace.mdlrepo.metamodel.IClass;
import org.soulspace.mdlrepo.metamodel.IDataType;
import org.soulspace.mdlrepo.metamodel.IInterface;
import org.soulspace.mdlrepo.metamodel.IPackage;


/**
 * Model element Package
 * 
 * @author Solbach (Last update: $Author$, $Date$)
 * @version $Revision$
 */
public class Package extends Classifier implements IPackage {

   List<IClass> classes = new ArrayList<IClass>();
   List<IInterface> interfaces = new ArrayList<IInterface>();
   List<IDataType> dataTypes = new ArrayList<IDataType>();
   List<IPackage> packages = new ArrayList<IPackage>();
   List<IAssociation> associations = new ArrayList<IAssociation>();

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
		final Package other = (Package) obj;
		return true;
	}
  
  
}
