package org.soulspace.mdlrepo.metamodel;

public interface ISubmachineState extends ICompositeState {

	boolean getIsConcurrent();
	
	IStateMachine getStateMachine();

}
