/*
 * IClassifier.java
 */
package org.soulspace.xmi.repository.elements;


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
   
  /**
   * Returns the qualified name of this classifier.
   * @return
   */
  String getQualifiedName();
   
}
