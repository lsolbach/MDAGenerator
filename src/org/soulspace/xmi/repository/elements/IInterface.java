/*
 * Created on Jan 27, 2005
 */
package org.soulspace.xmi.repository.elements;

import java.util.List;

/**
 * @author soulman
 *
 */
public interface IInterface extends IClassifier {

  List getSuperInterfaces();
  
  List getOperations();
}
