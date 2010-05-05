/*
 * Created on Feb 20, 2005
 */
package org.soulspace.mda.generator.ant;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Task;
import org.apache.tools.ant.types.FileSet;
import org.apache.tools.ant.util.ClasspathUtils;
import org.soulspace.mda.generator.ActorGenerator;
import org.soulspace.mda.generator.ClassGenerator;
import org.soulspace.mda.generator.GenerationContext;
import org.soulspace.mda.generator.GeneratorGroup;
import org.soulspace.mda.generator.ModelGenerator;
import org.soulspace.mda.generator.PackageGenerator;
import org.soulspace.mda.generator.StateMachineGenerator;
import org.soulspace.mda.generator.UseCaseGenerator;
import org.soulspace.mdlrepo.IModelBuilder;
import org.soulspace.mdlrepo.IModelFactory;
import org.soulspace.mdlrepo.IModelRepository;
import org.soulspace.mdlrepo.impl.ModelBuilder;
import org.soulspace.mdlrepo.impl.ModelRepository;
import org.soulspace.mdlrepo.metamodel.IActor;
import org.soulspace.mdlrepo.metamodel.IClass;
import org.soulspace.mdlrepo.metamodel.IPackage;
import org.soulspace.mdlrepo.metamodel.IStateMachine;
import org.soulspace.mdlrepo.metamodel.IUseCase;
import org.soulspace.mdlrepo.metamodel.impl.ModelFactory;
import org.soulspace.template.datasource.impl.BeanDataSource;
import org.soulspace.util.CollectionUtils;
import org.soulspace.xmi.repository.XMIRepository;

/**
 * @author soulman
 * 
 */
public class MdaGeneratorTask extends Task {

	private GenerationContext ctx;
	
	public MdaGeneratorTask() {
		super();
		ctx = new GenerationContext();
	}

	public void setDestDir(File destDir) {
		ctx.setDestDir(destDir);
	}

	public void setBackupDir(File backupDir) {
		ctx.setBackupDir(backupDir);
	}

	public void setTemplateDir(File templateDir) {
		ctx.setTemplateDir(templateDir);
	}

	public void setTemplateDirs(String templateDirs) {
		String[] dirs = templateDirs.split(",");
		ctx.setTemplateDirs(CollectionUtils
				.asArrayList(dirs));
	}
	
	public void setModelFile(File modelFile) {
		ctx.setModelFile(modelFile);
	}

	public void setModelFactory(String modelFactory) {
		ctx.setModelFactory(modelFactory);
	}

	public void setProfiles(String profiles) {
		ctx.setProfiles(profiles);
	}

	public void addClassGenerator(ClassGenerator cg) {
		ctx.getMainGroup().addClassGenerator(cg);
	}

	public void addModelGenerator(ModelGenerator mg) {
		ctx.getMainGroup().addModelGenerator(mg);
	}

	public void addPackageGenerator(PackageGenerator pg) {
		ctx.getMainGroup().addPackageGenerator(pg);
	}

	public void addStateMachineGenerator(StateMachineGenerator sg) {
		ctx.getMainGroup().addStateMachineGenerator(sg);
	}

	public void addActorGenerator(ActorGenerator ag) {
		ctx.getMainGroup().addActorGenerator(ag);
	}

	public void addUseCaseGenerator(UseCaseGenerator ug) {
		ctx.getMainGroup().addUseCaseGenerator(ug);
	}

	public void addGeneratorGroup(GeneratorGroup group) {
		ctx.getMainGroup().addGeneratorGroup(group);
	}	
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.tools.ant.Task#execute()
	 */
	public void execute() throws BuildException {
		try {
			ctx.callGenerators(ctx, ctx.getMainGroup());
		} catch (Exception e) {
			throw new BuildException("error while generating!", e);
		}
	}
	
}
