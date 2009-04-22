/*
 * IModelFactory.java
 */
package org.soulspace.mdlrepo;

import org.soulspace.mdlrepo.metamodel.IActor;
import org.soulspace.mdlrepo.metamodel.IAssociation;
import org.soulspace.mdlrepo.metamodel.IAssociationClass;
import org.soulspace.mdlrepo.metamodel.IAssociationEnd;
import org.soulspace.mdlrepo.metamodel.IAttribute;
import org.soulspace.mdlrepo.metamodel.ICallEvent;
import org.soulspace.mdlrepo.metamodel.IClass;
import org.soulspace.mdlrepo.metamodel.IDataType;
import org.soulspace.mdlrepo.metamodel.IDependency;
import org.soulspace.mdlrepo.metamodel.IInterface;
import org.soulspace.mdlrepo.metamodel.IModel;
import org.soulspace.mdlrepo.metamodel.IMultiplicity;
import org.soulspace.mdlrepo.metamodel.IOperation;
import org.soulspace.mdlrepo.metamodel.IPackage;
import org.soulspace.mdlrepo.metamodel.IParameter;
import org.soulspace.mdlrepo.metamodel.IStateMachine;
import org.soulspace.mdlrepo.metamodel.IStereotype;
import org.soulspace.mdlrepo.metamodel.ITagDefinition;
import org.soulspace.mdlrepo.metamodel.ITaggedValue;
import org.soulspace.mdlrepo.metamodel.IUseCase;
import org.soulspace.xmi.base.XmiObject;

/**
 * Interface
 * 
 * @author Solbach (Last update: $Author$, $Date$)
 * @version $Revision$
 */
public interface IModelFactory {

	IModelRepository getModelRepository();
	
  IModel createModel(XmiObject xmi);
  
  IPackage createPackage(XmiObject xmi);

  IClass createClass(XmiObject xmi);

  IAssociationClass createAssociationClass(XmiObject xmi);

  IDataType createDataType(XmiObject xmi);
  
  IAttribute createAttribute(XmiObject xmi);

  IOperation createOperation(XmiObject xmi);
  
  IParameter createParameter(XmiObject xmi);

  IInterface createInterface(XmiObject xmi);

  IAssociation createAssociation(XmiObject xmi);

  IAssociationEnd createAssociationEnd(XmiObject xmi);

  IStereotype createStereotype(XmiObject xmi);
  
  ITagDefinition createTagDefinition(XmiObject xmi);
  
  ITaggedValue createTaggedValue(XmiObject xmi);
  
  IMultiplicity createMultiplicity(XmiObject xmi);

  IDependency createDependency(XmiObject xmi);
  
  IUseCase createUseCase(XmiObject xmi);
  
  IActor createActor(XmiObject xmi);

  IStateMachine createStateMachine(XmiObject xmi);
  
  ICallEvent createCallEvent(XmiObject xmi);
  
  void processInclude(XmiObject xmi);

  void processExtend(XmiObject xmi);
  
  void processGeneralization(XmiObject xmi);

  void processAssociation(XmiObject xmi);

}