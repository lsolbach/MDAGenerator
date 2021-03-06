/*
 *  Copyright (c) Ludger Solbach. All rights reserved.
 *  The use and distribution terms for this software are covered by the
 *  Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
 *  which can be found in the file license.txt at the root of this distribution.
 *  By using this software in any fashion, you are agreeing to be bound by
 *  the terms of this license.
 *  You must not remove this notice, or any other, from this software.
 */
package org.soulspace.mdlrepo.ddd.metamodel.impl;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import org.soulspace.mdlrepo.IModelRepository;
import org.soulspace.mdlrepo.metamodel.IClass;
import org.soulspace.mdlrepo.metamodel.IStereotype;
import org.soulspace.mdlrepo.metamodel.impl.Class;
import org.soulspace.xmi.marshal.ClassItem;
import org.soulspace.xmi.marshal.ModelElement_stereotype;
import org.soulspace.xmi.marshal.ModelElement_stereotypeItem;

public class ModelFactory extends org.soulspace.mdlrepo.metamodel.impl.ModelFactory {

	public ModelFactory(IModelRepository mr) {
		super(mr);
	}

	public ModelFactory() {
		super();
	}

	/* (non-Javadoc)
	 * @see org.soulspace.mdlrepo.metamodel.impl.ModelFactory#createClassInstance(org.soulspace.xmi.marshal.Class)
	 */
	@Override
	protected IClass getClassInstance(org.soulspace.xmi.marshal.Class xmiClass) {
		Map<String, IStereotype> stereotypeMap = new HashMap<String, IStereotype>();
		Enumeration e1 = xmiClass.enumerateClassItem();
		while (e1.hasMoreElements()) {
			ClassItem cI = (ClassItem) e1.nextElement();
			if(cI.getModelElement_stereotype() != null) {
				IStereotype st = getStereotype(cI.getModelElement_stereotype());
				if(st != null && st.getName() != null) {
					stereotypeMap.put(st.getName(), st);					
				}
			}
		}
		if(stereotypeMap.get("entity") != null) {
			return new Entity();
		} else if(stereotypeMap.get("value") != null) {
			return new Value();
		} else {
			return super.getClassInstance(xmiClass);			
		}
	}

  IStereotype getStereotype(ModelElement_stereotype mEST) {
    Enumeration e1 = mEST.enumerateModelElement_stereotypeItem();
    while (e1.hasMoreElements()) {
      ModelElement_stereotypeItem stI = (ModelElement_stereotypeItem) e1
          .nextElement();
      if (stI.getStereotype() != null) {
        String xmiId = stI.getStereotype().getXmi_idref();
        if (xmiId != null) {
          IStereotype st = (IStereotype) getModelRepository().lookupByXmiId(xmiId);
          if (st != null) {
          	return st;
          } else {
          	throw new RuntimeException("Referenced stereotype " + xmiId + " not found in repository!");
          }
        }
      }
    }
    return null;
  }
}
