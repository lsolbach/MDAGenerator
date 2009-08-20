package org.soulspace.mdlrepo.test;

import org.soulspace.mdlrepo.IModelRepository;
import org.soulspace.mdlrepo.impl.ModelRepository;
import org.soulspace.mdlrepo.metamodel.IClass;
import org.soulspace.mdlrepo.metamodel.IStereotype;
import org.soulspace.mdlrepo.metamodel.impl.Class;

public class ArgoProfileTest {

	public static void main(String[] args) {
		
		IModelRepository mdlRepository = new ModelRepository();
		mdlRepository.initRepository(args);
		System.out.println(mdlRepository.getClasses().size());
		for(IClass clazz : mdlRepository.getClasses()) {
			System.out.println(clazz.getName());
			for(IStereotype stereotype: clazz.getStereotypes()) {
				System.out.println(stereotype.getName());
			}
		}
	}
}
