/*
 * Created on Mar 15, 2006
 */
package org.soulspace.xmi.repository.elements;

import java.util.List;

public interface IUseCase extends IClassifier {

	List<IExtensionPoint> getExtensionPoints();
	
	void addExtensionPoint(IExtensionPoint extensionPoint);

	List<IUseCase> getIncludes();
	
	void addInclude(IUseCase useCase);
	
	List<IUseCase> getIncluded();
	
	void addIncluded(IUseCase useCase);
	
	List<IUseCase> getExtends();
	
	void addExtend(IUseCase useCase);
	
	List<IUseCase> getExtended();
	
	void addExtended(IUseCase useCase);
}
