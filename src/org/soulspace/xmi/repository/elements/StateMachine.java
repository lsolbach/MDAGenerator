package org.soulspace.xmi.repository.elements;

import java.util.ArrayList;
import java.util.List;

public class StateMachine extends Classifier implements IStateMachine {

	private List<IState> stateList = new ArrayList<IState>();
	private List<ITransition> transitionList = new ArrayList<ITransition>();
	
	public void addState(IState state) {
		stateList.add(state);
	}

	public List<IState> getStates() {
		return stateList;
	}

	public void addTransition(ITransition transition) {
		transitionList.add(transition);
	}

	public List<ITransition> getTransitions() {
		return transitionList;
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
		final StateMachine other = (StateMachine) obj;
		return true;
	}

	
}
