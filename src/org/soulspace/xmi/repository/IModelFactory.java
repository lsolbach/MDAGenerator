/*
 * IModelFactory.java
 */
package org.soulspace.xmi.repository;

import org.soulspace.xmi.base.XmiObject;
import org.soulspace.xmi.repository.elements.IActor;
import org.soulspace.xmi.repository.elements.IAssociation;
import org.soulspace.xmi.repository.elements.IAssociationEnd;
import org.soulspace.xmi.repository.elements.IAttribute;
import org.soulspace.xmi.repository.elements.IClass;
import org.soulspace.xmi.repository.elements.IDataType;
import org.soulspace.xmi.repository.elements.IDependency;
import org.soulspace.xmi.repository.elements.IInterface;
import org.soulspace.xmi.repository.elements.IModel;
import org.soulspace.xmi.repository.elements.IMultiplicity;
import org.soulspace.xmi.repository.elements.IOperation;
import org.soulspace.xmi.repository.elements.IPackage;
import org.soulspace.xmi.repository.elements.IParameter;
import org.soulspace.xmi.repository.elements.IStateMachine;
import org.soulspace.xmi.repository.elements.IStereotype;
import org.soulspace.xmi.repository.elements.ITagDefinition;
import org.soulspace.xmi.repository.elements.ITaggedValue;
import org.soulspace.xmi.repository.elements.IUseCase;

/**
 * Interface
 * 
 * @author Solbach (Last update: $Author$, $Date$)
 * @version $Revision$
 */
public interface IModelFactory {

  IModel createModel(XmiObject xmiModel);
  
  IPackage createPackage(XmiObject xmiPackage);

  IClass createClass(XmiObject xmiClass);

  IDataType createDataType(XmiObject xmiDataType);
  
  IAttribute createAttribute(XmiObject xmiAttribute);

  IOperation createOperation(XmiObject xmiOperation);
  
  IParameter createParameter(XmiObject xmiParameter);

  IInterface createInterface(XmiObject xmiInterface);

  IAssociation createAssociation(XmiObject xmiAssociation);

  IAssociationEnd createAssociationEnd(XmiObject xmiAssociationEnd);

  IStereotype createStereotype(XmiObject xmiStereotype);
  
  ITagDefinition createTagDefinition(XmiObject xmiTagDefinition);
  
  ITaggedValue createTaggedValue(XmiObject xmiTaggedValue);
  
  IMultiplicity createMultiplicity(XmiObject xmiMultiplicity);

  IDependency createDependency(XmiObject xmiDependency);
  
  IUseCase createUseCase(XmiObject xmiUseCase);
  
  IActor createActor(XmiObject xmiActor);

  IStateMachine createStateMachine(XmiObject xmiStateMachine);
  
  void processInclude(XmiObject xmiInclude);

  void processExtend(XmiObject xmiExtend);
  
  void processGeneralization(XmiObject xmiGeneralization);

  void processAssociation(XmiObject xmiAssociation);

}