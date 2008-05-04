package org.soulspace.xmi.repository.elements;

public interface ISubmachineState extends IState {

	boolean getIsConcurrent();
	
	IStateMachine getStateMachine();

}
