/*
 * Created on Mar 15, 2006
 */
package org.soulspace.mdlrepo.metamodel;

import java.util.List;

public interface IState extends IClassifier {

	IAction getEntryAction();
	void setEntryAction(IAction action);

	IAction getExitAction();
	void setExitAction(IAction action);

	IAction getActivityAction();
	void setActivityAction(IAction action);
	
	List<ITransition> getIncomingTransitions();
	void setIncomingTransitions(List<ITransition> transitions);
	void addIncomingTransition(ITransition transition);
	void removeIncomingTransition(ITransition transition);

	List<ITransition> getOutgoingTransitions();
	void setOutgoingTransitions(List<ITransition> transitions);
	void addOutgoingTransition(ITransition transition);
	void removeOutgoingTransition(ITransition transition);
	
	List<ITransition> getInternalTransitions();
	void setInternalTransitions(List<ITransition> transitions);
	void addInternalTransition(ITransition transition);
	void removeInternalTransition(ITransition transition);
	
	List<IEvent> getDeferredEvents();
	void setDeferredEvents(List<IEvent> events);
	void addDeferredEvent(IEvent event);
	void removeDeferredEvent(IEvent event);

}
