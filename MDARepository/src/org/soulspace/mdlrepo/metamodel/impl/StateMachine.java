package org.soulspace.mdlrepo.metamodel.impl;

import java.util.ArrayList;
import java.util.List;

import org.soulspace.mdlrepo.metamodel.IElement;
import org.soulspace.mdlrepo.metamodel.IState;
import org.soulspace.mdlrepo.metamodel.IStateMachine;
import org.soulspace.mdlrepo.metamodel.ITransition;

public class StateMachine extends Classifier implements IStateMachine {

	private IElement context;
	private IState topState;
	
	private List<IState> stateList = new ArrayList<IState>();
	private List<ITransition> transitionList = new ArrayList<ITransition>();
	
	public IState getTopState() {
		return topState;
	}

	public void setTopState(IState topState) {
		this.topState = topState;
	}

	public IElement getContext() {
		return context;
	}

	public void setContext(IElement context) {
		this.context = context;
	}

	public List<IState> getStates() {
		return stateList;
	}

	public void setStates(List<IState> states) {
		this.stateList = states;
	}

	public void addState(IState state) {
		stateList.add(state);
	}

	public void removeState(IState state) {
		stateList.remove(state);
	}

	public List<ITransition> getTransitions() {
		return transitionList;
	}

	public void setTransitions(List<ITransition> transitions) {
		this.transitionList = transitions;
	}

	public void addTransition(ITransition transition) {
		transitionList.add(transition);
	}

	public void removeTransition(ITransition transition) {
		transitionList.remove(transition);		
	}

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
		final StateMachine other = (StateMachine) obj;
		return true;
	}

	
}
