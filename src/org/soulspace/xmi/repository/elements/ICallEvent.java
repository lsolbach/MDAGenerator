package org.soulspace.xmi.repository.elements;

import java.util.List;

public interface ICallEvent extends IEvent {
	List<IParameter> getParameters();
	void addParameter(IParameter parameter);
}
