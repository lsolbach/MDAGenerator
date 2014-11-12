/*
 * Created on Feb 8, 2005
 */
package org.soulspace.mdlrepo.metamodel;


/**
 * @author soulman
 *
 */
public interface ITagDefinition extends IClassifier {
  int getMultiplicityLow();
  int getMultiplicityHigh();
}
