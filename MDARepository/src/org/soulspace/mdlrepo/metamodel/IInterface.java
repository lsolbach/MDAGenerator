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
   * Returns a list of the dependencies of this interface.
   * @return dependencyList
   */
  List<IDependency> getDependencies();
  
  /**
   * Adds a dependency to this interface.
   * @param cf
   */
  void addDependency(IDependency d);

  /**
   * Returns a list of reverse dependencies of this interface.
   * @return
   */
  List<IDependency> getReverseDependencies();
  
  /**
   * Adds a reverse dependency to this interface.
   * @param cf
   */
  void addReverseDependency(IDependency d);


}
