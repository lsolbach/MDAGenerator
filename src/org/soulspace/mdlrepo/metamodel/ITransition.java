package org.soulspace.mdlrepo.metamodel;

import java.util.List;

public interface ITransition extends INamedElement {

	IState getSource();
	void setSource(IState state);
	
	IState getTarget();
	void setTarget(IState s);
	
	List<IEvent> getEvents();
	void addEvent(IEvent event);
	
}
