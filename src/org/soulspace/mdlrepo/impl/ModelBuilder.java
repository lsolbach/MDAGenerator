/*
 * Created on Mar 14, 2006
 */
package org.soulspace.mdlrepo.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.soulspace.mdlrepo.IModelFactory;
import org.soulspace.xmi.marshal.Actor;
import org.soulspace.xmi.marshal.Association;
import org.soulspace.xmi.marshal.AssociationClass;
import org.soulspace.xmi.marshal.Attribute;
import org.soulspace.xmi.marshal.CallEvent;
import org.soulspace.xmi.marshal.Class;
import org.soulspace.xmi.marshal.DataType;
import org.soulspace.xmi.marshal.Dependency;
import org.soulspace.xmi.marshal.Extend;
import org.soulspace.xmi.marshal.Generalization;
import org.soulspace.xmi.marshal.Include;
import org.soulspace.xmi.marshal.Interface;
import org.soulspace.xmi.marshal.Model;
import org.soulspace.xmi.marshal.Operation;
import org.soulspace.xmi.marshal.Package;
import org.soulspace.xmi.marshal.StateMachine;
import org.soulspace.xmi.marshal.Stereotype;
import org.soulspace.xmi.marshal.TagDefinition;
import org.soulspace.xmi.marshal.UseCase;
import org.soulspace.xmi.repository.XMIRepository;

public class ModelBuilder {

	List<XMIRepository> xmiRepositoryList = new ArrayList<XMIRepository>();
//  XMIRepository xmiRepository;
  IModelFactory modelFactory;
  
  public ModelBuilder(XMIRepository xmiRepository, IModelFactory modelFactory) {
    super();
//    this.xmiRepository = xmiRepository;
    this.xmiRepositoryList.add(xmiRepository);
    this.modelFactory = modelFactory;
  }

  public ModelBuilder(List<XMIRepository> xmiRepositoryList, IModelFactory modelFactory) {
    super();
    this.xmiRepositoryList = xmiRepositoryList;
    this.modelFactory = modelFactory;
    // FIXME build from list
  }
  
  public void buildModelRepository() {
  	for (XMIRepository xmiRepository : xmiRepositoryList) {
      // Build model repository
  		// the order of the build calls is relevant to get the references right
  		
      // Build stereotypes
      buildStereotypes(xmiRepository);
      // Build TagDefinitions
      buildTagDefinitions(xmiRepository);
      // Build model
      buildModels(xmiRepository);
      // Build packages
      buildPackages(xmiRepository);
      // Build Actors
      buildActors(xmiRepository);
      // Build UseCases
      buildUseCases(xmiRepository);
      // Build Events
      buildEvents(xmiRepository);
      // Build StateMachines
      buildStateMachines(xmiRepository);
      // Build DataTypes
      buildDataTypes(xmiRepository);
      // Build Interfaces
      buildInterfaces(xmiRepository);
      // Build Classes
      buildClasses(xmiRepository);
      // Build AssociationClasses
      buildAssociationClasses(xmiRepository);
      // Build Attributes
      buildAttributes(xmiRepository);
      // Build Operations
      buildOperations(xmiRepository);
      // Build Associations
      buildAssociations(xmiRepository);
      // Build Generalizations
      buildGeneralizations(xmiRepository);
      // Build Dependencies
      buildDependencies(xmiRepository);
			
		}
    System.out.println("Model repository initialized");
  }

	private void buildModels(XMIRepository xmiRepository) {
    Iterator i = xmiRepository.xmiModelListIterator();
    while(i.hasNext()) {
      modelFactory.createModel((Model) i.next());      
    }    
  }
  
  /**
   * 
   */
	private void buildStereotypes(XMIRepository xmiRepository) {
    Iterator i = xmiRepository.xmiStereotypeListIterator();
    while(i.hasNext()) {
      modelFactory.createStereotype((Stereotype) i.next());      
    }
  }
  
	private void buildTagDefinitions(XMIRepository xmiRepository) {
    Iterator i = xmiRepository.xmiTagDefinitionListIterator();
    while (i.hasNext()) {
      modelFactory.createTagDefinition((TagDefinition) i.next());
    }
  }
  
  /**
   * 
   */
	private void buildPackages(XMIRepository xmiRepository) {
    Iterator i = xmiRepository.xmiPackageListIterator();
    while(i.hasNext()) {
      modelFactory.createPackage((Package) i.next());      
    }
  }

	private void buildDataTypes(XMIRepository xmiRepository) {
    Iterator i = xmiRepository.xmiDataTypeListIterator();
    while(i.hasNext()) {
      modelFactory.createDataType((DataType) i.next());
    }
  }

	private void buildInterfaces(XMIRepository xmiRepository) {
    Iterator i = xmiRepository.xmiInterfaceListIterator();
    while (i.hasNext()) {
      modelFactory.createInterface((Interface) i.next());
    }
  }
  
	private void buildClasses(XMIRepository xmiRepository) {
    Iterator i = xmiRepository.xmiClassListIterator();
    while (i.hasNext()) {
      modelFactory.createClass((Class) i.next());    
    }
  }
  
	private void buildAssociationClasses(XMIRepository xmiRepository) {
    Iterator i = xmiRepository.xmiAssociationClassListIterator();
    while (i.hasNext()) {
      modelFactory.createAssociationClass((AssociationClass) i.next());    
    }
  }
  
	private void buildGeneralizations(XMIRepository xmiRepository) {
    Iterator i = xmiRepository.xmiGeneralizationListIterator();
    while(i.hasNext()) {
      modelFactory.processGeneralization((Generalization) i.next());
    }
  }
  
	private void buildAttributes(XMIRepository xmiRepository) {
    Iterator i = xmiRepository.xmiAttributeListIterator();
    while(i.hasNext()) {
      modelFactory.createAttribute((Attribute) i.next());
    }
  }
  
	private void buildOperations(XMIRepository xmiRepository) {
    Iterator i = xmiRepository.xmiOperationListIterator();
    while(i.hasNext()) {
      modelFactory.createOperation((Operation) i.next());
    }
  }

	private void buildAssociations(XMIRepository xmiRepository) {
    Iterator i = xmiRepository.xmiAssociationListIterator();
    while(i.hasNext()) {
      modelFactory.processAssociation((Association) i.next());
    }
  }
  
	private void buildDependencies(XMIRepository xmiRepository) {
    Iterator i = xmiRepository.xmiDependencyListIterator();
    while(i.hasNext()) {
      modelFactory.createDependency((Dependency) i.next());
    }
  }
  
  private void buildUseCases(XMIRepository xmiRepository) {
		Iterator i = xmiRepository.xmiUseCaseListIterator();
		while (i.hasNext()) {
			modelFactory.createUseCase((UseCase) i.next());
		}
	}

	private void buildActors(XMIRepository xmiRepository) {
		Iterator i = xmiRepository.xmiActorListIterator();
		while(i.hasNext()) {
			modelFactory.createActor((Actor) i.next());
		}
	}

	private void buildIncludes(XMIRepository xmiRepository) {
		Iterator i = xmiRepository.xmiIncludeListIterator();
		while(i.hasNext()) {
			modelFactory.processInclude((Include) i.next());
		}
	}

	private void buildExtends(XMIRepository xmiRepository) {
		Iterator i = xmiRepository.xmiExtendListIterator();
		while(i.hasNext()) {
			modelFactory.processExtend((Extend) i.next());
		}
	}

	private void buildStateMachines(XMIRepository xmiRepository) {
		Iterator i = xmiRepository.xmiStateMachineListIterator();
		while(i.hasNext()) {
			modelFactory.createStateMachine((StateMachine) i.next());
		}
	}

	private void buildEvents(XMIRepository xmiRepository) {
		for(CallEvent ce : xmiRepository.getCallEventList()) {
			modelFactory.createCallEvent(ce);
		}
	}

}
