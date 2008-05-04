/*
 * Created on May 3, 2005
 */
package org.soulspace.xmi.repository.elements;

import java.util.ArrayList;
import java.util.List;


public class Model extends Classifier implements IModel {

  private List packages = new ArrayList();
  
  public Model() {
    super();
  }

  public List getPackages() {
    return packages;
  }

  public void addPackage(IPackage p) {
    packages.add(p);
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
		final Model other = (Model) obj;
		return true;
	}
  
}
