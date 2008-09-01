/*
 * Created on Nov 19, 2004
 */
package org.soulspace.mdlrepo.metamodel.impl;

import org.soulspace.mdlrepo.metamodel.IDataType;


/**
 * @author soulman
 *
 */
public class DataType extends Classifier implements IDataType {

  /**
   * @param namespace
   */
  public DataType() {
    super();
  }
  
  public String toString() {
    return getQualifiedName();
  }


}
