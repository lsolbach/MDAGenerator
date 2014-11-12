/*
 *  Copyright (c) Ludger Solbach. All rights reserved.
 *  The use and distribution terms for this software are covered by the
 *  Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
 *  which can be found in the file license.txt at the root of this distribution.
 *  By using this software in any fashion, you are agreeing to be bound by
 *  the terms of this license.
 *  You must not remove this notice, or any other, from this software.
 */
package org.soulspace.mdlrepo.ddd.metamodel.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.soulspace.mdlrepo.ddd.metamodel.IEntity;
import org.soulspace.mdlrepo.ddd.metamodel.IValue;
import org.soulspace.mdlrepo.metamodel.IAssociationEnd;
import org.soulspace.mdlrepo.metamodel.impl.Class;

public class Value extends Class implements IValue {

	public Collection<IAssociationEnd> getEntityAssociations() {
		Collection<IAssociationEnd> entityAssociations = new ArrayList<IAssociationEnd>();
		Collection<IAssociationEnd> associations = getAssociations();
		for(IAssociationEnd asso : associations) {
			if(asso.getType() instanceof IEntity) {
				entityAssociations.add(asso);
			}
		}
		return entityAssociations;
	}

	public Collection<IAssociationEnd> getAllEntityAssociations() {
		Collection<IAssociationEnd> entityAssociations = new HashSet<IAssociationEnd>();
		Collection<IAssociationEnd> associations = getAllAssociations();
		for(IAssociationEnd asso : associations) {
			if(asso.getType() instanceof IEntity) {
				entityAssociations.add(asso);
			}
		}
		return entityAssociations;
	}

	public Collection<IAssociationEnd> getValueAssociations() {
		Collection<IAssociationEnd> valueAssociations = new ArrayList<IAssociationEnd>();
		Collection<IAssociationEnd> associations = getAssociations();
		for(IAssociationEnd asso : associations) {
			if(asso.getType() instanceof IValue) {
				valueAssociations.add(asso);
			}
		}		
		return valueAssociations;
	}

	public Collection<IAssociationEnd> getAllValueAssociations() {
		Collection<IAssociationEnd> valueAssociations = new ArrayList<IAssociationEnd>();
		Collection<IAssociationEnd> associations = getAllAssociations();
		for(IAssociationEnd asso : associations) {
			if(asso.getType() instanceof IValue) {
				valueAssociations.add(asso);
			}
		}				
		return valueAssociations;
	}

}
