package org.soulspace.mda.generator;

import java.util.ArrayList;
import java.util.List;


public class GeneratorGroup {

	private List<GeneratorGroup> generatorGroups = new ArrayList<GeneratorGroup>();
	
	private List<ModelGenerator> modelGenerators = new ArrayList<ModelGenerator>();

	private List<PackageGenerator> packageGenerators = new ArrayList<PackageGenerator>();

	private List<ClassGenerator> classGenerators = new ArrayList<ClassGenerator>();

	private List<StateMachineGenerator> stateMachineGenerators = new ArrayList<StateMachineGenerator>();

	private List<ActorGenerator> actorGenerators = new ArrayList<ActorGenerator>();

	private List<UseCaseGenerator> useCaseGenerators = new ArrayList<UseCaseGenerator>();

	/**
	 * Adds a generator group.
	 * @param group
	 */
	public void addGeneratorGroup(GeneratorGroup group) {
		generatorGroups.add(group);
	}
	
	public List<GeneratorGroup> getGeneratorGroups() {
		return generatorGroups;
	}
	
	/**
	 * Adds a class generator.
	 * @param cg
	 */
	public void addClassGenerator(ClassGenerator cg) {
		classGenerators.add(cg);
	}

	public List<ClassGenerator> getClassGenerators() {
		return classGenerators;
	}
	
	/**
	 * Adds a model generator.
	 * @param mg
	 */
	public void addModelGenerator(ModelGenerator mg) {
		modelGenerators.add(mg);
	}

	public List<ModelGenerator> getModelGenerators() {
		return modelGenerators;
	}
	
	/**
	 * Adds a package generator.
	 * @param pg
	 */
	public void addPackageGenerator(PackageGenerator pg) {
		packageGenerators.add(pg);
	}

	public List<PackageGenerator> getPackageGenerators() {
		return packageGenerators;
	}
	
	/**
	 * Adds a state machine generator.
	 * @param sg
	 */
	public void addStateMachineGenerator(StateMachineGenerator sg) {
		stateMachineGenerators.add(sg);
	}

	public List<StateMachineGenerator> getStateMachineGenerators() {
		return stateMachineGenerators;
	}
	
	/**
	 * Adds a model generator.
	 * @param mg
	 */
	public void addActorGenerator(ActorGenerator ag) {
		actorGenerators.add(ag);
	}

	public List<ActorGenerator> getActorGenerators() {
		return actorGenerators;
	}
	
	/**
	 * Adds a model generator.
	 * @param mg
	 */
	public void addUseCaseGenerator(UseCaseGenerator ug) {
		useCaseGenerators.add(ug);
	}

	public List<UseCaseGenerator> getUseCaseGenerators() {
		return useCaseGenerators;
	}
	

	
}
