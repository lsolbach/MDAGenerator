/*
 * Created on Feb 6, 2005
 */
package org.soulspace.mdlrepo.metamodel.impl;

import org.soulspace.mdlrepo.metamodel.IStereotype;


/**
 * @author soulman
 *
 */
public class Stereotype extends NamedElement implements IStereotype {

	public Stereotype() {
		super();
	}
	
	public Stereotype(String name) {
		super();
		this.setName(name);
	}
}
