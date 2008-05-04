package org.soulspace.xmi.repository.elements;

import java.util.List;

public interface ITransition extends INamedElement {

	IState getSource();
	
	IState getTarget();

	List<IEvent> getEvents();
	
	void addEvent(IEvent event);
	
}
