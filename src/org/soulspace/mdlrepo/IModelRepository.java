/*
 * Created on Jan 12, 2005
 */
package org.soulspace.mdlrepo;

import java.io.File;
import java.util.List;

import org.soulspace.mdlrepo.metamodel.IActor;
import org.soulspace.mdlrepo.metamodel.IClass;
import org.soulspace.mdlrepo.metamodel.IElement;
import org.soulspace.mdlrepo.metamodel.IInterface;
import org.soulspace.mdlrepo.metamodel.IModel;
import org.soulspace.mdlrepo.metamodel.IPackage;
import org.soulspace.mdlrepo.metamodel.IStateMachine;
import org.soulspace.mdlrepo.metamodel.IUseCase;

/**
 * Interface of the model repository.
 * 
 * @author soulman
 */
public interface IModelRepository {

	void setModelFactory(IModelFactory modelFactory);
	
  /**
   * Initialize the repository with the model.
   * @param modelFilename Model
   */
  void initRepository(String modelFilename);

  /**
   * Initialize the repository with the model.
   * @param modelFile Model
   */
  void initRepository(File modelFile);

  /**
   * Register the model element.
   * @param modelElement model element
   */
  void register(IElement modelElement);

  /**
   * Lookup a model element by the qualified name.
   * @param qualifiedName qualified name
   * @return model element
   */
  IElement lookupByQualifiedName(String qualifiedName);

  /**
   * Lookup a model package by the qualified name.
   * @param qualifiedName qualified name
   * @return model package
   */
  IPackage lookupPackageByQualifiedName(String qualifiedName);

  /**
   * Lookup a model class by qualified name.
   * @param qualifiedName qualified name
   * @return model class
   */
  IClass lookupClassByQualifiedName(String qualifiedName);

  /**
   * Lookup a model element by XMI id.
   * @param xmiId XMI id
   * @return model element
   */
  IElement lookupByXmiId(String xmiId);

  /**
   * Returns a list of the registered model packages.
   * @return list of model packages
   */
  List<IPackage> getPackages();

  /**
   * Returns a list of the registered model classes.
   * @return list of model classes
   */
  List<IClass> getClasses();

  /**
   * Returns a list of the registered model interfaces.
   * @return list of model interfaces
   */
  List<IInterface> getInterfaces();

  /**
   * Returns a list of the registered models.
   * @return list of models
   */
  List<IModel> getModels();
  
  /**
   * Returns a list of the registered use cases.
   * @return
   */
  List<IUseCase> getUseCases();

  /**
   * Returns a list of the registered actors.
   * @return
   */
  List<IActor> getActors();

  /**
   * Returns a list of the registered state machines.
   * @return
   */
  List<IStateMachine> getStateMachines();
}
