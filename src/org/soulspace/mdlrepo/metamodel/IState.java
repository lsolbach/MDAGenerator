/*
 * Created on Mar 15, 2006
 */
package org.soulspace.mdlrepo.metamodel;

import java.util.List;

public interface IState extends INamedElement {

	List<ITransition> getIncomingTransitions();
	void setIncomingTransitions(List<ITransition> transitions);
	void addIncomingTransition(ITransition transition);
	void removeIncomingTransition(ITransition transition);

	List<ITransition> getOutgoingTransitions();
	void setOutgoingTransitions(List<ITransition> transitions);
	void addOutgoingTransition(ITransition transition);
	void removeOutgoingTransition(ITransition transition);
}
