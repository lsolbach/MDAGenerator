/*
 *  Copyright (c) Ludger Solbach. All rights reserved.
 *  The use and distribution terms for this software are covered by the
 *  Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
 *  which can be found in the file license.txt at the root of this distribution.
 *  By using this software in any fashion, you are agreeing to be bound by
 *  the terms of this license.
 *  You must not remove this notice, or any other, from this software.
 */
package org.soulspace.xmi.util;

import org.soulspace.xmi.repository.XMIRepository;

public class XmiLoader {

  public XmiLoader() {
    super();
  }

  public static void main(String[] args) {
    XMIRepository xmiRepository;
    if(args.length > 0) {
      for(int i = 0; i < args.length; i++) {
        System.out.println("Model: " + args[i]);
        try {
          xmiRepository = new XMIRepository(args[i]);
          xmiRepository.initRepository();
          System.out.println("Elements: " + xmiRepository.getXmiIdMap().size());          
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    }
  }
  
}
