package org.soulspace.mdlrepo.metamodel.impl;

import java.util.ArrayList;
import java.util.List;

import org.soulspace.mdlrepo.metamodel.IAssociationEnd;
import org.soulspace.mdlrepo.metamodel.IExtensionPoint;
import org.soulspace.mdlrepo.metamodel.IUseCase;

public class UseCase extends Classifier implements IUseCase {

	private List<IExtensionPoint> extensionPointList = new ArrayList<IExtensionPoint>();
	private List<IUseCase> includeList = new ArrayList<IUseCase>();
	private List<IUseCase> includedList = new ArrayList<IUseCase>();
	private List<IUseCase> extendList = new ArrayList<IUseCase>();
	private List<IUseCase> extendedList = new ArrayList<IUseCase>();
	private List<IAssociationEnd> associations = new ArrayList<IAssociationEnd>();

	public void addExtensionPoint(IExtensionPoint extensionPoint) {
		extensionPointList.add(extensionPoint);
	}

	public List<IExtensionPoint> getExtensionPoints() {
		return extensionPointList;
	}

	public void addExtend(IUseCase useCase) {
		extendList.add(useCase);
	}

	public List<IUseCase> getExtends() {
		return extendList;
	}

	public void addExtended(IUseCase useCase) {
		extendedList.add(useCase);		
	}

	public List<IUseCase> getExtended() {
		return extendedList;
	}

	public void addInclude(IUseCase useCase) {
		includeList.add(useCase);
	}

	public List<IUseCase> getIncludes() {
		return includeList;
	}

	public void addIncluded(IUseCase useCase) {
		includedList.add(useCase);
	}

	public List<IUseCase> getIncluded() {
		return includedList;
	}

	public List<IAssociationEnd> getAssociations() {
		return associations;
	}

	public void addAssociation(IAssociationEnd ae) {
		associations.add(ae);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		final UseCase other = (UseCase) obj;
		return true;
	}
	
	
}
