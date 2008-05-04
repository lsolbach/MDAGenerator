/*
 * Created on Jan 12, 2005
 */
package org.soulspace.xmi.repository.elements;


/**
 * @author soulman
 *
 */
public interface IAttribute extends IClassifier {
  
  IClassifier getType();
    
  String getOwnerScope();
  
  String getVisibility();
  
  String getChangeability();
  
  boolean isDerived();
  
  IMultiplicity getMultiplicity();

  String getMethodSuffix();
  
  boolean checkOverloaded(IAttribute a);
}
