/*
 * Created on Mar 15, 2006
 */
package org.soulspace.xmi.repository.elements;

import java.util.List;

public interface IState extends INamedElement {

	List<ITransition> getIncomingTransitions();
	void addIncomingTransition(ITransition transition);

	List<ITransition> getOutgoingTransitions();
	void addOutgoingTransition(ITransition transition);
}
