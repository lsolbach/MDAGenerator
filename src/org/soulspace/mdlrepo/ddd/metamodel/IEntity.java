package org.soulspace.mdlrepo.ddd.metamodel;

import java.util.Collection;
import java.util.List;

import org.soulspace.mdlrepo.metamodel.IAssociationEnd;
import org.soulspace.mdlrepo.metamodel.IClass;

public interface IEntity extends IClass {
	
	Collection<IAssociationEnd> getEntityAssociations();
	Collection<IAssociationEnd> getAllEntityAssociations();

	Collection<IAssociationEnd> getValueAssociations();
	Collection<IAssociationEnd> getAllValueAssociations();

}
