/*
 * IPackage.java
 */
package org.soulspace.xmi.repository.elements;

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
  
  // TODO how about Actors, UseCases, StateMachines,...?
}
