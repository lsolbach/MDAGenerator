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

}
