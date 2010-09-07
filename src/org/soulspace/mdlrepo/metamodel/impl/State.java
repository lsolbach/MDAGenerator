package org.soulspace.mdlrepo.metamodel.impl;

import java.util.ArrayList;
import java.util.List;

import org.soulspace.mdlrepo.metamodel.IState;
import org.soulspace.mdlrepo.metamodel.ITransition;

public class State extends Classifier implements IState {
	
	private List<ITransition> incomingTransitionList = new ArrayList<ITransition>();
	private List<ITransition> outgoingTransitionList = new ArrayList<ITransition>();
	
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
