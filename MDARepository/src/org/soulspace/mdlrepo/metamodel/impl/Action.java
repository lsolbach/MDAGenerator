package org.soulspace.mdlrepo.metamodel.impl;

import java.util.ArrayList;
import java.util.List;

import org.soulspace.mdlrepo.metamodel.IAction;

public abstract class Action extends NamedElement implements IAction {
	
	List<String> argumentList = new ArrayList<String>();
	
	String recurrence;
	String script;
	String target;
	
	public List<String> getArguments() {
		return argumentList;
	}
	
	public void setArguments(List<String> arguments) {
		this.argumentList = arguments;
	}
	
	public void addArgument(String argument) {
		argumentList.add(argument);
	}
	
	public void removeArgument(String argument) {
		argumentList.remove(argument);
	}
	
	public String getRecurrence() {
		return recurrence;
	}
	
	public void setRecurrence(String recurrence) {
		this.recurrence = recurrence;
	}
	
	public String getScript() {
		return script;
	}
	
	public void setScript(String script) {
		this.script = script;
	}
	
	public String getTarget() {
		return target;
	}
	
	public void setTarget(String target) {
		this.target = target;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((argumentList == null) ? 0 : argumentList.hashCode());
		result = prime * result
				+ ((recurrence == null) ? 0 : recurrence.hashCode());
		result = prime * result + ((script == null) ? 0 : script.hashCode());
		result = prime * result + ((target == null) ? 0 : target.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Action other = (Action) obj;
		if (argumentList == null) {
			if (other.argumentList != null)
				return false;
		} else if (!argumentList.equals(other.argumentList))
			return false;
		if (recurrence == null) {
			if (other.recurrence != null)
				return false;
		} else if (!recurrence.equals(other.recurrence))
			return false;
		if (script == null) {
			if (other.script != null)
				return false;
		} else if (!script.equals(other.script))
			return false;
		if (target == null) {
			if (other.target != null)
				return false;
		} else if (!target.equals(other.target))
			return false;
		return true;
	}
	
}
