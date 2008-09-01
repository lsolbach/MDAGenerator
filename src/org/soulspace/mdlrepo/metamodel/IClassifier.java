/*
 * IClassifier.java
 */
package org.soulspace.mdlrepo.metamodel;


/**
 * Interface for Classifiers
 * 
 * @author soulman
 */
public interface IClassifier extends INamedElement {

  /**
   * Returns the namespace of this classifier.
   * @return
   */
  String getNamespace();
  
  void setNamespace(String namespace);
   
  /**
   * Returns the qualified name of this classifier.
   * @return
   */
  String getQualifiedName();
  
  void setQualifiedName(String qualifiedName);
  
  /**
   * Returns the package of this classifier.
   * @return
   */
  IPackage getPackage();
  
  void setPackage(IPackage pkg);
}
