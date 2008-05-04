/*
 * Created on Feb 9, 2005
 */
package org.soulspace.xmi.repository.elements;

import java.util.List;


/**
 * @author soulman
 *
 */
public interface IAssociationEnd extends IClassifier {

  String getRole();
  IClassifier getType();
  boolean isNavigable();
  boolean isDerived();
  String getMethodSuffix();
  String getAggregation();
  String getChangeability();
  String getOrdering();
  String getTargetScope();
  String getVisibility();
  
  IMultiplicity getMultiplicity();
  IAssociation getAssociation();
  List<IAttribute> getQualifiers();
  
}
