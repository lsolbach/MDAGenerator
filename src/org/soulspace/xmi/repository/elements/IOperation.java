/*
 * Created on Jan 12, 2005
 */
package org.soulspace.xmi.repository.elements;

import java.util.List;


/**
 * @author soulman
 *
 */
public interface IOperation extends IClassifier {

  public IClassifier getReturnType();
  
  public List<IParameter> getParameters();
}
