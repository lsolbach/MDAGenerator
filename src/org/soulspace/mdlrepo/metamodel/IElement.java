/*
 * IElement.java
 */
package org.soulspace.mdlrepo.metamodel;

import java.util.List;
import java.util.Map;

/**
 * Base interface for model elements
 * 
 * @author Solbach (Last update: $Author$, $Date$)
 * @version $Revision$
 */
public interface IElement {

  String getId();
  
  void setId(String id);
  
  String getElementType();
  
  IElement getThis();
  
  List<IStereotype> getStereotypes();
   
  Map<String, IStereotype> getStereotypeMap();
   
  void addStereotype(IStereotype st);

  List<ITaggedValue> getTaggedValues();
   
  Map<String, ITaggedValue> getTaggedValueMap();
   
  void addTaggedValue(ITaggedValue tv);
  
}
