package org.soulspace.mdlrepo.metamodel.impl;

import java.util.ArrayList;
import java.util.List;

import org.soulspace.mdlrepo.metamodel.IParameter;
import org.soulspace.mdlrepo.metamodel.ISignal;
import org.soulspace.mdlrepo.metamodel.ISignalEvent;

public class SignalEvent extends Event implements ISignalEvent {

	private ISignal signal;
	
	/**
	 * @return the signal
	 */
	public ISignal getSignal() {
		return signal;
	}

	/**
	 * @param signal the signal to set
	 */
	public void setSignal(ISignal signal) {
		this.signal = signal;
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
		final SignalEvent other = (SignalEvent) obj;
		return true;
	}

}
