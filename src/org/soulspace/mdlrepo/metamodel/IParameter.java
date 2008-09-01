/*
 * Created on Feb 12, 2005
 */
package org.soulspace.mdlrepo.metamodel;


/**
 * @author soulman
 *
 */
public interface IParameter extends IClassifier {

  public String getName();
  public IClassifier getType();
  public String getKind();

}
