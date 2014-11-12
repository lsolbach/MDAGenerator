/*
 *  Copyright (c) Ludger Solbach. All rights reserved.
 *  The use and distribution terms for this software are covered by the
 *  Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
 *  which can be found in the file license.txt at the root of this distribution.
 *  By using this software in any fashion, you are agreeing to be bound by
 *  the terms of this license.
 *  You must not remove this notice, or any other, from this software.
 */
package org.soulspace.mda.generator.ant;

import java.io.File;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Task;
import org.soulspace.mda.generator.GenerationContext;
import org.soulspace.mda.generator.GeneratorGroup;
import org.soulspace.util.CollectionUtils;

/**
 * @author soulman
 * 
 */
public class MdaGeneratorTask extends Task {

	private GenerationContext generationContext;
	
	public MdaGeneratorTask() {
		super();
		generationContext = new GenerationContext();
	}

	public void setGenerationContext(GenerationContext ctx) {
		this.generationContext = ctx;
	}
	
	public void setDestDir(File destDir) {
		generationContext.setDestDir(destDir);
	}

	public void setBackupDir(File backupDir) {
		generationContext.setBackupDir(backupDir);
	}

	public void setTemplateDir(File templateDir) {
		generationContext.setTemplateDir(templateDir);
	}

	public void setTemplateDirs(String templateDirs) {
		String[] dirs = templateDirs.split(",");
		generationContext.setTemplateDirs(CollectionUtils
				.asArrayList(dirs));
	}
	
	public void setModelFile(File modelFile) {
		generationContext.setModelFile(modelFile);
	}

	public void setModelFactory(String modelFactory) {
		generationContext.setModelFactory(modelFactory);
	}

	public void setProfiles(String profiles) {
		generationContext.setProfiles(profiles);
	}

	public void addClassGenerator(ClassGenerator cg) {
		generationContext.getMainGroup().addClassGenerator(cg);
	}

	public void addInterfaceGenerator(InterfaceGenerator ig) {
		generationContext.getMainGroup().addInterfaceGenerator(ig);
	}

	public void addModelGenerator(ModelGenerator mg) {
		generationContext.getMainGroup().addModelGenerator(mg);
	}

	public void addPackageGenerator(PackageGenerator pg) {
		generationContext.getMainGroup().addPackageGenerator(pg);
	}

	public void addStateMachineGenerator(StateMachineGenerator sg) {
		generationContext.getMainGroup().addStateMachineGenerator(sg);
	}

	public void addStateGenerator(StateGenerator sg) {
		generationContext.getMainGroup().addStateGenerator(sg);
	}

	public void addTransitionGenerator(TransitionGenerator tg) {
		generationContext.getMainGroup().addTransitionGenerator(tg);
	}

	public void addActorGenerator(ActorGenerator ag) {
		generationContext.getMainGroup().addActorGenerator(ag);
	}

	public void addUseCaseGenerator(UseCaseGenerator ug) {
		generationContext.getMainGroup().addUseCaseGenerator(ug);
	}

	public void addGeneratorGroup(GeneratorGroup group) {
		generationContext.getMainGroup().addGeneratorGroup(group);
	}	
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.tools.ant.Task#execute()
	 */
	public void execute() throws BuildException {
		try {
			generationContext.callGenerators(generationContext, generationContext.getMainGroup(), null);
		} catch (Exception e) {
			throw new BuildException("error while generating!", e);
		}
	}
	
}
