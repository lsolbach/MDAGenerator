package org.soulspace.mdlrepo.metamodel.impl;

import java.util.ArrayList;
import java.util.List;

import org.soulspace.mdlrepo.metamodel.ICallEvent;
import org.soulspace.mdlrepo.metamodel.IParameter;

public class CallEvent extends Event implements ICallEvent {

	List<IParameter> parameterList = new ArrayList<IParameter>();
	
	public void addParameter(IParameter parameter) {
		parameterList.add(parameter);
	}

	public List<IParameter> getParameters() {
		return parameterList;
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
		final CallEvent other = (CallEvent) obj;
		return true;
	}

}
