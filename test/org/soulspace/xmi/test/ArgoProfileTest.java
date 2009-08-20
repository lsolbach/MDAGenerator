package org.soulspace.xmi.test;

import org.soulspace.xmi.repository.XMIRepository;
import org.soulspace.xmi.util.XmiMultiLoader;

public class ArgoProfileTest {

	public ArgoProfileTest() {

	}
	
	  public static void main(String[] args) {
		XMIRepository xmiRepository;
		if (args.length > 0) {
			try {
				xmiRepository = new XMIRepository(args);
				xmiRepository.initRepository();
				System.out.println("Elements: "
						+ xmiRepository.getXmiIdMap().size());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
