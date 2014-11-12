package org.soulspace.mdlrepo.metamodel;

import java.util.List;

public interface IEvent extends IClassifier {

	List<IParameter> getParameters();
	void setParameters(List<IParameter> parameters);
	void addParameter(IParameter parameter);
	void removeParameter(IParameter parameter);
	
}
