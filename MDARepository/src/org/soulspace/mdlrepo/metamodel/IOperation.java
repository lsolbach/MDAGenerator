/*
 * Created on Jan 12, 2005
 */
package org.soulspace.mdlrepo.metamodel;

import java.util.List;


/**
 * @author soulman
 *
 */
public interface IOperation extends IClassifier {

  public IClassifier getReturnType();
	public void setReturnType(IClassifier cf);

  public List<IParameter> getParameters();
	public void addParameter(IParameter parameter);
  
  public String getOwnerScope();
	public void setOwnerScope(String ownerScope);
  
  public String getVisibility();
	public void setVisibility(String visibility);

  public String getConcurrency();
	public void setConcurrency(String concurrency);

  public boolean getAbstract();
	public void setAbstract(boolean isAbstract);

  public boolean getQuery();
	public void setQuery(boolean isQuery);

  public boolean checkOverride(IOperation superOp);
}
