package org.soulspace.mdlrepo.metamodel;

public interface ICallAction extends IAction {

	IOperation getOperation();
	void setOperation(IOperation operation);
	
}
