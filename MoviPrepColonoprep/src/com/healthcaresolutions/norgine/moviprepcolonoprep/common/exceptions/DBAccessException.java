package com.healthcaresolutions.norgine.moviprepcolonoprep.common.exceptions;

/**
 * Exception falls es Probleme mit der DB gibt.
 */
public class DBAccessException extends Exception {

	public DBAccessException() {
		super();
	}

	public DBAccessException(String detailMessage) {
		super(detailMessage);
	}

}
