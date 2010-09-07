/*
 * Created on Mar 15, 2006
 */
package org.soulspace.mdlrepo.metamodel;

import java.util.List;

public interface IStateMachine extends IClassifier {
	
	IElement getContext();
	void setContext(IElement context);
	
	List<IState> getStates();
	void setStates(List<IState> states);
	void addState(IState state);
	void removeState(IState state);
	
	
	List<ITransition> getTransitions();
	void setTransitions(List<ITransition> transitions);
	void addTransition(ITransition transition);
	void removeTransition(ITransition transition);
}
