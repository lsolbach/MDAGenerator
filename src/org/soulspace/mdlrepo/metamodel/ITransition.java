package org.soulspace.mdlrepo.metamodel;

import java.util.List;

public interface ITransition extends INamedElement {

	IState getSource();
	
	IState getTarget();

	List<IEvent> getEvents();
	
	void addEvent(IEvent event);
	
}
