package org.soulspace.mdlrepo.metamodel;

import java.util.List;

public interface IActionSequence extends IAction {

	List<IAction> getActions();
	void setActions(List<IAction> actions);
	void addAction(IAction action);
	void removeAction(IAction action);

}
