/*
 * Created on Jan 21, 2005
 */
package org.soulspace.mdlrepo.metamodel.impl;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import org.soulspace.mdlrepo.metamodel.IClassifier;
import org.soulspace.mdlrepo.metamodel.IOperation;
import org.soulspace.mdlrepo.metamodel.IParameter;
import org.soulspace.xmi.marshal.BehavioralFeature_parameterItem;
import org.soulspace.xmi.marshal.OperationItem;
import org.soulspace.xmi.marshal.Parameter;
import org.soulspace.xmi.marshal.ParameterItem;
import org.soulspace.xmi.marshal.Parameter_typeItem;
import org.soulspace.xmi.marshal.TypedElement_type;
import org.soulspace.xmi.marshal.types.KindType;

/**
 * @author soulman
 *
 */
public class Operation extends Classifier implements IOperation {
  
  IClassifier returnType;
  String visibility;
  String ownerScope;
  String concurrency;
  boolean isAbstract;
  boolean isSpecification;
  boolean isRoot;
  boolean isLeaf;
  boolean isQuery;
  List parameters = new ArrayList();
  
  public Operation() {
    super();
  }
  
  public void setReturnType(IClassifier cf) {
    returnType = cf;
  }
  /**
   * @param visibility The visibility to set.
   */
  public void setVisibility(String visibility) {
    this.visibility = visibility;
  }
  /**
   * @return Returns the concurrency.
   */
  public String getConcurrency() {
    return concurrency;
  }
  
  /**
   * @return Returns the isAbstract.
   */
  public boolean getAbstract() {
    return isAbstract;
  }
  
  /**
   * @return Returns the isLeaf.
   */
  public boolean isLeaf() {
    return isLeaf;
  }
  
  /**
   * @return Returns the isQuery.
   */
  public boolean getQuery() {
    return isQuery;
  }
  
  /**
   * @return Returns the isRoot.
   */
  public boolean isRoot() {
    return isRoot;
  }
  
  /**
   * @return Returns the isSpecification.
   */
  public boolean isSpecification() {
    return isSpecification;
  }
  
  /**
   * @return Returns the ownerScope.
   */
  public String getOwnerScope() {
    return ownerScope;
  }
  
  /**
   * @return Returns the parameters.
   */
  public List<IParameter> getParameters() {
    return parameters;
  }
  
  public void addParameter(IParameter p) {
    parameters.add(p);
  }
  
  /**
   * @return Returns the returnType.
   */
  public IClassifier getReturnType() {
    return returnType;
  }
  
  /**
   * @return Returns the visibility.
   */
  public String getVisibility() {
    return visibility;
  }
  
  /**
   * @param concurrency The concurrency to set.
   */
  public void setConcurrency(String concurrency) {
    this.concurrency = concurrency;
  }
  /**
   * @param isAbstract The isAbstract to set.
   */
  public void setAbstract(boolean isAbstract) {
    this.isAbstract = isAbstract;
  }
  /**
   * @param isLeaf The isLeaf to set.
   */
  public void setLeaf(boolean isLeaf) {
    this.isLeaf = isLeaf;
  }
  /**
   * @param isQuery The isQuery to set.
   */
  public void setQuery(boolean isQuery) {
    this.isQuery = isQuery;
  }
  /**
   * @param isRoot The isRoot to set.
   */
  public void setRoot(boolean isRoot) {
    this.isRoot = isRoot;
  }
  /**
   * @param isSpecification The isSpecification to set.
   */
  public void setSpecification(boolean isSpecification) {
    this.isSpecification = isSpecification;
  }
  /**
   * @param ownerScope The ownerScope to set.
   */
  public void setOwnerScope(String ownerScope) {
    this.ownerScope = ownerScope;
  }

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		// FIXME use a kind of 'signature' for equals and hashCode?!?
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((concurrency == null) ? 0 : concurrency.hashCode());
		result = prime * result + (isAbstract ? 1231 : 1237);
		result = prime * result + (isLeaf ? 1231 : 1237);
		result = prime * result + (isQuery ? 1231 : 1237);
		result = prime * result + (isRoot ? 1231 : 1237);
		result = prime * result + (isSpecification ? 1231 : 1237);
		result = prime * result
				+ ((ownerScope == null) ? 0 : ownerScope.hashCode());
		result = prime * result
				+ ((returnType == null) ? 0 : returnType.hashCode());
		result = prime * result
				+ ((visibility == null) ? 0 : visibility.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		// FIXME use a kind of 'signature' for equals and hashCode?!?
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		final Operation other = (Operation) obj;
		if (concurrency == null) {
			if (other.concurrency != null)
				return false;
		} else if (!concurrency.equals(other.concurrency))
			return false;
		if (isAbstract != other.isAbstract)
			return false;
		if (isLeaf != other.isLeaf)
			return false;
		if (isQuery != other.isQuery)
			return false;
		if (isRoot != other.isRoot)
			return false;
		if (isSpecification != other.isSpecification)
			return false;
		if (ownerScope == null) {
			if (other.ownerScope != null)
				return false;
		} else if (!ownerScope.equals(other.ownerScope))
			return false;
		if (returnType == null) {
			if (other.returnType != null)
				return false;
		} else if (!returnType.equals(other.returnType))
			return false;
		if (visibility == null) {
			if (other.visibility != null)
				return false;
		} else if (!visibility.equals(other.visibility))
			return false;
		return true;
	}
  
	public String getSignature() {
		StringBuilder sb = new StringBuilder();
		if(returnType != null) {
			sb.append(returnType.getQualifiedName() + " ");
		}
		sb.append(getQualifiedName() + "(");
		boolean firstParam = true;
		for(IParameter param : getParameters()) {
			if(!param.getKind().equals("return")) {
				if(firstParam) {
					firstParam = false;
				} else {
					sb.append(", ");
				}
				sb.append(param.getType().getQualifiedName());
			}
		}
		sb.append(")");
		return sb.toString();
	}
	
	public boolean checkOverride(IOperation op) {
		if(!getName().equals(op.getName())) {
			return false;
		}
		if(getParameters().size() != op.getParameters().size()) {
			return false;
		}
		for(int i = 0; i < getParameters().size(); i++) {
			// TODO check type compatibility (IClassifier.isCompatible()/isAssignableFrom()?)
			// TODO handle return type
			if(!getParameters().get(i).getType().equals(op.getParameters().get(i).getType())) {
				return false;
			}
		}
		if(!getVisibility().equals(op.getVisibility())) {
			// TODO implement check?
		}
		// TODO handle other attributes (isQuery, ownerScope, concurrency, ...)
		return true;
	}
	
	public String toString() {
		return getClass().getSimpleName() + "[ " + getId() + ", " + getSignature() + "]";
	}
}
