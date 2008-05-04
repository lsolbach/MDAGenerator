/*
 * Created on Mar 3, 2005
 */
package org.soulspace.xmi.repository.elements;

import java.util.ArrayList;
import java.util.List;


/**
 * @author soulman
 *
 */
public class Interface extends Classifier implements IInterface {

	List<IInterface> superInterfaceList = new ArrayList<IInterface>();
	List<IOperation> operationList = new ArrayList<IOperation>();
	
  /**
   * 
   */
  public Interface() {
    super();
  }

  /* (non-Javadoc)
   * @see org.soulspace.xmi.uml.IInterface#getSuperInterfaces()
   */
  public List<IInterface> getSuperInterfaces() {
    return superInterfaceList;
  }

  public void addSuperInterface(IInterface i) {
  	superInterfaceList.add(i);
  }
  
  /* (non-Javadoc)
   * @see org.soulspace.xmi.uml.IInterface#getOperations()
   */
  public List<IOperation> getOperations() {
    return operationList;
  }

  public void addOperation(IOperation o) {
  	operationList.add(o);
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
		final Interface other = (Interface) obj;
		return true;
	}
  
}
