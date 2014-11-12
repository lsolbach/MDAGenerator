package org.soulspace.mdlrepo.metamodel;

public interface IChangeEvent extends IEvent {
	
	String getExpression();
	void setExpression(String expression);

}
