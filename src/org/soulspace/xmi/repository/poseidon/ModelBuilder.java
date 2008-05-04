/*
 * Created on Mar 14, 2006
 */
package org.soulspace.xmi.repository.poseidon;

import java.util.Iterator;

import org.soulspace.xmi.marshal.Actor;
import org.soulspace.xmi.marshal.Association;
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

public class ModelBuilder {

  XMIRepository xmiRepository;
  ModelFactory modelFactory;
  
  public ModelBuilder(XMIRepository xmiRepository, ModelFactory modelFactory) {
    super();
    this.xmiRepository = xmiRepository;
    this.modelFactory = modelFactory;
  }

  public void buildModelRepository() {

    // Build model repository
    // Build stereotypes
    buildStereotypes();
    // Build TagDefinitions
    buildTagDefinitions();
    // Build model
    buildModels();
    // Build packages
    buildPackages();
    // Build Actors
    buildActors();
    // Build UseCases
    buildUseCases();
    // Build Events
    buildEvents();
    // Build StateMachines
    buildStateMachines();
    // Build DataTypes
    buildDataTypes();
    // Build Interfaces
    buildInterfaces();
    // Build Classes
    buildClasses();
    // Build Attributes
    buildAttributes();
    // Build Operations
    buildOperations();
    // Build Associations
    buildAssociations();
    // Build Generalizations
    buildGeneralizations();
    // Build Dependencies
    buildDependencies();
    
    System.out.println("Model repository initialized");
  }

	private void buildModels() {
    Iterator i = xmiRepository.xmiModelListIterator();
    while(i.hasNext()) {
      modelFactory.createModel((Model) i.next());      
    }    
  }
  
  /**
   * 
   */
	private void buildStereotypes() {
    Iterator i = xmiRepository.xmiStereotypeListIterator();
    while(i.hasNext()) {
      modelFactory.createStereotype((Stereotype) i.next());      
    }
  }
  
	private void buildTagDefinitions() {
    Iterator i = xmiRepository.xmiTagDefinitionListIterator();
    while (i.hasNext()) {
      modelFactory.createTagDefinition((TagDefinition) i.next());
    }
  }
  
  /**
   * 
   */
	private void buildPackages() {
    Iterator i = xmiRepository.xmiPackageListIterator();
    while(i.hasNext()) {
      modelFactory.createPackage((Package) i.next());      
    }
  }

	private void buildDataTypes() {
    Iterator i = xmiRepository.xmiDataTypeListIterator();
    while(i.hasNext()) {
      modelFactory.createDataType((DataType) i.next());
    }
  }

	private void buildInterfaces() {
    Iterator i = xmiRepository.xmiInterfaceListIterator();
    while (i.hasNext()) {
      modelFactory.createInterface((Interface) i.next());
    }
  }
  
	private void buildClasses() {
    Iterator i = xmiRepository.xmiClassListIterator();
    while (i.hasNext()) {
      modelFactory.createClass((Class) i.next());    
    }
  }
  
	private void buildGeneralizations() {
    Iterator i = xmiRepository.xmiGeneralizationListIterator();
    while(i.hasNext()) {
      modelFactory.processGeneralization((Generalization) i.next());
    }
  }
  
	private void buildAttributes() {
    Iterator i = xmiRepository.xmiAttributeListIterator();
    while(i.hasNext()) {
      modelFactory.createAttribute((Attribute) i.next());
    }
  }
  
	private void buildOperations() {
    Iterator i = xmiRepository.xmiOperationListIterator();
    while(i.hasNext()) {
      modelFactory.createOperation((Operation) i.next());
    }
  }

	private void buildAssociations() {
    Iterator i = xmiRepository.xmiAssociationListIterator();
    while(i.hasNext()) {
      modelFactory.processAssociation((Association) i.next());
    }
  }
  
	private void buildDependencies() {
    Iterator i = xmiRepository.xmiDependencyListIterator();
    while(i.hasNext()) {
      modelFactory.createDependency((Dependency) i.next());
    }
  }
  
  private void buildUseCases() {
		Iterator i = xmiRepository.xmiUseCaseListIterator();
		while (i.hasNext()) {
			modelFactory.createUseCase((UseCase) i.next());
		}
	}

	private void buildActors() {
		Iterator i = xmiRepository.xmiActorListIterator();
		while(i.hasNext()) {
			modelFactory.createActor((Actor) i.next());
		}
	}

	private void buildIncludes() {
		Iterator i = xmiRepository.xmiIncludeListIterator();
		while(i.hasNext()) {
			modelFactory.processInclude((Include) i.next());
		}
	}

	private void buildExtends() {
		Iterator i = xmiRepository.xmiExtendListIterator();
		while(i.hasNext()) {
			modelFactory.processExtend((Extend) i.next());
		}
	}

	private void buildStateMachines() {
		Iterator i = xmiRepository.xmiStateMachineListIterator();
		while(i.hasNext()) {
			modelFactory.createStateMachine((StateMachine) i.next());
		}
	}

	private void buildEvents() {
		for(CallEvent ce : xmiRepository.xmiCallEventList) {
			modelFactory.createCallEvent(ce);
		}
	}



}
