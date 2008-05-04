/*
 * Created on Mar 16, 2006
 */
package org.soulspace.xmi.util;

import org.soulspace.xmi.repository.IModelRepository;
import org.soulspace.xmi.repository.ModelRepository;
import org.soulspace.xmi.repository.poseidon.XMIRepository;

public class ModelLoader {

  public ModelLoader() {
    super();
  }

  public static void main(String[] args) {
    ModelLoader ml = new ModelLoader();
    if(args.length > 0) {
      for(int i = 0; i < args.length; i++) {
        System.out.println("Model: " + args[i]);
        try {
          IModelRepository mr = new ModelRepository();
          mr.initRepository(args[i]);
          System.out.println("Registrered Models: " + mr.getModels().size());
          System.out.println("Registrered Packages: " + mr.getPackages().size());
          System.out.println("Registrered Classes: " + mr.getClasses().size());
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    }

  }
  
}
