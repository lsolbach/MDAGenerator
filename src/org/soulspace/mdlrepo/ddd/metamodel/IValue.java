package org.soulspace.mdlrepo.ddd.metamodel;

import java.util.List;

import org.soulspace.mdlrepo.metamodel.IAssociationEnd;
import org.soulspace.mdlrepo.metamodel.IClass;

public interface IValue extends IClass {
	
	List<IAssociationEnd> getEntityAssociations();
	List<IAssociationEnd> getAllEntityAssociations();

	List<IAssociationEnd> getValueAssociations();
	List<IAssociationEnd> getAllValueAssociations();

}
