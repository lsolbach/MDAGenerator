package org.soulspace.mdlrepo.metamodel;

public interface ISubmachineState extends IState {

	boolean getIsConcurrent();
	
	IStateMachine getStateMachine();

}
