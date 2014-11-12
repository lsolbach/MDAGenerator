package org.soulspace.mdlrepo.metamodel;

import java.util.List;

public interface ICompositeState extends IState {
	List<IState> getSubStates();
	void setSubStates(List<IState> substates);
	void addSubState(IState substate);
	void removeSubState(IState substate);

}
