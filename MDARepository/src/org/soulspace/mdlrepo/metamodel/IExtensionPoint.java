package org.soulspace.mdlrepo.metamodel;

public interface IExtensionPoint extends INamedElement {

	String getLocation();
	void setLocation(String location);

}
