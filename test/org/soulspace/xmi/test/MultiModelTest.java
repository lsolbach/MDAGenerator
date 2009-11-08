package org.soulspace.xmi.test;

import java.io.File;

import org.soulspace.xmi.repository.XMIRepository;
import org.soulspace.xmi.util.XmiMultiLoader;

public class MultiModelTest {

	public MultiModelTest() {

	}

	public static void main(String[] args) {
		XMIRepository xmiRepository = new XMIRepository();
		if (args.length > 0) {
			try {
				for (String filename : args) {
					xmiRepository.loadModel(new File(filename));
				}
				System.out.println("Elements: "
						+ xmiRepository.getXmiIdMap().size());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
