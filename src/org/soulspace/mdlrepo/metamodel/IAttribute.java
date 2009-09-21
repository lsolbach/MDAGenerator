/*
 * Created on Jan 12, 2005
 */
package org.soulspace.mdlrepo.metamodel;


/**
 * @author soulman
 *
 */
public interface IAttribute extends IClassifier {
  
  IClassifier getType();
  void setType(IClassifier cf);
  
  String getOwnerScope();
  void setOwnerScope(String ownerScope);
  
  String getVisibility();
  void setVisibility(String visibility);
  
  String getChangeability();
  void setChangeability(String changeability);
  
  boolean isDerived();
  void setDerived(boolean derived);
  
  IMultiplicity getMultiplicity();
  void setMultiplicity(IMultiplicity multiplicity);
  
  boolean checkOverloaded(IAttribute a);
}
