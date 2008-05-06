/*
 * ModelFactory.java
 */
package org.soulspace.xmi.repository.poseidon;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import org.soulspace.xmi.base.XmiObject;
import org.soulspace.xmi.marshal.ActorItem;
import org.soulspace.xmi.marshal.AssociationEndItem;
import org.soulspace.xmi.marshal.AssociationEnd_multiplicityItem;
import org.soulspace.xmi.marshal.AssociationEnd_participantItem;
import org.soulspace.xmi.marshal.AssociationEnd_qualifierItem;
import org.soulspace.xmi.marshal.AssociationItem;
import org.soulspace.xmi.marshal.Association_connection;
import org.soulspace.xmi.marshal.Association_connectionItem;
import org.soulspace.xmi.marshal.AttributeItem;
import org.soulspace.xmi.marshal.BehavioralFeature_parameterItem;
import org.soulspace.xmi.marshal.CallEventItem;
import org.soulspace.xmi.marshal.ClassItem;
import org.soulspace.xmi.marshal.CompositeStateItem;
import org.soulspace.xmi.marshal.CompositeState_subvertexItem;
import org.soulspace.xmi.marshal.DataTypeItem;
import org.soulspace.xmi.marshal.DependencyItem;
import org.soulspace.xmi.marshal.Dependency_clientItem;
import org.soulspace.xmi.marshal.Dependency_supplierItem;
import org.soulspace.xmi.marshal.Event_parameterItem;
import org.soulspace.xmi.marshal.Extend;
import org.soulspace.xmi.marshal.ExtendItem;
import org.soulspace.xmi.marshal.Extend_baseItem;
import org.soulspace.xmi.marshal.Extend_extensionItem;
import org.soulspace.xmi.marshal.Extend_extensionPointItem;
import org.soulspace.xmi.marshal.FinalStateItem;
import org.soulspace.xmi.marshal.GeneralizationItem;
import org.soulspace.xmi.marshal.Generalization_childItem;
import org.soulspace.xmi.marshal.Generalization_parentItem;
import org.soulspace.xmi.marshal.Include;
import org.soulspace.xmi.marshal.IncludeItem;
import org.soulspace.xmi.marshal.InterfaceItem;
import org.soulspace.xmi.marshal.ModelElement_stereotype;
import org.soulspace.xmi.marshal.ModelElement_stereotypeItem;
import org.soulspace.xmi.marshal.ModelElement_taggedValue;
import org.soulspace.xmi.marshal.ModelElement_taggedValueItem;
import org.soulspace.xmi.marshal.ModelItem;
import org.soulspace.xmi.marshal.MultiplicityItem;
import org.soulspace.xmi.marshal.Multiplicity_rangeItem;
import org.soulspace.xmi.marshal.Namespace_ownedElementItem;
import org.soulspace.xmi.marshal.OperationItem;
import org.soulspace.xmi.marshal.PackageItem;
import org.soulspace.xmi.marshal.ParameterItem;
import org.soulspace.xmi.marshal.Parameter_typeItem;
import org.soulspace.xmi.marshal.PseudostateItem;
import org.soulspace.xmi.marshal.RegionItem;
import org.soulspace.xmi.marshal.SimpleState;
import org.soulspace.xmi.marshal.SimpleStateItem;
import org.soulspace.xmi.marshal.StateMachineItem;
import org.soulspace.xmi.marshal.StateMachine_submachineStateItem;
import org.soulspace.xmi.marshal.StateMachine_topItem;
import org.soulspace.xmi.marshal.StateMachine_transitionsItem;
import org.soulspace.xmi.marshal.StructuralFeature_multiplicityItem;
import org.soulspace.xmi.marshal.StructuralFeature_typeItem;
import org.soulspace.xmi.marshal.SubmachineStateItem;
import org.soulspace.xmi.marshal.SubmachineState_submachineItem;
import org.soulspace.xmi.marshal.TaggedValueItem;
import org.soulspace.xmi.marshal.TaggedValue_dataValue;
import org.soulspace.xmi.marshal.TaggedValue_typeItem;
import org.soulspace.xmi.marshal.TransitionItem;
import org.soulspace.xmi.marshal.Transition_triggerItem;
import org.soulspace.xmi.marshal.TypedElement_type;
import org.soulspace.xmi.marshal.UseCaseItem;
import org.soulspace.xmi.marshal.UseCase_extensionPointItem;
import org.soulspace.xmi.marshal.types.KindType;
import org.soulspace.xmi.repository.IModelFactory;
import org.soulspace.xmi.repository.IModelRepository;
import org.soulspace.xmi.repository.elements.Actor;
import org.soulspace.xmi.repository.elements.Association;
import org.soulspace.xmi.repository.elements.AssociationEnd;
import org.soulspace.xmi.repository.elements.Attribute;
import org.soulspace.xmi.repository.elements.CallEvent;
import org.soulspace.xmi.repository.elements.Class;
import org.soulspace.xmi.repository.elements.DataType;
import org.soulspace.xmi.repository.elements.Dependency;
import org.soulspace.xmi.repository.elements.ExtensionPoint;
import org.soulspace.xmi.repository.elements.FinalState;
import org.soulspace.xmi.repository.elements.IActor;
import org.soulspace.xmi.repository.elements.IAssociation;
import org.soulspace.xmi.repository.elements.IAssociationEnd;
import org.soulspace.xmi.repository.elements.IAttribute;
import org.soulspace.xmi.repository.elements.ICallEvent;
import org.soulspace.xmi.repository.elements.IClass;
import org.soulspace.xmi.repository.elements.IClassifier;
import org.soulspace.xmi.repository.elements.IDataType;
import org.soulspace.xmi.repository.elements.IDependency;
import org.soulspace.xmi.repository.elements.IElement;
import org.soulspace.xmi.repository.elements.IEvent;
import org.soulspace.xmi.repository.elements.IExtensionPoint;
import org.soulspace.xmi.repository.elements.IFinalState;
import org.soulspace.xmi.repository.elements.IInterface;
import org.soulspace.xmi.repository.elements.IModel;
import org.soulspace.xmi.repository.elements.IMultiplicity;
import org.soulspace.xmi.repository.elements.IOperation;
import org.soulspace.xmi.repository.elements.IPackage;
import org.soulspace.xmi.repository.elements.IParameter;
import org.soulspace.xmi.repository.elements.IPseudostate;
import org.soulspace.xmi.repository.elements.IState;
import org.soulspace.xmi.repository.elements.IStateMachine;
import org.soulspace.xmi.repository.elements.IStereotype;
import org.soulspace.xmi.repository.elements.ISubmachineState;
import org.soulspace.xmi.repository.elements.ITagDefinition;
import org.soulspace.xmi.repository.elements.ITaggedValue;
import org.soulspace.xmi.repository.elements.ITransition;
import org.soulspace.xmi.repository.elements.IUseCase;
import org.soulspace.xmi.repository.elements.Interface;
import org.soulspace.xmi.repository.elements.Model;
import org.soulspace.xmi.repository.elements.Multiplicity;
import org.soulspace.xmi.repository.elements.Operation;
import org.soulspace.xmi.repository.elements.Package;
import org.soulspace.xmi.repository.elements.Parameter;
import org.soulspace.xmi.repository.elements.Pseudostate;
import org.soulspace.xmi.repository.elements.State;
import org.soulspace.xmi.repository.elements.StateMachine;
import org.soulspace.xmi.repository.elements.Stereotype;
import org.soulspace.xmi.repository.elements.SubmachineState;
import org.soulspace.xmi.repository.elements.TagDefinition;
import org.soulspace.xmi.repository.elements.Transition;
import org.soulspace.xmi.repository.elements.UseCase;
import org.soulspace.xmi.util.XmiHelper;

/**
 * Model factory
 * 
 * @author Solbach (Last update: $Author$, $Date$)
 * @version $Revision$
 */
public class ModelFactory implements IModelFactory {

  IModelRepository repository;

  /**
   * 
   */
  public ModelFactory(IModelRepository mr) {
    super();
    repository = mr;
  }

  public IModel createModel(XmiObject xmiObj) {
    org.soulspace.xmi.marshal.Model xmiModel = (org.soulspace.xmi.marshal.Model) xmiObj;
    Model m = new Model();
    m.setName(xmiModel.getName());
    m.setNamespace("");
    m.setQualifiedName(xmiModel.getName());
    m.setId(xmiModel.getXmi_id());
    Enumeration e1 = xmiModel.enumerateModelItem();
    while (e1.hasMoreElements()) {
      ModelItem mI = (ModelItem) e1.nextElement();
      if (mI.getNamespace_ownedElement() != null) {
        Enumeration e2 = mI.getNamespace_ownedElement()
            .enumerateNamespace_ownedElementItem();
        while (e2.hasMoreElements()) {
          Namespace_ownedElementItem nOEI = (Namespace_ownedElementItem) e2
              .nextElement();
          if (nOEI.getPackage() != null) {
            // 
          }
        }
      } else if (mI.getModelElement_stereotype() != null) {
        addStereotypes(m, mI.getModelElement_stereotype());
      } else if (mI.getModelElement_taggedValue() != null) {
        addTaggedValues(m, mI.getModelElement_taggedValue());
      }
    }
    repository.register(m);
    return m;
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.soulspace.xmi.uml.IModelFactory#createPackage()
   */
  public IPackage createPackage(XmiObject xmiObj) {
    org.soulspace.xmi.marshal.Package xmiPackage = (org.soulspace.xmi.marshal.Package) xmiObj;
    Package p = new Package();
    p.setNamespace(xmiPackage.getNamespace());
    p.setQualifiedName(xmiPackage.getQualifiedName());
    p.setName(xmiPackage.getName());
    p.setId(xmiPackage.getXmi_id());

    Enumeration e1 = xmiPackage.enumeratePackageItem();
    while (e1.hasMoreElements()) {
      PackageItem pI = (PackageItem) e1.nextElement();
      if (pI.getModelElement_stereotype() != null) {
        addStereotypes(p, pI.getModelElement_stereotype());
      } else if (pI.getModelElement_taggedValue() != null) {
        addTaggedValues(p, pI.getModelElement_taggedValue());
      }
    }

    repository.register(p);
    return p;
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.soulspace.xmi.uml.IModelFactory#createClass()
   */
  public IClass createClass(XmiObject xmiObj) {
    org.soulspace.xmi.marshal.Class xmiClass = (org.soulspace.xmi.marshal.Class) xmiObj;
    Class c = new Class();
    c.setId(xmiClass.getXmi_id());
    c.setNamespace(xmiClass.getNamespace());
    c.setQualifiedName(xmiClass.getQualifiedName());
    c.setName(xmiClass.getName());
    c.setAbstract(xmiClass.getIsAbstract());
    c.setVisibility(XmiHelper.toString(xmiClass.getVisibility()));

    Enumeration e1 = xmiClass.enumerateClassItem();
    while (e1.hasMoreElements()) {
      ClassItem cI = (ClassItem) e1.nextElement();
      if (cI.getModelElement_stereotype() != null) {
        addStereotypes(c, cI.getModelElement_stereotype());
      } else if (cI.getModelElement_taggedValue() != null) {
        addTaggedValues(c, cI.getModelElement_taggedValue());
        // } else if(cI.getGeneralizableElement_generalization() != null) {
        // Enumeration e2 =
        // cI.getGeneralizableElement_generalization().enumerateGeneralizableElement_generalizationItem();
        // } else if(cI.getModelElement_clientDependency() != null) {
        // org.soulspace.xmi.marshal.Abstraction a =
        // cI.getModelElement_clientDependency().getAbstraction();
      }
    }
    Package p = (Package) repository.lookupPackageByQualifiedName(c.getNamespace());
    if (p != null) {
      p.addClass(c);
    }

    repository.register(c);
    return c;
  }

  public IInterface createInterface(XmiObject xmiObj) {
    org.soulspace.xmi.marshal.Interface xmiInterface = (org.soulspace.xmi.marshal.Interface) xmiObj;
    Interface i = new Interface();
    i.setId(xmiInterface.getXmi_id());
    i.setName(xmiInterface.getName());
    i.setNamespace(xmiInterface.getNamespace());
    i.setQualifiedName(xmiInterface.getQualifiedName());

    Enumeration e1 = xmiInterface.enumerateInterfaceItem();
    while (e1.hasMoreElements()) {
      InterfaceItem iI = (InterfaceItem) e1.nextElement();
      if (iI.getModelElement_stereotype() != null) {
        addStereotypes(i, iI.getModelElement_stereotype());
      } else if (iI.getModelElement_taggedValue() != null) {
        addTaggedValues(i, iI.getModelElement_taggedValue());
      }
    }

    repository.register(i);
    return i;
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.soulspace.xmi.uml.IModelFactory#createDataType()
   */
  public IDataType createDataType(XmiObject xmiObj) {
    org.soulspace.xmi.marshal.DataType xmiDataType = (org.soulspace.xmi.marshal.DataType) xmiObj;
    DataType dt = new DataType();
    dt.setId(xmiDataType.getXmi_id());
    dt.setName(xmiDataType.getName());
    dt.setNamespace(xmiDataType.getNamespace());
    dt.setQualifiedName(xmiDataType.getQualifiedName());

    Enumeration e1 = xmiDataType.enumerateDataTypeItem();
    while (e1.hasMoreElements()) {
      DataTypeItem dtI = (DataTypeItem) e1.nextElement();
      if (dtI.getModelElement_stereotype() != null) {
        addStereotypes(dt, dtI.getModelElement_stereotype());
      }
    }

    repository.register(dt);
    return dt;
  }

  public IAttribute createAttribute(XmiObject xmiObj) {
    org.soulspace.xmi.marshal.Attribute xmiAttribute = (org.soulspace.xmi.marshal.Attribute) xmiObj;
    Attribute a = new Attribute();

    if(!XmiHelper.isSet(xmiAttribute.getName())) {
    	System.err.println("The name of attribute " + xmiAttribute.getXmi_id() + " is not set!");
    	return null;
    }
    
    String name = xmiAttribute.getName();
    if(name.startsWith("/")) {
      a.setName(name.substring(1));
      a.setMethodSuffix(a.getName().substring(0, 1).toUpperCase()
          + a.getName().substring(1));
      a.setDerived(true);
    } else {
      a.setName(name);
      a.setMethodSuffix(a.getName().substring(0, 1).toUpperCase()
          + a.getName().substring(1));
      a.setDerived(false);
    }    	

    a.setId(xmiAttribute.getXmi_id());
    a.setNamespace(xmiAttribute.getNamespace());
    a.setQualifiedName(xmiAttribute.getQualifiedName());

    a.setVisibility(xmiAttribute.getVisibility().toString());
    a.setChangeability(xmiAttribute.getChangeability().toString());
    a.setOwnerScope(xmiAttribute.getOwnerScope());

    Enumeration e1 = xmiAttribute.enumerateAttributeItem();
    while (e1.hasMoreElements()) {
      AttributeItem aI = (AttributeItem) e1.nextElement();
      if (aI.getModelElement_taggedValue() != null) {
        addTaggedValues(a, aI.getModelElement_taggedValue());
      } else if (aI.getModelElement_stereotype() != null) {
        addStereotypes(a, aI.getModelElement_stereotype());
      } else if (aI.getTypedElement_type() != null) {
    	  // UML2
    	  TypedElement_type teT = aI.getTypedElement_type();
    	  if (teT.getClazz() != null) {
              a.setType(findClass(teT.getClazz()));
          } else if (teT.getDataType() != null) {
              a.setType(findDataType(teT.getDataType()));
          } else if (teT.getInterface() != null) {
              a.setType(findInterface(teT.getInterface()));
          }
      } else if (aI.getStructuralFeature_type() != null) {
    	  // UML1
    	  Enumeration e2 = aI.getStructuralFeature_type()
            .enumerateStructuralFeature_typeItem();
        while (e2.hasMoreElements()) {
          StructuralFeature_typeItem tI = (StructuralFeature_typeItem) e2
              .nextElement();
          if (tI.getClazz() != null) {
            a.setType(findClass(tI.getClazz()));
          } else if (tI.getDataType() != null) {
            a.setType(findDataType(tI.getDataType()));
          } else if (tI.getInterface() != null) {
            a.setType(findInterface(tI.getInterface()));
          }
        }
      } else if(aI.getStructuralFeature_multiplicity() != null) {
        Enumeration e2 = aI.getStructuralFeature_multiplicity()
        .enumerateStructuralFeature_multiplicityItem();
        while (e2.hasMoreElements()) {
          StructuralFeature_multiplicityItem mI = (StructuralFeature_multiplicityItem) e2
              .nextElement();
          if (mI.getMultiplicity() != null) {
            IMultiplicity m = createMultiplicity(mI.getMultiplicity());
            a.setMultiplicity(m);
          }
        }
      }
    }

    Class c = (Class) repository.lookupClassByQualifiedName(a.getNamespace());
    if (c != null) {
      c.addAttribute(a);
    }
    repository.register(a);
    return a;
  }

  public IOperation createOperation(XmiObject xmiObj) {
    org.soulspace.xmi.marshal.Operation xmiOperation = (org.soulspace.xmi.marshal.Operation) xmiObj;
    Operation o = new Operation();

    o.setName(xmiOperation.getName());
    o.setId(xmiOperation.getXmi_id());
    o.setNamespace(xmiOperation.getNamespace());
    o.setQualifiedName(xmiOperation.getQualifiedName());

    o.setOwnerScope(xmiOperation.getOwnerScope());
    o.setVisibility(XmiHelper.toString(xmiOperation.getVisibility()));
    o.setConcurrency(XmiHelper.toString(xmiOperation.getConcurrency()));

    // TODO refactor the fetchReturnType method in into this and use a find method for the lookup
    // TODO make it look like any other type lookup here
    String xmiId = fetchReturnType((org.soulspace.xmi.marshal.Operation) xmiOperation);
    IClassifier cf = (IClassifier) repository.lookupByXmiId(xmiId);
    o.setReturnType(cf);

    Enumeration e1 = xmiOperation.enumerateOperationItem();
    while (e1.hasMoreElements()) {
      OperationItem oI = (OperationItem) e1.nextElement();
      if (oI.getBehavioralFeature_parameter() != null) {
        Enumeration e2 = oI.getBehavioralFeature_parameter()
            .enumerateBehavioralFeature_parameterItem();
        while (e2.hasMoreElements()) {
          BehavioralFeature_parameterItem pI = (BehavioralFeature_parameterItem) e2
              .nextElement();
          if (pI.getParameter() != null) {
            o.addParameter(createParameter(pI.getParameter()));
          }
        }
      } else if (oI.getModelElement_stereotype() != null) {
        addStereotypes(o, oI.getModelElement_stereotype());
      } else if (oI.getModelElement_taggedValue() != null) {
        addTaggedValues(o, oI.getModelElement_taggedValue());
      }
    }

    Class c = (Class) repository.lookupClassByQualifiedName(o.getNamespace());
    if (c != null) {
      c.addOperation(o);
    }
    repository.register(o);
    return o;
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.soulspace.xmi.uml.IModelFactory#createAssociation(org.soulspace.xmi.base.XmiObject)
   */
  public IAssociation createAssociation(XmiObject xmiObj) {
    org.soulspace.xmi.marshal.Association xmiAssociation = (org.soulspace.xmi.marshal.Association) xmiObj;
    Association a = new Association();

    a.setNamespace(xmiAssociation.getNamespace());
    a.setQualifiedName(xmiAssociation.getQualifiedName());
    a.setId(xmiAssociation.getXmi_id());
    a.setName(xmiAssociation.getName());

    Enumeration e = xmiAssociation.enumerateAssociationItem();
    while (e.hasMoreElements()) {
      AssociationItem aI = (AssociationItem) e.nextElement();
      if (aI.getAssociation_connection() != null) {
        Association_connection aC = aI.getAssociation_connection();
        Enumeration eA = aC.enumerateAssociation_connectionItem();
        while (eA.hasMoreElements()) {
					Association_connectionItem cI = (Association_connectionItem) eA.nextElement();
//					if(cI.getAssociationEnd() != null) {
//						String xmiId = cI.getAssociationEnd().getXmi_id();
//						AssociationEnd ae = (AssociationEnd) findAssociationEnd(xmiId);
//						if(ae != null) {
//							// TODO handle AssociationEnd (reference Association from AssociationEnd!)
//							ae.setAssociation(a);
//						}
//					}
				}
      } else if (aI.getModelElement_stereotype() != null) {
        addStereotypes(a, aI.getModelElement_stereotype());
      } else if (aI.getModelElement_taggedValue() != null) {
        addTaggedValues(a, aI.getModelElement_taggedValue());
      }
    }

    Class c = (Class) repository.lookupClassByQualifiedName(a.getNamespace());
    if (c != null) {
      // c.addAssociation(a);
    }
    repository.register(a);
    return a;
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.soulspace.xmi.uml.IModelFactory#createAssociationEnd(org.soulspace.xmi.base.XmiObject)
   */
  public IAssociationEnd createAssociationEnd(XmiObject xmiObj) {
    org.soulspace.xmi.marshal.AssociationEnd xmiAssociationEnd = (org.soulspace.xmi.marshal.AssociationEnd) xmiObj;
    AssociationEnd ae = new AssociationEnd();
    IClassifier c = null;

    if(XmiHelper.isSet(xmiAssociationEnd.getName())) {
    	if(xmiAssociationEnd.getName().startsWith("/")) {
    		ae.setName(xmiAssociationEnd.getName().substring(1));
        ae.setMethodSuffix(ae.getName().substring(0, 1).toUpperCase()
            + ae.getName().substring(1));
    		ae.setDerived(true);
    	} else if(xmiAssociationEnd.getName() != null) {
    		ae.setName(xmiAssociationEnd.getName());
        ae.setMethodSuffix(ae.getName().substring(0, 1).toUpperCase()
            + ae.getName().substring(1));
    		ae.setDerived(false);
    	}
    } else {
    	ae.setName("");
    	ae.setMethodSuffix("");
    }
    ae.setId(xmiAssociationEnd.getXmi_id());
    ae.setNamespace(xmiAssociationEnd.getNamespace());
    ae.setQualifiedName(xmiAssociationEnd.getQualifiedName());
    ae.setNavigable(xmiAssociationEnd.getIsNavigable());
    ae.setAggregation(xmiAssociationEnd.getAggregation().toString());
    ae.setChangeability(xmiAssociationEnd.getChangeability().toString());
    ae.setOrdering(xmiAssociationEnd.getOrdering().toString());
    ae.setTargetScope(xmiAssociationEnd.getTargetScope().toString());
    ae.setVisibility(xmiAssociationEnd.getVisibility().toString());    
    
    Enumeration e1 = xmiAssociationEnd.enumerateAssociationEndItem();
    while (e1.hasMoreElements()) {
      AssociationEndItem aeI = (AssociationEndItem) e1.nextElement();
      if (aeI.getAssociationEnd_participant() != null) {
        Enumeration e2 = aeI.getAssociationEnd_participant()
            .enumerateAssociationEnd_participantItem();
        while (e2.hasMoreElements()) {
          AssociationEnd_participantItem pI = (AssociationEnd_participantItem) e2
              .nextElement();
          // FIXME find other types than Class
          if(pI.getClazz() != null) {
            c = findClass(pI.getClazz());            
          } else if(pI.getInterface() != null) {
            c = findInterface(pI.getInterface());                        
          } else if(pI.getActor() != null) {
            c = findActor(pI.getActor());
          } else if(pI.getUseCase() != null) {
            c = findUseCase(pI.getUseCase());
          } else {
          	System.out.println("WARNING: Participant missing for AssociationEnd Id: " + ae.getId());
          }
        }
        ae.setType(c);
      } else if (aeI.getAssociationEnd_multiplicity() != null) {
        Enumeration e2 = aeI.getAssociationEnd_multiplicity()
            .enumerateAssociationEnd_multiplicityItem();
        while (e2.hasMoreElements()) {
          AssociationEnd_multiplicityItem mI = (AssociationEnd_multiplicityItem) e2
              .nextElement();
          if (mI.getMultiplicity() != null) {
            IMultiplicity m = createMultiplicity(mI.getMultiplicity());
            ae.setMultiplicity(m);
          } else {
          	System.out.println("INFO: Multiplicity missing for AssociationEnd Id: " + ae.getId());
          }
        }
      } else if (aeI.getAssociationEnd_qualifier() != null) {
      	Enumeration e = aeI.getAssociationEnd_qualifier().enumerateAssociationEnd_qualifierItem();
      	while (e.hasMoreElements()) {
					AssociationEnd_qualifierItem qI = (AssociationEnd_qualifierItem) e.nextElement();
					if(qI.getAttribute() != null) {
						System.out.println("Qualifier for " + ae.getId() + " found");
						IAttribute a = createAttribute(qI.getAttribute());
						System.out.println("Qualifier name " + a.getName());
						ae.addQualifier(a);
					}
				}
      	if(!ae.getMultiplicity().getHigh().equals("1")) {
        	System.out.println("INFO: The multiplicity of an AssociationEnd with Qualifiers should be 0..1");      		
      	}
      } else if (aeI.getModelElement_taggedValue() != null) {
        addTaggedValues(ae, aeI.getModelElement_taggedValue());
      } else if (aeI.getModelElement_stereotype() != null) {
        addStereotypes(ae, aeI.getModelElement_stereotype());
      }
    }
    return ae;
  }

	/*
   * (non-Javadoc)
   * 
   * @see org.soulspace.xmi.uml.IModelFactory#createStereotype(org.soulspace.xmi.base.XmiObject)
   */
  public IStereotype createStereotype(XmiObject xmiObj) {
    org.soulspace.xmi.marshal.Stereotype xmiStereotype = (org.soulspace.xmi.marshal.Stereotype) xmiObj;
    Stereotype s = new Stereotype();
    s.setName(xmiStereotype.getName());
    s.setId(xmiStereotype.getXmi_id());

    repository.register(s);
    return s;
  }

  public ITagDefinition createTagDefinition(XmiObject xmiObj) {
    org.soulspace.xmi.marshal.TagDefinition xmiTagDefinition = (org.soulspace.xmi.marshal.TagDefinition) xmiObj;
    TagDefinition td = new TagDefinition();
    td.setName(xmiTagDefinition.getName());
    td.setId(xmiTagDefinition.getXmi_id());
    td.setNamespace(xmiTagDefinition.getNamespace());

    repository.register(td);
    return td;
  }

  public ITaggedValue createTaggedValue(XmiObject xmiObj) {
    org.soulspace.xmi.marshal.TaggedValue xmiTaggedValue = (org.soulspace.xmi.marshal.TaggedValue) xmiObj;
    org.soulspace.xmi.repository.elements.TaggedValue tv = new org.soulspace.xmi.repository.elements.TaggedValue();

    tv.setId(xmiTaggedValue.getXmi_id());

    Enumeration e1 = xmiTaggedValue.enumerateTaggedValueItem();
    while (e1.hasMoreElements()) {
      TaggedValueItem tvI = (TaggedValueItem) e1.nextElement();
      if (tvI.getTaggedValue_dataValue() != null) {
        if (tvI.getTaggedValue_dataValue().getContent() != null) {
          tv.setValue(tvI.getTaggedValue_dataValue().getContent());
        }
        Enumeration e2 = tvI.getTaggedValue_dataValue()
            .enumerateTaggedValue_dataValueItem();
        while (e2.hasMoreElements()) {
          TaggedValue_dataValue dv = (TaggedValue_dataValue) e2.nextElement();
          if (dv.getContent() != null) {
            tv.setValue(dv.getContent());
          }
        }
      } else if (tvI.getTaggedValue_type() != null) {
        Enumeration e2 = tvI.getTaggedValue_type()
            .enumerateTaggedValue_typeItem();
        while (e2.hasMoreElements()) {
          TaggedValue_typeItem tI = (TaggedValue_typeItem) e2.nextElement();
          ITagDefinition td = findTagDefinition(tI);
          if(td != null) {
            tv.setName(td.getName());
          } else {
            System.out.println("WARNING: TagDefinition not found for TaggedValue id: " + tv.getId());
          }
        }
      }
    }

    repository.register(tv);
    return tv;
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.soulspace.xmi.uml.IModelFactory#createMultiplicity(org.soulspace.xmi.base.XmiObject)
   */
  public IMultiplicity createMultiplicity(XmiObject xmiObj) {
    org.soulspace.xmi.marshal.Multiplicity xmiMultiplicity = (org.soulspace.xmi.marshal.Multiplicity) xmiObj;
    Multiplicity m = new Multiplicity();
    Enumeration e1 = xmiMultiplicity.enumerateMultiplicityItem();
    while (e1.hasMoreElements()) {
      MultiplicityItem mI = (MultiplicityItem) e1.nextElement();
      if (mI.getMultiplicity_range() != null) {
        Enumeration e2 = mI.getMultiplicity_range()
            .enumerateMultiplicity_rangeItem();
        while (e2.hasMoreElements()) {
          Multiplicity_rangeItem rI = (Multiplicity_rangeItem) e2.nextElement();
          if (rI.getMultiplicityRange() != null) {
            m.setLow(rI.getMultiplicityRange().getLower());
            m.setHigh(rI.getMultiplicityRange().getUpper());
          }
        }
      }
    }

    return m;
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.soulspace.xmi.uml.IModelFactory#createParameter(org.soulspace.xmi.base.XmiObject)
   */
  public IParameter createParameter(XmiObject xmiObj) {
    org.soulspace.xmi.marshal.Parameter xmiParameter = (org.soulspace.xmi.marshal.Parameter) xmiObj;
    Parameter p = new Parameter();

    p.setId(xmiParameter.getXmi_id());
    p.setName(xmiParameter.getName());
    p.setNamespace(xmiParameter.getNamespace());
    p.setQualifiedName(xmiParameter.getQualifiedName());
    if(xmiParameter.getKind() != null) {
      p.setKind(xmiParameter.getKind().toString());    	
    } else {
    	p.setKind(KindType.IN.toString());
    }

    Enumeration e1 = xmiParameter.enumerateParameterItem();
    while (e1.hasMoreElements()) {
      ParameterItem pI = (ParameterItem) e1.nextElement();
      if(pI.getModelElement_stereotype() != null) {
        addStereotypes(p, pI.getModelElement_stereotype());
      } else if (pI.getModelElement_taggedValue() != null) {
        addTaggedValues(p, pI.getModelElement_taggedValue());
      } else if (pI.getTypedElement_type() != null) {
    	  // UML2
    	  TypedElement_type teT = pI.getTypedElement_type();
    	  if (teT.getClazz() != null) {
              p.setType(findClass(teT.getClazz()));
          } else if (teT.getDataType() != null) {
              p.setType(findDataType(teT.getDataType()));
          } else if (teT.getInterface() != null) {
              p.setType(findInterface(teT.getInterface()));
          }
      } else if (pI.getParameter_type() != null) {
    	  // UML1
      	Enumeration e2 = pI.getParameter_type().enumerateParameter_typeItem();
        while (e2.hasMoreElements()) {
          Parameter_typeItem ptI = (Parameter_typeItem) e2.nextElement();
          if (ptI.getClazz() != null) {
            p.setType(findClass(ptI.getClazz()));
          } else if (ptI.getDataType() != null) {
            p.setType(findDataType(ptI.getDataType()));
          } else if (ptI.getInterface() != null) {
            p.setType(findInterface(ptI.getInterface()));
          }
        }
      }
    }
    if(p.getType() == null) {
    	System.out.println("ERROR: Parameter type not set for parameter " + p.getId());
    }
    if(p.getName() == null) {
    	System.out.println("ERROR: Parameter name not set for parameter " + p.getId());    	
    }
    return p;
  }
  
  public IDependency createDependency(XmiObject xmiObj) {
    org.soulspace.xmi.marshal.Dependency xmiDependency = (org.soulspace.xmi.marshal.Dependency) xmiObj;
    Dependency d = new Dependency();

    d.setId(xmiDependency.getXmi_id());
    d.setNamespace(xmiDependency.getNamespace());
    if(xmiDependency.getName() != null) {
      d.setName(xmiDependency.getName());
      d.setMethodSuffix(d.getName().substring(0, 1).toUpperCase()
        + d.getName().substring(1));
    }
    Enumeration e1 = xmiDependency.enumerateDependencyItem();
    while (e1.hasMoreElements()) {
      DependencyItem dI = (DependencyItem) e1.nextElement();
      if(dI.getModelElement_stereotype() != null) {
        addStereotypes(d, dI.getModelElement_stereotype());
      } else if (dI.getModelElement_taggedValue() != null) {
        addTaggedValues(d, dI.getModelElement_taggedValue());
      } else if(dI.getDependency_supplier() != null) {
        Enumeration e2 = dI.getDependency_supplier().enumerateDependency_supplierItem();
        while (e2.hasMoreElements()) {
          Dependency_supplierItem dsI = (Dependency_supplierItem) e2.nextElement();
          if(dsI.getClazz() != null) {
            d.setSupplier(findClass(dsI.getClazz()));
          } else if(dsI.getDataType() != null) {
            d.setSupplier(findDataType(dsI.getDataType()));
          } else if(dsI.getInterface() != null) {
            d.setSupplier(findInterface(dsI.getInterface()));
          }
        }
      } else if(dI.getDependency_client() != null) {
        Enumeration e2 = dI.getDependency_client().enumerateDependency_clientItem();
        while (e2.hasMoreElements()) {
          Dependency_clientItem dcI = (Dependency_clientItem) e2.nextElement();
          if(dcI.getClazz() != null) {
            IClass c = findClass(dcI.getClazz());
            d.setClient(c);
            c.addDependency(d);
          } else if(dcI.getDataType() != null) {
            d.setClient(findDataType(dcI.getDataType()));
          } else if(dcI.getInterface() != null) {
            d.setClient(findInterface(dcI.getInterface()));
          }
        }
      }
    }
    repository.register(d);
    return d;
  }
  
  /*
   *  (non-Javadoc)
   * @see org.soulspace.xmi.repository.IModelFactory#createUseCase(org.soulspace.xmi.base.XmiObject)
   */
	public IUseCase createUseCase(XmiObject xmiObj) {
		org.soulspace.xmi.marshal.UseCase xmiUseCase = (org.soulspace.xmi.marshal.UseCase) xmiObj;
		UseCase uc = new UseCase();

		uc.setId(xmiUseCase.getXmi_id());
		uc.setName(xmiUseCase.getName());
		uc.setNamespace(xmiUseCase.getNamespace());
		uc.setQualifiedName(xmiUseCase.getQualifiedName());
		
		Enumeration e1 = xmiUseCase.enumerateUseCaseItem();
		while (e1.hasMoreElements()) {
			UseCaseItem ucI = (UseCaseItem) e1.nextElement();
			if(ucI.getModelElement_stereotype() != null) {
				addStereotypes(uc, ucI.getModelElement_stereotype());
			} else if(ucI.getModelElement_taggedValue() != null) {
				addTaggedValues(uc, ucI.getModelElement_taggedValue());
			} else if(ucI.getUseCase_extend() != null) {
				
			} else if(ucI.getUseCase_extensionPoint() != null) {
				Enumeration e2 = ucI.getUseCase_extensionPoint().enumerateUseCase_extensionPointItem();
				while (e2.hasMoreElements()) {
					UseCase_extensionPointItem epI = (UseCase_extensionPointItem) e2.nextElement();
					if(epI.getExtensionPoint() != null) {
						uc.addExtensionPoint(createExtensionPoint(epI.getExtensionPoint()));						
					}
				}
			} else if(ucI.getUseCase_include() != null) {
//				Enumeration e2 = ucI.getUseCase_include().enumerateUseCase_includeItem();
//				while(e2.hasMoreElements()) {
//					UseCase_includeItem uciI = (UseCase_includeItem) e2.nextElement();
//					Enumeration e3 = uciI.getInclude().enumerateIncludeItem();
//					while (e3.hasMoreElements()) {
//						IncludeItem iI = (IncludeItem) e3.nextElement();
//						// TODO 
//						iI.getInclude_addition();
//						iI.getInclude_base();
//					}
//				}
			}
		}
		
    repository.register(uc);
		return uc;
	}

	ExtensionPoint createExtensionPoint(XmiObject xmiObj) {
		ExtensionPoint ep = new ExtensionPoint();
		org.soulspace.xmi.marshal.ExtensionPoint xmiExtensionPoint = (org.soulspace.xmi.marshal.ExtensionPoint) xmiObj;
		ep.setId(xmiExtensionPoint.getXmi_id());
		ep.setName(xmiExtensionPoint.getName());
		ep.setLocation(xmiExtensionPoint.getLocation());
		
		return ep;
	}
	
	/*
	 *  (non-Javadoc)
	 * @see org.soulspace.xmi.repository.IModelFactory#createActor(org.soulspace.xmi.base.XmiObject)
	 */
	public IActor createActor(XmiObject xmiObj) {
		org.soulspace.xmi.marshal.Actor xmiActor = (org.soulspace.xmi.marshal.Actor) xmiObj;
		Actor a = new Actor();
		
		a.setId(xmiActor.getXmi_id());
		a.setName(xmiActor.getName());
		a.setNamespace(xmiActor.getName());
		a.setQualifiedName(xmiActor.getQualifiedName());

		Enumeration e1 = xmiActor.enumerateActorItem();
		while (e1.hasMoreElements()) {
			ActorItem aI = (ActorItem) e1.nextElement();
			if(aI.getModelElement_stereotype() != null) {
				addStereotypes(a, aI.getModelElement_stereotype());
			} else if(aI.getModelElement_taggedValue() != null) {
				addTaggedValues(a, aI.getModelElement_taggedValue());
			}
		}
		// TODO add generalized Actor
		
    repository.register(a);
		return a;
	}

	/*
	 * (non-Javadoc)
	 * @see org.soulspace.xmi.repository.IModelFactory#createStateMachine(org.soulspace.xmi.base.XmiObject)
	 */
	public IStateMachine createStateMachine(XmiObject xmiObj) {
		org.soulspace.xmi.marshal.StateMachine xmiStateMachine = (org.soulspace.xmi.marshal.StateMachine) xmiObj;
		StateMachine sm = new StateMachine();
		sm.setId(xmiStateMachine.getXmi_id());
		sm.setNamespace(xmiStateMachine.getNamespace());
		sm.setQualifiedName(xmiStateMachine.getQualifiedName());
		if(xmiStateMachine.getName() != null) {
			sm.setName(xmiStateMachine.getName());
		}
		
		Enumeration e1 = xmiStateMachine.enumerateStateMachineItem();
		while (e1.hasMoreElements()) {
			StateMachineItem smI = (StateMachineItem) e1.nextElement();
			if(smI.getModelElement_stereotype() != null) {
				addStereotypes(sm, smI.getModelElement_stereotype());
			} else if(smI.getModelElement_taggedValue() != null) {
				addTaggedValues(sm, smI.getModelElement_taggedValue());
			} else if(smI.getStateMachine_top() != null) {
				Enumeration e2 = smI.getStateMachine_top().enumerateStateMachine_topItem();
				while (e2.hasMoreElements()) {
					StateMachine_topItem smtI = (StateMachine_topItem) e2.nextElement();
					// TODO create top states
					if(smtI.getCompositeState() != null) {
						Enumeration e3 = smtI.getCompositeState().enumerateCompositeStateItem();
						while (e3.hasMoreElements()) {
							CompositeStateItem csI = (CompositeStateItem) e3.nextElement();
							Enumeration e4 = csI.getCompositeState_subvertex().enumerateCompositeState_subvertexItem();
							while (e4.hasMoreElements()) {
								CompositeState_subvertexItem cssI = (CompositeState_subvertexItem) e4.nextElement();
								if(cssI.getSimpleState() != null) {
									sm.addState(createSimpleState(cssI.getSimpleState()));
								} else if(cssI.getPseudostate() != null) {
									sm.addState(createPseudostate(cssI.getPseudostate()));
								} else if(cssI.getFinalState() != null) {
									sm.addState(createFinalState(cssI.getFinalState()));
								} else if(cssI.getSubmachineState() != null) {
									// TODO
									// sm.addState(createSubmachineState(cssI.getSubmachineState()));
								}
							}
						}
					}
				}
			} else if(smI.getStateMachine_region() != null) {
				Enumeration e2 = smI.getStateMachine_region().getRegion().enumerateRegionItem();
				while (e2.hasMoreElements()) {
					RegionItem rI = (RegionItem) e2.nextElement();
					// TODO create region
				}
			} else if(smI.getStateMachine_submachineState() != null) {
				Enumeration e2 = smI.getStateMachine_submachineState().enumerateStateMachine_submachineStateItem();
				while (e2.hasMoreElements()) {
					StateMachine_submachineStateItem smssI = (StateMachine_submachineStateItem) e2.nextElement();
					// TODO create submachine state
					
				}
			} else if(smI.getStateMachine_transitions() != null) {
				Enumeration e2 = smI.getStateMachine_transitions().enumerateStateMachine_transitionsItem();
				while (e2.hasMoreElements()) {
					StateMachine_transitionsItem smtI = (StateMachine_transitionsItem) e2.nextElement();
					if(smtI.getTransition() != null) {
						sm.addTransition(createTransition(smtI.getTransition()));
					}
				}
			}
		}
		
    repository.register(sm);
		return sm;
	}
	
	IState createSimpleState(XmiObject xmiObj) {
		State s = new State();
		SimpleState xmiSimpleState = (SimpleState) xmiObj;
		s.setId(xmiSimpleState.getXmi_id());
		if(xmiSimpleState.getName() != null) {
			s.setName(xmiSimpleState.getName());
		} else {
			System.out.println("INFO: no name set for state");
		}
		// TODO complete
		Enumeration e1 = xmiSimpleState.enumerateSimpleStateItem();
		while(e1.hasMoreElements()) {
			SimpleStateItem ssI = (SimpleStateItem) e1.nextElement();
			if(ssI.getModelElement_stereotype() != null) {
				addStereotypes(s, ssI.getModelElement_stereotype());
			} else if(ssI.getModelElement_taggedValue() != null) {
				addTaggedValues(s, ssI.getModelElement_taggedValue());
			} else if(ssI.getStateVertex_incoming() != null) {
				
			} else if(ssI.getStateVertex_outgoing() != null) {
				
			} else {
				System.out.println("INFO: unhandled element on SimpleStateItem.");				
			}
		}
    repository.register(s);
		return s;
	}
	
	IPseudostate createPseudostate(XmiObject xmiObj) {
		Pseudostate ps = new Pseudostate();
		org.soulspace.xmi.marshal.Pseudostate xmiPseudostate = (org.soulspace.xmi.marshal.Pseudostate) xmiObj;
		ps.setKind(xmiPseudostate.getKind().toString());
		// TODO complete
		Enumeration e1 = xmiPseudostate.enumeratePseudostateItem();
		while (e1.hasMoreElements()) {
			PseudostateItem pI = (PseudostateItem) e1.nextElement();
			if(pI.getModelElement_stereotype() != null) {
				addStereotypes(ps, pI.getModelElement_stereotype());
			} else if(pI.getModelElement_taggedValue() != null) {
				addTaggedValues(ps, pI.getModelElement_taggedValue());
			} else if(pI.getStateVertex_outgoing() != null) {
				
			} else if(pI.getVertex_outgoing() != null) {
				
			} else {
				System.out.println("INFO: unhandled element on PseudostateItem.");								
			}
		}
    repository.register(ps);
		return ps;
	}
	
	IFinalState createFinalState(XmiObject xmiObj) {
		FinalState fs = new FinalState();
		org.soulspace.xmi.marshal.FinalState xmiFinalState = (org.soulspace.xmi.marshal.FinalState) xmiObj;
		fs.setId(xmiFinalState.getXmi_id());
		fs.setName(xmiFinalState.getName());
		// TODO complete
		Enumeration e1 = xmiFinalState.enumerateFinalStateItem();
		while (e1.hasMoreElements()) {
			FinalStateItem fsI = (FinalStateItem) e1.nextElement();
			if(fsI.getModelElement_stereotype() != null) {
				addStereotypes(fs, fsI.getModelElement_stereotype());
			} else if(fsI.getModelElement_taggedValue() != null) {
				addTaggedValues(fs, fsI.getModelElement_taggedValue());
			} else if(fsI.getStateVertex_incoming() != null) {
				
			} else if(fsI.getVertex_incoming() != null) {
				
			} else {
				System.out.println("INFO: unhandled element on FinalStateItem.");
			}
		}
    repository.register(fs);
		return fs;
	}
	
	ISubmachineState createSubmachineState(XmiObject xmiObj) {
		SubmachineState ss = new SubmachineState();
		org.soulspace.xmi.marshal.SubmachineState xmiSubmachineState = (org.soulspace.xmi.marshal.SubmachineState) xmiObj;
		
		ss.setId(xmiSubmachineState.getXmi_id());
		ss.setName(xmiSubmachineState.getName());
		
		Enumeration e1 = xmiSubmachineState.enumerateSubmachineStateItem();
		while (e1.hasMoreElements()) {
			SubmachineStateItem ssI = (SubmachineStateItem) e1.nextElement();
			if(ssI.getModelElement_stereotype() != null) {
				
			} else if(ssI.getModelElement_taggedValue() != null) {
				
			} else if(ssI.getStateVertex_incoming() != null) {
				
//			} else if(ssI.getStateVertex_outgoing() != null) {
				
			} else if(ssI.getSubmachineState_submachine() != null) {
				Enumeration e2 = ssI.getSubmachineState_submachine().enumerateSubmachineState_submachineItem();
				while (e2.hasMoreElements()) {
					SubmachineState_submachineItem sssI = (SubmachineState_submachineItem) e2.nextElement();
					// FIXME ???
					// sssI.getStateMachine();
				}
			} else {
				System.out.println("INFO: unhandled element on SubmachineStateItem.");
			}
		}		
    repository.register(ss);
		return ss;
	}
	
	ITransition createTransition(XmiObject xmiObj) {
		IState source = null;
		IState target = null;
		Transition t = new Transition();
		org.soulspace.xmi.marshal.Transition xmiTransition = (org.soulspace.xmi.marshal.Transition) xmiObj;
	
		t.setId(xmiTransition.getXmi_id());
		if(xmiTransition.getName() != null) {
			t.setName(xmiTransition.getName());
		}
		// TODO further transition attributes
		
		Enumeration e1 = xmiTransition.enumerateTransitionItem();
		while (e1.hasMoreElements()) {
			TransitionItem tI = (TransitionItem) e1.nextElement();
			if(tI.getModelElement_stereotype() != null) {
				addStereotypes(t, tI.getModelElement_stereotype());
			} else if(tI.getModelElement_taggedValue() != null) {
				addTaggedValues(t, tI.getModelElement_taggedValue());
			} else if(tI.getTransition_trigger() != null) {
				Enumeration e2 = tI.getTransition_trigger().enumerateTransition_triggerItem();
				while (e2.hasMoreElements()) {
					Transition_triggerItem ttI = (Transition_triggerItem) e2.nextElement();
					if(ttI.getCallEvent() != null) {
						t.addEvent(findEvent(ttI.getCallEvent().getXmi_idref()));
					}
				}
			} else if(tI.getTransition_source() != null) {
				if(tI.getTransition_source().getSimpleState() != null) {
					source = findState(tI.getTransition_source().getSimpleState().getXmi_idref());
				} else if(tI.getTransition_source().getPseudostate() != null) {
					source = findState(tI.getTransition_source().getPseudostate().getXmi_idref());
				} else if(tI.getTransition_source().getSubmachineState() != null) {
					source = findState(tI.getTransition_source().getSubmachineState().getXmi_idref());					
				} else if(tI.getTransition_source().getState() != null) {
					source = findState(tI.getTransition_source().getState().getXmi_idref());					
				} else if(tI.getTransition_source().getCompositeState() != null) {
					source = findState(tI.getTransition_source().getCompositeState().getXmi_idref());					
				} else {
					System.out.println("INFO: unkown transition source type on transition " + t.getId());
				}
			} else if(tI.getTransition_target() != null) {
				if(tI.getTransition_target().getSimpleState() != null) {
					target = findState(tI.getTransition_target().getSimpleState().getXmi_idref());
				} else if(tI.getTransition_target().getPseudostate() != null) {
					target = findState(tI.getTransition_target().getPseudostate().getXmi_idref());
				} else if(tI.getTransition_target().getSubmachineState() != null) {
					target = findState(tI.getTransition_target().getSubmachineState().getXmi_idref());					
				} else if(tI.getTransition_target().getState() != null) {
					target = findState(tI.getTransition_target().getState().getXmi_idref());					
				} else if(tI.getTransition_target().getCompositeState() != null) {
					target = findState(tI.getTransition_target().getCompositeState().getXmi_idref());					
				} else if(tI.getTransition_target().getFinalState() != null) {
					target = findState(tI.getTransition_target().getFinalState().getXmi_idref());					
				} else {
					System.out.println("INFO: unkown transition target type on transition " + t.getId());
				}				
			}
		}
		if(source != null) {
			source.addOutgoingTransition(t);
			t.setSource(source);			
		} else {
			System.out.println("ERROR: Transition source not set for transition " + t.getId());			
		}
		if(target != null) {
			target.addIncomingTransition(t);
			t.setTarget(target);
		} else {
			System.out.println("ERROR: Transition target not set for transition " + t.getId());
		}
    repository.register(t);
		return t;
	}
	
	ICallEvent createCallEvent(org.soulspace.xmi.marshal.CallEvent xmiCallEvent) {
		CallEvent ce = new CallEvent();
		ce.setId(xmiCallEvent.getXmi_id());
		ce.setName(xmiCallEvent.getName());
		ce.setNamespace(xmiCallEvent.getNamespace());
		ce.setQualifiedName(ce.getQualifiedName());
		// TODO
		
		Enumeration e1 = xmiCallEvent.enumerateCallEventItem();
		while (e1.hasMoreElements()) {
			CallEventItem ceI = (CallEventItem) e1.nextElement();
			if(ceI.getEvent_parameter() != null) {
				Enumeration e2 = ceI.getEvent_parameter().enumerateEvent_parameterItem();
				while (e2.hasMoreElements()) {
					Event_parameterItem epI = (Event_parameterItem) e2.nextElement();
					if(epI.getParameter() != null) {
						ce.addParameter(createParameter(epI.getParameter()));						
					}
				}
			}
		}
		repository.register(ce);
		return ce;
	}
	
	
  /*
   * (non-Javadoc)
   * 
   * @see org.soulspace.xmi.uml.IModelFactory#processGeneralization(org.soulspace.xmi.base.XmiObject)
   */
  public void processGeneralization(XmiObject xmiObj) {
    org.soulspace.xmi.marshal.Generalization xmiGeneralization = (org.soulspace.xmi.marshal.Generalization) xmiObj;
    IClass superClass = null;
    IClass subClass = null;
    Enumeration e1 = xmiGeneralization.enumerateGeneralizationItem();
    while (e1.hasMoreElements()) {
      GeneralizationItem gI = (GeneralizationItem) e1.nextElement();
      if (gI.getGeneralization_parent() != null) {
        Enumeration e2 = gI.getGeneralization_parent()
            .enumerateGeneralization_parentItem();
        while (e2.hasMoreElements()) {
          Generalization_parentItem gpI = (Generalization_parentItem) e2
              .nextElement();
          superClass = findClass(gpI.getClazz());
        }
      } else if (gI.getGeneralization_child() != null) {
        Enumeration e2 = gI.getGeneralization_child()
            .enumerateGeneralization_childItem();
        while (e2.hasMoreElements()) {
          Generalization_childItem gcI = (Generalization_childItem) e2
              .nextElement();
          subClass = findClass(gcI.getClazz());
        }
      }
    }
    if (subClass != null && superClass != null) {
      subClass.addSuperClass(superClass);
      superClass.addSubClass(subClass);
    }
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.soulspace.xmi.uml.IModelFactory#processAssociation(org.soulspace.xmi.base.XmiObject)
   */
  public void processAssociation(XmiObject xmiObj) {
    org.soulspace.xmi.marshal.Association xmiAssociation = (org.soulspace.xmi.marshal.Association) xmiObj;
    IAssociationEnd fromEnd = null;
    IAssociationEnd toEnd = null;

    IAssociation a = createAssociation(xmiAssociation);
    
    List aeList = new ArrayList();
    Enumeration e1 = xmiAssociation.enumerateAssociationItem();
    while (e1.hasMoreElements()) {
      AssociationItem aI = (AssociationItem) e1.nextElement();
      if (aI.getAssociation_connection() != null) {
        Enumeration e2 = aI.getAssociation_connection()
            .enumerateAssociation_connectionItem();
        while (e2.hasMoreElements()) {
        	// TODO add association ends in 'from' and 'to'
          Association_connectionItem cI = (Association_connectionItem) e2
              .nextElement();
          if (cI.getAssociationEnd() != null) {
            IAssociationEnd ae = createAssociationEnd(cI.getAssociationEnd());
            ((AssociationEnd) ae).setAssociation(a);
            if (fromEnd == null) {
              fromEnd = ae;
            } else if (toEnd == null) {
              toEnd = ae;
            }
          }
        }
      }
    }

    if(fromEnd != null && fromEnd.getType() != null
        && toEnd != null && toEnd.getType() != null) {
    	// set ends on association
    	a.setFromEnd(fromEnd);
      a.setToEnd(toEnd);

      // set references to each other
    	((AssociationEnd) fromEnd).setSourceEnd(toEnd);
    	((AssociationEnd) toEnd).setSourceEnd(fromEnd);

    	// FIXME add other types (UseCase, Actor, ...)
      ((Class) fromEnd.getType()).addAssociation(toEnd);
      ((Class) toEnd.getType()).addAssociation(fromEnd);
    }
    Package p = (Package) repository.lookupPackageByQualifiedName(a.getNamespace());
    if (p != null) {
      p.addAssociation(a);
    }

    repository.register(a);
  }
  
  public void processInclude(XmiObject xmiObj) {
  	IUseCase base = null;
  	IUseCase addition = null;
  	Include xmiInclude = (Include) xmiObj;
  	Enumeration e1 = xmiInclude.enumerateIncludeItem();
  	while (e1.hasMoreElements()) {
			IncludeItem iI = (IncludeItem) e1.nextElement();
			if(iI.getInclude_base() != null) {
				base = findUseCase(iI.getInclude_base().getUseCase());
			} else if(iI.getInclude_addition() != null) {
				addition = findUseCase(iI.getInclude_addition().getUseCase());
			}
		}
  	if(base != null && addition != null) {
  		base.addInclude(addition);
  		addition.addIncluded(base);
  	}
  }
  
  public void processExtend(XmiObject xmiObj) {
  	IUseCase base = null;
  	IUseCase extension = null;
  	IExtensionPoint extensionPoint = null;
  	Extend xmiExtend = (Extend) xmiObj;
  	Enumeration e1 = xmiExtend.enumerateExtendItem();
  	while (e1.hasMoreElements()) {
			ExtendItem eI = (ExtendItem) e1.nextElement();
			if(eI.getExtend_base() != null) {
				Enumeration e2 = eI.getExtend_base().enumerateExtend_baseItem();
				while (e2.hasMoreElements()) {
					Extend_baseItem ebI = (Extend_baseItem) e2.nextElement();
					base = findUseCase(ebI.getUseCase());
				}
			} else if(eI.getExtend_extension() != null) {
				Enumeration e2 = eI.getExtend_extension().enumerateExtend_extensionItem();
				while (e2.hasMoreElements()) {
					Extend_extensionItem eeI = (Extend_extensionItem) e2.nextElement();
					extension = findUseCase(eeI.getUseCase());
				}
			} else if(eI.getExtend_extensionPoint() != null) {
				Enumeration e2 = eI.getExtend_extensionPoint().enumerateExtend_extensionPointItem();
				while (e2.hasMoreElements()) {
					Extend_extensionPointItem eepI = (Extend_extensionPointItem) e2.nextElement();
					extensionPoint = findExtensionPoint(eepI.getExtensionPoint());
				}
			}
		}
  }
  
  IClass findClass(org.soulspace.xmi.marshal.Class c) {
    if (c != null && c.getXmi_idref() != null) {
      return (Class) repository.lookupByXmiId(c.getXmi_idref());
    }
    return null;
  }

  private IDataType findDataType(org.soulspace.xmi.marshal.DataType dt) {
    if (dt != null && dt.getXmi_idref() != null) {
      return (DataType) repository.lookupByXmiId(dt.getXmi_idref());
    }
    return null;
  }

  /**
   * @param interface1
   * @return
   */
  private IInterface findInterface(org.soulspace.xmi.marshal.Interface i) {
    if (i != null && i.getXmi_idref() != null) {
      return (Interface) repository.lookupByXmiId(i.getXmi_idref());
    }
    return null;
  }

  private IUseCase findUseCase(org.soulspace.xmi.marshal.UseCase uc) {
  	if(uc != null && uc.getXmi_idref() != null) {
  		return (IUseCase) repository.lookupByXmiId(uc.getXmi_id());
  	}
  	return null;
  }
  
  private IExtensionPoint findExtensionPoint(org.soulspace.xmi.marshal.ExtensionPoint ep) {
  	if(ep != null && ep.getXmi_idref() != null) {
  		return (IExtensionPoint) repository.lookupByXmiId(ep.getXmi_id());
  	}
  	return null;
  }  

	private IActor findActor(org.soulspace.xmi.marshal.Actor a) {
    if (a != null && a.getXmi_idref() != null) {
      return (IActor) repository.lookupByXmiId(a.getXmi_idref());
    }
    return null;
	}

	private IAssociationEnd findAssociationEnd(String id) {
     return (IAssociationEnd) repository.lookupByXmiId(id);
	}

	private IState findState(String id) {
    return (IState) repository.lookupByXmiId(id);
	}

  private IEvent findEvent(String id) {
  	return (IEvent) repository.lookupByXmiId(id);
  }

  private IAssociation findAssociation(org.soulspace.xmi.marshal.Association a) {
    if (a != null && a.getXmi_id() != null) {
      return (IAssociation) repository.lookupByXmiId(a.getXmi_id());
    }
    return null;
	}

  private Stereotype findStereotype(ModelElement_stereotypeItem stI) {
    if (stI.getStereotype() != null &&stI.getStereotype().getXmi_idref() != null) {
      return (Stereotype) repository.lookupByXmiId(stI.getStereotype().getXmi_idref());
    }
    return null;
  }

  TagDefinition findTagDefinition(TaggedValue_typeItem tI) {
    if (tI.getTagDefinition() != null) {
      String xmiId = tI.getTagDefinition().getXmi_idref();
      if (xmiId != null) {
        return (TagDefinition) repository.lookupByXmiId(xmiId);
      }
    }
    return null;
  }
  
  void addStereotypes(IElement element, ModelElement_stereotype mEST) {
    Enumeration e1 = mEST.enumerateModelElement_stereotypeItem();
    while (e1.hasMoreElements()) {
      ModelElement_stereotypeItem stI = (ModelElement_stereotypeItem) e1
          .nextElement();
      if (stI.getStereotype() != null) {
        String xmiId = stI.getStereotype().getXmi_idref();
        if (xmiId != null) {
          IStereotype st = (IStereotype) repository.lookupByXmiId(xmiId);
          if (st != null) {
            element.addStereotype(st);
          }
        }
      }
    }
  }

  void addTaggedValues(IElement element, ModelElement_taggedValue mETV) {
    Enumeration e1 = mETV.enumerateModelElement_taggedValueItem();
    while (e1.hasMoreElements()) {
      ModelElement_taggedValueItem tvI = (ModelElement_taggedValueItem) e1
          .nextElement();
      if (tvI.getTaggedValue() != null) {
        org.soulspace.xmi.marshal.TaggedValue tv = tvI.getTaggedValue();
        ITaggedValue mTV = createTaggedValue(tv);
        element.addTaggedValue(mTV);
      }
    }
  }

  
  public String fetchReturnType(org.soulspace.xmi.marshal.Operation xmiOperation) {
    String xmiId = "";
    Enumeration e = xmiOperation.enumerateOperationItem();
    while (e.hasMoreElements()) {
      OperationItem oI = (OperationItem) e.nextElement();
      if(oI.getBehavioralFeature_parameter() != null) {
        Enumeration e2 = oI.getBehavioralFeature_parameter().enumerateBehavioralFeature_parameterItem();
        while(e2.hasMoreElements()) {
          BehavioralFeature_parameterItem bp = (BehavioralFeature_parameterItem) e2.nextElement();
          if(bp.getParameter().getKind() != null && bp.getParameter().getKind().equals(KindType.RETURN)) {
            Enumeration e3 = bp.getParameter().enumerateParameterItem();
            while(e3.hasMoreElements()) {
              ParameterItem pI = (ParameterItem) e3.nextElement();
              if(pI.getTypedElement_type() != null) {
                // UML2 TypedElement.type
                TypedElement_type tet = pI.getTypedElement_type();
                if(tet.getClazz() != null) {
                  xmiId = tet.getClazz().getXmi_idref();
                } else if(tet.getDataType() != null) {
                  xmiId = tet.getDataType().getXmi_idref(); 
                } else if(tet.getInterface() != null) {
                  xmiId = tet.getInterface().getXmi_idref();
                }                
              } else if(pI.getParameter_type() != null) {
                // UML ParameterType
                Enumeration e5 = pI.getParameter_type().enumerateParameter_typeItem();
                while (e5.hasMoreElements()) {
                  Parameter_typeItem ptI = (Parameter_typeItem) e5.nextElement();
                  if(ptI.getClazz() != null) {
                    xmiId = ptI.getClazz().getXmi_idref();
                  } else if(ptI.getDataType() != null) {
                    xmiId = ptI.getDataType().getXmi_idref(); 
                  } else if(ptI.getInterface() != null) {
                    xmiId = ptI.getInterface().getXmi_idref();
                  }
                }
              } else if(pI.getModelElement_stereotype() != null) {
                // TODO check if there's nothing to do for return types
              } else if(pI.getModelElement_taggedValue() != null) {
                // TODO check if there's nothing to do for return types
              }
            }
          }
        }
      }
    }
    return xmiId;
  }
  
}