package org.soulspace.mdlrepo.metamodel.impl;

import org.soulspace.mdlrepo.metamodel.IExpression;

public class Expression implements IExpression {

	private String body;
	private String language;
	
	public String getBody() {
		return body;
	}
	
	public void setBody(String body) {
		this.body = body;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

}
