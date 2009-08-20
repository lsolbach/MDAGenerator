/*
 * Created on Mar 8, 2006
 */
package org.soulspace.xmi.util;

import org.soulspace.xmi.repository.XMIRepository;

public class XmiMultiLoader {

  public XmiMultiLoader() {
    super();
  }

  public static void main(String[] args) {
    XMIRepository xmiRepository;
    if(args.length > 0) {
      try {
        xmiRepository = new XMIRepository(args);
        xmiRepository.initRepository();
        System.out.println("Elements: " + xmiRepository.getXmiIdMap().size());          
	  } catch (Exception e) {
	    e.printStackTrace();
      }
    }
  }
}
