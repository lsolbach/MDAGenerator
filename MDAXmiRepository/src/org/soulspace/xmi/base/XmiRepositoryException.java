/*
 *  Copyright (c) Ludger Solbach. All rights reserved.
 *  The use and distribution terms for this software are covered by the
 *  Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
 *  which can be found in the file license.txt at the root of this distribution.
 *  By using this software in any fashion, you are agreeing to be bound by
 *  the terms of this license.
 *  You must not remove this notice, or any other, from this software.
 */
package org.soulspace.xmi.base;

public class XmiRepositoryException extends RuntimeException {

	public XmiRepositoryException() {
	}

	public XmiRepositoryException(String message) {
		super(message);
	}

	public XmiRepositoryException(Throwable cause) {
		super(cause);
	}

	public XmiRepositoryException(String message, Throwable cause) {
		super(message, cause);
	}

}
