/*
 * ModelFactory.java
 */
package org.soulspace.mdlrepo.metamodel.impl;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import org.soulspace.mdlrepo.IModelFactory;
import org.soulspace.mdlrepo.IModelRepository;
import org.soulspace.mdlrepo.impl.ModelRepository;
import org.soulspace.mdlrepo.metamodel.*;
import org.soulspace.xmi.base.XmiObject;
import org.soulspace.xmi.marshal.*;
import org.soulspace.xmi.marshal.types.KindType;
import org.soulspace.xmi.util.XmiHelper;

/**
 * Model factory
 * 
 * @author Solbach (Last update: $Author$, $Date$)
 * @version $Revision$
 */
public class ModelFactory implements IModelFactory {

	private IModelRepository repository;

	/**
   * 
   */
	public ModelFactory(IModelRepository mr) {
		super();
		this.repository = mr;
	}

	public ModelFactory() {
		this.repository = new ModelRepository();
	}

	public IModelRepository getModelRepository() {
		return repository;
	}

	public void setModelRepository(IModelRepository mr) {
		this.repository = mr;
	}

	public IAction createAction(XmiObject xmiObj) {
		IAction action = null;
		if(xmiObj instanceof org.soulspace.xmi.marshal.CallAction) {
			action = createCallAction(xmiObj);
		} else if(xmiObj instanceof org.soulspace.xmi.marshal.CreateAction) {
			action = createCreateAction(xmiObj);			
		} else if(xmiObj instanceof org.soulspace.xmi.marshal.DestroyAction) {
			action = createDestroyAction(xmiObj);
		} else if(xmiObj instanceof org.soulspace.xmi.marshal.SendAction) {
			action = createSendAction(xmiObj);
		}
		return action;
	}
	
	public IModel createModel(XmiObject xmiObj) {
		org.soulspace.xmi.marshal.Model xmiModel = (org.soulspace.xmi.marshal.Model) xmiObj;
		IModel model = getModelInstance(xmiModel);
		model = initModel(model, xmiModel);
		repository.register(model);
		return model;
	}

	public IPackage createPackage(XmiObject xmiObj) {
		org.soulspace.xmi.marshal.Package xmiPackage = (org.soulspace.xmi.marshal.Package) xmiObj;
		IPackage pkg = getPackageInstance(xmiPackage);
		pkg = initPackage(pkg, xmiPackage);
		repository.register(pkg);
		return pkg;
	}

	public IClass createClass(XmiObject xmiObj) {
		org.soulspace.xmi.marshal.Class xmiClass = (org.soulspace.xmi.marshal.Class) xmiObj;
		IClass clazz = getClassInstance(xmiClass);
		clazz = initClass(clazz, xmiClass);
		repository.register(clazz);
		return clazz;
	}

	public IAssociationClass createAssociationClass(XmiObject xmiObj) {
		org.soulspace.xmi.marshal.AssociationClass xmiAssociationClass = (org.soulspace.xmi.marshal.AssociationClass) xmiObj;
		IAssociationClass ac = getAssociationClassInstance(xmiAssociationClass);
		ac = initAssociationClass(ac, xmiAssociationClass);
		repository.register(ac);
		return ac;
	}

	public IInterface createInterface(XmiObject xmiObj) {
		org.soulspace.xmi.marshal.Interface xmiInterface = (org.soulspace.xmi.marshal.Interface) xmiObj;
		IInterface i = getInterfaceInstance(xmiInterface);
		i = initInterface(i, xmiInterface);
		repository.register(i);
		return i;
	}

	public IDataType createDataType(XmiObject xmiObj) {
		org.soulspace.xmi.marshal.DataType xmiDataType = (org.soulspace.xmi.marshal.DataType) xmiObj;
		IDataType dt = getDataTypeInstance(xmiDataType);
		dt = initDataType(dt, xmiDataType);
		repository.register(dt);
		return dt;
	}

	public IEnumerationType createEnumerationType(XmiObject xmiObj) {
		org.soulspace.xmi.marshal.Enumeration xmiEnumerationType = (org.soulspace.xmi.marshal.Enumeration) xmiObj;
		IEnumerationType et = getEnumerationTypeInstance(xmiEnumerationType);
		et = initEnumerationType(et, xmiEnumerationType);
		repository.register(et);
		return et;
	}

	public IAttribute createAttribute(XmiObject xmiObj) {
		org.soulspace.xmi.marshal.Attribute xmiAttribute = (org.soulspace.xmi.marshal.Attribute) xmiObj;
		IAttribute a = getAttributeInstance(xmiAttribute);
		a = initAttribute(a, xmiAttribute);
		repository.register(a);
		return a;
	}

	public IOperation createOperation(XmiObject xmiObj) {
		org.soulspace.xmi.marshal.Operation xmiOperation = (org.soulspace.xmi.marshal.Operation) xmiObj;
		IOperation o = getOperationInstance(xmiOperation);
		o = initOperation(o, xmiOperation);
		repository.register(o);
		return o;
	}

	public IAssociation createAssociation(XmiObject xmiObj) {
		org.soulspace.xmi.marshal.Association xmiAssociation = (org.soulspace.xmi.marshal.Association) xmiObj;
		IAssociation a = getAssociationInstance(xmiAssociation);
		a = initAssociation(a, xmiAssociation);
		repository.register(a);
		return a;
	}

	public IAssociationEnd createAssociationEnd(XmiObject xmiObj) {
		org.soulspace.xmi.marshal.AssociationEnd xmiAssociationEnd = (org.soulspace.xmi.marshal.AssociationEnd) xmiObj;
		IAssociationEnd ae = getAssociationEndInstance(xmiAssociationEnd);
		ae = initAssociationEnd(ae, xmiAssociationEnd);
		repository.register(ae);
		return ae;
	}

	public IStereotype createStereotype(XmiObject xmiObj) {
		org.soulspace.xmi.marshal.Stereotype xmiStereotype = (org.soulspace.xmi.marshal.Stereotype) xmiObj;
		IStereotype s = getStereotypeInstance(xmiStereotype);
		s = initStereotype(s, xmiStereotype);
		repository.register(s);
		return s;
	}

	public ITagDefinition createTagDefinition(XmiObject xmiObj) {
		org.soulspace.xmi.marshal.TagDefinition xmiTagDefinition = (org.soulspace.xmi.marshal.TagDefinition) xmiObj;
		ITagDefinition td = getTagDefinitionInstance(xmiTagDefinition);
		td = initTagDefinition(td, xmiTagDefinition);
		repository.register(td);
		return td;
	}

	public ITaggedValue createTaggedValue(XmiObject xmiObj) {
		org.soulspace.xmi.marshal.TaggedValue xmiTaggedValue = (org.soulspace.xmi.marshal.TaggedValue) xmiObj;
		ITaggedValue tv = getTaggedValueInstance(xmiTaggedValue);
		tv = initTaggedValue(tv, xmiTaggedValue);
		repository.register(tv);
		return tv;
	}

	public IParameter createParameter(XmiObject xmiObj) {
		org.soulspace.xmi.marshal.Parameter xmiParameter = (org.soulspace.xmi.marshal.Parameter) xmiObj;
		IParameter p = getParameterInstance(xmiParameter);
		p = initParameter(p, xmiParameter);
		repository.register(p);
		return p;
	}

	public IDependency createDependency(XmiObject xmiObj) {
		org.soulspace.xmi.marshal.Dependency xmiDependency = (org.soulspace.xmi.marshal.Dependency) xmiObj;
		IDependency d = getDependencyInstance(xmiDependency);
		d = initDependency(d, xmiDependency);
		repository.register(d);
		return d;
	}

	public IUseCase createUseCase(XmiObject xmiObj) {
		org.soulspace.xmi.marshal.UseCase xmiUseCase = (org.soulspace.xmi.marshal.UseCase) xmiObj;
		IUseCase uc = getUseCaseInstance(xmiUseCase);
		uc = initUseCase(uc, xmiUseCase);
		repository.register(uc);
		return uc;
	}

	public IExtensionPoint createExtensionPoint(XmiObject xmiObj) {
		org.soulspace.xmi.marshal.ExtensionPoint xmiExtensionPoint = (org.soulspace.xmi.marshal.ExtensionPoint) xmiObj;
		IExtensionPoint ep = getExtensionPointInstance(xmiExtensionPoint);
		ep = initExtensionPoint(ep, xmiExtensionPoint);
		repository.register(ep);
		return ep;
	}

	public IActor createActor(XmiObject xmiObj) {
		org.soulspace.xmi.marshal.Actor xmiActor = (org.soulspace.xmi.marshal.Actor) xmiObj;
		IActor a = getActorInstance(xmiActor);
		a = initActor(a, xmiActor);
		repository.register(a);
		return a;
	}

	public IStateMachine createStateMachine(XmiObject xmiObj) {
		org.soulspace.xmi.marshal.StateMachine xmiStateMachine = (org.soulspace.xmi.marshal.StateMachine) xmiObj;
		IStateMachine sm = getStateMachineInstance(xmiStateMachine);
		sm = initStateMachine(sm, xmiStateMachine);
		repository.register(sm);
		return sm;
	}

	public ICompositeState createCompositeState(XmiObject xmiObj) {
		org.soulspace.xmi.marshal.CompositeState xmiCompositeState = (org.soulspace.xmi.marshal.CompositeState) xmiObj;
		ICompositeState s = getCompositeStateInstance(xmiCompositeState);
		s = initCompositeState(s, xmiCompositeState);
		repository.register(s);
		return s;
	}

	public IState createSimpleState(XmiObject xmiObj) {
		SimpleState xmiSimpleState = (SimpleState) xmiObj;
		IState s = getSimpleStateInstance(xmiSimpleState);
		s = initSimpleState(s, xmiSimpleState);
		repository.register(s);
		return s;
	}

	public IPseudostate createPseudostate(XmiObject xmiObj) {
		org.soulspace.xmi.marshal.Pseudostate xmiPseudostate = (org.soulspace.xmi.marshal.Pseudostate) xmiObj;
		IPseudostate ps = getPseudostateInstance(xmiPseudostate);
		ps = initPseudostate(ps, xmiPseudostate);
		repository.register(ps);
		return ps;
	}

	public IFinalState createFinalState(XmiObject xmiObj) {
		org.soulspace.xmi.marshal.FinalState xmiFinalState = (org.soulspace.xmi.marshal.FinalState) xmiObj;
		IFinalState fs = getFinalStateInstance(xmiFinalState);
		fs = initFinalState(fs, xmiFinalState);
		repository.register(fs);
		return fs;
	}

	public ISubmachineState createSubmachineState(XmiObject xmiObj) {
		org.soulspace.xmi.marshal.SubmachineState xmiSubmachineState = (org.soulspace.xmi.marshal.SubmachineState) xmiObj;
		ISubmachineState ss = getSubmachineStateInstance(xmiSubmachineState);
		ss = initSubmachineState(ss, xmiSubmachineState);
		repository.register(ss);
		return ss;
	}

	public ITransition createTransition(XmiObject xmiObj) {
		org.soulspace.xmi.marshal.Transition xmiTransition = (org.soulspace.xmi.marshal.Transition) xmiObj;
		ITransition t = getTransitionInstance(xmiTransition);
		t = initTransition(t, xmiTransition);
		repository.register(t);
		return t;
	}

	public ICallEvent createCallEvent(XmiObject xmiObj) {
		org.soulspace.xmi.marshal.CallEvent xmiCallEvent = (org.soulspace.xmi.marshal.CallEvent) xmiObj;
		ICallEvent ce = getCallEventInstance(xmiCallEvent);
		ce = initCallEvent(ce, xmiCallEvent);
		repository.register(ce);
		return ce;
	}

	public ISignalEvent createSignalEvent(XmiObject xmiObj) {
		org.soulspace.xmi.marshal.SignalEvent xmiSignalEvent = (org.soulspace.xmi.marshal.SignalEvent) xmiObj;
		ISignalEvent se = getSignalEventInstance(xmiSignalEvent);
		se = initSignalEvent(se, xmiSignalEvent);
		repository.register(se);
		return se;
	}

	public IChangeEvent createChangeEvent(XmiObject xmiObj) {
		org.soulspace.xmi.marshal.ChangeEvent xmiChangeEvent = (org.soulspace.xmi.marshal.ChangeEvent) xmiObj;
		IChangeEvent ce = getChangeEventInstance(xmiChangeEvent);
		ce = initChangeEvent(ce, xmiChangeEvent);
		repository.register(ce);
		return ce;
	}

	public ITimeEvent createTimeEvent(XmiObject xmiObj) {
		org.soulspace.xmi.marshal.TimeEvent xmiTimeEvent = (org.soulspace.xmi.marshal.TimeEvent) xmiObj;
		ITimeEvent te = getTimeEventInstance(xmiTimeEvent);
		te = initTimeEvent(te, xmiTimeEvent);
		repository.register(te);
		return te;
	}

	public IArgument createArgument(XmiObject xmiObj) {
		org.soulspace.xmi.marshal.Argument xmiArgument = (org.soulspace.xmi.marshal.Argument) xmiObj;
		IArgument a = getArgumentInstance(xmiArgument);
		a = initArgument(a, xmiArgument);
		repository.register(a);
		return a;
	}

	public ICallAction createCallAction(XmiObject xmiObj) {
		org.soulspace.xmi.marshal.CallAction xmiCallAction = (org.soulspace.xmi.marshal.CallAction) xmiObj;
		ICallAction ca = getCallActionInstance(xmiCallAction);
		ca = initCallAction(ca, xmiCallAction);
		repository.register(ca);
		return ca;
	}

	public ICreateAction createCreateAction(XmiObject xmiObj) {
		org.soulspace.xmi.marshal.CreateAction xmiCreateAction = (org.soulspace.xmi.marshal.CreateAction) xmiObj;
		ICreateAction ca = getCreateActionInstance(xmiCreateAction);
		ca = initCreateAction(ca, xmiCreateAction);
		repository.register(ca);
		return ca;
	}

	public IDestroyAction createDestroyAction(XmiObject xmiObj) {
		org.soulspace.xmi.marshal.DestroyAction xmiDestroyAction = (org.soulspace.xmi.marshal.DestroyAction) xmiObj;
		IDestroyAction ca = getDestroyActionInstance(xmiDestroyAction);
		ca = initDestroyAction(ca, xmiDestroyAction);
		repository.register(ca);
		return ca;
	}

	public ISendAction createSendAction(XmiObject xmiObj) {
		org.soulspace.xmi.marshal.SendAction xmiSendAction = (org.soulspace.xmi.marshal.SendAction) xmiObj;
		ISendAction ca = getSendActionInstance(xmiSendAction);
		ca = initSendAction(ca, xmiSendAction);
		repository.register(ca);
		return ca;
	}

	public IReturnAction createReturnAction(XmiObject xmiObj) {
		org.soulspace.xmi.marshal.ReturnAction xmiReturnAction = (org.soulspace.xmi.marshal.ReturnAction) xmiObj;
		IReturnAction ca = getReturnActionInstance(xmiReturnAction);
		ca = initReturnAction(ca, xmiReturnAction);
		repository.register(ca);
		return ca;
	}

	public ITerminateAction createTerminateAction(XmiObject xmiObj) {
		org.soulspace.xmi.marshal.TerminateAction xmiTerminateAction = (org.soulspace.xmi.marshal.TerminateAction) xmiObj;
		ITerminateAction ca = getTerminateActionInstance(xmiTerminateAction);
		ca = initTerminateAction(ca, xmiTerminateAction);
		repository.register(ca);
		return ca;
	}

	public IUninterpretedAction createUninterpretedAction(XmiObject xmiObj) {
		org.soulspace.xmi.marshal.UninterpretedAction xmiUninterpretedAction = (org.soulspace.xmi.marshal.UninterpretedAction) xmiObj;
		IUninterpretedAction ca = getUninterpretedActionInstance(xmiUninterpretedAction);
		ca = initUninterpretedAction(ca, xmiUninterpretedAction);
		repository.register(ca);
		return ca;
	}

	public IActionSequence createActionSequence(XmiObject xmiObj) {
		org.soulspace.xmi.marshal.ActionSequence xmiActionSequence = (org.soulspace.xmi.marshal.ActionSequence) xmiObj;
		IActionSequence ca = getActionSequenceInstance(xmiActionSequence);
		ca = initActionSequence(ca, xmiActionSequence);
		repository.register(ca);
		return ca;
	}

	// protected void initNamedElement(INamedElement n,
	// org.soulspace.xmi.marshal.NamedElement xmiNamedElement) {
	//		
	// }

	protected IModel getModelInstance(org.soulspace.xmi.marshal.Model xmiModel) {
		Model m = new Model();
		m.setId(xmiModel.getXmi_id());
		return m;
	}

	protected IModel initModel(IModel m,
			org.soulspace.xmi.marshal.Model xmiModel) {
		m.setId(xmiModel.getXmi_id());
		m.setProfileElement(xmiModel.getProfileElement());
		m.setName(xmiModel.getName());
		m.setNamespace("");
		m.setQualifiedName(xmiModel.getName());
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
		return m;
	}

	protected Package getPackageInstance(
			org.soulspace.xmi.marshal.Package xmiPackage) {
		Package p = new Package();
		p.setId(xmiPackage.getXmi_id());
		return p;
	}

	protected IPackage initPackage(IPackage p,
			org.soulspace.xmi.marshal.Package xmiPackage) {
		p.setProfileElement(xmiPackage.getProfileElement());
		p.setNamespace(xmiPackage.getNamespace());
		p.setQualifiedName(xmiPackage.getQualifiedName());
		p.setName(xmiPackage.getName());
		p.setPackage(findPackage(p.getNamespace()));

		// FIXME implement reference to model in package, so that packages can be added to models
		Model m = (Model) findModel("Don't know how at the moment");
		if (m != null) {
			//p.setModel(m);
			m.addPackage(p);
		}

		Enumeration e1 = xmiPackage.enumeratePackageItem();
		while (e1.hasMoreElements()) {
			PackageItem pI = (PackageItem) e1.nextElement();
			if (pI.getModelElement_stereotype() != null) {
				addStereotypes(p, pI.getModelElement_stereotype());
			} else if (pI.getModelElement_taggedValue() != null) {
				addTaggedValues(p, pI.getModelElement_taggedValue());
			}
		}
		return p;
	}

	protected IClass getClassInstance(org.soulspace.xmi.marshal.Class xmiClass) {
		IClass c = new Class();
		c.setId(xmiClass.getXmi_id());
		return c;
	}

	protected IClass initClass(IClass c,
			org.soulspace.xmi.marshal.Class xmiClass) {
		c.setId(xmiClass.getXmi_id());
		c.setProfileElement(xmiClass.getProfileElement());
		c.setNamespace(xmiClass.getNamespace());
		c.setQualifiedName(xmiClass.getQualifiedName());
		c.setName(xmiClass.getName());
		c.setAbstract(xmiClass.getIsAbstract());
		c.setVisibility(XmiHelper.toString(xmiClass.getVisibility()));

		Package p = (Package) findPackage(c.getNamespace());
		if (p != null) {
			c.setPackage(p);
			p.addClass(c);
		}

		Enumeration e1 = xmiClass.enumerateClassItem();
		while (e1.hasMoreElements()) {
			ClassItem cI = (ClassItem) e1.nextElement();
			if (cI.getModelElement_stereotype() != null) {
				addStereotypes(c, cI.getModelElement_stereotype());
			} else if (cI.getModelElement_taggedValue() != null) {
				addTaggedValues(c, cI.getModelElement_taggedValue());
			}
		}
		return c;
	}

	protected IAssociationClass getAssociationClassInstance(
			org.soulspace.xmi.marshal.AssociationClass xmiAssociationClass) {
		IAssociationClass ac = new AssociationClass();
		ac.setId(xmiAssociationClass.getXmi_id());
		return ac;
	}

	protected IAssociationClass initAssociationClass(IAssociationClass ac,
			org.soulspace.xmi.marshal.AssociationClass xmiAssociationClass) {
		IAssociationEnd fromEnd = null;
		IAssociationEnd toEnd = null;

		ac.setId(xmiAssociationClass.getXmi_id());
		ac.setProfileElement(xmiAssociationClass.getProfileElement());
		ac.setNamespace(xmiAssociationClass.getNamespace());
		ac.setQualifiedName(xmiAssociationClass.getQualifiedName());
		ac.setName(xmiAssociationClass.getName());
		ac.setAbstract(xmiAssociationClass.getIsAbstract());
		ac.setVisibility(XmiHelper
				.toString(xmiAssociationClass.getVisibility()));
		// FIXME handle association attributes

		Package p = (Package) findPackage(ac.getNamespace());
		if (p != null) {
			ac.setPackage(p);
			// FIXME handle seperatly?!? (p.addAssociationClass(ac);)
			p.addClass(ac);
		}

		List aeList = new ArrayList();

		Enumeration e1 = xmiAssociationClass.enumerateAssociationClassItem();
		while (e1.hasMoreElements()) {
			AssociationClassItem cI = (AssociationClassItem) e1.nextElement();
			if (cI.getModelElement_stereotype() != null) {
				addStereotypes(ac, cI.getModelElement_stereotype());
			} else if (cI.getModelElement_taggedValue() != null) {
				addTaggedValues(ac, cI.getModelElement_taggedValue());
			} else if (cI.getAssociation_connection() != null) {
				Enumeration e2 = cI.getAssociation_connection()
						.enumerateAssociation_connectionItem();
				while (e2.hasMoreElements()) {
					Association_connectionItem cnI = (Association_connectionItem) e2
							.nextElement();
					if (cnI.getAssociationEnd() != null) {
						IAssociationEnd ae = createAssociationEnd(cnI
								.getAssociationEnd());
						((AssociationEnd) ae).setAssociation(ac);
						if (fromEnd == null) {
							fromEnd = ae;
						} else if (toEnd == null) {
							toEnd = ae;
						}
					}
				}
			}
		}

		if (fromEnd != null && fromEnd.getType() != null && toEnd != null
				&& toEnd.getType() != null) {
			// set ends on association
			ac.setFromEnd(fromEnd);
			ac.setToEnd(toEnd);

			// set references to each other
			((AssociationEnd) fromEnd).setSourceEnd(toEnd);
			((AssociationEnd) toEnd).setSourceEnd(fromEnd);

			// FIXME AssociationClass add other types (UseCase, Actor, ...)
			((Class) fromEnd.getType()).addAssociation(toEnd);
			((Class) toEnd.getType()).addAssociation(fromEnd);
		}

		return ac;
	}

	protected IInterface getInterfaceInstance(
			org.soulspace.xmi.marshal.Interface xmiInterface) {
		IInterface i = new Interface();
		i.setId(xmiInterface.getXmi_id());
		return i;
	}

	protected IInterface initInterface(IInterface i,
			org.soulspace.xmi.marshal.Interface xmiInterface) {
		i.setProfileElement(xmiInterface.getProfileElement());
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

		return i;
	}

	protected IDataType getDataTypeInstance(
			org.soulspace.xmi.marshal.DataType xmiDataType) {
		IDataType dt = new DataType();
		dt.setId(xmiDataType.getXmi_id());
		return dt;
	}

	protected IDataType initDataType(IDataType dt,
			org.soulspace.xmi.marshal.DataType xmiDataType) {
		dt.setProfileElement(xmiDataType.getProfileElement());
		dt.setName(xmiDataType.getName());
		dt.setNamespace(xmiDataType.getNamespace());
		dt.setQualifiedName(xmiDataType.getQualifiedName());

		Enumeration e1 = xmiDataType.enumerateDataTypeItem();
		while (e1.hasMoreElements()) {
			DataTypeItem dtI = (DataTypeItem) e1.nextElement();
			if (dtI.getModelElement_stereotype() != null) {
				addStereotypes(dt, dtI.getModelElement_stereotype());
			} else if (dtI.getModelElement_taggedValue() != null) {
				addTaggedValues(dt, dtI.getModelElement_taggedValue());
			}
		}
		return dt;
	}

	protected IEnumerationType getEnumerationTypeInstance(
			org.soulspace.xmi.marshal.Enumeration xmiEnumerationType) {
		IEnumerationType et = new EnumerationType();
		et.setId(xmiEnumerationType.getXmi_id());
		return et;
	}

	protected IEnumerationType initEnumerationType(IEnumerationType et,
			org.soulspace.xmi.marshal.Enumeration xmiEnumerationType) {
		et.setProfileElement(xmiEnumerationType.getProfileElement());
		et.setName(xmiEnumerationType.getName());
		et.setNamespace(xmiEnumerationType.getNamespace());
		et.setQualifiedName(xmiEnumerationType.getQualifiedName());

		Enumeration e1 = xmiEnumerationType.enumerateEnumerationItem();
		while (e1.hasMoreElements()) {
			EnumerationItem eI = (EnumerationItem) e1.nextElement();
			if (eI.getModelElement_stereotype() != null) {
				addStereotypes(et, eI.getModelElement_stereotype());
			} else if (eI.getModelElement_taggedValue() != null) {
				addTaggedValues(et, eI.getModelElement_taggedValue());
			}
		}
		return et;
	}

	protected IAttribute getAttributeInstance(
			org.soulspace.xmi.marshal.Attribute xmiAttribute) {
		IAttribute a = new Attribute();
		a.setId(xmiAttribute.getXmi_id());
		return a;
	}

	protected IAttribute initAttribute(IAttribute a,
			org.soulspace.xmi.marshal.Attribute xmiAttribute) {
		if (!XmiHelper.isSet(xmiAttribute.getName())) {
			System.err.println("ERROR: The name of attribute "
					+ xmiAttribute.getXmi_id() + " is not set!");
			return null;
		}

		String name = xmiAttribute.getName();
		if (name.startsWith("/")) {
			a.setName(name.substring(1));
			a.setDerived(true);
		} else {
			a.setName(name);
			a.setDerived(false);
		}

		a.setProfileElement(xmiAttribute.getProfileElement());
		a.setNamespace(xmiAttribute.getNamespace());
		a.setQualifiedName(xmiAttribute.getQualifiedName());

		a.setVisibility(xmiAttribute.getVisibility().toString());
		a.setChangeability(xmiAttribute.getChangeability().toString());
		a.setOwnerScope(xmiAttribute.getOwnerScope());
		if(xmiAttribute.getParent() != null) {
			IClassifier cf;
			if((cf = (IClassifier) findElement(xmiAttribute.getParent().getXmiId())) != null) {
				a.setOwner(cf);
			} else {
				System.err.println("WARN: Parent Classifier " + xmiAttribute.getParent().getXmiId() + " not found.");
			}
		} else {
			System.err.println("WARN: Owner of attribute "
					+ xmiAttribute.getXmi_id() + " is not set.");
		}
		// FIXME not only classes
		IClass c = (IClass) repository.lookupClassByQualifiedName(a
				.getNamespace());
		if (c != null) {
			c.addAttribute(a);
		}
		
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
				} else {
					System.err.println("ERROR: The type of attribute "
							+ xmiAttribute.getXmi_id()
							+ " is not a class, an interface or a datatype.");
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
					} else if (tI.getEnumeration() != null) {
						a.setType(findEnumerationType(tI.getEnumeration()));
					} else {
						System.err
								.println("ERROR: The type of attribute "
										+ xmiAttribute.getXmi_id()
										+ " is not a class, an interface, an enumeration or a datatype!");
					}
				}
			} else if (aI.getStructuralFeature_multiplicity() != null) {
				Enumeration e2 = aI.getStructuralFeature_multiplicity()
						.enumerateStructuralFeature_multiplicityItem();
				while (e2.hasMoreElements()) {
					StructuralFeature_multiplicityItem mI = (StructuralFeature_multiplicityItem) e2
							.nextElement();
					if (mI.getMultiplicity() != null) {
						IMultiplicity m = createMultiplicity(mI
								.getMultiplicity());
						a.setMultiplicity(m);
					}
				}
			}
		}

		// check validity
		if(a.getType() == null) {
			System.err
			.println("ERROR: The type of attribute "
					+ xmiAttribute.getXmi_id() + " - " + xmiAttribute.getName()
					+ " is not set!");			
		}
		return a;
	}

	protected IOperation getOperationInstance(
			org.soulspace.xmi.marshal.Operation xmiOperation) {
		IOperation o = new Operation();
		o.setId(xmiOperation.getXmi_id());
		return o;
	}

	protected IOperation initOperation(IOperation o,
			org.soulspace.xmi.marshal.Operation xmiOperation) {
		if (!XmiHelper.isSet(xmiOperation.getName())) {
			System.err.println("ERROR: The name of operation "
					+ xmiOperation.getXmi_id() + " is not set!");
			return null;
		}

		o.setProfileElement(xmiOperation.getProfileElement());
		o.setName(xmiOperation.getName());
		o.setId(xmiOperation.getXmi_id());
		o.setNamespace(xmiOperation.getNamespace());
		o.setQualifiedName(xmiOperation.getQualifiedName());

		o.setOwnerScope(xmiOperation.getOwnerScope());
		o.setVisibility(XmiHelper.toString(xmiOperation.getVisibility()));
		o.setConcurrency(XmiHelper.toString(xmiOperation.getConcurrency()));

		o.setQuery(xmiOperation.getIsQuery());
		o.setAbstract(xmiOperation.getIsAbstract());

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
						if (pI.getParameter().getKind() == null
								|| !pI.getParameter().getKind().equals(
										KindType.RETURN)) {
							// normal parameter
							// add to parameter list
							o.addParameter(createParameter(pI.getParameter()));
						} else {
							// return parameter
							// add to parameter list and set as return type
							o.addParameter(createParameter(pI.getParameter()));
							o.setReturnType(getReturnType(pI.getParameter()));
						}
					}
				}
			} else if (oI.getModelElement_stereotype() != null) {
				addStereotypes(o, oI.getModelElement_stereotype());
			} else if (oI.getModelElement_taggedValue() != null) {
				addTaggedValues(o, oI.getModelElement_taggedValue());
			}
		}

		if (o.getReturnType() == null) {
			System.out.println("WARN: The return type of method " + o.getName()
					+ " is not set!");
		}
		Class c = (Class) repository.lookupClassByQualifiedName(o
				.getNamespace());
		if (c != null) {
			c.addOperation(o);
		}
		return o;
	}

	protected IAssociation getAssociationInstance(
			org.soulspace.xmi.marshal.Association xmiAssociation) {
		Association a = new Association();
		a.setId(xmiAssociation.getXmi_id());

		return a;
	}

	protected IAssociation initAssociation(IAssociation a,
			org.soulspace.xmi.marshal.Association xmiAssociation) {
		a.setProfileElement(xmiAssociation.getProfileElement());
		a.setNamespace(xmiAssociation.getNamespace());
		a.setQualifiedName(xmiAssociation.getQualifiedName());
		a.setName(xmiAssociation.getName());

		Enumeration e = xmiAssociation.enumerateAssociationItem();
		while (e.hasMoreElements()) {
			AssociationItem aI = (AssociationItem) e.nextElement();
			if (aI.getAssociation_connection() != null) {
				Association_connection aC = aI.getAssociation_connection();
				Enumeration eA = aC.enumerateAssociation_connectionItem();
				while (eA.hasMoreElements()) {
					Association_connectionItem cI = (Association_connectionItem) eA
							.nextElement();
				}
			} else if (aI.getModelElement_stereotype() != null) {
				addStereotypes(a, aI.getModelElement_stereotype());
			} else if (aI.getModelElement_taggedValue() != null) {
				addTaggedValues(a, aI.getModelElement_taggedValue());
			}
		}

		Class c = (Class) repository.lookupClassByQualifiedName(a
				.getNamespace());
		if (c != null) {
			// c.addAssociation(a);
		}
		return a;
	}

	protected IAssociationEnd getAssociationEndInstance(
			org.soulspace.xmi.marshal.AssociationEnd xmiAssociationEnd) {
		AssociationEnd ae = new AssociationEnd();
		ae.setId(xmiAssociationEnd.getXmi_id());
		return ae;
	}

	protected IAssociationEnd initAssociationEnd(IAssociationEnd ae,
			org.soulspace.xmi.marshal.AssociationEnd xmiAssociationEnd) {
		IClassifier c = null;

		if (XmiHelper.isSet(xmiAssociationEnd.getName())) {
			if (xmiAssociationEnd.getName().startsWith("/")) {
				ae.setName(xmiAssociationEnd.getName().substring(1));
				ae.setDerived(true);
			} else if (xmiAssociationEnd.getName() != null) {
				ae.setName(xmiAssociationEnd.getName());
				ae.setDerived(false);
			}
		} else {
			ae.setName("");
		}
		ae.setId(xmiAssociationEnd.getXmi_id());
		ae.setProfileElement(xmiAssociationEnd.getProfileElement());
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
					if (pI.getClazz() != null) {
						c = findClass(pI.getClazz());
					} else if (pI.getInterface() != null) {
						c = findInterface(pI.getInterface());
					} else if (pI.getActor() != null) {
						c = findActor(pI.getActor());
					} else if (pI.getUseCase() != null) {
						c = findUseCase(pI.getUseCase());
					} else {
						System.out
								.println("WARNING: Participant missing for AssociationEnd Id: "
										+ ae.getId());
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
						IMultiplicity m = createMultiplicity(mI
								.getMultiplicity());
						ae.setMultiplicity(m);
					} else {
						System.out
								.println("INFO: Multiplicity missing for AssociationEnd Id: "
										+ ae.getId());
					}
				}
			} else if (aeI.getAssociationEnd_qualifier() != null) {
				Enumeration e = aeI.getAssociationEnd_qualifier()
						.enumerateAssociationEnd_qualifierItem();
				while (e.hasMoreElements()) {
					AssociationEnd_qualifierItem qI = (AssociationEnd_qualifierItem) e
							.nextElement();
					if (qI.getAttribute() != null) {
						IAttribute a = createAttribute(qI.getAttribute());
						ae.addQualifier(a);
					}
				}
				if (ae.getMultiplicity() != null && !ae.getMultiplicity().getHigh().equals("1")) {
					System.out
							.println("INFO: The multiplicity of an  AssociationEnd with Qualifiers may be 0..1 for AssociationEnd id: "
									+ ae.getId());
				}
			} else if (aeI.getModelElement_taggedValue() != null) {
				addTaggedValues(ae, aeI.getModelElement_taggedValue());
			} else if (aeI.getModelElement_stereotype() != null) {
				addStereotypes(ae, aeI.getModelElement_stereotype());
			}
		}
		if(ae.getMultiplicity() == null) {
			Multiplicity m = new Multiplicity();
			m.setHigh("1");
			m.setLow("1");
			ae.setMultiplicity(m);
		}
		return ae;
	}

	protected IStereotype getStereotypeInstance(
			org.soulspace.xmi.marshal.Stereotype xmiStereotype) {
		Stereotype s = new Stereotype();
		s.setId(xmiStereotype.getXmi_id());
		return s;
	}

	protected IStereotype initStereotype(IStereotype s,
			org.soulspace.xmi.marshal.Stereotype xmiStereotype) {
		s.setName(xmiStereotype.getName());
		s.setProfileElement(xmiStereotype.getProfileElement());
		return s;
	}

	protected ITagDefinition getTagDefinitionInstance(
			org.soulspace.xmi.marshal.TagDefinition xmiTagDefinition) {
		TagDefinition td = new TagDefinition();
		td.setId(xmiTagDefinition.getXmi_id());
		return td;
	}

	protected ITagDefinition initTagDefinition(ITagDefinition td,
			org.soulspace.xmi.marshal.TagDefinition xmiTagDefinition) {
		td.setProfileElement(xmiTagDefinition.getProfileElement());
		td.setName(xmiTagDefinition.getName());
		td.setNamespace(xmiTagDefinition.getNamespace());
		return td;
	}

	protected ITaggedValue getTaggedValueInstance(
			org.soulspace.xmi.marshal.TaggedValue xmiTaggedValue) {
		ITaggedValue tv = new TaggedValue();
		tv.setId(xmiTaggedValue.getXmi_id());
		return tv;
	}

	protected ITaggedValue initTaggedValue(ITaggedValue tv,
			org.soulspace.xmi.marshal.TaggedValue xmiTaggedValue) {
		tv.setProfileElement(xmiTaggedValue.getProfileElement());
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
					TaggedValue_dataValue dv = (TaggedValue_dataValue) e2
							.nextElement();
					if (dv.getContent() != null) {
						tv.setValue(dv.getContent());
					}
				}
			} else if (tvI.getTaggedValue_type() != null) {
				Enumeration e2 = tvI.getTaggedValue_type()
						.enumerateTaggedValue_typeItem();
				while (e2.hasMoreElements()) {
					TaggedValue_typeItem tI = (TaggedValue_typeItem) e2
							.nextElement();
					ITagDefinition td = findTagDefinition(tI);
					if (td != null) {
						tv.setName(td.getName());
					} else {
						System.out
								.println("WARNING: TagDefinition not found for TaggedValue id: "
										+ tv.getId());
					}
				}
			}
		}
		return tv;
	}

	protected IParameter getParameterInstance(
			org.soulspace.xmi.marshal.Parameter xmiParameter) {
		IParameter p = new Parameter();
		p.setId(xmiParameter.getXmi_id());
		return p;
	}

	protected IParameter initParameter(IParameter p,
			org.soulspace.xmi.marshal.Parameter xmiParameter) {
		p.setProfileElement(xmiParameter.getProfileElement());
		p.setName(xmiParameter.getName());
		p.setNamespace(xmiParameter.getNamespace());
		p.setQualifiedName(xmiParameter.getQualifiedName());

		if (xmiParameter.getKind() != null) {
			p.setKind(xmiParameter.getKind().toString());
		} else {
			p.setKind(KindType.IN.toString());
		}

		Enumeration e1 = xmiParameter.enumerateParameterItem();
		while (e1.hasMoreElements()) {
			ParameterItem pI = (ParameterItem) e1.nextElement();
			if (pI.getModelElement_stereotype() != null) {
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
				Enumeration e2 = pI.getParameter_type()
						.enumerateParameter_typeItem();
				while (e2.hasMoreElements()) {
					Parameter_typeItem ptI = (Parameter_typeItem) e2
							.nextElement();
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
		if (p.getType() == null) {
			System.out.println("ERROR: Parameter type not set for parameter "
					+ p.getId());
		}
		if (p.getName() == null) {
			System.out.println("ERROR: Parameter name not set for parameter "
					+ p.getId());
		}
		return p;
	}

	protected IDependency getDependencyInstance(
			org.soulspace.xmi.marshal.Dependency xmiDependency) {
		IDependency d = new Dependency();
		d.setId(xmiDependency.getXmi_id());
		return d;
	}

	protected IDependency initDependency(IDependency d,
			org.soulspace.xmi.marshal.Dependency xmiDependency) {
		d.setProfileElement(xmiDependency.getProfileElement());
		d.setNamespace(xmiDependency.getNamespace());
		if (xmiDependency.getName() != null) {
			d.setName(xmiDependency.getName());
		}

		Enumeration e1 = xmiDependency.enumerateDependencyItem();
		while (e1.hasMoreElements()) {
			DependencyItem dI = (DependencyItem) e1.nextElement();
			if (dI.getModelElement_stereotype() != null) {
				addStereotypes(d, dI.getModelElement_stereotype());
			} else if (dI.getModelElement_taggedValue() != null) {
				addTaggedValues(d, dI.getModelElement_taggedValue());
			} else if (dI.getDependency_supplier() != null) {
				Enumeration e2 = dI.getDependency_supplier()
						.enumerateDependency_supplierItem();
				while (e2.hasMoreElements()) {
					Dependency_supplierItem dsI = (Dependency_supplierItem) e2
							.nextElement();
					if (dsI.getClazz() != null) {
						IClass c = findClass(dsI.getClazz());
						d.setSupplier(c);
					} else if (dsI.getDataType() != null) {
						d.setSupplier(findDataType(dsI.getDataType()));
					} else if (dsI.getInterface() != null) {
						d.setSupplier(findInterface(dsI.getInterface()));
					} else if (dsI.getPackage() != null) {
						d.setSupplier(findPackage(dsI.getPackage()));
					}
				}
			} else if (dI.getDependency_client() != null) {
				Enumeration e2 = dI.getDependency_client()
						.enumerateDependency_clientItem();
				while (e2.hasMoreElements()) {
					Dependency_clientItem dcI = (Dependency_clientItem) e2
							.nextElement();
					if (dcI.getClazz() != null) {
						IClass c = findClass(dcI.getClazz());
						d.setClient(c);
						c.addDependency(d);
					} else if (dcI.getDataType() != null) {
						IDataType dt = findDataType(dcI.getDataType());
						d.setClient(findDataType(dcI.getDataType()));
						// dt.addDependency(d); // TODO implement if necessary
					} else if (dcI.getInterface() != null) {
						IInterface i = findInterface(dcI.getInterface());
						d.setClient(i);
						i.addDependency(d);
					} else if (dcI.getPackage() != null) {
						d.setClient(findPackage(dcI.getPackage()));
					}
				}
			}
		}
		return d;
	}

	protected IUseCase getUseCaseInstance(
			org.soulspace.xmi.marshal.UseCase xmiUseCase) {
		IUseCase uc = new UseCase();
		uc.setId(xmiUseCase.getXmi_id());
		return uc;
	}

	protected IUseCase initUseCase(IUseCase uc,
			org.soulspace.xmi.marshal.UseCase xmiUseCase) {
		uc.setProfileElement(xmiUseCase.getProfileElement());
		uc.setName(xmiUseCase.getName());
		uc.setNamespace(xmiUseCase.getNamespace());
		uc.setQualifiedName(xmiUseCase.getQualifiedName());

		Enumeration e1 = xmiUseCase.enumerateUseCaseItem();
		while (e1.hasMoreElements()) {
			UseCaseItem ucI = (UseCaseItem) e1.nextElement();
			if (ucI.getModelElement_stereotype() != null) {
				addStereotypes(uc, ucI.getModelElement_stereotype());
			} else if (ucI.getModelElement_taggedValue() != null) {
				addTaggedValues(uc, ucI.getModelElement_taggedValue());
			} else if (ucI.getUseCase_extend() != null) {

			} else if (ucI.getUseCase_extensionPoint() != null) {
				Enumeration e2 = ucI.getUseCase_extensionPoint()
						.enumerateUseCase_extensionPointItem();
				while (e2.hasMoreElements()) {
					UseCase_extensionPointItem epI = (UseCase_extensionPointItem) e2
							.nextElement();
					if (epI.getExtensionPoint() != null) {
						uc.addExtensionPoint(createExtensionPoint(epI
								.getExtensionPoint()));
					}
				}
			} else if (ucI.getUseCase_include() != null) {
				// Enumeration e2 =
				// ucI.getUseCase_include().enumerateUseCase_includeItem();
				// while(e2.hasMoreElements()) {
				// UseCase_includeItem uciI = (UseCase_includeItem)
				// e2.nextElement();
				// Enumeration e3 = uciI.getInclude().enumerateIncludeItem();
				// while (e3.hasMoreElements()) {
				// IncludeItem iI = (IncludeItem) e3.nextElement();
				// // TODO
				// iI.getInclude_addition();
				// iI.getInclude_base();
				// }
				// }
			}
		}

		return uc;
	}

	protected IExtensionPoint getExtensionPointInstance(
			org.soulspace.xmi.marshal.ExtensionPoint xmiExtensionPoint) {
		IExtensionPoint ep = new ExtensionPoint();
		ep.setId(xmiExtensionPoint.getXmi_id());
		return ep;
	}

	protected IExtensionPoint initExtensionPoint(IExtensionPoint ep,
			org.soulspace.xmi.marshal.ExtensionPoint xmiExtensionPoint) {
		ep.setProfileElement(xmiExtensionPoint.getProfileElement());
		ep.setName(xmiExtensionPoint.getName());
		ep.setLocation(xmiExtensionPoint.getLocation());

		return ep;
	}

	protected IActor getActorInstance(org.soulspace.xmi.marshal.Actor xmiActor) {
		IActor a = new Actor();
		a.setId(xmiActor.getXmi_id());
		return a;
	}

	protected IActor initActor(IActor a,
			org.soulspace.xmi.marshal.Actor xmiActor) {
		a.setProfileElement(xmiActor.getProfileElement());
		a.setName(xmiActor.getName());
		a.setNamespace(xmiActor.getName());
		a.setQualifiedName(xmiActor.getQualifiedName());

		Enumeration e1 = xmiActor.enumerateActorItem();
		while (e1.hasMoreElements()) {
			ActorItem aI = (ActorItem) e1.nextElement();
			if (aI.getModelElement_stereotype() != null) {
				addStereotypes(a, aI.getModelElement_stereotype());
			} else if (aI.getModelElement_taggedValue() != null) {
				addTaggedValues(a, aI.getModelElement_taggedValue());
			}
		}
		// TODO add generalized Actor

		return a;
	}

	protected IStateMachine getStateMachineInstance(
			org.soulspace.xmi.marshal.StateMachine xmiStateMachine) {
		IStateMachine sm = new StateMachine();
		sm.setId(xmiStateMachine.getXmi_id());
		return sm;
	}

	protected IStateMachine initStateMachine(IStateMachine sm,
			org.soulspace.xmi.marshal.StateMachine xmiStateMachine) {
		sm.setProfileElement(xmiStateMachine.getProfileElement());
		sm.setNamespace(xmiStateMachine.getNamespace());
		sm.setQualifiedName(xmiStateMachine.getQualifiedName());
		if (xmiStateMachine.getName() != null) {
			sm.setName(xmiStateMachine.getName());
		}
		
		Enumeration e1 = xmiStateMachine.enumerateStateMachineItem();
		while (e1.hasMoreElements()) {
			StateMachineItem smI = (StateMachineItem) e1.nextElement();
			if (smI.getModelElement_stereotype() != null) {
				addStereotypes(sm, smI.getModelElement_stereotype());
			} else if (smI.getModelElement_taggedValue() != null) {
				addTaggedValues(sm, smI.getModelElement_taggedValue());
			} else if (smI.getStateMachine_top() != null) {
				Enumeration e2 = smI.getStateMachine_top()
						.enumerateStateMachine_topItem();
				while (e2.hasMoreElements()) {
					StateMachine_topItem smtI = (StateMachine_topItem) e2
							.nextElement();
					if (smtI.getCompositeState() != null) {
						sm.setTopState(createCompositeState(smtI.getCompositeState()));
					}
				}
			} else if (smI.getStateMachine_context() != null) {
				Enumeration e2 = smI.getStateMachine_context().enumerateStateMachine_contextItem();
				while(e2.hasMoreElements()) {
					StateMachine_contextItem smCI = (StateMachine_contextItem) e2.nextElement();
					if(smCI.getClazz() != null) {
						sm.setContext(findElement(smCI.getClazz().getRefId()));
					} else if(smCI.getInterface() != null) {
						sm.setContext(findElement(smCI.getInterface().getRefId()));
					} else if(smCI.getPackage() != null) {
						sm.setContext(findElement(smCI.getPackage().getRefId()));
					} else if(smCI.getAssociationClass() != null) {
						sm.setContext(findElement(smCI.getAssociationClass().getRefId()));
					} else if(smCI.getActor() != null) {
						sm.setContext(findElement(smCI.getActor().getRefId()));
					} else if(smCI.getUseCase() != null) {
						sm.setContext(findElement(smCI.getUseCase().getRefId()));
					}
					
				}
			} else if (smI.getStateMachine_transitions() != null) {
				Enumeration e2 = smI.getStateMachine_transitions()
						.enumerateStateMachine_transitionsItem();
				while (e2.hasMoreElements()) {
					StateMachine_transitionsItem smtI = (StateMachine_transitionsItem) e2
							.nextElement();
					if (smtI.getTransition() != null) {
						sm
								.addTransition(createTransition(smtI
										.getTransition()));
					}
				}
			}
		}
		return sm;
	}

	protected ICompositeState getCompositeStateInstance(
			org.soulspace.xmi.marshal.CompositeState xmiCompositeState) {
		ICompositeState cs = new CompositeState();
		cs.setId(xmiCompositeState.getXmi_id());
		return cs;
	}

	protected ICompositeState initCompositeState(ICompositeState s, org.soulspace.xmi.marshal.CompositeState xmiCompositeState) {
		if (xmiCompositeState.getName() != null) {
			s.setName(xmiCompositeState.getName());
		} else {
			System.out.println("INFO: no name set for state");
		}
		s.setProfileElement(xmiCompositeState.getProfileElement());
		// TODO complete
		Enumeration e1 = xmiCompositeState.enumerateCompositeStateItem();
		while (e1.hasMoreElements()) {
			CompositeStateItem csI = (CompositeStateItem) e1.nextElement();
			if (csI.getModelElement_stereotype() != null) {
				addStereotypes(s, csI.getModelElement_stereotype());
			} else if (csI.getModelElement_taggedValue() != null) {
				addTaggedValues(s, csI.getModelElement_taggedValue());
			} else if (csI.getStateVertex_incoming() != null) {
				// TODO complete
				csI.getStateVertex_incoming().enumerateStateVertex_incomingItem();
			} else if (csI.getStateVertex_outgoing() != null) {
				// TODO complete
				csI.getStateVertex_outgoing().enumerateStateVertex_outgoingItem();
			} else if (csI.getCompositeState_subvertex() != null) {
				Enumeration e2 = csI.getCompositeState_subvertex().enumerateCompositeState_subvertexItem();
				while (e2.hasMoreElements()) {
					CompositeState_subvertexItem cssI = (CompositeState_subvertexItem) e2.nextElement();
					if (cssI.getSimpleState() != null) {
						s.addSubState(createSimpleState(cssI
								.getSimpleState()));
					} else if (cssI.getPseudostate() != null) {
						s.addSubState(createPseudostate(cssI
								.getPseudostate()));
					} else if (cssI.getFinalState() != null) {
						s.addSubState(createFinalState(cssI
								.getFinalState()));
					} else if (cssI.getCompositeState() != null) {
						s.addSubState(createCompositeState(cssI.getCompositeState()));
					} else if (cssI.getSubmachineState() != null) {
						s.addSubState(createSubmachineState(cssI.getSubmachineState()));
					}

				}
			} else if (csI.getState_entry() != null) {
				Enumeration e2 = csI.getState_entry().enumerateState_entryItem();
				while (e2.hasMoreElements()) {
					State_entryItem sI = (State_entryItem) e2.nextElement();
					if(sI.getCallAction() != null) {
						s.setEntryAction(createCallAction(sI.getCallAction()));
					} else if(sI.getCreateAction() != null) {
						s.setEntryAction(createCreateAction(sI.getCreateAction()));
					} else if(sI.getDestroyAction() != null) {
						s.setEntryAction(createDestroyAction(sI.getDestroyAction()));
					} else if(sI.getSendAction() != null) {
						s.setEntryAction(createSendAction(sI.getSendAction()));
					}
				}
			} else if (csI.getState_doActivity() != null) {
				Enumeration e2 = csI.getState_doActivity().enumerateState_doActivityItem();
				while (e2.hasMoreElements()) {
					State_doActivityItem sI = (State_doActivityItem) e2.nextElement();
					if(sI.getCallAction() != null) {
						s.setEntryAction(createCallAction(sI.getCallAction()));
					} else if(sI.getCreateAction() != null) {
						s.setEntryAction(createCreateAction(sI.getCreateAction()));
					} else if(sI.getDestroyAction() != null) {
						s.setEntryAction(createDestroyAction(sI.getDestroyAction()));
					} else if(sI.getSendAction() != null) {
						s.setEntryAction(createSendAction(sI.getSendAction()));
					}
				}
			} else if (csI.getState_exit() != null) {
				Enumeration e2 = csI.getState_exit().enumerateState_exitItem();
				while (e2.hasMoreElements()) {
					State_exitItem sI = (State_exitItem) e2.nextElement();
					if(sI.getCallAction() != null) {
						s.setEntryAction(createCallAction(sI.getCallAction()));
					} else if(sI.getCreateAction() != null) {
						s.setEntryAction(createCreateAction(sI.getCreateAction()));
					} else if(sI.getDestroyAction() != null) {
						s.setEntryAction(createDestroyAction(sI.getDestroyAction()));
					} else if(sI.getSendAction() != null) {
						s.setEntryAction(createSendAction(sI.getSendAction()));
					}
				}
			} else if (csI.getState_deferredEvent() != null) {
				Enumeration e2 = csI.getState_deferredEvent().enumerateState_deferredEventItem();
				while (e2.hasMoreElements()) {
					State_deferredEventItem dI = (State_deferredEventItem) e2.nextElement();
					if(dI.getCallEvent() != null) {
						s.addDeferredEvent(createCallEvent(dI.getCallEvent()));
					} else if(dI.getChangeEvent() != null) {
						s.addDeferredEvent(createChangeEvent(dI.getChangeEvent()));
					} else if(dI.getSignalEvent() != null) {
						s.addDeferredEvent(createSignalEvent(dI.getSignalEvent()));
					} else if(dI.getTimeEvent() != null) {
						s.addDeferredEvent(createTimeEvent(dI.getTimeEvent()));
					}
				}
			} else {
				System.out
						.println("INFO: unhandled element on CompositeStateItem.");
			}
		}
		return s;
	}

	protected IState getSimpleStateInstance(SimpleState xmiSimpleState) {
		IState s = new State();
		s.setId(xmiSimpleState.getXmi_id());
		return s;
	}

	protected IState initSimpleState(IState s, SimpleState xmiSimpleState) {
		if (xmiSimpleState.getName() != null) {
			s.setName(xmiSimpleState.getName());
		} else {
			System.out.println("INFO: no name set for state");
		}
		s.setProfileElement(xmiSimpleState.getProfileElement());
		// TODO complete
		Enumeration e1 = xmiSimpleState.enumerateSimpleStateItem();
		while (e1.hasMoreElements()) {
			SimpleStateItem ssI = (SimpleStateItem) e1.nextElement();
			if (ssI.getModelElement_stereotype() != null) {
				addStereotypes(s, ssI.getModelElement_stereotype());
			} else if (ssI.getModelElement_taggedValue() != null) {
				addTaggedValues(s, ssI.getModelElement_taggedValue());
			} else if (ssI.getStateVertex_incoming() != null) {
				ssI.getStateVertex_incoming();
			} else if (ssI.getStateVertex_outgoing() != null) {
				ssI.getStateVertex_outgoing();
			} else if (ssI.getState_entry() != null) {
				Enumeration e2 = ssI.getState_entry().enumerateState_entryItem();
				while (e2.hasMoreElements()) {
					State_entryItem sI = (State_entryItem) e2.nextElement();
					if(sI.getCallAction() != null) {
						s.setEntryAction(createCallAction(sI.getCallAction()));
					} else if(sI.getCreateAction() != null) {
						s.setEntryAction(createCreateAction(sI.getCreateAction()));
					} else if(sI.getDestroyAction() != null) {
						s.setEntryAction(createDestroyAction(sI.getDestroyAction()));
					} else if(sI.getSendAction() != null) {
						s.setEntryAction(createSendAction(sI.getSendAction()));
					}
				}
			} else if (ssI.getState_doActivity() != null) {
				Enumeration e2 = ssI.getState_doActivity().enumerateState_doActivityItem();
				while (e2.hasMoreElements()) {
					State_doActivityItem sI = (State_doActivityItem) e2.nextElement();
					if(sI.getCallAction() != null) {
						s.setEntryAction(createCallAction(sI.getCallAction()));
					} else if(sI.getCreateAction() != null) {
						s.setEntryAction(createCreateAction(sI.getCreateAction()));
					} else if(sI.getDestroyAction() != null) {
						s.setEntryAction(createDestroyAction(sI.getDestroyAction()));
					} else if(sI.getSendAction() != null) {
						s.setEntryAction(createSendAction(sI.getSendAction()));
					}
				}
			} else if (ssI.getState_exit() != null) {
				Enumeration e2 = ssI.getState_exit().enumerateState_exitItem();
				while (e2.hasMoreElements()) {
					State_exitItem sI = (State_exitItem) e2.nextElement();
					if(sI.getCallAction() != null) {
						s.setEntryAction(createCallAction(sI.getCallAction()));
					} else if(sI.getCreateAction() != null) {
						s.setEntryAction(createCreateAction(sI.getCreateAction()));
					} else if(sI.getDestroyAction() != null) {
						s.setEntryAction(createDestroyAction(sI.getDestroyAction()));
					} else if(sI.getSendAction() != null) {
						s.setEntryAction(createSendAction(sI.getSendAction()));
					}
				}
			} else if (ssI.getState_deferredEvent() != null) {
				Enumeration e2 = ssI.getState_deferredEvent().enumerateState_deferredEventItem();
				while (e2.hasMoreElements()) {
					State_deferredEventItem dI = (State_deferredEventItem) e2.nextElement();
					if(dI.getCallEvent() != null) {
						s.addDeferredEvent(createCallEvent(dI.getCallEvent()));
					} else if(dI.getChangeEvent() != null) {
						s.addDeferredEvent(createChangeEvent(dI.getChangeEvent()));
					} else if(dI.getSignalEvent() != null) {
						s.addDeferredEvent(createSignalEvent(dI.getSignalEvent()));
					} else if(dI.getTimeEvent() != null) {
						s.addDeferredEvent(createTimeEvent(dI.getTimeEvent()));
					}
				}
			} else {
				System.out
						.println("INFO: unhandled element on SimpleStateItem.");
			}
		}
		return s;
	}

	protected IPseudostate getPseudostateInstance(
			org.soulspace.xmi.marshal.Pseudostate xmiPseudostate) {
		IPseudostate ps = new Pseudostate();
		ps.setId(xmiPseudostate.getXmi_id());
		return ps;
	}

	protected IPseudostate initPseudostate(IPseudostate ps,
			org.soulspace.xmi.marshal.Pseudostate xmiPseudostate) {
		ps.setKind(xmiPseudostate.getKind().toString());
		ps.setProfileElement(xmiPseudostate.getProfileElement());
		// TODO complete
		Enumeration e1 = xmiPseudostate.enumeratePseudostateItem();
		while (e1.hasMoreElements()) {
			PseudostateItem pI = (PseudostateItem) e1.nextElement();
			if (pI.getModelElement_stereotype() != null) {
				addStereotypes(ps, pI.getModelElement_stereotype());
			} else if (pI.getModelElement_taggedValue() != null) {
				addTaggedValues(ps, pI.getModelElement_taggedValue());
			} else if (pI.getStateVertex_outgoing() != null) {

			} else {
				System.out
						.println("INFO: unhandled element on PseudostateItem.");
			}
		}
		return ps;
	}

	protected IFinalState getFinalStateInstance(
			org.soulspace.xmi.marshal.FinalState xmiFinalState) {
		IFinalState fs = new FinalState();
		fs.setId(xmiFinalState.getXmi_id());
		return fs;
	}

	protected IFinalState initFinalState(IFinalState s,
			org.soulspace.xmi.marshal.FinalState xmiFinalState) {
		s.setName(xmiFinalState.getName());
		s.setProfileElement(xmiFinalState.getProfileElement());
		// TODO complete
		Enumeration e1 = xmiFinalState.enumerateFinalStateItem();
		while (e1.hasMoreElements()) {
			FinalStateItem ssI = (FinalStateItem) e1.nextElement();
			if (ssI.getModelElement_stereotype() != null) {
				addStereotypes(s, ssI.getModelElement_stereotype());
			} else if (ssI.getModelElement_taggedValue() != null) {
				addTaggedValues(s, ssI.getModelElement_taggedValue());
			} else if (ssI.getStateVertex_incoming() != null) {
				ssI.getStateVertex_incoming();
			} else if (ssI.getState_entry() != null) {
				Enumeration e2 = ssI.getState_entry().enumerateState_entryItem();
				while (e2.hasMoreElements()) {
					State_entryItem sI = (State_entryItem) e2.nextElement();
					if(sI.getCallAction() != null) {
						s.setEntryAction(createCallAction(sI.getCallAction()));
					} else if(sI.getCreateAction() != null) {
						s.setEntryAction(createCreateAction(sI.getCreateAction()));
					} else if(sI.getDestroyAction() != null) {
						s.setEntryAction(createDestroyAction(sI.getDestroyAction()));
					} else if(sI.getSendAction() != null) {
						s.setEntryAction(createSendAction(sI.getSendAction()));
					}
				}
			} else if (ssI.getState_doActivity() != null) {
				Enumeration e2 = ssI.getState_doActivity().enumerateState_doActivityItem();
				while (e2.hasMoreElements()) {
					State_doActivityItem sI = (State_doActivityItem) e2.nextElement();
					if(sI.getCallAction() != null) {
						s.setEntryAction(createCallAction(sI.getCallAction()));
					} else if(sI.getCreateAction() != null) {
						s.setEntryAction(createCreateAction(sI.getCreateAction()));
					} else if(sI.getDestroyAction() != null) {
						s.setEntryAction(createDestroyAction(sI.getDestroyAction()));
					} else if(sI.getSendAction() != null) {
						s.setEntryAction(createSendAction(sI.getSendAction()));
					}
				}
			} else if (ssI.getState_exit() != null) {
				Enumeration e2 = ssI.getState_exit().enumerateState_exitItem();
				while (e2.hasMoreElements()) {
					State_exitItem sI = (State_exitItem) e2.nextElement();
					if(sI.getCallAction() != null) {
						s.setEntryAction(createCallAction(sI.getCallAction()));
					} else if(sI.getCreateAction() != null) {
						s.setEntryAction(createCreateAction(sI.getCreateAction()));
					} else if(sI.getDestroyAction() != null) {
						s.setEntryAction(createDestroyAction(sI.getDestroyAction()));
					} else if(sI.getSendAction() != null) {
						s.setEntryAction(createSendAction(sI.getSendAction()));
					}
				}
			} else if (ssI.getState_deferredEvent() != null) {
				Enumeration e2 = ssI.getState_deferredEvent().enumerateState_deferredEventItem();
				while (e2.hasMoreElements()) {
					State_deferredEventItem dI = (State_deferredEventItem) e2.nextElement();
					if(dI.getCallEvent() != null) {
						s.addDeferredEvent(createCallEvent(dI.getCallEvent()));
					} else if(dI.getChangeEvent() != null) {
						s.addDeferredEvent(createChangeEvent(dI.getChangeEvent()));
					} else if(dI.getSignalEvent() != null) {
						s.addDeferredEvent(createSignalEvent(dI.getSignalEvent()));
					} else if(dI.getTimeEvent() != null) {
						s.addDeferredEvent(createTimeEvent(dI.getTimeEvent()));
					}
				}
			} else {
				System.out
						.println("INFO: unhandled element on FinalStateItem.");
			}
		}
		return s;
	}

	protected ISubmachineState getSubmachineStateInstance(
			org.soulspace.xmi.marshal.SubmachineState xmiSubmachineState) {
		ISubmachineState ss = new SubmachineState();
		ss.setId(xmiSubmachineState.getXmi_id());
		return ss;
	}

	protected ISubmachineState initSubmachineState(ISubmachineState s,
			org.soulspace.xmi.marshal.SubmachineState xmiSubmachineState) {
		s.setName(xmiSubmachineState.getName());
		s.setProfileElement(xmiSubmachineState.getProfileElement());

		Enumeration e1 = xmiSubmachineState.enumerateSubmachineStateItem();
		while (e1.hasMoreElements()) {
			SubmachineStateItem ssI = (SubmachineStateItem) e1.nextElement();
			if (ssI.getModelElement_stereotype() != null) {
				addStereotypes(s, ssI.getModelElement_stereotype());
			} else if (ssI.getModelElement_taggedValue() != null) {
				addTaggedValues(s, ssI.getModelElement_taggedValue());
			} else if (ssI.getStateVertex_incoming() != null) {
				ssI.getStateVertex_incoming();
			} else if (ssI.getStateVertex_outgoing() != null) {
				ssI.getStateVertex_outgoing();
			} else if (ssI.getState_entry() != null) {
				Enumeration e2 = ssI.getState_entry().enumerateState_entryItem();
				while (e2.hasMoreElements()) {
					State_entryItem sI = (State_entryItem) e2.nextElement();
					if(sI.getCallAction() != null) {
						s.setEntryAction(createCallAction(sI.getCallAction()));
					} else if(sI.getCreateAction() != null) {
						s.setEntryAction(createCreateAction(sI.getCreateAction()));
					} else if(sI.getDestroyAction() != null) {
						s.setEntryAction(createDestroyAction(sI.getDestroyAction()));
					} else if(sI.getSendAction() != null) {
						s.setEntryAction(createSendAction(sI.getSendAction()));
					}
				}
			} else if (ssI.getState_doActivity() != null) {
				Enumeration e2 = ssI.getState_doActivity().enumerateState_doActivityItem();
				while (e2.hasMoreElements()) {
					State_doActivityItem sI = (State_doActivityItem) e2.nextElement();
					if(sI.getCallAction() != null) {
						s.setEntryAction(createCallAction(sI.getCallAction()));
					} else if(sI.getCreateAction() != null) {
						s.setEntryAction(createCreateAction(sI.getCreateAction()));
					} else if(sI.getDestroyAction() != null) {
						s.setEntryAction(createDestroyAction(sI.getDestroyAction()));
					} else if(sI.getSendAction() != null) {
						s.setEntryAction(createSendAction(sI.getSendAction()));
					}
				}
			} else if (ssI.getState_exit() != null) {
				Enumeration e2 = ssI.getState_exit().enumerateState_exitItem();
				while (e2.hasMoreElements()) {
					State_exitItem sI = (State_exitItem) e2.nextElement();
					if(sI.getCallAction() != null) {
						s.setEntryAction(createCallAction(sI.getCallAction()));
					} else if(sI.getCreateAction() != null) {
						s.setEntryAction(createCreateAction(sI.getCreateAction()));
					} else if(sI.getDestroyAction() != null) {
						s.setEntryAction(createDestroyAction(sI.getDestroyAction()));
					} else if(sI.getSendAction() != null) {
						s.setEntryAction(createSendAction(sI.getSendAction()));
					}
				}
			} else if (ssI.getState_deferredEvent() != null) {
				Enumeration e2 = ssI.getState_deferredEvent().enumerateState_deferredEventItem();
				while (e2.hasMoreElements()) {
					State_deferredEventItem dI = (State_deferredEventItem) e2.nextElement();
					if(dI.getCallEvent() != null) {
						s.addDeferredEvent(createCallEvent(dI.getCallEvent()));
					} else if(dI.getChangeEvent() != null) {
						s.addDeferredEvent(createChangeEvent(dI.getChangeEvent()));
					} else if(dI.getSignalEvent() != null) {
						s.addDeferredEvent(createSignalEvent(dI.getSignalEvent()));
					} else if(dI.getTimeEvent() != null) {
						s.addDeferredEvent(createTimeEvent(dI.getTimeEvent()));
					}
				}
			} else if (ssI.getSubmachineState_submachine() != null) {
				Enumeration e2 = ssI.getSubmachineState_submachine()
						.enumerateSubmachineState_submachineItem();
				while (e2.hasMoreElements()) {
					SubmachineState_submachineItem sssI = (SubmachineState_submachineItem) e2
							.nextElement();
					// FIXME ???
					sssI.getStateMachine();
					// sssI.getStateMachine();
					
				}
			} else {
				System.out
						.println("INFO: unhandled element on SubmachineStateItem.");
			}
		}
		return s;
	}

	protected ITransition getTransitionInstance(
			org.soulspace.xmi.marshal.Transition xmiTransition) {
		ITransition t = new Transition();
		t.setId(xmiTransition.getXmi_id());
		return t;
	}

	protected ITransition initTransition(ITransition t,
			org.soulspace.xmi.marshal.Transition xmiTransition) {
		IState source = null;
		IState target = null;

		if (xmiTransition.getName() != null) {
			t.setName(xmiTransition.getName());
		}
		t.setProfileElement(xmiTransition.getProfileElement());
		// TODO further transition attributes

		Enumeration e1 = xmiTransition.enumerateTransitionItem();
		while (e1.hasMoreElements()) {
			TransitionItem tI = (TransitionItem) e1.nextElement();
			if (tI.getModelElement_stereotype() != null) {
				addStereotypes(t, tI.getModelElement_stereotype());
			} else if (tI.getModelElement_taggedValue() != null) {
				addTaggedValues(t, tI.getModelElement_taggedValue());
			} else if (tI.getTransition_trigger() != null) {
				Enumeration e2 = tI.getTransition_trigger()
						.enumerateTransition_triggerItem();
				while (e2.hasMoreElements()) {
					Transition_triggerItem ttI = (Transition_triggerItem) e2
							.nextElement();
					if (ttI.getCallEvent() != null) {
						t.addEvent(findEvent(ttI.getCallEvent().getRefId()));
					} else if(ttI.getSignalEvent() != null) {
						t.addEvent(findEvent(ttI.getSignalEvent().getRefId()));
					} else if(ttI.getChangeEvent() != null) {
						t.addEvent(findEvent(ttI.getChangeEvent().getRefId()));
					} else if(ttI.getTimeEvent() != null) {
						t.addEvent(findEvent(ttI.getTimeEvent().getRefId()));
					}
				}
			} else if (tI.getTransition_effect() != null) {
				Enumeration e2 = tI.getTransition_effect().enumerateTransition_effectItem();
				while (e2.hasMoreElements()) {
					Transition_effectItem teI = (Transition_effectItem) e2.nextElement();
					if(teI.getActionSequence() != null) {
						t.setEffect(createActionSequence(teI.getActionSequence()));
					} else if(teI.getCallAction() != null) {
						t.setEffect(createCallAction(teI.getCallAction()));						
					} else if(teI.getCreateAction() != null) {
						t.setEffect(createCreateAction(teI.getCreateAction()));												
					} else if(teI.getDestroyAction() != null) {
						t.setEffect(createDestroyAction(teI.getDestroyAction()));												
					} else if(teI.getReturnAction() != null) {
						t.setEffect(createReturnAction(teI.getReturnAction()));						
					} else if(teI.getSendAction() != null) {
						t.setEffect(createSendAction(teI.getSendAction()));						
					} else if(teI.getTerminateAction() != null) {
						t.setEffect(createTerminateAction(teI.getTerminateAction()));						
					} else if(teI.getUninterpretedAction() != null) {
						t.setEffect(createUninterpretedAction(teI.getUninterpretedAction()));
					}
				}
			} else if (tI.getTransition_guard() != null) {
				Enumeration e2 = tI.getTransition_guard().enumerateTransition_guardItem();
				while (e2.hasMoreElements()) {
					Transition_guardItem tgI = (Transition_guardItem) e2.nextElement();
					if(tgI.getGuard() != null) {
						Enumeration e3 = tgI.getGuard().enumerateGuardItem();
						while (e3.hasMoreElements()) {
							GuardItem gI = (GuardItem) e3.nextElement();
							if(gI.getBooleanExpression() != null) {
								t.setGuard(gI.getBooleanExpression().getBody());
							}
						}
					}
					
				}
			} else if (tI.getTransition_source() != null) {
				if (tI.getTransition_source().getSimpleState() != null) {
					source = findState(tI.getTransition_source()
							.getSimpleState().getRefId());
				} else if (tI.getTransition_source().getPseudostate() != null) {
					source = findState(tI.getTransition_source()
							.getPseudostate().getRefId());
				} else if (tI.getTransition_source().getSubmachineState() != null) {
					source = findState(tI.getTransition_source()
							.getSubmachineState().getRefId());
				} else if (tI.getTransition_source().getState() != null) {
					source = findState(tI.getTransition_source().getState()
							.getRefId());
				} else if (tI.getTransition_source().getCompositeState() != null) {
					source = findState(tI.getTransition_source()
							.getCompositeState().getRefId());
				} else {
					System.out
							.println("INFO: unkown transition source type on transition "
									+ t.getId());
				}
			} else if (tI.getTransition_target() != null) {
				if (tI.getTransition_target().getSimpleState() != null) {
					target = findState(tI.getTransition_target()
							.getSimpleState().getRefId());
				} else if (tI.getTransition_target().getPseudostate() != null) {
					target = findState(tI.getTransition_target()
							.getPseudostate().getRefId());
				} else if (tI.getTransition_target().getSubmachineState() != null) {
					target = findState(tI.getTransition_target()
							.getSubmachineState().getRefId());
				} else if (tI.getTransition_target().getState() != null) {
					target = findState(tI.getTransition_target().getState()
							.getRefId());
				} else if (tI.getTransition_target().getCompositeState() != null) {
					target = findState(tI.getTransition_target()
							.getCompositeState().getRefId());
				} else if (tI.getTransition_target().getFinalState() != null) {
					target = findState(tI.getTransition_target()
							.getFinalState().getRefId());
				} else {
					System.out
							.println("INFO: unkown transition target type on transition "
									+ t.getId());
				}
			}
		}
		if (source != null) {
			source.addOutgoingTransition(t);
			t.setSource(source);
		} else {
			System.out
					.println("ERROR: Transition source not set for transition "
							+ t.getId());
		}
		if (target != null) {
			target.addIncomingTransition(t);
			t.setTarget(target);
		} else {
			System.out
					.println("ERROR: Transition target not set for transition "
							+ t.getId());
		}
		return t;
	}

	protected ICallEvent getCallEventInstance(
			org.soulspace.xmi.marshal.CallEvent xmiCallEvent) {
		ICallEvent ce = new CallEvent();
		ce.setId(xmiCallEvent.getXmi_id());
		return ce;
	}

	protected ICallEvent initCallEvent(ICallEvent ce,
			org.soulspace.xmi.marshal.CallEvent xmiCallEvent) {
		ce.setProfileElement(xmiCallEvent.getProfileElement());
		if(xmiCallEvent.getName() != null) {
			ce.setName(xmiCallEvent.getName());
		}
		ce.setNamespace(xmiCallEvent.getNamespace());

		Enumeration e1 = xmiCallEvent.enumerateCallEventItem();
		while (e1.hasMoreElements()) {
			CallEventItem ceI = (CallEventItem) e1.nextElement();
			if (ceI.getModelElement_stereotype() != null) {
				addStereotypes(ce, ceI.getModelElement_stereotype());
			} else if (ceI.getModelElement_taggedValue() != null) {
				addTaggedValues(ce, ceI.getModelElement_taggedValue());
			} else if (ceI.getEvent_parameter() != null) {
				Enumeration e2 = ceI.getEvent_parameter()
						.enumerateEvent_parameterItem();
				while (e2.hasMoreElements()) {
					Event_parameterItem epI = (Event_parameterItem) e2
							.nextElement();
					if (epI.getParameter() != null) {
						ce.addParameter(createParameter(epI.getParameter()));
					}
				}
			} else if(ceI.getCallEvent_operation() != null) {
				// TODO implement				
			}
		}
		return ce;
	}

	protected ISignalEvent getSignalEventInstance(
			org.soulspace.xmi.marshal.SignalEvent xmiSignalEvent) {
		ISignalEvent se = new SignalEvent();
		se.setId(xmiSignalEvent.getXmi_id());
		return se;
	}

	protected ISignalEvent initSignalEvent(ISignalEvent se,
			org.soulspace.xmi.marshal.SignalEvent xmiSignalEvent) {
		se.setProfileElement(xmiSignalEvent.getProfileElement());
		if(xmiSignalEvent.getName() != null) {
			se.setName(xmiSignalEvent.getName());
		}
		se.setName(xmiSignalEvent.getName());
		se.setNamespace(xmiSignalEvent.getNamespace());

		Enumeration e1 = xmiSignalEvent.enumerateSignalEventItem();
		while (e1.hasMoreElements()) {
			SignalEventItem seI = (SignalEventItem) e1.nextElement();
			if (seI.getModelElement_stereotype() != null) {
				addStereotypes(se, seI.getModelElement_stereotype());
			} else if (seI.getModelElement_taggedValue() != null) {
				addTaggedValues(se, seI.getModelElement_taggedValue());
			} else if (seI.getEvent_parameter() != null) {
				Enumeration e2 = seI.getEvent_parameter()
						.enumerateEvent_parameterItem();
				while (e2.hasMoreElements()) {
					Event_parameterItem epI = (Event_parameterItem) e2
							.nextElement();
					if (epI.getParameter() != null) {
						se.addParameter(createParameter(epI.getParameter()));
					}
				}
			} else if(seI.getSignalEvent_signal() != null) {
				// TODO implement
			}
		}
		return se;
	}

	protected IChangeEvent getChangeEventInstance(
			org.soulspace.xmi.marshal.ChangeEvent xmiChangeEvent) {
		IChangeEvent ce = new ChangeEvent();
		ce.setId(xmiChangeEvent.getXmi_id());
		return ce;
	}

	protected IChangeEvent initChangeEvent(IChangeEvent ce,
			org.soulspace.xmi.marshal.ChangeEvent xmiChangeEvent) {
		ce.setProfileElement(xmiChangeEvent.getProfileElement());
		if(xmiChangeEvent.getName() != null) {
			ce.setName(xmiChangeEvent.getName());
		}
		ce.setName(xmiChangeEvent.getName());
		ce.setNamespace(xmiChangeEvent.getNamespace());

		Enumeration e1 = xmiChangeEvent.enumerateChangeEventItem();
		while (e1.hasMoreElements()) {
			ChangeEventItem ceI = (ChangeEventItem) e1.nextElement();
			if (ceI.getModelElement_stereotype() != null) {
				addStereotypes(ce, ceI.getModelElement_stereotype());
			} else if (ceI.getModelElement_taggedValue() != null) {
				addTaggedValues(ce, ceI.getModelElement_taggedValue());
			} else if (ceI.getEvent_parameter() != null) {
				Enumeration e2 = ceI.getEvent_parameter()
						.enumerateEvent_parameterItem();
				while (e2.hasMoreElements()) {
					Event_parameterItem epI = (Event_parameterItem) e2
							.nextElement();
					if (epI.getParameter() != null) {
						ce.addParameter(createParameter(epI.getParameter()));
					}
				}
			} else if(ceI.getChangeEvent_changeExpression() != null) {
				// TODO implement
			}
		}
		return ce;
	}

	protected ITimeEvent getTimeEventInstance(
			org.soulspace.xmi.marshal.TimeEvent xmiTimeEvent) {
		ITimeEvent te = new TimeEvent();
		te.setId(xmiTimeEvent.getXmi_id());
		return te;
	}

	protected ITimeEvent initTimeEvent(ITimeEvent te,
			org.soulspace.xmi.marshal.TimeEvent xmiTimeEvent) {
		te.setProfileElement(xmiTimeEvent.getProfileElement());
		if(xmiTimeEvent.getName() != null) {
			te.setName(xmiTimeEvent.getName());
		}
		te.setName(xmiTimeEvent.getName());
		te.setNamespace(xmiTimeEvent.getNamespace());

		Enumeration e1 = xmiTimeEvent.enumerateTimeEventItem();
		while (e1.hasMoreElements()) {
			TimeEventItem teI = (TimeEventItem) e1.nextElement();
			if (teI.getModelElement_stereotype() != null) {
				addStereotypes(te, teI.getModelElement_stereotype());
			} else if (teI.getModelElement_taggedValue() != null) {
				addTaggedValues(te, teI.getModelElement_taggedValue());
			} else if (teI.getEvent_parameter() != null) {
				Enumeration e2 = teI.getEvent_parameter()
						.enumerateEvent_parameterItem();
				while (e2.hasMoreElements()) {
					Event_parameterItem epI = (Event_parameterItem) e2
							.nextElement();
					if (epI.getParameter() != null) {
						te.addParameter(createParameter(epI.getParameter()));
					}
				}
			} else if(teI.getTimeEvent_when() != null) {
				// TODO implement
			}
		}
		return te;
	}

	protected IArgument getArgumentInstance(
			org.soulspace.xmi.marshal.Argument xmiArgument) {
		IArgument te = new Argument();
		te.setId(xmiArgument.getXmi_id());
		return te;
	}

	protected IArgument initArgument(IArgument a,
			org.soulspace.xmi.marshal.Argument xmiArgument) {
		a.setProfileElement(xmiArgument.getProfileElement());
		if(xmiArgument.getName() != null) {
			a.setName(xmiArgument.getName());
		}
		a.setName(xmiArgument.getName());
		a.setNamespace(xmiArgument.getNamespace());

//		Enumeration e1 = xmiArgument.enumerateArgumentItem();
//		while (e1.hasMoreElements()) {
//			ArgumentItem teI = (ArgumentItem) e1.nextElement();
//			if (teI.getModelElement_stereotype() != null) {
//				addStereotypes(te, teI.getModelElement_stereotype());
//			} else if (teI.getModelElement_taggedValue() != null) {
//				addTaggedValues(te, teI.getModelElement_taggedValue());
//			}
//		}
		return a;
	}

	protected ICallAction getCallActionInstance(
			org.soulspace.xmi.marshal.CallAction xmiCallAction) {
		ICallAction ca = new CallAction();
		ca.setId(xmiCallAction.getXmi_id());
		return ca;
	}

	protected ICallAction initCallAction(ICallAction ca,
			org.soulspace.xmi.marshal.CallAction xmiCallAction) {
		ca.setProfileElement(xmiCallAction.getProfileElement());
		if(xmiCallAction.getName() != null) {
			ca.setName(xmiCallAction.getName());
		}
		ca.setNamespace(xmiCallAction.getNamespace());

		Enumeration e1 = xmiCallAction.enumerateCallActionItem();
		while (e1.hasMoreElements()) {
			CallActionItem caI = (CallActionItem) e1.nextElement();
			if (caI.getCallAction_operation() != null) {
				Enumeration e2 = caI.getCallAction_operation()
						.enumerateCallAction_operationItem();
				while (e2.hasMoreElements()) {
					CallAction_operationItem caOI = (CallAction_operationItem) e2
							.nextElement();
					if (caOI.getOperation() != null) {
						ca.setOperation((IOperation) findElement(caOI.getOperation().getRefId()));
					}
				}
			} else if(caI.getAction_actualArgument() != null) {
				Enumeration e2 = caI.getAction_actualArgument().enumerateAction_actualArgumentItem();
				while (e2.hasMoreElements()) {
					Action_actualArgumentItem aaI = (Action_actualArgumentItem) e2.nextElement();
					if(aaI.getArgument() != null) {
						Enumeration e3 = aaI.getArgument().enumerateArgumentItem();
						while (e3.hasMoreElements()) {
							ArgumentItem argI = (ArgumentItem) e3.nextElement();
							if(argI.getArgument_value() != null) {
								Enumeration e4 = argI.getArgument_value().enumerateArgument_valueItem();
								while (e4.hasMoreElements()) {
									Argument_valueItem avI = (Argument_valueItem) e4.nextElement();
									if(avI.getActionExpression() != null) {
										ca.addArgument(avI.getActionExpression().getBody());
									} else if(avI.getArgListExpression() != null) {
										ca.addArgument(avI.getArgListExpression().getBody());
									} else if(avI.getBooleanExpression() != null) {
										ca.addArgument(avI.getBooleanExpression().getBody());
									} else if(avI.getIterationExpression() != null) {
										ca.addArgument(avI.getIterationExpression().getBody());
									} else if(avI.getMappingExpression() != null) {
										ca.addArgument(avI.getMappingExpression().getBody());
									} else if(avI.getObjectSetExpression() != null) {
										ca.addArgument(avI.getObjectSetExpression().getBody());
									} else if(avI.getProcedureExpression() != null) {
										ca.addArgument(avI.getProcedureExpression().getBody());
									} else if(avI.getTimeExpression() != null) {
										ca.addArgument(avI.getTimeExpression().getBody());
									} else if(avI.getTypeExpression() != null) {
										ca.addArgument(avI.getTypeExpression().getBody());
									}
								}
							}
						}						
					}
				}
			} else if(caI.getAction_script() != null) {
				Enumeration e2 = caI.getAction_script().enumerateAction_scriptItem();
				while (e2.hasMoreElements()) {
					Action_scriptItem asI = (Action_scriptItem) e2.nextElement();
					if(asI.getActionExpression() != null) {
						ca.setScript(asI.getActionExpression().getBody());
					}
				}
			} else if(caI.getAction_recurrence() != null) {
				Enumeration e2 = caI.getAction_recurrence().enumerateAction_recurrenceItem();
				while (e2.hasMoreElements()) {
					Action_recurrenceItem arI = (Action_recurrenceItem) e2.nextElement();
					if(arI.getIterationExpression() != null) {
						ca.setRecurrence(arI.getIterationExpression().getBody());
					}
				}
			} else if(caI.getAction_target() != null) {
				Enumeration e2 = caI.getAction_target().enumerateAction_targetItem();
				while (e2.hasMoreElements()) {
					Action_targetItem atI = (Action_targetItem) e2.nextElement();
					if(atI.getObjectSetExpression() != null) {
						ca.setTarget(atI.getObjectSetExpression().getBody());
					}
				}
			}
		}
		return ca;
	}
	
	protected ICreateAction getCreateActionInstance(
			org.soulspace.xmi.marshal.CreateAction xmiCreateAction) {
		ICreateAction ca = new CreateAction();
		ca.setId(xmiCreateAction.getXmi_id());
		return ca;
	}

	protected ICreateAction initCreateAction(ICreateAction ca,
			org.soulspace.xmi.marshal.CreateAction xmiCreateAction) {
		ca.setProfileElement(xmiCreateAction.getProfileElement());
		if(xmiCreateAction.getName() != null) {
			ca.setName(xmiCreateAction.getName());
		}
		ca.setNamespace(xmiCreateAction.getNamespace());
//		ca.setQualifiedName(ca.getQualifiedName());

		Enumeration e1 = xmiCreateAction.enumerateCreateActionItem();
		while (e1.hasMoreElements()) {
			CreateActionItem caI = (CreateActionItem) e1.nextElement();
			if (caI.getCreateAction_instanciation() != null) {
				Enumeration e2 = caI.getCreateAction_instanciation()
						.enumerateCreateAction_instanciationItem();
				while (e2.hasMoreElements()) {
					CreateAction_instanciationItem caII = (CreateAction_instanciationItem) e2
							.nextElement();
					if (caII.getClass() != null) {
						ca.setInstanciation(findClass(caII.getClazz()));
					} else if(caII.getAssociationClass() != null) {
						ca.setInstanciation((IAssociationClass) findElement(caII.getAssociationClass().getRefId()));						
					}
				}
			} else if(caI.getAction_actualArgument() != null) {
				Enumeration e2 = caI.getAction_actualArgument().enumerateAction_actualArgumentItem();
				while (e2.hasMoreElements()) {
					Action_actualArgumentItem aaI = (Action_actualArgumentItem) e2.nextElement();
					if(aaI.getArgument() != null) {
						Enumeration e3 = aaI.getArgument().enumerateArgumentItem();
						while (e3.hasMoreElements()) {
							ArgumentItem argI = (ArgumentItem) e3.nextElement();
							if(argI.getArgument_value() != null) {
								Enumeration e4 = argI.getArgument_value().enumerateArgument_valueItem();
								while (e4.hasMoreElements()) {
									Argument_valueItem avI = (Argument_valueItem) e4.nextElement();
									if(avI.getActionExpression() != null) {
										ca.addArgument(avI.getActionExpression().getBody());
									} else if(avI.getArgListExpression() != null) {
										ca.addArgument(avI.getArgListExpression().getBody());
									} else if(avI.getBooleanExpression() != null) {
										ca.addArgument(avI.getBooleanExpression().getBody());
									} else if(avI.getIterationExpression() != null) {
										ca.addArgument(avI.getIterationExpression().getBody());
									} else if(avI.getMappingExpression() != null) {
										ca.addArgument(avI.getMappingExpression().getBody());
									} else if(avI.getObjectSetExpression() != null) {
										ca.addArgument(avI.getObjectSetExpression().getBody());
									} else if(avI.getProcedureExpression() != null) {
										ca.addArgument(avI.getProcedureExpression().getBody());
									} else if(avI.getTimeExpression() != null) {
										ca.addArgument(avI.getTimeExpression().getBody());
									} else if(avI.getTypeExpression() != null) {
										ca.addArgument(avI.getTypeExpression().getBody());
									}
								}
							}
						}						
					}
				}
			} else if(caI.getAction_script() != null) {
				Enumeration e2 = caI.getAction_script().enumerateAction_scriptItem();
				while (e2.hasMoreElements()) {
					Action_scriptItem asI = (Action_scriptItem) e2.nextElement();
					if(asI.getActionExpression() != null) {
						ca.setScript(asI.getActionExpression().getBody());
					}
				}
			} else if(caI.getAction_recurrence() != null) {
				Enumeration e2 = caI.getAction_recurrence().enumerateAction_recurrenceItem();
				while (e2.hasMoreElements()) {
					Action_recurrenceItem arI = (Action_recurrenceItem) e2.nextElement();
					if(arI.getIterationExpression() != null) {
						ca.setRecurrence(arI.getIterationExpression().getBody());
					}
				}
			} else if(caI.getAction_target() != null) {
				Enumeration e2 = caI.getAction_target().enumerateAction_targetItem();
				while (e2.hasMoreElements()) {
					Action_targetItem atI = (Action_targetItem) e2.nextElement();
					if(atI.getObjectSetExpression() != null) {
						ca.setTarget(atI.getObjectSetExpression().getBody());
					}
				}
			}
		}
		return ca;
	}

	protected ISendAction getSendActionInstance(
			org.soulspace.xmi.marshal.SendAction xmiSendAction) {
		ISendAction ca = new SendAction();
		ca.setId(xmiSendAction.getXmi_id());
		return ca;
	}

	protected ISendAction initSendAction(ISendAction ca,
			org.soulspace.xmi.marshal.SendAction xmiSendAction) {
		ca.setProfileElement(xmiSendAction.getProfileElement());
		if(xmiSendAction.getName() != null) {
			ca.setName(xmiSendAction.getName());
		}
		ca.setNamespace(xmiSendAction.getNamespace());
//		ca.setQualifiedName(ca.getQualifiedName());

		Enumeration e1 = xmiSendAction.enumerateSendActionItem();
		while (e1.hasMoreElements()) {
			SendActionItem caI = (SendActionItem) e1.nextElement();
			if (caI.getSendAction_signal() != null) {
				Enumeration e2 = caI.getSendAction_signal()
						.enumerateSendAction_signalItem();
				while (e2.hasMoreElements()) {
					SendAction_signalItem caOI = (SendAction_signalItem) e2
							.nextElement();
					if (caOI.getSignal() != null) {
						// TODO add signal
						// ca.setOperation((IOperation) findElement(caOI.getOperation().getRefId()));
					}
				}
			} else if(caI.getAction_actualArgument() != null) {
				Enumeration e2 = caI.getAction_actualArgument().enumerateAction_actualArgumentItem();
				while (e2.hasMoreElements()) {
					Action_actualArgumentItem aaI = (Action_actualArgumentItem) e2.nextElement();
					if(aaI.getArgument() != null) {
						Enumeration e3 = aaI.getArgument().enumerateArgumentItem();
						while (e3.hasMoreElements()) {
							ArgumentItem argI = (ArgumentItem) e3.nextElement();
							if(argI.getArgument_value() != null) {
								Enumeration e4 = argI.getArgument_value().enumerateArgument_valueItem();
								while (e4.hasMoreElements()) {
									Argument_valueItem avI = (Argument_valueItem) e4.nextElement();
									if(avI.getActionExpression() != null) {
										ca.addArgument(avI.getActionExpression().getBody());
									} else if(avI.getArgListExpression() != null) {
										ca.addArgument(avI.getArgListExpression().getBody());
									} else if(avI.getBooleanExpression() != null) {
										ca.addArgument(avI.getBooleanExpression().getBody());
									} else if(avI.getIterationExpression() != null) {
										ca.addArgument(avI.getIterationExpression().getBody());
									} else if(avI.getMappingExpression() != null) {
										ca.addArgument(avI.getMappingExpression().getBody());
									} else if(avI.getObjectSetExpression() != null) {
										ca.addArgument(avI.getObjectSetExpression().getBody());
									} else if(avI.getProcedureExpression() != null) {
										ca.addArgument(avI.getProcedureExpression().getBody());
									} else if(avI.getTimeExpression() != null) {
										ca.addArgument(avI.getTimeExpression().getBody());
									} else if(avI.getTypeExpression() != null) {
										ca.addArgument(avI.getTypeExpression().getBody());
									}
								}
							}
						}						
					}
				}
			} else if(caI.getAction_script() != null) {
				Enumeration e2 = caI.getAction_script().enumerateAction_scriptItem();
				while (e2.hasMoreElements()) {
					Action_scriptItem asI = (Action_scriptItem) e2.nextElement();
					if(asI.getActionExpression() != null) {
						ca.setScript(asI.getActionExpression().getBody());
					}
				}
			} else if(caI.getAction_recurrence() != null) {
				Enumeration e2 = caI.getAction_recurrence().enumerateAction_recurrenceItem();
				while (e2.hasMoreElements()) {
					Action_recurrenceItem arI = (Action_recurrenceItem) e2.nextElement();
					if(arI.getIterationExpression() != null) {
						ca.setRecurrence(arI.getIterationExpression().getBody());
					}
				}
			} else if(caI.getAction_target() != null) {
				Enumeration e2 = caI.getAction_target().enumerateAction_targetItem();
				while (e2.hasMoreElements()) {
					Action_targetItem atI = (Action_targetItem) e2.nextElement();
					if(atI.getObjectSetExpression() != null) {
						ca.setTarget(atI.getObjectSetExpression().getBody());
					}
				}
			}
		}
		return ca;
	}

	protected IDestroyAction getDestroyActionInstance(
			org.soulspace.xmi.marshal.DestroyAction xmiDestroyAction) {
		IDestroyAction da = new DestroyAction();
		da.setId(xmiDestroyAction.getXmi_id());
		return da;
	}

	protected IDestroyAction initDestroyAction(IDestroyAction da,
			org.soulspace.xmi.marshal.DestroyAction xmiDestroyAction) {
		da.setProfileElement(xmiDestroyAction.getProfileElement());
		if(xmiDestroyAction.getName() != null) {
			da.setName(xmiDestroyAction.getName());
		}
		da.setNamespace(xmiDestroyAction.getNamespace());
//		da.setQualifiedName(ca.getQualifiedName());

		Enumeration e1 = xmiDestroyAction.enumerateDestroyActionItem();
		while (e1.hasMoreElements()) {
			DestroyActionItem daI = (DestroyActionItem) e1.nextElement();
			if(daI.getAction_actualArgument() != null) {
				Enumeration e2 = daI.getAction_actualArgument().enumerateAction_actualArgumentItem();
				while (e2.hasMoreElements()) {
					Action_actualArgumentItem aaI = (Action_actualArgumentItem) e2.nextElement();
					if(aaI.getArgument() != null) {
						Enumeration e3 = aaI.getArgument().enumerateArgumentItem();
						while (e3.hasMoreElements()) {
							ArgumentItem argI = (ArgumentItem) e3.nextElement();
							if(argI.getArgument_value() != null) {
								Enumeration e4 = argI.getArgument_value().enumerateArgument_valueItem();
								while (e4.hasMoreElements()) {
									Argument_valueItem avI = (Argument_valueItem) e4.nextElement();
									if(avI.getActionExpression() != null) {
										da.addArgument(avI.getActionExpression().getBody());
									} else if(avI.getArgListExpression() != null) {
										da.addArgument(avI.getArgListExpression().getBody());
									} else if(avI.getBooleanExpression() != null) {
										da.addArgument(avI.getBooleanExpression().getBody());
									} else if(avI.getIterationExpression() != null) {
										da.addArgument(avI.getIterationExpression().getBody());
									} else if(avI.getMappingExpression() != null) {
										da.addArgument(avI.getMappingExpression().getBody());
									} else if(avI.getObjectSetExpression() != null) {
										da.addArgument(avI.getObjectSetExpression().getBody());
									} else if(avI.getProcedureExpression() != null) {
										da.addArgument(avI.getProcedureExpression().getBody());
									} else if(avI.getTimeExpression() != null) {
										da.addArgument(avI.getTimeExpression().getBody());
									} else if(avI.getTypeExpression() != null) {
										da.addArgument(avI.getTypeExpression().getBody());
									}
								}
							}
						}						
					}
				}
			} else if(daI.getAction_script() != null) {
				Enumeration e2 = daI.getAction_script().enumerateAction_scriptItem();
				while (e2.hasMoreElements()) {
					Action_scriptItem asI = (Action_scriptItem) e2.nextElement();
					if(asI.getActionExpression() != null) {
						da.setScript(asI.getActionExpression().getBody());
					}
				}
			} else if(daI.getAction_recurrence() != null) {
				Enumeration e2 = daI.getAction_recurrence().enumerateAction_recurrenceItem();
				while (e2.hasMoreElements()) {
					Action_recurrenceItem arI = (Action_recurrenceItem) e2.nextElement();
					if(arI.getIterationExpression() != null) {
						da.setRecurrence(arI.getIterationExpression().getBody());
					}
				}
			} else if(daI.getAction_target() != null) {
				Enumeration e2 = daI.getAction_target().enumerateAction_targetItem();
				while (e2.hasMoreElements()) {
					Action_targetItem atI = (Action_targetItem) e2.nextElement();
					if(atI.getObjectSetExpression() != null) {
						da.setTarget(atI.getObjectSetExpression().getBody());
					}
				}
			}
		}
		return da;
	}

	protected IReturnAction getReturnActionInstance(
			org.soulspace.xmi.marshal.ReturnAction xmiReturnAction) {
		IReturnAction da = new ReturnAction();
		da.setId(xmiReturnAction.getXmi_id());
		return da;
	}

	protected IReturnAction initReturnAction(IReturnAction da,
			org.soulspace.xmi.marshal.ReturnAction xmiReturnAction) {
		da.setProfileElement(xmiReturnAction.getProfileElement());
		if(xmiReturnAction.getName() != null) {
			da.setName(xmiReturnAction.getName());
		}
		da.setNamespace(xmiReturnAction.getNamespace());
//		da.setQualifiedName(ca.getQualifiedName());

		Enumeration e1 = xmiReturnAction.enumerateReturnActionItem();
		while (e1.hasMoreElements()) {
			ReturnActionItem daI = (ReturnActionItem) e1.nextElement();
			if(daI.getAction_actualArgument() != null) {
				Enumeration e2 = daI.getAction_actualArgument().enumerateAction_actualArgumentItem();
				while (e2.hasMoreElements()) {
					Action_actualArgumentItem aaI = (Action_actualArgumentItem) e2.nextElement();
					if(aaI.getArgument() != null) {
						Enumeration e3 = aaI.getArgument().enumerateArgumentItem();
						while (e3.hasMoreElements()) {
							ArgumentItem argI = (ArgumentItem) e3.nextElement();
							if(argI.getArgument_value() != null) {
								Enumeration e4 = argI.getArgument_value().enumerateArgument_valueItem();
								while (e4.hasMoreElements()) {
									Argument_valueItem avI = (Argument_valueItem) e4.nextElement();
									if(avI.getActionExpression() != null) {
										da.addArgument(avI.getActionExpression().getBody());
									} else if(avI.getArgListExpression() != null) {
										da.addArgument(avI.getArgListExpression().getBody());
									} else if(avI.getBooleanExpression() != null) {
										da.addArgument(avI.getBooleanExpression().getBody());
									} else if(avI.getIterationExpression() != null) {
										da.addArgument(avI.getIterationExpression().getBody());
									} else if(avI.getMappingExpression() != null) {
										da.addArgument(avI.getMappingExpression().getBody());
									} else if(avI.getObjectSetExpression() != null) {
										da.addArgument(avI.getObjectSetExpression().getBody());
									} else if(avI.getProcedureExpression() != null) {
										da.addArgument(avI.getProcedureExpression().getBody());
									} else if(avI.getTimeExpression() != null) {
										da.addArgument(avI.getTimeExpression().getBody());
									} else if(avI.getTypeExpression() != null) {
										da.addArgument(avI.getTypeExpression().getBody());
									}
								}
							}
						}						
					}
				}
			} else if(daI.getAction_script() != null) {
				Enumeration e2 = daI.getAction_script().enumerateAction_scriptItem();
				while (e2.hasMoreElements()) {
					Action_scriptItem asI = (Action_scriptItem) e2.nextElement();
					if(asI.getActionExpression() != null) {
						da.setScript(asI.getActionExpression().getBody());
					}
				}
			} else if(daI.getAction_recurrence() != null) {
				Enumeration e2 = daI.getAction_recurrence().enumerateAction_recurrenceItem();
				while (e2.hasMoreElements()) {
					Action_recurrenceItem arI = (Action_recurrenceItem) e2.nextElement();
					if(arI.getIterationExpression() != null) {
						da.setRecurrence(arI.getIterationExpression().getBody());
					}
				}
			} else if(daI.getAction_target() != null) {
				Enumeration e2 = daI.getAction_target().enumerateAction_targetItem();
				while (e2.hasMoreElements()) {
					Action_targetItem atI = (Action_targetItem) e2.nextElement();
					if(atI.getObjectSetExpression() != null) {
						da.setTarget(atI.getObjectSetExpression().getBody());
					}
				}
			}
		}
		return da;
	}

	protected ITerminateAction getTerminateActionInstance(
			org.soulspace.xmi.marshal.TerminateAction xmiTerminateAction) {
		ITerminateAction da = new TerminateAction();
		da.setId(xmiTerminateAction.getXmi_id());
		return da;
	}

	protected ITerminateAction initTerminateAction(ITerminateAction da,
			org.soulspace.xmi.marshal.TerminateAction xmiTerminateAction) {
		da.setProfileElement(xmiTerminateAction.getProfileElement());
		if(xmiTerminateAction.getName() != null) {
			da.setName(xmiTerminateAction.getName());
		}
		da.setNamespace(xmiTerminateAction.getNamespace());
//		da.setQualifiedName(ca.getQualifiedName());

		Enumeration e1 = xmiTerminateAction.enumerateTerminateActionItem();
		while (e1.hasMoreElements()) {
			TerminateActionItem daI = (TerminateActionItem) e1.nextElement();
			if(daI.getAction_actualArgument() != null) {
				Enumeration e2 = daI.getAction_actualArgument().enumerateAction_actualArgumentItem();
				while (e2.hasMoreElements()) {
					Action_actualArgumentItem aaI = (Action_actualArgumentItem) e2.nextElement();
					if(aaI.getArgument() != null) {
						Enumeration e3 = aaI.getArgument().enumerateArgumentItem();
						while (e3.hasMoreElements()) {
							ArgumentItem argI = (ArgumentItem) e3.nextElement();
							if(argI.getArgument_value() != null) {
								Enumeration e4 = argI.getArgument_value().enumerateArgument_valueItem();
								while (e4.hasMoreElements()) {
									Argument_valueItem avI = (Argument_valueItem) e4.nextElement();
									if(avI.getActionExpression() != null) {
										da.addArgument(avI.getActionExpression().getBody());
									} else if(avI.getArgListExpression() != null) {
										da.addArgument(avI.getArgListExpression().getBody());
									} else if(avI.getBooleanExpression() != null) {
										da.addArgument(avI.getBooleanExpression().getBody());
									} else if(avI.getIterationExpression() != null) {
										da.addArgument(avI.getIterationExpression().getBody());
									} else if(avI.getMappingExpression() != null) {
										da.addArgument(avI.getMappingExpression().getBody());
									} else if(avI.getObjectSetExpression() != null) {
										da.addArgument(avI.getObjectSetExpression().getBody());
									} else if(avI.getProcedureExpression() != null) {
										da.addArgument(avI.getProcedureExpression().getBody());
									} else if(avI.getTimeExpression() != null) {
										da.addArgument(avI.getTimeExpression().getBody());
									} else if(avI.getTypeExpression() != null) {
										da.addArgument(avI.getTypeExpression().getBody());
									}
								}
							}
						}						
					}
				}
			} else if(daI.getAction_script() != null) {
				Enumeration e2 = daI.getAction_script().enumerateAction_scriptItem();
				while (e2.hasMoreElements()) {
					Action_scriptItem asI = (Action_scriptItem) e2.nextElement();
					if(asI.getActionExpression() != null) {
						da.setScript(asI.getActionExpression().getBody());
					}
				}
			} else if(daI.getAction_recurrence() != null) {
				Enumeration e2 = daI.getAction_recurrence().enumerateAction_recurrenceItem();
				while (e2.hasMoreElements()) {
					Action_recurrenceItem arI = (Action_recurrenceItem) e2.nextElement();
					if(arI.getIterationExpression() != null) {
						da.setRecurrence(arI.getIterationExpression().getBody());
					}
				}
			} else if(daI.getAction_target() != null) {
				Enumeration e2 = daI.getAction_target().enumerateAction_targetItem();
				while (e2.hasMoreElements()) {
					Action_targetItem atI = (Action_targetItem) e2.nextElement();
					if(atI.getObjectSetExpression() != null) {
						da.setTarget(atI.getObjectSetExpression().getBody());
					}
				}
			}
		}
		return da;
	}

	protected IUninterpretedAction getUninterpretedActionInstance(
			org.soulspace.xmi.marshal.UninterpretedAction xmiUninterpretedAction) {
		IUninterpretedAction da = new UninterpretedAction();
		da.setId(xmiUninterpretedAction.getXmi_id());
		return da;
	}

	protected IUninterpretedAction initUninterpretedAction(IUninterpretedAction da,
			org.soulspace.xmi.marshal.UninterpretedAction xmiUninterpretedAction) {
		da.setProfileElement(xmiUninterpretedAction.getProfileElement());
		if(xmiUninterpretedAction.getName() != null) {
			da.setName(xmiUninterpretedAction.getName());
		}
		da.setNamespace(xmiUninterpretedAction.getNamespace());
//		da.setQualifiedName(ca.getQualifiedName());

		Enumeration e1 = xmiUninterpretedAction.enumerateUninterpretedActionItem();
		while (e1.hasMoreElements()) {
			ReturnActionItem daI = (ReturnActionItem) e1.nextElement();
			if(daI.getAction_actualArgument() != null) {
				Enumeration e2 = daI.getAction_actualArgument().enumerateAction_actualArgumentItem();
				while (e2.hasMoreElements()) {
					Action_actualArgumentItem aaI = (Action_actualArgumentItem) e2.nextElement();
					if(aaI.getArgument() != null) {
						Enumeration e3 = aaI.getArgument().enumerateArgumentItem();
						while (e3.hasMoreElements()) {
							ArgumentItem argI = (ArgumentItem) e3.nextElement();
							if(argI.getArgument_value() != null) {
								Enumeration e4 = argI.getArgument_value().enumerateArgument_valueItem();
								while (e4.hasMoreElements()) {
									Argument_valueItem avI = (Argument_valueItem) e4.nextElement();
									if(avI.getActionExpression() != null) {
										da.addArgument(avI.getActionExpression().getBody());
									} else if(avI.getArgListExpression() != null) {
										da.addArgument(avI.getArgListExpression().getBody());
									} else if(avI.getBooleanExpression() != null) {
										da.addArgument(avI.getBooleanExpression().getBody());
									} else if(avI.getIterationExpression() != null) {
										da.addArgument(avI.getIterationExpression().getBody());
									} else if(avI.getMappingExpression() != null) {
										da.addArgument(avI.getMappingExpression().getBody());
									} else if(avI.getObjectSetExpression() != null) {
										da.addArgument(avI.getObjectSetExpression().getBody());
									} else if(avI.getProcedureExpression() != null) {
										da.addArgument(avI.getProcedureExpression().getBody());
									} else if(avI.getTimeExpression() != null) {
										da.addArgument(avI.getTimeExpression().getBody());
									} else if(avI.getTypeExpression() != null) {
										da.addArgument(avI.getTypeExpression().getBody());
									}
								}
							}
						}						
					}
				}
			} else if(daI.getAction_script() != null) {
				Enumeration e2 = daI.getAction_script().enumerateAction_scriptItem();
				while (e2.hasMoreElements()) {
					Action_scriptItem asI = (Action_scriptItem) e2.nextElement();
					if(asI.getActionExpression() != null) {
						da.setScript(asI.getActionExpression().getBody());
					}
				}
			} else if(daI.getAction_recurrence() != null) {
				Enumeration e2 = daI.getAction_recurrence().enumerateAction_recurrenceItem();
				while (e2.hasMoreElements()) {
					Action_recurrenceItem arI = (Action_recurrenceItem) e2.nextElement();
					if(arI.getIterationExpression() != null) {
						da.setRecurrence(arI.getIterationExpression().getBody());
					}
				}
			} else if(daI.getAction_target() != null) {
				Enumeration e2 = daI.getAction_target().enumerateAction_targetItem();
				while (e2.hasMoreElements()) {
					Action_targetItem atI = (Action_targetItem) e2.nextElement();
					if(atI.getObjectSetExpression() != null) {
						da.setTarget(atI.getObjectSetExpression().getBody());
					}
				}
			}
		}
		return da;
	}

	protected IActionSequence getActionSequenceInstance(
			org.soulspace.xmi.marshal.ActionSequence xmiActionSequence) {
		IActionSequence da = new ActionSequence();
		da.setId(xmiActionSequence.getXmi_id());
		return da;
	}

	protected IActionSequence initActionSequence(IActionSequence da,
			org.soulspace.xmi.marshal.ActionSequence xmiActionSequence) {
		da.setProfileElement(xmiActionSequence.getProfileElement());
		if(xmiActionSequence.getName() != null) {
			da.setName(xmiActionSequence.getName());
		}
		da.setNamespace(xmiActionSequence.getNamespace());
//		da.setQualifiedName(ca.getQualifiedName());

		Enumeration e1 = xmiActionSequence.enumerateActionSequenceItem();
		while (e1.hasMoreElements()) {
			ActionSequenceItem daI = (ActionSequenceItem) e1.nextElement();
			if(daI.getAction_actualArgument() != null) {
				Enumeration e2 = daI.getAction_actualArgument().enumerateAction_actualArgumentItem();
				while (e2.hasMoreElements()) {
					Action_actualArgumentItem aaI = (Action_actualArgumentItem) e2.nextElement();
					if(aaI.getArgument() != null) {
						Enumeration e3 = aaI.getArgument().enumerateArgumentItem();
						while (e3.hasMoreElements()) {
							ArgumentItem argI = (ArgumentItem) e3.nextElement();
							if(argI.getArgument_value() != null) {
								Enumeration e4 = argI.getArgument_value().enumerateArgument_valueItem();
								while (e4.hasMoreElements()) {
									Argument_valueItem avI = (Argument_valueItem) e4.nextElement();
									if(avI.getActionExpression() != null) {
										da.addArgument(avI.getActionExpression().getBody());
									} else if(avI.getArgListExpression() != null) {
										da.addArgument(avI.getArgListExpression().getBody());
									} else if(avI.getBooleanExpression() != null) {
										da.addArgument(avI.getBooleanExpression().getBody());
									} else if(avI.getIterationExpression() != null) {
										da.addArgument(avI.getIterationExpression().getBody());
									} else if(avI.getMappingExpression() != null) {
										da.addArgument(avI.getMappingExpression().getBody());
									} else if(avI.getObjectSetExpression() != null) {
										da.addArgument(avI.getObjectSetExpression().getBody());
									} else if(avI.getProcedureExpression() != null) {
										da.addArgument(avI.getProcedureExpression().getBody());
									} else if(avI.getTimeExpression() != null) {
										da.addArgument(avI.getTimeExpression().getBody());
									} else if(avI.getTypeExpression() != null) {
										da.addArgument(avI.getTypeExpression().getBody());
									}
								}
							}
						}						
					}
				}
			} else if(daI.getAction_script() != null) {
				Enumeration e2 = daI.getAction_script().enumerateAction_scriptItem();
				while (e2.hasMoreElements()) {
					Action_scriptItem asI = (Action_scriptItem) e2.nextElement();
					if(asI.getActionExpression() != null) {
						da.setScript(asI.getActionExpression().getBody());
					}
				}
			} else if(daI.getAction_recurrence() != null) {
				Enumeration e2 = daI.getAction_recurrence().enumerateAction_recurrenceItem();
				while (e2.hasMoreElements()) {
					Action_recurrenceItem arI = (Action_recurrenceItem) e2.nextElement();
					if(arI.getIterationExpression() != null) {
						da.setRecurrence(arI.getIterationExpression().getBody());
					}
				}
			} else if(daI.getAction_target() != null) {
				Enumeration e2 = daI.getAction_target().enumerateAction_targetItem();
				while (e2.hasMoreElements()) {
					Action_targetItem atI = (Action_targetItem) e2.nextElement();
					if(atI.getObjectSetExpression() != null) {
						da.setTarget(atI.getObjectSetExpression().getBody());
					}
				}
			}
		}
		return da;
	}

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
					Multiplicity_rangeItem rI = (Multiplicity_rangeItem) e2
							.nextElement();
					if (rI.getMultiplicityRange() != null) {
						m.setLow(rI.getMultiplicityRange().getLower());
						m.setHigh(rI.getMultiplicityRange().getUpper());
					}
				}
			}
		}

		return m;
	}

	void addStereotypes(IElement element, ModelElement_stereotype mEST) {
		Enumeration e1 = mEST.enumerateModelElement_stereotypeItem();
		while (e1.hasMoreElements()) {
			ModelElement_stereotypeItem stI = (ModelElement_stereotypeItem) e1
					.nextElement();
			if (stI.getStereotype() != null) {
				String xmiId = stI.getStereotype().getRefId();
				if (xmiId != null) {
					IStereotype st = (IStereotype) repository
							.lookupByXmiId(xmiId);
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.soulspace.xmi.uml.IModelFactory#processGeneralization(org.soulspace
	 * .xmi.base.XmiObject)
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
	 * @see
	 * org.soulspace.xmi.uml.IModelFactory#processAssociation(org.soulspace.
	 * xmi.base.XmiObject)
	 */
	public void processAssociation(XmiObject xmiObj) {
		org.soulspace.xmi.marshal.Association xmiAssociation = (org.soulspace.xmi.marshal.Association) xmiObj;
		IAssociationEnd fromEnd = null;
		IAssociationEnd toEnd = null;

		IAssociation a = createAssociation(xmiAssociation);
		a.setProfileElement(xmiAssociation.getProfileElement());

		List aeList = new ArrayList();
		Enumeration e1 = xmiAssociation.enumerateAssociationItem();
		while (e1.hasMoreElements()) {
			AssociationItem aI = (AssociationItem) e1.nextElement();
			if (aI.getAssociation_connection() != null) {
				Enumeration e2 = aI.getAssociation_connection()
						.enumerateAssociation_connectionItem();
				while (e2.hasMoreElements()) {
					Association_connectionItem cI = (Association_connectionItem) e2
							.nextElement();
					if (cI.getAssociationEnd() != null) {
						IAssociationEnd ae = createAssociationEnd(cI
								.getAssociationEnd());
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

		if (fromEnd != null && fromEnd.getType() != null && toEnd != null
				&& toEnd.getType() != null) {
			// set ends on association
			a.setFromEnd(fromEnd);
			a.setToEnd(toEnd);

			// set references to each other
			((AssociationEnd) fromEnd).setSourceEnd(toEnd);
			((AssociationEnd) toEnd).setSourceEnd(fromEnd);

			// TODO add other types
			if(fromEnd.getType() instanceof Class) {
				((Class) fromEnd.getType()).addAssociation(toEnd);
			} else if(fromEnd.getType() instanceof Interface) {
				((Interface) fromEnd.getType()).addAssociation(toEnd);				
			} else if(fromEnd.getType() instanceof DataType) {
				((DataType) fromEnd.getType()).addAssociation(toEnd);				
			} else if(fromEnd.getType() instanceof UseCase) {
				((UseCase) fromEnd.getType()).addAssociation(toEnd);				
			} else if(fromEnd.getType() instanceof Actor) {
				((Actor) fromEnd.getType()).addAssociation(toEnd);				
			}

			if(toEnd.getType() instanceof Class) {
				((Class) toEnd.getType()).addAssociation(fromEnd);
			} else if(toEnd.getType() instanceof Interface) {
				((Interface) toEnd.getType()).addAssociation(fromEnd);
			} else if(toEnd.getType() instanceof DataType) {
				((DataType) toEnd.getType()).addAssociation(fromEnd);
			} else if(toEnd.getType() instanceof UseCase) {
				((UseCase) toEnd.getType()).addAssociation(fromEnd);
			} else if(toEnd.getType() instanceof Actor) {
				((Actor) toEnd.getType()).addAssociation(fromEnd);
			}

		}
		Package p = (Package) repository.lookupPackageByQualifiedName(a
				.getNamespace());
		if (p != null) {
			p.addAssociation(a);
		}

		//repository.register(a);
	}

	public void processInclude(XmiObject xmiObj) {
		IUseCase base = null;
		IUseCase addition = null;
		Include xmiInclude = (Include) xmiObj;
		Enumeration e1 = xmiInclude.enumerateIncludeItem();
		while (e1.hasMoreElements()) {
			IncludeItem iI = (IncludeItem) e1.nextElement();
			if (iI.getInclude_base() != null) {
				base = findUseCase(iI.getInclude_base().getUseCase());
			} else if (iI.getInclude_addition() != null) {
				addition = findUseCase(iI.getInclude_addition().getUseCase());
			}
		}
		if (base != null && addition != null) {
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
			if (eI.getExtend_base() != null) {
				Enumeration e2 = eI.getExtend_base().enumerateExtend_baseItem();
				while (e2.hasMoreElements()) {
					Extend_baseItem ebI = (Extend_baseItem) e2.nextElement();
					base = findUseCase(ebI.getUseCase());
				}
			} else if (eI.getExtend_extension() != null) {
				Enumeration e2 = eI.getExtend_extension()
						.enumerateExtend_extensionItem();
				while (e2.hasMoreElements()) {
					Extend_extensionItem eeI = (Extend_extensionItem) e2
							.nextElement();
					extension = findUseCase(eeI.getUseCase());
				}
			} else if (eI.getExtend_extensionPoint() != null) {
				Enumeration e2 = eI.getExtend_extensionPoint()
						.enumerateExtend_extensionPointItem();
				while (e2.hasMoreElements()) {
					Extend_extensionPointItem eepI = (Extend_extensionPointItem) e2
							.nextElement();
					extensionPoint = findExtensionPoint(eepI
							.getExtensionPoint());
				}
			}
		}
	}

	IElement findElement(String xmiId) {
		return repository.lookupByXmiId(xmiId);
	}

	IElement findModel(String xmiId) {
		return repository.lookupByXmiId(xmiId);
	}

	IPackage findPackage(String namespace) {
		return repository.lookupPackageByQualifiedName(namespace);
	}

	IPackage findPackage(org.soulspace.xmi.marshal.Package p) {
		return (Package) repository.lookupByXmiId(p.getRefId());
	}

	IClass findClass(org.soulspace.xmi.marshal.Class c) {
		return (Class) repository.lookupByXmiId(c.getRefId());
	}

	private IDataType findDataType(org.soulspace.xmi.marshal.DataType dt) {
		return (DataType) repository.lookupByXmiId(dt.getRefId());
	}

	private IEnumerationType findEnumerationType(
			org.soulspace.xmi.marshal.Enumeration e) {
		return (EnumerationType) repository.lookupByXmiId(e.getRefId());
	}

	private IInterface findInterface(org.soulspace.xmi.marshal.Interface i) {
		return (Interface) repository.lookupByXmiId(i.getRefId());
	}

	private IClassifier findClassifier(org.soulspace.xmi.base.XmiObject xmiObj) {
		return (IClassifier) repository.lookupByXmiId(xmiObj.getRefId());
	}

	private IUseCase findUseCase(org.soulspace.xmi.marshal.UseCase uc) {
		return (IUseCase) repository.lookupByXmiId(uc.getXmi_id());
	}

	private IExtensionPoint findExtensionPoint(
			org.soulspace.xmi.marshal.ExtensionPoint ep) {
		return (IExtensionPoint) repository.lookupByXmiId(ep.getXmi_id());
	}

	private IActor findActor(org.soulspace.xmi.marshal.Actor a) {
		return (IActor) repository.lookupByXmiId(a.getRefId());
	}

	private IAssociationEnd findAssociationEnd(
			org.soulspace.xmi.marshal.AssociationEnd ae) {
		return (IAssociationEnd) repository.lookupByXmiId(ae.getRefId());
	}

	private IState findState(String id) {
		return (IState) repository.lookupByXmiId(id);
	}

	private IEvent findEvent(String id) {
		return (IEvent) repository.lookupByXmiId(id);
	}

	private IAssociation findAssociation(org.soulspace.xmi.marshal.Association a) {
		return (IAssociation) repository.lookupByXmiId(a.getXmi_id());
	}

	private Stereotype findStereotype(ModelElement_stereotypeItem stI) {
		return (Stereotype) repository.lookupByXmiId(stI.getStereotype()
				.getRefId());
	}

	TagDefinition findTagDefinition(TaggedValue_typeItem tI) {
		return (TagDefinition) repository.lookupByXmiId(tI.getTagDefinition()
				.getRefId());
	}

	IClassifier getReturnType(org.soulspace.xmi.marshal.Parameter p) {
		Enumeration e3 = p.enumerateParameterItem();
		while (e3.hasMoreElements()) {
			ParameterItem pI = (ParameterItem) e3.nextElement();
			if (pI.getTypedElement_type() != null) {
				// UML2 TypedElement.type
				TypedElement_type tet = pI.getTypedElement_type();
				if (tet.getClazz() != null) {
					return (IClassifier) this.findElement(tet.getClazz()
							.getRefId());
				} else if (tet.getDataType() != null) {
					return (IClassifier) this.findElement(tet.getDataType()
							.getRefId());
				} else if (tet.getInterface() != null) {
					return (IClassifier) this.findElement(tet.getInterface()
							.getRefId());
				}
			} else if (pI.getParameter_type() != null) {
				// UML ParameterType
				Enumeration e5 = pI.getParameter_type()
						.enumerateParameter_typeItem();
				while (e5.hasMoreElements()) {
					Parameter_typeItem ptI = (Parameter_typeItem) e5
							.nextElement();
					if (ptI.getClazz() != null) {
						return (IClassifier) this.findElement(ptI.getClazz()
								.getRefId());
					} else if (ptI.getDataType() != null) {
						return (IClassifier) this.findElement(ptI.getDataType()
								.getRefId());
					} else if (ptI.getInterface() != null) {
						return (IClassifier) this.findElement(ptI
								.getInterface().getRefId());
					}
				}
			} else if (pI.getModelElement_stereotype() != null) {
				// TODO check if there's nothing to do for
				// return types
			} else if (pI.getModelElement_taggedValue() != null) {
				// TODO check if there's nothing to do for
				// return types
			}
		}
		return null;
	}

}