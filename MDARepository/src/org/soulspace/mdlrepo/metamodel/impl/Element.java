/*
 * Element.java
 */
package org.soulspace.mdlrepo.metamodel.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.soulspace.mdlrepo.metamodel.IElement;
import org.soulspace.mdlrepo.metamodel.IStateMachine;
import org.soulspace.mdlrepo.metamodel.IStereotype;
import org.soulspace.mdlrepo.metamodel.ITaggedValue;

/**
 * Base class for model elements
 * 
 * @author Solbach (Last update: $Author$, $Date$)
 * @version $Revision$
 */
public class Element implements IElement {

	private String id;
	private String namespace = "";
	private IElement parentElement = null;
	private boolean profileElement = false;
	
	private IStateMachine behaviour;
	
	protected List<IStereotype> stereotypes = new ArrayList<IStereotype>();
	protected Map<String, IStereotype> stereotypeMap = new HashMap<String, IStereotype>();

	protected List<ITaggedValue> taggedValues = new ArrayList<ITaggedValue>();
	protected Map<String, ITaggedValue> taggedValueMap = new HashMap<String, ITaggedValue>();

	public Element() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNamespace() {
		return namespace;
	}

	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}

	/**
	 * @return the profileElement
	 */
	public boolean getProfileElement() {
		return profileElement;
	}

	/**
	 * @param profileElement
	 *            the profileElement to set
	 */
	public void setProfileElement(boolean profileElement) {
		this.profileElement = profileElement;
	}

	public List<IStereotype> getStereotypes() {
		return stereotypes;
	}

	public Map<String, IStereotype> getStereotypeMap() {
		return stereotypeMap;
	}

	public void addStereotype(IStereotype st) {
		stereotypes.add(st);
		stereotypeMap.put(st.getName(), st);
	}

	public Map<String, ITaggedValue> getTaggedValueMap() {
		return taggedValueMap;
	}

	public List<ITaggedValue> getTaggedValues() {
		return taggedValues;
	}

	public void addTaggedValue(ITaggedValue tv) {
		taggedValues.add(tv);
		taggedValueMap.put(tv.getName(), tv);
	}

	public String getElementType() {
		return getClass().getSimpleName();
	}

	public IElement getThis() {
		return this;
	}

	public IElement getParentElement() {
		return parentElement;
	}

	public void setParentElement(IElement parentElement) {
		this.parentElement = parentElement;
	}
	
	public IStateMachine getBehaviour() {
		return behaviour;
	}

	public void setBehaviour(IStateMachine behaviour) {
		this.behaviour = behaviour;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((namespace == null) ? 0 : namespace.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final Element other = (Element) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (namespace == null) {
			if (other.namespace != null)
				return false;
		} else if (!namespace.equals(other.namespace))
			return false;
		return true;
	}

	public String toString() {
		return getClass().getSimpleName() + "["+ getId() +"]";
	}
	
}