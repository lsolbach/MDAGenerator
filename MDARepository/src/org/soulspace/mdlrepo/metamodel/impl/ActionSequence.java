package org.soulspace.mdlrepo.metamodel.impl;

import java.util.ArrayList;
import java.util.List;

import org.soulspace.mdlrepo.metamodel.IAction;
import org.soulspace.mdlrepo.metamodel.IActionSequence;

public class ActionSequence extends Action implements IActionSequence {

	List<IAction> actionList = new ArrayList<IAction>();
	
	public List<IAction> getActions() {
		return actionList;
	}

	public void setActions(List<IAction> actions) {
		actionList = actions;
	}

	public void addAction(IAction action) {
		actionList.add(action);
	}

	public void removeAction(IAction action) {
		actionList.remove(action);
	}

}
