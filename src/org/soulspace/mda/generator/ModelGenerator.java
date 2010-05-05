/*
 * Created on Feb 21, 2005
 */
package org.soulspace.mda.generator;

import java.io.File;
import java.util.Map;

import org.soulspace.mda.generator.ant.MdaGeneratorTask;
import org.soulspace.mdlrepo.IModelRepository;
import org.soulspace.mdlrepo.metamodel.IModel;
import org.soulspace.template.datasource.impl.BeanDataSource;

/**
 * @author soulman
 * 
 */
public class ModelGenerator extends ClassifierGenerator {

	/**
   * 
   */
	public ModelGenerator() {
		super();
	}

//	public void generate(GenerationContext ctx, IModel model) {
//		String output;
//		Map userSections = null;
//		File templateDir = ctx.getTemplateDir();
//		dataSource = ctx.getDataSource();
//
//		engine = getEngine(templateDir);
//
//		try {
//
//			// put model repository in data source
//			BeanDataSource myDS = new BeanDataSource(model);
//			// add generator context
//			myDS.add("GenContext", getGeneratorContext());
//			// FIXME read user sections?
//			// if(isSet(getGeneratorContext().getUserSection())) {
//			// userSections = readUserSections(getPath(gt, model, true));
//			// myDS.add("USERSECTIONS", userSections);
//			// }
//
//			output = engine.generate(myDS);
//
//			if (acceptWrite(output)) {
//				createPackagePath(ctx, model);
//				writeFile(getPath(ctx, model, false), output);
//			}
//		} catch (Exception e1) {
//			System.err.println("Exception while processing template "
//					+ getGeneratorContext().getName() + "!");
//			e1.printStackTrace();
//		}
//	}
}
