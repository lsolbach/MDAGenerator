/*
 * Created on Feb 21, 2005
 */
package org.soulspace.mda.generator.ant;

import java.io.File;
import java.util.Map;

import org.soulspace.mdlrepo.IModelRepository;
import org.soulspace.mdlrepo.metamodel.IModel;
import org.soulspace.template.datasource.impl.BeanDataSource;

/**
 * @author soulman
 * 
 */
public class ModelGenerator extends AntGenerator {
  
  /**
   * 
   */
  public ModelGenerator() {
    super();
  }

  public void generate(MdaGeneratorTask gt, IModelRepository modelRepository) {
    String output;
    Map userSections = null;
    File templateDir = gt.getTemplateDir();
//    if(!isSet(getBasename())) {
//      setBasename(getName());
//    }
    dataSource = gt.getDataSource();

    engine = getEngine(templateDir);

    try {
    	if(modelRepository.getModels().size() < 1) {
    		throw new RuntimeException("No models loaded");
    	}
    	IModel model = modelRepository.getModels().get(0);

    	// put model repository in data source
    	BeanDataSource myDS = new BeanDataSource(modelRepository);
      // add generator context
      myDS.add("GenContext", getGeneratorContext());
      // FIXME read user sections?
//      if(isSet(getGeneratorContext().getUserSection())) {
//        userSections = readUserSections(getPath(gt, model, true));
//        myDS.add("USERSECTIONS", userSections);      	
//      }

      output = engine.generate(myDS);
      
      if(acceptWrite(output)) {
	      createPackagePath(gt, model);
	      writeFile(getPath(gt, model, false), output);
      }
    } catch (Exception e1) {
      System.err.println("Exception while processing template " + getGeneratorContext().getName() + "!");
      e1.printStackTrace();
    } 
  }
}
