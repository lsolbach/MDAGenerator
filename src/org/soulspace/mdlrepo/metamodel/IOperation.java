/*
 * Created on Jan 12, 2005
 */
package org.soulspace.mdlrepo.metamodel;

import java.util.List;


/**
 * @author soulman
 *
 */
public interface IOperation extends IClassifier {

  public IClassifier getReturnType();
  
  public List<IParameter> getParameters();
}
