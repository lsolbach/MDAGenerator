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
  boolean isNavigable();
  boolean isDerived();
  String getMethodSuffix();
  String getAggregation();
  String getChangeability();
  String getOrdering();
  String getTargetScope();
  String getVisibility();
  
  IMultiplicity getMultiplicity();
  IAssociationEnd getSourceEnd();
  IAssociation getAssociation();
  List<IAttribute> getQualifiers();
  
}
