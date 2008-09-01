/*
 * Created on Jan 12, 2005
 */
package org.soulspace.mdlrepo.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.soulspace.mdlrepo.IModelFactory;
import org.soulspace.mdlrepo.IModelRepository;
import org.soulspace.mdlrepo.metamodel.IActor;
import org.soulspace.mdlrepo.metamodel.IAssociation;
import org.soulspace.mdlrepo.metamodel.IAttribute;
import org.soulspace.mdlrepo.metamodel.IClass;
import org.soulspace.mdlrepo.metamodel.IDataType;
import org.soulspace.mdlrepo.metamodel.IDependency;
import org.soulspace.mdlrepo.metamodel.IElement;
import org.soulspace.mdlrepo.metamodel.IEvent;
import org.soulspace.mdlrepo.metamodel.IInterface;
import org.soulspace.mdlrepo.metamodel.IModel;
import org.soulspace.mdlrepo.metamodel.IOperation;
import org.soulspace.mdlrepo.metamodel.IPackage;
import org.soulspace.mdlrepo.metamodel.IState;
import org.soulspace.mdlrepo.metamodel.IStateMachine;
import org.soulspace.mdlrepo.metamodel.IStereotype;
import org.soulspace.mdlrepo.metamodel.ITagDefinition;
import org.soulspace.mdlrepo.metamodel.ITaggedValue;
import org.soulspace.mdlrepo.metamodel.ITransition;
import org.soulspace.mdlrepo.metamodel.IUseCase;
import org.soulspace.mdlrepo.metamodel.impl.ModelFactory;
import org.soulspace.xmi.repository.XMIRepository;

/**
 * ModelRepository
 * @author soulman
 *
 */
public class ModelRepository implements IModelRepository {
  
  private List<IModel> modelList = new ArrayList<IModel>();
  private List<IPackage> packageList = new ArrayList<IPackage>();
  private List<IClass> classList = new ArrayList<IClass>();
  private List<IDataType> dataTypeList = new ArrayList<IDataType>();
  private List<IInterface> interfaceList = new ArrayList<IInterface>();
  private List<IStereotype> stereotypeList = new ArrayList<IStereotype>();
  private List<ITagDefinition> tagDefinitionList = new ArrayList<ITagDefinition>();
  private List<IDependency> dependencyList = new ArrayList<IDependency>();
  private List<IUseCase> useCaseList = new ArrayList<IUseCase>();
  private List<IActor> actorList = new ArrayList<IActor>();
  private List<IStateMachine> stateMachineList = new ArrayList<IStateMachine>();
  private List<IState> stateList = new ArrayList<IState>();
  private List<ITransition> transitionList = new ArrayList<ITransition>();
  private List<IEvent> eventList = new ArrayList<IEvent>();
  private List<IAssociation> associationList = new ArrayList<IAssociation>();
  
  private Map<String, IElement> nameMap = new HashMap<String, IElement>();
  private Map<String, IElement> idMap = new HashMap<String, IElement>();
  private Map<String, IPackage> packageMap = new HashMap<String, IPackage>();
  private Map<String, IClass> classMap = new HashMap<String, IClass>();
  private Map<String, IAttribute> attributeMap = new HashMap<String, IAttribute>();
  private Map<String, IOperation> operationMap = new HashMap<String, IOperation>();
  
  private IModelFactory factory;
  
  public ModelRepository() {
  	// FIXME inject
    factory = new ModelFactory(this);
  }
  
  public ModelRepository(IModelFactory mf) {
  	this.factory = mf;
  }
  
  public void setModelFactory(IModelFactory mf) {
  	this.factory = mf;
  }
  
  public void initRepository(String modelFilename) {
    XMIRepository xmiRepository = new XMIRepository(modelFilename);
    xmiRepository.initRepository();
    
    ModelBuilder modelBuilder = new ModelBuilder(xmiRepository, factory);
    modelBuilder.buildModelRepository();
  }

  /**
   * Initialize the repository with the model file
   */
  public void initRepository(File modelFile) {
    XMIRepository xmiRepository = new XMIRepository(modelFile);
    xmiRepository.initRepository();
    
    ModelBuilder modelBuilder = new ModelBuilder(xmiRepository, factory);
    modelBuilder.buildModelRepository();
  }  
  
  /* (non-Javadoc)
   * @see org.soulspace.xmi.uml.IModelRepository#register(org.soulspace.xmi.uml.IElement)
   */
  public void register(IElement e) {
  	idMap.put(e.getId(), e);
    if(e instanceof IModel) {
      modelList.add((IModel) e);
    } else if(e instanceof IPackage) {
      IPackage p = (IPackage) e;
      packageList.add(p);
      packageMap.put(p.getQualifiedName(), p);
      nameMap.put(p.getQualifiedName(), p);
    } else if(e instanceof IClass) {
      IClass c = (IClass) e;
      classList.add(c);
      classMap.put(c.getQualifiedName(), c);
      nameMap.put(c.getQualifiedName(), c);
    } else if(e instanceof IInterface) {
      IInterface i = (IInterface) e;
      nameMap.put(i.getQualifiedName(), i);
    } else if(e instanceof IAttribute) {
      IAttribute a = (IAttribute) e;
      attributeMap.put(a.getQualifiedName(), a);
    } else if(e instanceof IOperation) {
      IOperation o = (IOperation) e;
      operationMap.put(o.getQualifiedName(), o);
    } else if(e instanceof IDataType) {
      IDataType dt = (IDataType) e;
      dataTypeList.add(dt);
    } else if(e instanceof IStereotype) {
      IStereotype st = (IStereotype) e;
      stereotypeList.add(st);
    } else if(e instanceof ITagDefinition) {
      ITagDefinition td = (ITagDefinition) e;
      tagDefinitionList.add(td);
    } else if(e instanceof IDependency) {
      IDependency d = (IDependency) e;
      dependencyList.add(d);
    } else if(e instanceof IUseCase) {
    	IUseCase uc = (IUseCase) e;
    	useCaseList.add(uc);
    } else if(e instanceof IActor) {
    	IActor a = (IActor) e;
    	actorList.add(a);
    } else if(e instanceof IStateMachine) {
    	IStateMachine sm = (IStateMachine) e;
    	stateMachineList.add(sm);
    } else if(e instanceof IAssociation) {
    	IAssociation a = (IAssociation) e;
    	associationList.add(a);
    } else if(e instanceof IState) {
    	IState s = (IState) e;
    	stateList.add(s);
    } else if(e instanceof ITransition) {
    	ITransition t = (ITransition) e;
    	transitionList.add(t);
    } else if(e instanceof IEvent) {
    	IEvent ev = (IEvent) e;
    	eventList.add(ev);
    } else {
    	//System.out.println("Unknown element:" + e.getClass().getName());
    }
  }

  public IElement lookupByQualifiedName(String qualifiedName) {
    return (IElement) nameMap.get(qualifiedName);
  }

  public IClass lookupClassByQualifiedName(String qualifiedName) {
    return (IClass) classMap.get(qualifiedName);
  }
  
  public IPackage lookupPackageByQualifiedName(String qualifiedName) {
    return (IPackage) packageMap.get(qualifiedName);
  }
  
  public IPackage lookupAttributeByName(String qualifiedName) {
    return (IPackage) packageMap.get(qualifiedName);
  }
  
  public IElement lookupByXmiId(String xmiId) {
    return (IElement) idMap.get(xmiId);
  }
  
  public List<IPackage> getPackages() {
    return packageList;
  }
  
  public List<IClass> getClasses() {
    return classList;
  }
  
  public List<IInterface> getInterfaces() {
    return interfaceList;
  }

  public List<IModel> getModels() {
    return modelList;
  }

	public List<IUseCase> getUseCases() {
		return useCaseList;
	}

	public List<IActor> getActors() {
		return actorList;
	}

	public List<IStateMachine> getStateMachines() {
		return stateMachineList;
	}

	public List<ITransition> getTransitions() {
		return transitionList;
	}

	public List<IState> getStates() {
		return stateList;
	}

	public List<IEvent> getEvents() {
		return eventList;
	}

	public List<IAssociation> getAssociations() {
		return associationList;
	}
}
