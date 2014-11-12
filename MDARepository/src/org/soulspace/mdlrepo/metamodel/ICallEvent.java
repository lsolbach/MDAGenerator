package org.soulspace.mdlrepo.metamodel;

import java.util.List;

public interface ICallEvent extends IEvent {

	IOperation getOperation();
	void setOperation(IOperation operation);
	
}
