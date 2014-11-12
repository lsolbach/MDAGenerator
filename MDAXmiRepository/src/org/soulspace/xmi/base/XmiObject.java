/*
 *  Copyright (c) Ludger Solbach. All rights reserved.
 *  The use and distribution terms for this software are covered by the
 *  Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
 *  which can be found in the file license.txt at the root of this distribution.
 *  By using this software in any fashion, you are agreeing to be bound by
 *  the terms of this license.
 *  You must not remove this notice, or any other, from this software.
 */
package org.soulspace.xmi.base;

/**
 * Base class for XMI objects
 * 
 * @author soulman
 * 
 */
public class XmiObject {

	private String namespace = "";
	private String qualifiedName = "";
	private XmiObject parent = null;
	private String xmiId;
	private String xmiIdRef;
	private String hRef;
	private boolean profileElement;

	/**
	 * Constructor
	 */
	public XmiObject() {
		super();
	}

	/**
	 * Constructor
	 * 
	 * @param namespace
	 *            Namespace for the XMI object
	 * @param parent
	 */
	public XmiObject(String namespace, XmiObject parent) {
		super();
		this.namespace = namespace;
		this.parent = parent;
	}

	/**
	 * @return Returns the namespace.
	 */
	public String getNamespace() {
		return namespace;
	}

	/**
	 * @param namespace
	 *            The namespace to set.
	 */
	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}

	/**
	 * @return Returns the parent.
	 */
	public XmiObject getParent() {
		return parent;
	}

	/**
	 * @param parent
	 *            The parent to set.
	 */
	public void setParent(XmiObject parent) {
		this.parent = parent;
	}

	/**
	 * @return Returns the qualifiedName.
	 */
	public String getQualifiedName() {
		return qualifiedName;
	}

	/**
	 * @param qualifiedName
	 *            The qualifiedName to set.
	 */
	public void setQualifiedName(String qualifiedName) {
		this.qualifiedName = qualifiedName;
	}

	/**
	 * @return the xmiId
	 */
	public String getXmiId() {
		return xmiId;
	}

	/**
	 * @param xmiId
	 *            the xmiId to set
	 */
	public void setXmiId(String xmiId) {
		this.xmiId = xmiId;
	}

	/**
	 * @return the xmiIdRef
	 */
	public String getXmiIdRef() {
		return xmiIdRef;
	}

	/**
	 * @param xmiIdRef
	 *            the xmiIdRef to set
	 */
	public void setXmiIdRef(String xmiIdRef) {
		this.xmiIdRef = xmiIdRef;
	}

	/**
	 * @return the xmiIdRef
	 */
	public String getHRef() {
		return hRef;
	}

	/**
	 * @param xmiIdRef
	 *            the xmiIdRef to set
	 */
	public void setHRef(String hRef) {
		this.hRef = hRef;
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

	/**
	 * 
	 * @return
	 */
	public String getRefId() {
		if (getXmiIdRef() != null) {
			return getXmiIdRef();
		} else if (getHRef() != null) {
			String[] parts = getHRef().split("#");
			if (parts.length == 2) {
				String xmiIdRef = parts[1];
				return xmiIdRef;
			}
		} else if(getXmiId() != null) {
			return getXmiId();
		}
		return null;
	}

}
