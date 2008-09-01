package org.soulspace.mdlrepo.metamodel;

public interface INamedElement extends IElement {

	/**
	 * Returns the (simple) name of this classifier.
	 * @return name
	 */
  String getName();

  void setName(String name);
}
