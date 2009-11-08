/*
 * Created on Aug 9, 2005
 */
package org.soulspace.mdlrepo.metamodel;

public interface IDependency extends INamedElement {

  /**
   * Returns the supplier of this dependency.
   * @return
   */
  IClassifier getSupplier();

  /**
   * Sets the supplier of this dependency.
   * @param cf
   */
  void setSupplier(IClassifier cf);

  /**
   * Returns the client of this dependency.
   * @return
   */
  IClassifier getClient();

  /**
   * Sets the client of this dependency.
   * @param cf
   */
  void setClient(IClassifier cf);
  
}
