package org.soulspace.mdlrepo.metamodel;

import java.util.List;

public interface IAction extends INamedElement {

	List<String> getArguments();
	void setArguments(List<String> arguments);
	void addArgument(String argument);
	void removeArgument(String argument);

	String getScript();
	void setScript(String script);

	String getTarget();
	void setTarget(String target);

	String getRecurrence();
	void setRecurrence(String recurrence);

}
