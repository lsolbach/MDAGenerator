package org.soulspace.mdlrepo.metamodel;

public interface ISubmachineState extends ICompositeState {

	boolean getIsConcurrent();
	void setIsConcurrent(boolean isConcurrent);
	
	IStateMachine getSubmachine();
	void setSubmachine(IStateMachine submachine);

}
