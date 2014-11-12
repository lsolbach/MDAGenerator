package org.soulspace.mdlrepo.metamodel.impl;

import java.util.ArrayList;
import java.util.List;

import org.soulspace.mdlrepo.metamodel.IEvent;
import org.soulspace.mdlrepo.metamodel.IParameter;

public class Event extends Classifier implements IEvent {

	List<IParameter> parameterList = new ArrayList<IParameter>();
	
	public List<IParameter> getParameters() {
		return parameterList;
	}

	public void setParameters(List<IParameter> parameters) {
		this.parameterList = parameters;
	}

	public void addParameter(IParameter parameter) {
		parameterList.add(parameter);
	}

	public void removeParameter(IParameter parameter) {
		parameterList.remove(parameter);
	}

}
