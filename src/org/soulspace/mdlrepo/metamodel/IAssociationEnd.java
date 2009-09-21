/*
 * Created on Feb 9, 2005
 */
package org.soulspace.mdlrepo.metamodel;

import java.util.List;


/**
 * @author soulman
 *
 */
public interface IAssociationEnd extends IClassifier {

  IClassifier getType();
  void setType(IClassifier cf);
  
  boolean isNavigable();
  void setNavigable(boolean navigable);
  
  boolean isDerived();
  void setDerived(boolean derived);
  
  String getAggregation();
  void setAggregation(String aggregation);
  
  String getChangeability();
  void setChangeability(String changeability);
  
  String getOrdering();
  void setOrdering(String ordering);
  
  String getTargetScope();
  void setTargetScope(String targetScope);
  
  String getVisibility();
  void setVisibility(String visibility);
  
  IMultiplicity getMultiplicity();
  void setMultiplicity(IMultiplicity multiplicity);
  
  IAssociationEnd getSourceEnd();
  void setSourceEnd(IAssociationEnd sourceEnd);
  
  IAssociation getAssociation();
  void setAssociation(IAssociation association);
  
  List<IAttribute> getQualifiers();
  void addQualifier(IAttribute qualifier);
}
