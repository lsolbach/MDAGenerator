package org.soulspace.mdlrepo.metamodel;

import java.util.List;

public interface ISignalEvent extends IEvent {

	ISignal getSignal();
	void setSignal(ISignal signal);
	
}
