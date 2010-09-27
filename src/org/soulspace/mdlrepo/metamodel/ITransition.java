package org.soulspace.mdlrepo.metamodel;

import java.util.List;

public interface ITransition extends INamedElement {

	IState getSource();
	void setSource(IState state);
	
	IState getTarget();
	void setTarget(IState s);
	
	String getGuard();
	void setGuard(String guard);
	
	IAction getEffect();
	void setEffect(IAction effect);
	
	List<IEvent> getEvents();
	void addEvent(IEvent event);
	
}
