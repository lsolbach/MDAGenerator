package org.soulspace.mdlrepo.metamodel.impl;

import java.util.ArrayList;
import java.util.List;

import org.soulspace.mdlrepo.metamodel.IAction;
import org.soulspace.mdlrepo.metamodel.IEvent;
import org.soulspace.mdlrepo.metamodel.IState;
import org.soulspace.mdlrepo.metamodel.ITransition;

public class State extends Classifier implements IState {
	
	private List<ITransition> incomingTransitionList = new ArrayList<ITransition>();
	private List<ITransition> outgoingTransitionList = new ArrayList<ITransition>();
	private List<ITransition> internalTransitionList = new ArrayList<ITransition>();
	private List<IEvent> deferredEventList = new ArrayList<IEvent>();
	private IAction entryAction;
	private IAction activityAction;
	private IAction exitAction;
	
	public List<ITransition> getIncomingTransitions() {
		return incomingTransitionList;
	}

	public void setIncomingTransitions(List<ITransition> transitions) {
		incomingTransitionList = transitions;
	}

	public void addIncomingTransition(ITransition transition) {
		incomingTransitionList.add(transition);
	}

	public void removeIncomingTransition(ITransition transition) {
		incomingTransitionList.remove(transition);
	}

	public List<ITransition> getOutgoingTransitions() {
		return outgoingTransitionList;
	}

	public void setOutgoingTransitions(List<ITransition> transitions) {
		outgoingTransitionList = transitions;
	}

	public void addOutgoingTransition(ITransition transition) {
		outgoingTransitionList.add(transition);
	}

	public void removeOutgoingTransition(ITransition transition) {
		outgoingTransitionList.remove(transition);
	}

	public List<ITransition> getInternalTransitions() {
		return internalTransitionList;
	}

	public void setInternalTransitions(List<ITransition> transitions) {
		internalTransitionList = transitions;
	}

	public void addInternalTransition(ITransition transition) {
		internalTransitionList.add(transition);
	}

	public void removeInternalTransition(ITransition transition) {
		internalTransitionList.remove(transition);
	}

	public List<IEvent> getDeferredEvents() {
		return deferredEventList;
	}

	public void setDeferredEvents(List<IEvent> events) {
		deferredEventList = events;
	}

	public void addDeferredEvent(IEvent event) {
		deferredEventList.add(event);
	}

	public void removeDeferredEvent(IEvent event) {
		deferredEventList.remove(event);
	}

	public IAction getEntryAction() {
		return entryAction;
	}

	public void setEntryAction(IAction entryAction) {
		this.entryAction = entryAction;
	}

	public IAction getActivityAction() {
		return activityAction;
	}

	public void setActivityAction(IAction activityAction) {
		this.activityAction = activityAction;
	}

	public IAction getExitAction() {
		return exitAction;
	}

	public void setExitAction(IAction exitAction) {
		this.exitAction = exitAction;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		final State other = (State) obj;
		return true;
	}

	
}
