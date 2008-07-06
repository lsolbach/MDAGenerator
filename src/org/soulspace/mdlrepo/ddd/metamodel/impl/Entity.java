package org.soulspace.mdlrepo.ddd.metamodel.impl;

import java.util.ArrayList;
import java.util.List;

import org.soulspace.mdlrepo.ddd.metamodel.IEntity;
import org.soulspace.mdlrepo.ddd.metamodel.IValue;
import org.soulspace.mdlrepo.metamodel.IAssociationEnd;
import org.soulspace.mdlrepo.metamodel.impl.Class;

public class Entity extends Class implements IEntity {

	public List<IAssociationEnd> getEntityAssociations() {
		List<IAssociationEnd> entityAssociations = new ArrayList<IAssociationEnd>();
		List<IAssociationEnd> associations = getAssociations();
		for(IAssociationEnd asso : associations) {
			if(asso.getType() instanceof IEntity) {
				entityAssociations.add(asso);
			}
		}
		return entityAssociations;
	}

	public List<IAssociationEnd> getAllEntityAssociations() {
		List<IAssociationEnd> entityAssociations = new ArrayList<IAssociationEnd>();
		List<IAssociationEnd> associations = getAllAssociations();
		for(IAssociationEnd asso : associations) {
			if(asso.getType() instanceof IEntity) {
				entityAssociations.add(asso);
			}
		}
		return entityAssociations;
	}

	public List<IAssociationEnd> getValueAssociations() {
		List<IAssociationEnd> valueAssociations = new ArrayList<IAssociationEnd>();
		List<IAssociationEnd> associations = getAssociations();
		for(IAssociationEnd asso : associations) {
			if(asso.getType() instanceof IValue) {
				valueAssociations.add(asso);
			}
		}		
		return valueAssociations;
	}

	public List<IAssociationEnd> getAllValueAssociations() {
		List<IAssociationEnd> valueAssociations = new ArrayList<IAssociationEnd>();
		List<IAssociationEnd> associations = getAllAssociations();
		for(IAssociationEnd asso : associations) {
			if(asso.getType() instanceof IValue) {
				valueAssociations.add(asso);
			}
		}				
		return valueAssociations;
	}

}
