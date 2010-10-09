package org.soulspace.mdlrepo;

import java.io.File;

import org.soulspace.mdlrepo.impl.ModelBuilder;
import org.soulspace.mdlrepo.impl.ModelRepository;
import org.soulspace.mdlrepo.metamodel.IAssociation;
import org.soulspace.mdlrepo.metamodel.IAssociationEnd;
import org.soulspace.mdlrepo.metamodel.IClass;
import org.soulspace.mdlrepo.metamodel.impl.ModelFactory;
import org.soulspace.xmi.repository.XMIRepository;

import junit.framework.TestCase;

public class ModelRepositoryTest extends TestCase {

	IModelRepository repository;
	IModelBuilder builder;
	XMIRepository xmiRepository = new XMIRepository();
	
	protected void setUp() throws Exception {
		builder = new ModelBuilder(new ModelFactory());
		xmiRepository = new XMIRepository();
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

/*	
	public void testAssociationClass() {
		xmiRepository.loadModel(new File("refModels/argouml/associationclass.xmi"));

		builder.addXmiRepository(xmiRepository);

		repository = builder.getModelRepository();
		for(IClass c : repository.getClasses()) {
			System.out.println("Class " + c.getName());
			for(IAssociationEnd ae : c.getAssociations()) {
				System.out.println("Association to " + ae.getType().getName());				
			}
		}
		assertEquals("3 Classes ", 3, repository.getClasses().size());
		
		for(IAssociation a : repository.getAssociations()) {
			System.out.println("Association " + a.getId());
		}
		assertEquals("1 Association", 1, repository.getAssociations().size());
		
	}
*/
	
	public void testStateMachine() {
		xmiRepository.loadModel(new File("refModels/argouml/statemachine.xmi"));

		builder.addXmiRepository(xmiRepository);
		repository = builder.getModelRepository();
		
	}

}
