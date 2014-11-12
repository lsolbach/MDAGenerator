package org.soulspace.mdlrepo.metamodel.impl;

import java.util.ArrayList;
import java.util.List;

import org.soulspace.mdlrepo.metamodel.ICompositeState;
import org.soulspace.mdlrepo.metamodel.IState;

public class CompositeState extends State implements ICompositeState {

	List<IState> substateList = new ArrayList<IState>();
	
	public void addSubState(IState substate) {
		substateList.add(substate);
	}

	public List<IState> getSubStates() {
		return substateList;
	}

	public void removeSubState(IState substate) {
		substateList.remove(substate);
	}

	public void setSubStates(List<IState> substates) {
		substateList = substates;
	}

}
