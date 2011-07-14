package org.soulspace.mdlrepo.metamodel.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.soulspace.mdlrepo.metamodel.IAction;
import org.soulspace.mdlrepo.metamodel.IEvent;
import org.soulspace.mdlrepo.metamodel.IState;
import org.soulspace.mdlrepo.metamodel.ITransition;

public class Transition extends Classifier implements ITransition {

	IState source;
	IState target;
	IAction effect;
	String guard;
	List<IEvent> eventList = new ArrayList<IEvent>();
	
	public IState getSource() {
		return source;
	}

	public void setSource(IState source) {
		this.source = source;
	}
	
	public IState getTarget() {
		return target;
	}

	public void setTarget(IState target) {
		this.target = target;
	}

	public IAction getEffect() {
		return effect;
	}

	public void setEffect(IAction effect) {
		this.effect = effect;
	}

	public String getGuard() {
		return guard;
	}

	public void setGuard(String guard) {
		this.guard = guard;
	}

	public void addEvent(IEvent event) {
		eventList.add(event);	
	}

	public List<IEvent> getEvents() {
		return eventList;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((source == null) ? 0 : source.hashCode());
		result = prime * result + ((target == null) ? 0 : target.hashCode());
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
		final Transition other = (Transition) obj;
		if (source == null) {
			if (other.source != null)
				return false;
		} else if (!source.equals(other.source))
			return false;
		if (target == null) {
			if (other.target != null)
				return false;
		} else if (!target.equals(other.target))
			return false;
		return true;
	}
	
	
}
