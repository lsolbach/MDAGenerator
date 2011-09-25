/*
 * IPackage.java
 */
package org.soulspace.mdlrepo.metamodel;

import java.util.List;

/**
 * TODO Insert documentation
 * 
 * @author Solbach (Last update: $Author$, $Date$)
 * @version $Revision$
 */
public interface IPackage extends IClassifier {

  public List<IClass> getClasses();
  public List<IDataType> getDataTypes();
  public List<IInterface> getInterfaces();
  public List<IPackage> getPackages();
  public List<IAssociation> getAssociations();
  public List<IActor> getActors();
  public List<IUseCase> getUseCases();
  // TODO how about StateMachines,...?

  /**
   * Returns a list of the dependencies of this package.
   * @return dependencyList
   */
  List<IDependency> getDependencies();

  /**
   * Adds a dependency to this package.
   * @param cf
   */
  void addDependency(IDependency d);

  /**
   * Returns a list of reverse dependencies of this package.
   * @return
   */
  List<IDependency> getReverseDependencies();
  
  /**
   * Adds a reverse dependency to this package.
   * @param cf
   */
  void addReverseDependency(IDependency d);
}
