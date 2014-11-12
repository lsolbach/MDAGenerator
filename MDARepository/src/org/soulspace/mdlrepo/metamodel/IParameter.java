/*
 * Created on Feb 12, 2005
 */
package org.soulspace.mdlrepo.metamodel;


/**
 * @author soulman
 *
 */
public interface IParameter extends IClassifier {

  IClassifier getType();
  void setType(IClassifier cf);

  String getKind();
  void setKind(String kind);
  
}
