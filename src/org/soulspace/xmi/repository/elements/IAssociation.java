/*
 * Created on Nov 19, 2004
 */
package org.soulspace.xmi.repository.elements;

/**
 * @author soulman
 *
 */
public interface IAssociation extends IClassifier {

	IClassifier getFrom();
	void setFrom(IClassifier from);

	IClassifier getTo();
	void setTo(IClassifier to);
	
	IAssociationEnd getFromEnd();
	void setFromEnd(IAssociationEnd fromEnd);

	IAssociationEnd getToEnd();
	void setToEnd(IAssociationEnd toEnd);
	
	String getFromRole();
	void setFromRole(String fromRole);
	
	String getToRole();
	void setToRole(String fromRole);
	
	boolean getFromNavigable();
	void setFromNavigable(boolean fromNavigable);

	boolean getToNavigable();
	void setToNavigable(boolean toNavigable);
}
