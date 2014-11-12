/*
 *  Copyright (c) Ludger Solbach. All rights reserved.
 *  The use and distribution terms for this software are covered by the
 *  Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
 *  which can be found in the file license.txt at the root of this distribution.
 *  By using this software in any fashion, you are agreeing to be bound by
 *  the terms of this license.
 *  You must not remove this notice, or any other, from this software.
 */
package org.soulspace.mda.generator;

import java.util.ArrayList;
import java.util.List;

public class GeneratorGroup {

	private List<GeneratorGroup> generatorGroups = new ArrayList<GeneratorGroup>();
	
	private List<ClassifierGenerator> modelGenerators = new ArrayList<ClassifierGenerator>();

	private List<ClassifierGenerator> packageGenerators = new ArrayList<ClassifierGenerator>();

	private List<ClassifierGenerator> classGenerators = new ArrayList<ClassifierGenerator>();

	private List<ClassifierGenerator> interfaceGenerators = new ArrayList<ClassifierGenerator>();

	private List<ClassifierGenerator> stateMachineGenerators = new ArrayList<ClassifierGenerator>();
	
	private List<ClassifierGenerator> stateGenerators = new ArrayList<ClassifierGenerator>();

	private List<ClassifierGenerator> transitionGenerators = new ArrayList<ClassifierGenerator>();

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
	 * Adds a transition generator.
	 * @param tg
	 */
	public void addTransitionGenerator(ClassifierGenerator tg) {
		transitionGenerators.add(tg);
	}

	public List<ClassifierGenerator> getTransitionGenerators() {
		return transitionGenerators;
	}
	
	/**
	 * Adds a transition generator.
	 * @param tg
	 */
	public void addStateGenerator(ClassifierGenerator sg) {
		stateGenerators.add(sg);
	}

	public List<ClassifierGenerator> getStateGenerators() {
		return stateGenerators;
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
