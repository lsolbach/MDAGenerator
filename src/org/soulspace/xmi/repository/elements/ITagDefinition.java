/*
 * Created on Feb 8, 2005
 */
package org.soulspace.xmi.repository.elements;


/**
 * @author soulman
 *
 */
public interface ITagDefinition extends IElement {
  public String getName();
  public int getMultiplicityLow();
  public int getMultiplicityHigh();
}
