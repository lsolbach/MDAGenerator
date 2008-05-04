/*
 * Created on Nov 19, 2004
 */
package org.soulspace.xmi.repository.elements;


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
