/*
 * IClass.java
 */
package org.soulspace.mdlrepo.metamodel;

import java.util.Collection;
import java.util.List;
import java.util.Set;


/**
 * Interface for a class representation
 * 
 * @author soulman
 */
public interface IClass extends IClassifier {

	boolean getAbstract();
	
	void setAbstract(boolean isAbstract);
	
	String getVisibility();
	
	void setVisibility(String visibility);
	
  /**
   * Returns a list of the attributes declared by this class.
   * @return attributeList
   */
  List<IAttribute> getAttributes();

  /**
   * Returns a list of the attributes declared by this class and it's superclasses.
   * @return attributeList
   */
  List<IAttribute> getAllAttributes();

  /**
   * Adds an attribute to this class.
   * @param attr
   */
  void addAttribute(IAttribute attr);
  
  /**
   * Returns a list of the operations declared by this class.
   * @return operationList
   */
  List<IOperation> getOperations();

  /**
   * Returns a list of the attributes declared by this class and it's superclasses.
   * @return operationList
   */
  List<IOperation> getAllOperations();

  /**
   * Adds an operation to this class 
   * @param op
   */
  void addOperation(IOperation op);
  
  /**
   * Returns a list of the associations of this class.
   * @return associationList
   */
  List<IAssociationEnd> getAssociations();

  /**
   * Returns a list of the associations of this class and it's superclasses.
   * @return associationList
   */
  List<IAssociationEnd> getAllAssociations();

  /**
   * Adds an association to this class.
   * @param ae
   */
  void addAssociation(IAssociationEnd ae);
  
  /**
   * Returns a list of the superclasses of this class.
   * @return superclassList
   */
  List<IClass> getSuperClasses();

  /**
   * Adds a superclass to this class.
   * @param c
   */
  void addSuperClass(IClass c);

  /**
   * Returns a list of the supclasses of this class.
   * @return subclassList
   */
  List<IClass> getSubClasses();

  /**
   * Adds a subclass to this class.
   * @param c
   */
  void addSubClass(IClass c);
  
  /**
   * Returns the types referenced by this class.
   * @return referencedTypeList
   */
  List<IClassifier> getReferencedTypes();

  /**
   * Returns the types referenced by this class and it's superclasses.
   * @return referencedTypeList
   */
  List<IClassifier> getAllReferencedTypes();
  
  /**
   * Returns a list of the dependencies of this class.
   * @return dependencyList
   */
  List<IDependency> getDependencies();

  /**
   * Returns a list of the dependencies of this class and it's superclasses.
   * @return dependencyList
   */
  List<IDependency> getAllDependencies();
  
  /**
   * Adds a dependency to this class.
   * @param cf
   */
  void addDependency(IDependency d);

  /**
   * Returns a list of reverse dependencies of this class.
   * @return
   */
  List<IDependency> getReverseDependencies();
  
  /**
   * Returns a list of reverse dependencies of this class.
   * @return
   */
  List<IDependency> getAllReverseDependencies();
  
  void addReverseDependency(IDependency d);
}
