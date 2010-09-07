package org.soulspace.mdlrepo.metamodel.impl;

import org.soulspace.mdlrepo.metamodel.IClassifier;
import org.soulspace.mdlrepo.metamodel.ICreateAction;

public class CreateAction extends Action implements ICreateAction {

	private IClassifier instanciation;
	
	public IClassifier getInstanciation() {
		return instanciation;
	}

	public void setInstanciation(IClassifier instanciation) {
		this.instanciation = instanciation;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((instanciation == null) ? 0 : instanciation.hashCode());
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
		CreateAction other = (CreateAction) obj;
		if (instanciation == null) {
			if (other.instanciation != null)
				return false;
		} else if (!instanciation.equals(other.instanciation))
			return false;
		return true;
	}

	
}
