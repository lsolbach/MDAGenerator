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

  /**
   * Returns a list of the dependencies of this class.
   * @return dependencyList
   */
  List<IDependency> getDependencies();
  
  /**
   * Adds a dependency to this class.
   * @param cf
   */
  void addDependency(IDependency d);


}
