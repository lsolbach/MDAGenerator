/*
 * Created on Jan 27, 2005
 */
package org.soulspace.mdlrepo.metamodel;

import java.util.List;

/**
 * @author soulman
 *
 */
public interface IInterface extends IClassifier {

  List getSuperInterfaces();
  
  List getOperations();
}
