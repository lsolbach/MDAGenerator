package org.soulspace.mdlrepo.metamodel.impl;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.soulspace.mdlrepo.metamodel.IAssociationClass;
import org.soulspace.mdlrepo.metamodel.IAssociationEnd;
import org.soulspace.mdlrepo.metamodel.IAttribute;
import org.soulspace.mdlrepo.metamodel.IClass;
import org.soulspace.mdlrepo.metamodel.IClassifier;
import org.soulspace.mdlrepo.metamodel.IDependency;
import org.soulspace.mdlrepo.metamodel.IElement;
import org.soulspace.mdlrepo.metamodel.IInterface;
import org.soulspace.mdlrepo.metamodel.IOperation;
import org.soulspace.mdlrepo.metamodel.IPackage;
import org.soulspace.mdlrepo.metamodel.IStateMachine;
import org.soulspace.mdlrepo.metamodel.IStereotype;
import org.soulspace.mdlrepo.metamodel.ITaggedValue;

public class AssociationClass implements IAssociationClass {

	private Class clazz = new Class();
	private Association association = new Association();
	
	public IElement getParentElement() {
		return clazz.getParentElement();
	}

	public void setParentElement(IElement parentElement) {
		clazz.setParentElement(parentElement);
	}
	
	/**
	 * @return
	 * @see org.soulspace.mdlrepo.metamodel.impl.Element#getProfileElement()
	 */
	public boolean getProfileElement() {
		return clazz.getProfileElement();
	}

	/**
	 * @param profileElement
	 * @see org.soulspace.mdlrepo.metamodel.impl.Element#setProfileElement(boolean)
	 */
	public void setProfileElement(boolean profileElement) {
		clazz.setProfileElement(profileElement);
	}

	/**
	 * @param ae
	 * @see org.soulspace.mdlrepo.metamodel.impl.Class#addAssociation(org.soulspace.mdlrepo.metamodel.IAssociationEnd)
	 */
	public void addAssociation(IAssociationEnd ae) {
		clazz.addAssociation(ae);
	}

	/**
	 * @param attr
	 * @see org.soulspace.mdlrepo.metamodel.impl.Class#addAttribute(org.soulspace.mdlrepo.metamodel.IAttribute)
	 */
	public void addAttribute(IAttribute attr) {
		clazz.addAttribute(attr);
	}

	/**
	 * @param d
	 * @see org.soulspace.mdlrepo.metamodel.impl.Class#addDependency(org.soulspace.mdlrepo.metamodel.IDependency)
	 */
	public void addDependency(IDependency d) {
		clazz.addDependency(d);
	}

	/**
	 * @param d
	 * @see org.soulspace.mdlrepo.metamodel.impl.Class#addReverseDependency(org.soulspace.mdlrepo.metamodel.IDependency)
	 */
	public void addReverseDependency(IDependency d) {
		clazz.addReverseDependency(d);
	}

	/**
	 * @param o
	 * @see org.soulspace.mdlrepo.metamodel.impl.Class#addOperation(org.soulspace.mdlrepo.metamodel.IOperation)
	 */
	public void addOperation(IOperation o) {
		clazz.addOperation(o);
	}

	/**
	 * @param st
	 * @see org.soulspace.mdlrepo.metamodel.impl.Element#addStereotype(org.soulspace.mdlrepo.metamodel.IStereotype)
	 */
	public void addStereotype(IStereotype st) {
		clazz.addStereotype(st);
	}

	/**
	 * @param sc
	 * @see org.soulspace.mdlrepo.metamodel.impl.Class#addSubClass(org.soulspace.mdlrepo.metamodel.IClass)
	 */
	public void addSubClass(IClass sc) {
		clazz.addSubClass(sc);
	}

	/**
	 * @param sc
	 * @see org.soulspace.mdlrepo.metamodel.impl.Class#addSuperClass(org.soulspace.mdlrepo.metamodel.IClass)
	 */
	public void addSuperClass(IClass sc) {
		clazz.addSuperClass(sc);
	}

	/**
	 * @param tv
	 * @see org.soulspace.mdlrepo.metamodel.impl.Element#addTaggedValue(org.soulspace.mdlrepo.metamodel.ITaggedValue)
	 */
	public void addTaggedValue(ITaggedValue tv) {
		clazz.addTaggedValue(tv);
	}

	/**
	 * @return
	 * @see org.soulspace.mdlrepo.metamodel.impl.Class#getAbstract()
	 */
	public boolean getAbstract() {
		return clazz.getAbstract();
	}

	/**
	 * @return
	 * @see org.soulspace.mdlrepo.metamodel.impl.Class#getAllAssociations()
	 */
	public List<IAssociationEnd> getAllAssociations() {
		return clazz.getAllAssociations();
	}

	/**
	 * @return
	 * @see org.soulspace.mdlrepo.metamodel.impl.Class#getAllAttributes()
	 */
	public List<IAttribute> getAllAttributes() {
		return clazz.getAllAttributes();
	}

	/**
	 * @return
	 * @see org.soulspace.mdlrepo.metamodel.impl.Class#getAllDependencies()
	 */
	public List<IDependency> getAllDependencies() {
		return clazz.getAllDependencies();
	}

	/**
	 * @return
	 * @see org.soulspace.mdlrepo.metamodel.impl.Class#getAllReverseDependencies()
	 */
	public List<IDependency> getAllReverseDependencies() {
		return clazz.getAllReverseDependencies();
	}

	/**
	 * @return
	 * @see org.soulspace.mdlrepo.metamodel.impl.Class#getAllOperations()
	 */
	public List<IOperation> getAllOperations() {
		return clazz.getAllOperations();
	}

	/**
	 * @return
	 * @see org.soulspace.mdlrepo.metamodel.impl.Class#getAllReferencedTypes()
	 */
	public List<IClassifier> getAllReferencedTypes() {
		return clazz.getAllReferencedTypes();
	}

	/**
	 * @return
	 * @see org.soulspace.mdlrepo.metamodel.impl.Class#getAssociations()
	 */
	public List<IAssociationEnd> getAssociations() {
		return clazz.getAssociations();
	}

	/**
	 * @return
	 * @see org.soulspace.mdlrepo.metamodel.impl.Class#getAttributes()
	 */
	public List<IAttribute> getAttributes() {
		return clazz.getAttributes();
	}

	/**
	 * @return
	 * @see org.soulspace.mdlrepo.metamodel.impl.Class#getDependencies()
	 */
	public List<IDependency> getDependencies() {
		return clazz.getDependencies();
	}

	/**
	 * @return
	 * @see org.soulspace.mdlrepo.metamodel.impl.Class#getReverseDependencies()
	 */
	public List<IDependency> getReverseDependencies() {
		return clazz.getReverseDependencies();
	}

	public String getElementType() {
		return getClass().getSimpleName();
	}

	public IElement getThis() {
		return this;
	}

	/**
	 * @return
	 * @see org.soulspace.mdlrepo.metamodel.impl.Element#getId()
	 */
	public String getId() {
		return clazz.getId();
	}

	/**
	 * @return
	 * @see org.soulspace.mdlrepo.metamodel.impl.Class#getInterfaces()
	 */
	public List<IInterface> getInterfaces() {
		return clazz.getInterfaces();
	}

	/**
	 * @return
	 * @see org.soulspace.mdlrepo.metamodel.impl.NamedElement#getName()
	 */
	public String getName() {
		return clazz.getName();
	}

	/**
	 * @return
	 * @see org.soulspace.mdlrepo.metamodel.impl.Element#getNamespace()
	 */
	public String getNamespace() {
		return clazz.getNamespace();
	}

	/**
	 * @return
	 * @see org.soulspace.mdlrepo.metamodel.impl.Class#getOperations()
	 */
	public List<IOperation> getOperations() {
		return clazz.getOperations();
	}

	/**
	 * @return
	 * @see org.soulspace.mdlrepo.metamodel.impl.Classifier#getPackage()
	 */
	public IPackage getPackage() {
		return clazz.getPackage();
	}

	/**
	 * @return
	 * @see org.soulspace.mdlrepo.metamodel.impl.Classifier#getQualifiedName()
	 */
	public String getQualifiedName() {
		return clazz.getQualifiedName();
	}

	/**
	 * @return
	 * @see org.soulspace.mdlrepo.metamodel.impl.Classifier#getQualifiedNameAsPath()
	 */
	public String getQualifiedNameAsPath() {
		return clazz.getQualifiedNameAsPath();
	}

	/**
	 * @return
	 * @see org.soulspace.mdlrepo.metamodel.impl.Class#getReferencedTypes()
	 */
	public List<IClassifier> getReferencedTypes() {
		return clazz.getReferencedTypes();
	}

	/**
	 * @return
	 * @see org.soulspace.mdlrepo.metamodel.impl.Element#getStereotypeMap()
	 */
	public Map<String, IStereotype> getStereotypeMap() {
		return clazz.getStereotypeMap();
	}

	/**
	 * @return
	 * @see org.soulspace.mdlrepo.metamodel.impl.Element#getStereotypes()
	 */
	public List<IStereotype> getStereotypes() {
		return clazz.getStereotypes();
	}

	/**
	 * @return
	 * @see org.soulspace.mdlrepo.metamodel.impl.Class#getSubClasses()
	 */
	public List<IClass> getSubClasses() {
		return clazz.getSubClasses();
	}

	/**
	 * @return
	 * @see org.soulspace.mdlrepo.metamodel.impl.Class#getSuperClasses()
	 */
	public List<IClass> getSuperClasses() {
		return clazz.getSuperClasses();
	}

	/**
	 * @return
	 * @see org.soulspace.mdlrepo.metamodel.impl.Element#getTaggedValueMap()
	 */
	public Map<String, ITaggedValue> getTaggedValueMap() {
		return clazz.getTaggedValueMap();
	}

	/**
	 * @return
	 * @see org.soulspace.mdlrepo.metamodel.impl.Element#getTaggedValues()
	 */
	public List<ITaggedValue> getTaggedValues() {
		return clazz.getTaggedValues();
	}

	/**
	 * @return
	 * @see org.soulspace.mdlrepo.metamodel.impl.Class#getVisibility()
	 */
	public String getVisibility() {
		return clazz.getVisibility();
	}

	/**
	 * @param isAbstract
	 * @see org.soulspace.mdlrepo.metamodel.impl.Class#setAbstract(boolean)
	 */
	public void setAbstract(boolean isAbstract) {
		clazz.setAbstract(isAbstract);
	}

	/**
	 * @param id
	 * @see org.soulspace.mdlrepo.metamodel.impl.Element#setId(java.lang.String)
	 */
	public void setId(String id) {
		clazz.setId(id);
	}

	/**
	 * @param interfaces
	 * @see org.soulspace.mdlrepo.metamodel.impl.Class#setInterfaces(java.util.List)
	 */
	public void setInterfaces(List<IInterface> interfaces) {
		clazz.setInterfaces(interfaces);
	}

	/**
	 * @param name
	 * @see org.soulspace.mdlrepo.metamodel.impl.Classifier#setName(java.lang.String)
	 */
	public void setName(String name) {
		clazz.setName(name);
	}

	/**
	 * @param namespace
	 * @see org.soulspace.mdlrepo.metamodel.impl.Element#setNamespace(java.lang.String)
	 */
	public void setNamespace(String namespace) {
		clazz.setNamespace(namespace);
	}

	/**
	 * @param pkg
	 * @see org.soulspace.mdlrepo.metamodel.impl.Classifier#setPackage(org.soulspace.mdlrepo.metamodel.IPackage)
	 */
	public void setPackage(IPackage pkg) {
		clazz.setPackage(pkg);
	}

	/**
	 * @param qualifiedName
	 * @see org.soulspace.mdlrepo.metamodel.impl.Classifier#setQualifiedName(java.lang.String)
	 */
	public void setQualifiedName(String qualifiedName) {
		clazz.setQualifiedName(qualifiedName);
	}

	/**
	 * @param visibility
	 * @see org.soulspace.mdlrepo.metamodel.impl.Class#setVisibility(java.lang.String)
	 */
	public void setVisibility(String visibility) {
		clazz.setVisibility(visibility);
	}

	/**
	 * @return
	 * @see org.soulspace.mdlrepo.metamodel.impl.Class#toString()
	 */
	public String toString() {
		return clazz.toString();
	}

	/**
	 * @return
	 * @see org.soulspace.mdlrepo.metamodel.impl.Association#getFrom()
	 */
	public IClassifier getFrom() {
		return association.getFrom();
	}

	/**
	 * @return
	 * @see org.soulspace.mdlrepo.metamodel.impl.Association#getFromEnd()
	 */
	public IAssociationEnd getFromEnd() {
		return association.getFromEnd();
	}

	/**
	 * @return
	 * @see org.soulspace.mdlrepo.metamodel.impl.Association#getFromNavigable()
	 */
	public boolean getFromNavigable() {
		return association.getFromNavigable();
	}

	/**
	 * @return
	 * @see org.soulspace.mdlrepo.metamodel.impl.Association#getFromRole()
	 */
	public String getFromRole() {
		return association.getFromRole();
	}

	/**
	 * @return
	 * @see org.soulspace.mdlrepo.metamodel.impl.Association#getTo()
	 */
	public IClassifier getTo() {
		return association.getTo();
	}

	/**
	 * @return
	 * @see org.soulspace.mdlrepo.metamodel.impl.Association#getToEnd()
	 */
	public IAssociationEnd getToEnd() {
		return association.getToEnd();
	}

	/**
	 * @return
	 * @see org.soulspace.mdlrepo.metamodel.impl.Association#getToNavigable()
	 */
	public boolean getToNavigable() {
		return association.getToNavigable();
	}

	/**
	 * @return
	 * @see org.soulspace.mdlrepo.metamodel.impl.Association#getToRole()
	 */
	public String getToRole() {
		return association.getToRole();
	}

	/**
	 * @param from
	 * @see org.soulspace.mdlrepo.metamodel.impl.Association#setFrom(org.soulspace.mdlrepo.metamodel.IClassifier)
	 */
	public void setFrom(IClassifier from) {
		association.setFrom(from);
	}

	/**
	 * @param fromEnd
	 * @see org.soulspace.mdlrepo.metamodel.impl.Association#setFromEnd(org.soulspace.mdlrepo.metamodel.IAssociationEnd)
	 */
	public void setFromEnd(IAssociationEnd fromEnd) {
		association.setFromEnd(fromEnd);
	}

	/**
	 * @param fromNavigable
	 * @see org.soulspace.mdlrepo.metamodel.impl.Association#setFromNavigable(boolean)
	 */
	public void setFromNavigable(boolean fromNavigable) {
		association.setFromNavigable(fromNavigable);
	}

	/**
	 * @param fromRole
	 * @see org.soulspace.mdlrepo.metamodel.impl.Association#setFromRole(java.lang.String)
	 */
	public void setFromRole(String fromRole) {
		association.setFromRole(fromRole);
	}

	/**
	 * @param to
	 * @see org.soulspace.mdlrepo.metamodel.impl.Association#setTo(org.soulspace.mdlrepo.metamodel.IClassifier)
	 */
	public void setTo(IClassifier to) {
		association.setTo(to);
	}

	/**
	 * @param toEnd
	 * @see org.soulspace.mdlrepo.metamodel.impl.Association#setToEnd(org.soulspace.mdlrepo.metamodel.IAssociationEnd)
	 */
	public void setToEnd(IAssociationEnd toEnd) {
		association.setToEnd(toEnd);
	}

	/**
	 * @param toNavigable
	 * @see org.soulspace.mdlrepo.metamodel.impl.Association#setToNavigable(boolean)
	 */
	public void setToNavigable(boolean toNavigable) {
		association.setToNavigable(toNavigable);
	}

	/**
	 * @param toRole
	 * @see org.soulspace.mdlrepo.metamodel.impl.Association#setToRole(java.lang.String)
	 */
	public void setToRole(String toRole) {
		association.setToRole(toRole);
	}
	
	/**
	 * @param obj
	 * @return
	 * @see org.soulspace.mdlrepo.metamodel.impl.Class#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		// FIXME use class and association
		return clazz.equals(obj);
	}

	/**
	 * @return
	 * @see org.soulspace.mdlrepo.metamodel.impl.Class#hashCode()
	 */
	public int hashCode() {
		// FIXME use class and association
		return clazz.hashCode();
	}

	public IStateMachine getBehaviour() {
		return clazz.getBehaviour();
	}

	public void setBehaviour(IStateMachine sm) {
		clazz.setBehaviour(sm);
	}

}
