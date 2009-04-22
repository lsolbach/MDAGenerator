package org.soulspace.mdlrepo;

import org.soulspace.mdlrepo.impl.ModelRepository;
import org.soulspace.mdlrepo.metamodel.IAssociation;
import org.soulspace.mdlrepo.metamodel.IAssociationEnd;
import org.soulspace.mdlrepo.metamodel.IClass;

import junit.framework.TestCase;

public class ModelRepositoryTest extends TestCase {

	IModelRepository repository;
	
	protected void setUp() throws Exception {
		repository = new ModelRepository();
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testAssociationClass() {
		repository.initRepository("refModels/argouml/associationclass.xmi");
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
	
	
	
}
