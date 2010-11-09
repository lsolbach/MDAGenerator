package org.soulspace.mda.generator;

import java.util.ArrayList;
import java.util.List;

import org.soulspace.mda.generator.ant.ActorGenerator;
import org.soulspace.mda.generator.ant.ClassGenerator;
import org.soulspace.mda.generator.ant.ModelGenerator;
import org.soulspace.mda.generator.ant.PackageGenerator;
import org.soulspace.mda.generator.ant.StateMachineGenerator;
import org.soulspace.mda.generator.ant.UseCaseGenerator;

public class GeneratorGroup {

	private List<GeneratorGroup> generatorGroups = new ArrayList<GeneratorGroup>();
	
	private List<ClassifierGenerator> modelGenerators = new ArrayList<ClassifierGenerator>();

	private List<ClassifierGenerator> packageGenerators = new ArrayList<ClassifierGenerator>();

	private List<ClassifierGenerator> classGenerators = new ArrayList<ClassifierGenerator>();

	private List<ClassifierGenerator> interfaceGenerators = new ArrayList<ClassifierGenerator>();

	private List<ClassifierGenerator> stateMachineGenerators = new ArrayList<ClassifierGenerator>();

	private List<ClassifierGenerator> actorGenerators = new ArrayList<ClassifierGenerator>();

	private List<ClassifierGenerator> useCaseGenerators = new ArrayList<ClassifierGenerator>();

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
	public void addClassGenerator(ClassifierGenerator cg) {
		classGenerators.add(cg);
	}

	public List<ClassifierGenerator> getClassGenerators() {
		return classGenerators;
	}
	
	/**
	 * Adds an interface generator.
	 * @param ig
	 */
	public void addInterfaceGenerator(ClassifierGenerator ig) {
		interfaceGenerators.add(ig);
	}

	public List<ClassifierGenerator> getInterfaceGenerators() {
		return interfaceGenerators;
	}
	
	/**
	 * Adds a model generator.
	 * @param mg
	 */
	public void addModelGenerator(ClassifierGenerator mg) {
		modelGenerators.add(mg);
	}

	public List<ClassifierGenerator> getModelGenerators() {
		return modelGenerators;
	}
	
	/**
	 * Adds a package generator.
	 * @param pg
	 */
	public void addPackageGenerator(ClassifierGenerator pg) {
		packageGenerators.add(pg);
	}

	public List<ClassifierGenerator> getPackageGenerators() {
		return packageGenerators;
	}
	
	/**
	 * Adds a state machine generator.
	 * @param sg
	 */
	public void addStateMachineGenerator(ClassifierGenerator sg) {
		stateMachineGenerators.add(sg);
	}

	public List<ClassifierGenerator> getStateMachineGenerators() {
		return stateMachineGenerators;
	}
	
	/**
	 * Adds a model generator.
	 * @param mg
	 */
	public void addActorGenerator(ClassifierGenerator ag) {
		actorGenerators.add(ag);
	}

	public List<ClassifierGenerator> getActorGenerators() {
		return actorGenerators;
	}
	
	/**
	 * Adds a model generator.
	 * @param mg
	 */
	public void addUseCaseGenerator(ClassifierGenerator ug) {
		useCaseGenerators.add(ug);
	}

	public List<ClassifierGenerator> getUseCaseGenerators() {
		return useCaseGenerators;
	}
	

	
}
