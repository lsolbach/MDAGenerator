/*
 * Created on Mar 15, 2006
 */
package org.soulspace.xmi.repository.elements;

import java.util.List;

public interface IStateMachine extends IClassifier {
	List<IState> getStates();
	void addState(IState state);

	List<ITransition> getTransitions();
	void addTransition(ITransition transition);
}
