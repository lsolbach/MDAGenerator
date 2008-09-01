package org.soulspace.mdlrepo.metamodel;

import java.util.List;

public interface ICallEvent extends IEvent {
	List<IParameter> getParameters();
	void addParameter(IParameter parameter);
}
