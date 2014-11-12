package org.soulspace.mdlrepo.metamodel;

public interface ICreateAction extends IAction {
	
	IClassifier getInstanciation();
	void setInstanciation(IClassifier instanciation);
	
}
