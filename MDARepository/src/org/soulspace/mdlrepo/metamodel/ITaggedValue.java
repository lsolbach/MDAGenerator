/*
 * Created on Jan 31, 2005
 *
 */
package org.soulspace.mdlrepo.metamodel;


/**
 * @author soulman
 *
 */
public interface ITaggedValue extends INamedElement {
  
  String getValue();
  void setValue(String value);
  
}
