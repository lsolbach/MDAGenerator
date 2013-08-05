/*
 *  Copyright (c) Ludger Solbach. All rights reserved.
 *  The use and distribution terms for this software are covered by the
 *  Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
 *  which can be found in the file license.txt at the root of this distribution.
 *  By using this software in any fashion, you are agreeing to be bound by
 *  the terms of this license.
 *  You must not remove this notice, or any other, from this software.
 */
package org.soulspace.mda.generator;

/**
 * Datatype for Stereotypes used to include or exclude specific
 * Stereotypes for generation
 * @author soulman
 *
 */
public class Stereotypes {

  private String stereotypes;
  
  public Stereotypes() {
  }
  
  public String getStereotypes() {
    return stereotypes;
  }
  
  public void setStereotypes(String stereotypes) {
    this.stereotypes = stereotypes;
  }
}
