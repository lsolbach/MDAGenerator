/*
 * IElement.java
 */
package org.soulspace.mdlrepo.metamodel;

import java.util.List;
import java.util.Map;

/**
 * Base interface for model elements
 */
public interface IElement {

	String getElementType();

	IElement getThis();

	String getId();

	void setId(String id);

	String getNamespace();

	void setNamespace(String namespace);

	boolean getProfileElement();

	void setProfileElement(boolean profileElement);

	List<IStereotype> getStereotypes();

	Map<String, IStereotype> getStereotypeMap();

	void addStereotype(IStereotype st);

	List<ITaggedValue> getTaggedValues();

	Map<String, ITaggedValue> getTaggedValueMap();

	void addTaggedValue(ITaggedValue tv);

}
