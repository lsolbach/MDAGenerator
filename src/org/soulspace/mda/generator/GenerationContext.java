package org.soulspace.mda.generator;

import java.io.File;
import java.util.List;

import org.apache.tools.ant.util.ClasspathUtils;
import org.soulspace.mda.generator.ant.ActorGenerator;
import org.soulspace.mda.generator.ant.ClassGenerator;
import org.soulspace.mda.generator.ant.ModelGenerator;
import org.soulspace.mda.generator.ant.PackageGenerator;
import org.soulspace.mda.generator.ant.StateMachineGenerator;
import org.soulspace.mda.generator.ant.UseCaseGenerator;
import org.soulspace.mdlrepo.IModelBuilder;
import org.soulspace.mdlrepo.IModelFactory;
import org.soulspace.mdlrepo.IModelRepository;
import org.soulspace.mdlrepo.impl.ModelBuilder;
import org.soulspace.mdlrepo.metamodel.IActor;
import org.soulspace.mdlrepo.metamodel.IClass;
import org.soulspace.mdlrepo.metamodel.IModel;
import org.soulspace.mdlrepo.metamodel.IPackage;
import org.soulspace.mdlrepo.metamodel.IStateMachine;
import org.soulspace.mdlrepo.metamodel.IUseCase;
import org.soulspace.mdlrepo.metamodel.impl.ModelFactory;
import org.soulspace.template.datasource.impl.BeanDataSourceImpl;
import org.soulspace.xmi.base.XmiRepositoryException;
import org.soulspace.xmi.repository.XMIRepository;

public class GenerationContext {

	private File destDir;

	private File backupDir;

	private File templateDir;

	private List<String> templateDirs;

	private File modelFile;

	private String profiles;

	private String modelFactory;

	private GeneratorGroup mainGroup = new GeneratorGroup();

	private IModelRepository repository;

	/**
	 * @return the repository
	 */
	public IModelRepository getRepository() {
		if(repository == null) {
			repository = initRepository();
		}
		return repository;
	}

	/**
	 * @param repository the repository to set
	 */
	public void setRepository(IModelRepository repository) {
		this.repository = repository;
	}

	public GenerationContext() {
		super();
	}

	/**
	 * @return the destDir
	 */
	public File getDestDir() {
		return destDir;
	}

	/**
	 * @param destDir
	 *            the destDir to set
	 */
	public void setDestDir(File destDir) {
		this.destDir = destDir;
	}

	/**
	 * @return the backupDir
	 */
	public File getBackupDir() {
		return backupDir;
	}

	/**
	 * @param backupDir
	 *            the backupDir to set
	 */
	public void setBackupDir(File backupDir) {
		this.backupDir = backupDir;
	}

	/**
	 * @return the templateDir
	 */
	public File getTemplateDir() {
		return templateDir;
	}

	/**
	 * @param templateDir
	 *            the templateDir to set
	 */
	public void setTemplateDir(File templateDir) {
		this.templateDir = templateDir;
	}

	/**
	 * @return the searchDirs
	 */
	public List<String> getTemplateDirs() {
		return templateDirs;
	}

	/**
	 * @param searchDirs
	 *            the searchDirs to set
	 */
	public void setTemplateDirs(List<String> templateDirs) {
		this.templateDirs = templateDirs;
	}

	/**
	 * @return the modelFile
	 */
	public File getModelFile() {
		return modelFile;
	}

	/**
	 * @param modelFile
	 *            the modelFile to set
	 */
	public void setModelFile(File modelFile) {
		this.modelFile = modelFile;
	}

	/**
	 * @return the profiles
	 */
	public String getProfiles() {
		return profiles;
	}

	/**
	 * @param profiles
	 *            the profiles to set
	 */
	public void setProfiles(String profiles) {
		this.profiles = profiles;
	}

	/**
	 * @return the modelFactory
	 */
	public String getModelFactory() {
		return modelFactory;
	}

	/**
	 * @param modelFactory
	 *            the modelFactory to set
	 */
	public void setModelFactory(String modelFactory) {
		this.modelFactory = modelFactory;
	}

	/**
	 * @return the mainGroup
	 */
	public GeneratorGroup getMainGroup() {
		return mainGroup;
	}

	/**
	 * @param mainGroup
	 *            the mainGroup to set
	 */
	public void setMainGroup(GeneratorGroup mainGroup) {
		this.mainGroup = mainGroup;
	}

	/**
	 * Adds a class generator.
	 * 
	 * @param cg
	 */
	public void addClassGenerator(ClassGenerator cg) {
		mainGroup.addClassGenerator(cg);
	}

	/**
	 * Adds a model generator.
	 * 
	 * @param mg
	 */
	public void addModelGenerator(ModelGenerator mg) {
		mainGroup.addModelGenerator(mg);
	}

	/**
	 * Adds a package generator.
	 * 
	 * @param pg
	 */
	public void addPackageGenerator(PackageGenerator pg) {
		mainGroup.addPackageGenerator(pg);
	}

	/**
	 * Adds a state machine generator.
	 * 
	 * @param sg
	 */
	public void addStateMachineGenerator(StateMachineGenerator sg) {
		mainGroup.addStateMachineGenerator(sg);
	}

	/**
	 * Adds a state machine generator.
	 * 
	 * @param sg
	 */
	public void addActorGenerator(ActorGenerator ag) {
		mainGroup.addActorGenerator(ag);
	}

	/**
	 * Adds a state machine generator.
	 * 
	 * @param sg
	 */
	public void addUseCaseGenerator(UseCaseGenerator ug) {
		mainGroup.addUseCaseGenerator(ug);
	}

	/**
	 * Adds a generator group.
	 * 
	 * @param group
	 */
	public void addGeneratorGroup(GeneratorGroup group) {
		mainGroup.addGeneratorGroup(group);
	}

	IModelRepository initRepository() {
		// TODO changes for uml version/tool dependend xmi repositories
		// TODO instanciate (specific) XmiRepository

		if (destDir == null || !destDir.isDirectory()) {
			throw new RuntimeException(destDir + " is not a valid directory");
		}

		if (modelFile == null) {
			throw new RuntimeException("no modelFile set");
		}

		XMIRepository xmiRepository = new XMIRepository();
		IModelFactory mFactory;

		if (modelFactory != null) {
			// instanciate model factory
			mFactory = (IModelFactory) ClasspathUtils.newInstance(modelFactory,
					this.getClass().getClassLoader());
		} else {
			mFactory = new ModelFactory();
		}
		IModelBuilder modelBuilder = new ModelBuilder(mFactory);
		
		if (getProfiles() != null) {
			File profileFile;
			// initialize repository with the provided xmi files
			String[] profileNames = getProfiles().split(",");
			for (String profileName : profileNames) {
				profileFile = new File(profileName.trim());
				log("loading profile " + profileFile.getAbsolutePath());
				try {
					xmiRepository.loadProfile(profileFile);
				} catch (XmiRepositoryException e) {
					e.printStackTrace(System.err);
				}
			}
		}
		log("loading model " + modelFile);
		xmiRepository.loadModel(modelFile);
		modelBuilder.addXmiRepository(xmiRepository);

		return modelBuilder.getModelRepository();
	}
	
	public void callGenerators(GenerationContext ctx, GeneratorGroup gg, BeanDataSourceImpl ds) {
		if(ds == null) {
			ds = new BeanDataSourceImpl(getRepository());
		}
		// 
		// model
		for(IModel model : getRepository().getModels()) {
			for (ClassifierGenerator mg : gg.getModelGenerators()) {
				mg.generate(ctx, model, ds);
			}
		}

		// packages
		for (IPackage p : getRepository().getPackages()) {
			for (ClassifierGenerator pg : gg.getPackageGenerators()) {
				pg.generate(ctx, p, ds);
			}
		}

		// classes
		for (IClass c : getRepository().getClasses()) {
			for (ClassifierGenerator cg : gg.getClassGenerators()) {
				cg.generate(ctx, c, ds);
			}
		}

		// state machines
		for (IStateMachine s : getRepository().getStateMachines()) {
			for (ClassifierGenerator sg : gg.getStateMachineGenerators()) {
				sg.generate(ctx, s, ds);
			}
		}
		
		for(IActor a : getRepository().getActors()) {
			for(ClassifierGenerator ag : gg.getActorGenerators()) {
				ag.generate(ctx, a, ds);
			}
		}
		
		for(IUseCase uc : getRepository().getUseCases()) {
			for(ClassifierGenerator ug : gg.getUseCaseGenerators()) {
				ug.generate(ctx, uc, ds);
			}
		}
		
		for(GeneratorGroup genGroup : gg.getGeneratorGroups()) {
			callGenerators(ctx, genGroup, ds);
		}
	}

	void log(String message) {
		System.out.println(message);
	}

}
