package org.soulspace.mdlrepo;

import org.soulspace.xmi.repository.XMIRepository;

public interface IModelBuilder {

	void addXmiRepository(XMIRepository xmiRepository);
	IModelRepository getModelRepository();

}
