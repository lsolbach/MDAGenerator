package org.soulspace.mdlrepo.metamodel.impl;

import org.soulspace.mdlrepo.metamodel.ICallAction;
import org.soulspace.mdlrepo.metamodel.IOperation;

public class CallAction extends Action implements ICallAction {

	private IOperation operation;

	public IOperation getOperation() {
		return operation;
	}

	public void setOperation(IOperation operation) {
		this.operation = operation;
	}
	
	
}
