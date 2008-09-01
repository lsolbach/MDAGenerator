package org.soulspace.mdlrepo.metamodel.impl;

import org.soulspace.mdlrepo.metamodel.IStateMachine;
import org.soulspace.mdlrepo.metamodel.ISubmachineState;

public class SubmachineState extends State implements ISubmachineState {

	private boolean isConcurrent = false;
	private IStateMachine stateMachine;
	
	public boolean getIsConcurrent() {
		return isConcurrent;
	}

	public void setIsConcurrent(boolean isConcurrent) {
		this.isConcurrent = isConcurrent;
	}
	
	public IStateMachine getStateMachine() {
		return stateMachine;
	}

	public void setStateMachine(IStateMachine stateMachine) {
		this.stateMachine = stateMachine;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (isConcurrent ? 1231 : 1237);
		result = prime * result
				+ ((stateMachine == null) ? 0 : stateMachine.hashCode());
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
		final SubmachineState other = (SubmachineState) obj;
		if (isConcurrent != other.isConcurrent)
			return false;
		if (stateMachine == null) {
			if (other.stateMachine != null)
				return false;
		} else if (!stateMachine.equals(other.stateMachine))
			return false;
		return true;
	}
	
	
}
