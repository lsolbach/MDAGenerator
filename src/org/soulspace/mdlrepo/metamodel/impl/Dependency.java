/*
 * Created on Aug 9, 2005
 */
package org.soulspace.mdlrepo.metamodel.impl;

import org.soulspace.mdlrepo.metamodel.IClassifier;
import org.soulspace.mdlrepo.metamodel.IDependency;


public class Dependency extends NamedElement implements IDependency {

  IClassifier supplier;
  IClassifier client;
  String methodSuffix = "";
  
  public Dependency() {
    super();
  }

  public IClassifier getSupplier() {
    return supplier;
  }

  public void setSupplier(IClassifier cf) {
    supplier = cf;
  }

  public IClassifier getClient() {
    return client;
  }

  public void setClient(IClassifier cf) {
    client = cf;
  }

	public String getMethodSuffix() {
		return methodSuffix;
	}

	public void setMethodSuffix(String methodSuffix) {
		this.methodSuffix = methodSuffix;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((client == null) ? 0 : client.hashCode());
		result = prime * result
				+ ((methodSuffix == null) ? 0 : methodSuffix.hashCode());
		result = prime * result + ((supplier == null) ? 0 : supplier.hashCode());
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
		final Dependency other = (Dependency) obj;
		if (client == null) {
			if (other.client != null)
				return false;
		} else if (!client.equals(other.client))
			return false;
		if (methodSuffix == null) {
			if (other.methodSuffix != null)
				return false;
		} else if (!methodSuffix.equals(other.methodSuffix))
			return false;
		if (supplier == null) {
			if (other.supplier != null)
				return false;
		} else if (!supplier.equals(other.supplier))
			return false;
		return true;
	}

	
}
