/*
 *  Copyright (c) Ludger Solbach. All rights reserved.
 *  The use and distribution terms for this software are covered by the
 *  Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
 *  which can be found in the file license.txt at the root of this distribution.
 *  By using this software in any fashion, you are agreeing to be bound by
 *  the terms of this license.
 *  You must not remove this notice, or any other, from this software.
 */
package org.soulspace.mdlrepo.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.soulspace.mdlrepo.IModelBuilder;
import org.soulspace.mdlrepo.IModelFactory;
import org.soulspace.mdlrepo.IModelRepository;
import org.soulspace.mdlrepo.metamodel.IActor;
import org.soulspace.mdlrepo.metamodel.IAssociation;
import org.soulspace.mdlrepo.metamodel.IAssociationClass;
import org.soulspace.mdlrepo.metamodel.IAttribute;
import org.soulspace.mdlrepo.metamodel.ICallAction;
import org.soulspace.mdlrepo.metamodel.ICallEvent;
import org.soulspace.mdlrepo.metamodel.IChangeEvent;
import org.soulspace.mdlrepo.metamodel.IClass;
import org.soulspace.mdlrepo.metamodel.ICreateAction;
import org.soulspace.mdlrepo.metamodel.IDataType;
import org.soulspace.mdlrepo.metamodel.IDependency;
import org.soulspace.mdlrepo.metamodel.IDestroyAction;
import org.soulspace.mdlrepo.metamodel.IEnumerationType;
import org.soulspace.mdlrepo.metamodel.IExtend;
import org.soulspace.mdlrepo.metamodel.IInclude;
import org.soulspace.mdlrepo.metamodel.IInterface;
import org.soulspace.mdlrepo.metamodel.IModel;
import org.soulspace.mdlrepo.metamodel.IOperation;
import org.soulspace.mdlrepo.metamodel.IPackage;
import org.soulspace.mdlrepo.metamodel.ISendAction;
import org.soulspace.mdlrepo.metamodel.ISignalEvent;
import org.soulspace.mdlrepo.metamodel.IStateMachine;
import org.soulspace.mdlrepo.metamodel.IStereotype;
import org.soulspace.mdlrepo.metamodel.ITagDefinition;
import org.soulspace.mdlrepo.metamodel.ITimeEvent;
import org.soulspace.mdlrepo.metamodel.IUseCase;
import org.soulspace.xmi.marshal.Actor;
import org.soulspace.xmi.marshal.Association;
import org.soulspace.xmi.marshal.AssociationClass;
import org.soulspace.xmi.marshal.Attribute;
import org.soulspace.xmi.marshal.CallAction;
import org.soulspace.xmi.marshal.CallEvent;
import org.soulspace.xmi.marshal.ChangeEvent;
import org.soulspace.xmi.marshal.Class;
import org.soulspace.xmi.marshal.CreateAction;
import org.soulspace.xmi.marshal.DataType;
import org.soulspace.xmi.marshal.Dependency;
import org.soulspace.xmi.marshal.DestroyAction;
import org.soulspace.xmi.marshal.Enumeration;
import org.soulspace.xmi.marshal.Extend;
import org.soulspace.xmi.marshal.Generalization;
import org.soulspace.xmi.marshal.Include;
import org.soulspace.xmi.marshal.Interface;
import org.soulspace.xmi.marshal.Model;
import org.soulspace.xmi.marshal.Operation;
import org.soulspace.xmi.marshal.Package;
import org.soulspace.xmi.marshal.SendAction;
import org.soulspace.xmi.marshal.SignalEvent;
import org.soulspace.xmi.marshal.StateMachine;
import org.soulspace.xmi.marshal.Stereotype;
import org.soulspace.xmi.marshal.TagDefinition;
import org.soulspace.xmi.marshal.TimeEvent;
import org.soulspace.xmi.marshal.UseCase;
import org.soulspace.xmi.repository.XMIRepository;

public class ModelBuilder implements IModelBuilder {

	IModelFactory modelFactory;
	IModelRepository modelRepository;

	public ModelBuilder(IModelFactory modelFactory) {
		super();
		this.modelRepository = new ModelRepository();
		this.modelFactory = modelFactory;
		modelFactory.setModelRepository(modelRepository);
	}

	public IModelRepository getModelRepository() {
		return this.modelRepository;
	}
	
	public void addXmiRepository(XMIRepository xmiRepository) {		
		buildStereotypes(xmiRepository);
		buildTagDefinitions(xmiRepository);
		buildModels(xmiRepository);
		buildPackages(xmiRepository);
		buildEnumerations(xmiRepository);
		buildActors(xmiRepository);
		buildUseCases(xmiRepository);
		buildDataTypes(xmiRepository);
		buildInterfaces(xmiRepository);
		buildClasses(xmiRepository);
		buildAssociationClasses(xmiRepository);
		buildAttributes(xmiRepository);
		buildOperations(xmiRepository);
		buildAssociations(xmiRepository);
		buildGeneralizations(xmiRepository);
		buildEvents(xmiRepository);
//		buildActions(xmiRepository);
		buildStateMachines(xmiRepository);
		buildDependencies(xmiRepository);

		// FIXME workaround because there are no reference from package to containing model in Xmi
		// FIXME Better implement this in Xmi loading (XmiRepository or XmiParser)
		addPackagesToModel();
	}
	
	private void buildModels(XMIRepository xmiRepository) {
		Iterator i = xmiRepository.xmiModelListIterator();
		while (i.hasNext()) {
			IModel element = modelFactory.createModel((Model) i.next());
		}
	}

	private void buildStereotypes(XMIRepository xmiRepository) {
		Iterator i = xmiRepository.xmiStereotypeListIterator();
		while (i.hasNext()) {
			IStereotype element = modelFactory.createStereotype((Stereotype) i
					.next());
		}
	}

	private void buildTagDefinitions(XMIRepository xmiRepository) {
		Iterator i = xmiRepository.xmiTagDefinitionListIterator();
		while (i.hasNext()) {
			ITagDefinition element = modelFactory
					.createTagDefinition((TagDefinition) i.next());
		}
	}

	private void buildPackages(XMIRepository xmiRepository) {
		Iterator i = xmiRepository.xmiPackageListIterator();
		while (i.hasNext()) {
			IPackage element = modelFactory.createPackage((Package) i.next());
		}
	}

	private void buildEnumerations(XMIRepository xmiRepository) {
		Iterator i = xmiRepository.xmiEnumerationListIterator();
		while (i.hasNext()) {
			IEnumerationType element = modelFactory
					.createEnumerationType((Enumeration) i.next());
		}
	}

	private void buildDataTypes(XMIRepository xmiRepository) {
		Iterator i = xmiRepository.xmiDataTypeListIterator();
		while (i.hasNext()) {
			IDataType element = modelFactory
					.createDataType((DataType) i.next());
		}
	}

	private void buildInterfaces(XMIRepository xmiRepository) {
		Iterator i = xmiRepository.xmiInterfaceListIterator();
		while (i.hasNext()) {
			IInterface element = modelFactory.createInterface((Interface) i
					.next());
		}
	}

	private void buildClasses(XMIRepository xmiRepository) {
		Iterator i = xmiRepository.xmiClassListIterator();
		while (i.hasNext()) {
			IClass element = modelFactory.createClass((Class) i.next());
		}
	}

	private void buildAssociationClasses(XMIRepository xmiRepository) {
		Iterator i = xmiRepository.xmiAssociationClassListIterator();
		while (i.hasNext()) {
			IAssociationClass element = modelFactory
					.createAssociationClass((AssociationClass) i.next());
		}
	}

	private void buildGeneralizations(XMIRepository xmiRepository) {
		Iterator i = xmiRepository.xmiGeneralizationListIterator();
		while (i.hasNext()) {
			// FIXME no return value
			modelFactory.processGeneralization((Generalization) i.next());
		}
	}

	private void buildAttributes(XMIRepository xmiRepository) {
		Iterator i = xmiRepository.xmiAttributeListIterator();
		while (i.hasNext()) {
			IAttribute element = modelFactory.createAttribute((Attribute) i
					.next());
		}
	}

	private void buildOperations(XMIRepository xmiRepository) {
		Iterator i = xmiRepository.xmiOperationListIterator();
		while (i.hasNext()) {
			IOperation element = modelFactory.createOperation((Operation) i
					.next());
		}
	}

	private void buildAssociations(XMIRepository xmiRepository) {
		Iterator i = xmiRepository.xmiAssociationListIterator();
		while (i.hasNext()) {
			modelFactory.processAssociation((Association) i.next());
		}
	}

	private void buildDependencies(XMIRepository xmiRepository) {
		Iterator i = xmiRepository.xmiDependencyListIterator();
		while (i.hasNext()) {
			IDependency element = modelFactory.createDependency((Dependency) i
					.next());
		}
	}

	private void buildUseCases(XMIRepository xmiRepository) {
		Iterator i = xmiRepository.xmiUseCaseListIterator();
		while (i.hasNext()) {
			IUseCase element = modelFactory.createUseCase((UseCase) i.next());
		}
	}

	private void buildActors(XMIRepository xmiRepository) {
		Iterator i = xmiRepository.xmiActorListIterator();
		while (i.hasNext()) {
			IActor element = modelFactory.createActor((Actor) i.next());
		}
	}

	private void buildIncludes(XMIRepository xmiRepository) {
		Iterator i = xmiRepository.xmiIncludeListIterator();
		while (i.hasNext()) {
			modelFactory.processInclude((Include) i.next());
		}
	}

	private void buildExtends(XMIRepository xmiRepository) {
		Iterator i = xmiRepository.xmiExtendListIterator();
		while (i.hasNext()) {
			modelFactory.processExtend((Extend) i.next());
		}
	}

	private void buildStateMachines(XMIRepository xmiRepository) {
		Iterator i = xmiRepository.xmiStateMachineListIterator();
		while (i.hasNext()) {
			IStateMachine element = modelFactory
					.createStateMachine((StateMachine) i.next());
		}
		i = xmiRepository.xmiStateMachineListIterator();
		while (i.hasNext()) {
			 modelFactory.processStateMachine((StateMachine) i.next());
		}
	}

	private void buildEvents(XMIRepository xmiRepository) {
		for (CallEvent ce : xmiRepository.getCallEventList()) {
			ICallEvent element = modelFactory.createCallEvent(ce);
		}
		for(SignalEvent se : xmiRepository.getSignalEventList()) {
			ISignalEvent element = modelFactory.createSignalEvent(se);
		}
		for(ChangeEvent ce : xmiRepository.getChangeEventList()) {
			IChangeEvent element = modelFactory.createChangeEvent(ce);
		}
		for(TimeEvent te : xmiRepository.getTimeEventList()) {
			ITimeEvent element = modelFactory.createTimeEvent(te);
		}
	}

	private void buildActions(XMIRepository xmiRepository) {
		for(CallAction ca : xmiRepository.getCallActionList()) {
			ICallAction element = modelFactory.createCallAction(ca);
		}
		for(CreateAction ca : xmiRepository.getCreateActionList()) {
			ICreateAction element = modelFactory.createCreateAction(ca);
		}
		for(DestroyAction da : xmiRepository.getDestroyActionList()) {
			IDestroyAction element = modelFactory.createDestroyAction(da);
		}
		for(SendAction ca : xmiRepository.getSendActionList()) {
			ISendAction element = modelFactory.createSendAction(ca);
		}
		// TODO add missing actions
	}
	
	private void addPackagesToModel() {
		// only handle non profile elements here
		for(IModel model : modelRepository.getModels()) {
			if(!model.getProfileElement()) {
				for(IPackage pkg : modelRepository.getPackages()) {
					if(!pkg.getProfileElement()) {
						model.addPackage(pkg);
					}
				}
			}
		}
	}
}
