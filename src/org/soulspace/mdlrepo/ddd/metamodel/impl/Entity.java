package org.soulspace.mdlrepo.ddd.metamodel.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.soulspace.mdlrepo.ddd.metamodel.IEntity;
import org.soulspace.mdlrepo.ddd.metamodel.IValue;
import org.soulspace.mdlrepo.metamodel.IAssociationEnd;
import org.soulspace.mdlrepo.metamodel.impl.Class;

public class Entity extends Class implements IEntity {

	public Collection<IAssociationEnd> getEntityAssociations() {
		List<IAssociationEnd> entityAssociations = new ArrayList<IAssociationEnd>();
		List<IAssociationEnd> associations = getAssociations();
		for(IAssociationEnd asso : associations) {
			if(asso.getType() instanceof IEntity) {
				entityAssociations.add(asso);
			}
		}
		return entityAssociations;
	}

	public Collection<IAssociationEnd> getAllEntityAssociations() {
		List<IAssociationEnd> entityAssociations = new ArrayList<IAssociationEnd>();
		Collection<IAssociationEnd> associations = getAllAssociations();
		for(IAssociationEnd asso : associations) {
			if(asso.getType() instanceof IEntity) {
				entityAssociations.add(asso);
			}
		}
		return entityAssociations;
	}

	public Collection<IAssociationEnd> getValueAssociations() {
		List<IAssociationEnd> valueAssociations = new ArrayList<IAssociationEnd>();
		Collection<IAssociationEnd> associations = getAssociations();
		for(IAssociationEnd asso : associations) {
			if(asso.getType() instanceof IValue) {
				valueAssociations.add(asso);
			}
		}		
		return valueAssociations;
	}

	public Collection<IAssociationEnd> getAllValueAssociations() {
		List<IAssociationEnd> valueAssociations = new ArrayList<IAssociationEnd>();
		Collection<IAssociationEnd> associations = getAllAssociations();
		for(IAssociationEnd asso : associations) {
			if(asso.getType() instanceof IValue) {
				valueAssociations.add(asso);
			}
		}				
		return valueAssociations;
	}

}
