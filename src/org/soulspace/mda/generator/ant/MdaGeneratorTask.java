/*
 * Created on Feb 20, 2005
 */
package org.soulspace.mda.generator.ant;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Task;
import org.soulspace.template.datasource.impl.BeanDataSource;
import org.soulspace.xmi.repository.IModelRepository;
import org.soulspace.xmi.repository.ModelRepository;
import org.soulspace.xmi.repository.elements.IClass;
import org.soulspace.xmi.repository.elements.IPackage;
import org.soulspace.xmi.repository.elements.IStateMachine;

/**
 * @author soulman
 * 
 */
public class MdaGeneratorTask extends Task {

  private File destDir;

  private File backupDir;

  private File templateDir;

  private File modelFile;

  private List<ModelGenerator> modelGenerators = new ArrayList<ModelGenerator>();

  private List<PackageGenerator> packageGenerators = new ArrayList<PackageGenerator>();

  private List<ClassGenerator> classGenerators = new ArrayList<ClassGenerator>();

  private List<StateMachineGenerator> stateMachineGenerators = new ArrayList<StateMachineGenerator>();
  
  private BeanDataSource dataSource;

  /**
   * Constructor
   */
  public MdaGeneratorTask() {
    super();
  }

  /**
   * @return Returns the dataSource.
   */
  public BeanDataSource getDataSource() {
    return dataSource;
  }

  /**
   * @param destdir
   *          The destdir to set.
   */
  public void setDestDir(File destDir) {
    this.destDir = destDir;
  }

  /**
   * @return Returns the destDir.
   */
  public File getDestDir() {
    return destDir;
  }

  /**
   * @param backupDir
   *          The backupDir to set.
   */
  public void setBackupDir(File backupDir) {
    this.backupDir = backupDir;
  }

  /**
   * @return Returns the backupDir.
   */
  public File getBackupDir() {
    return backupDir;
  }

  /**
   * @param templateDir
   *          The templateDir to set.
   */
  public void setTemplateDir(File templateDir) {
    this.templateDir = templateDir;
  }

  /**
   * @return Returns the templateDir.
   */
  public File getTemplateDir() {
    return templateDir;
  }

  /**
   * @param modelFile
   *          The modelFile to set.
   */
  public void setModelFile(File modelFile) {
    this.modelFile = modelFile;
  }

  /**
   * @return Returns the modelFile.
   */
  public File getModelFile() {
    return modelFile;
  }

  /**
   * 
   * @param cg
   */
  public void addClassGenerator(ClassGenerator cg) {
    classGenerators.add(cg);
  }

  /**
   * 
   * @param mg
   */
  public void addModelGenerator(ModelGenerator mg) {
    modelGenerators.add(mg);
  }

  /**
   * 
   * @param pg
   */
  public void addPackageGenerator(PackageGenerator pg) {
    packageGenerators.add(pg);
  }

  /**
   * 
   * @param sg
   */
  public void addStateMachineGenerator(StateMachineGenerator sg) {
  	stateMachineGenerators.add(sg);
  }
  
  IModelRepository initRepository() {
    ModelRepository repository = new ModelRepository();
    repository.initRepository(modelFile.getAbsolutePath());
    return repository;
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.apache.tools.ant.Task#execute()
   */
  public void execute() throws BuildException {
    if (destDir == null || !destDir.isDirectory()) {
      throw new BuildException(destDir + " is not a valid directory");
    }
    
    if (modelFile == null) {
      throw new BuildException("no modelFile set");
    }
    
    IModelRepository repository = initRepository();
    dataSource = new BeanDataSource(repository);

    // model
    for(ModelGenerator mg : modelGenerators) {
      mg.generate(this, repository);    	
    }
    
    // packages
    for(IPackage p : repository.getPackages()) {
    	for(PackageGenerator pg : packageGenerators) {
    		pg.generate(this, p);
    	}
    }
    
    // classes
    for(IClass c : repository.getClasses()) {
    	for(ClassGenerator cg : classGenerators) {
    		cg.generate(this, c);
    	}
    }
    
    // state machines
    for(IStateMachine s : repository.getStateMachines()) {
    	for(StateMachineGenerator sg : stateMachineGenerators) {
    		sg.generate(this, s);
    	}
    }
  }
  
}
