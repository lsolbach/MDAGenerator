package org.soulspace.xmi.repository.elements;

import java.util.ArrayList;
import java.util.List;

public class State extends Classifier implements IState {
	
	private List<ITransition> incomingTransitionList = new ArrayList<ITransition>();
	private List<ITransition> outgoingTransitionList = new ArrayList<ITransition>();
	
	public void addIncomingTransition(ITransition transition) {
		incomingTransitionList.add(transition);
	}

	public List<ITransition> getIncomingTransitions() {
		return incomingTransitionList;
	}

	public void addOutgoingTransition(ITransition transition) {
		outgoingTransitionList.add(transition);
	}

	public List<ITransition> getOutgoingTransitions() {
		return outgoingTransitionList;
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
