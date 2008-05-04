package org.soulspace.xmi.repository.elements;

import java.util.ArrayList;
import java.util.List;

public class Actor extends Classifier implements IActor {

	private List superActors = new ArrayList();
	private List subActors = new ArrayList();
	private List associations = new ArrayList();
	
	public List getSuperActors() {
		return superActors;
	}

	public void addSuperActor(IActor actor) {
		superActors.add(actor);
	}

	public List getSubActors() {
		return subActors;
	}

	public void addSubActor(IActor actor) {
		subActors.add(actor);
	}

	public List getAssociations() {
		return associations;
	}

	public void addAssociation(IAssociationEnd ae) {
		associations.add(ae);
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
		final Actor other = (Actor) obj;
		return true;
	}

}
