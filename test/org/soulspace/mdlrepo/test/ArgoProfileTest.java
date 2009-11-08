package org.soulspace.mdlrepo.test;

import java.io.File;

import org.soulspace.mdlrepo.IModelBuilder;
import org.soulspace.mdlrepo.IModelFactory;
import org.soulspace.mdlrepo.IModelRepository;
import org.soulspace.mdlrepo.impl.ModelBuilder;
import org.soulspace.mdlrepo.impl.ModelRepository;
import org.soulspace.mdlrepo.metamodel.IClass;
import org.soulspace.mdlrepo.metamodel.IStereotype;
import org.soulspace.mdlrepo.metamodel.impl.Class;
import org.soulspace.mdlrepo.metamodel.impl.ModelFactory;
import org.soulspace.xmi.repository.XMIRepository;

public class ArgoProfileTest {

	public static void main(String[] args) {
		IModelFactory modelFactory = new ModelFactory();
		IModelBuilder modelBuilder = new ModelBuilder(modelFactory);
		XMIRepository xmiRepository = new XMIRepository();
		for(int i = 0; i < args.length; i++) {
			String filename = args[i];
			if(i < args.length - 1) {
				xmiRepository.loadProfile(new File(filename));
				modelBuilder.addXmiRepository(xmiRepository);
			} else {
				xmiRepository.loadModel(new File(filename));
				modelBuilder.addXmiRepository(xmiRepository);
			}
		}
		IModelRepository mdlRepository = modelBuilder.getModelRepository();
		System.out.println(mdlRepository.getClasses().size());
		for(IClass clazz : mdlRepository.getClasses()) {
			System.out.println(clazz.getName());
			for(IStereotype stereotype: clazz.getStereotypes()) {
				System.out.println(stereotype.getName());
			}
		}
	}
}
