package com.healthcaresolutions.norgine.moviprepcolonoprep.common.exceptions;

/**
 * Exception falls keine Config gefunden wird
 */
public class NoConfigFoundException extends Exception {

	public NoConfigFoundException() {
		super();
	}

	public NoConfigFoundException(String detailMessage) {
		super(detailMessage);
	}

}
