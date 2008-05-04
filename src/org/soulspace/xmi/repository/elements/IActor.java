/*
 * Created on Mar 15, 2006
 */
package org.soulspace.xmi.repository.elements;

import java.util.List;

public interface IActor extends IClassifier {

	List getSuperActors();

	void addSuperActor(IActor actor);

	List getSubActors();

	void addSubActor(IActor actor);

	List getAssociations();
	
	void addAssociation(IAssociationEnd ae);
	
}
