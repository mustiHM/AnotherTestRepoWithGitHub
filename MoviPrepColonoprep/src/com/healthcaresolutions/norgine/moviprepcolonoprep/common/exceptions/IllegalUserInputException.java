package com.healthcaresolutions.norgine.moviprepcolonoprep.common.exceptions;

/**
 * Exception die geworfen wird, falls der User ung�ltige Daten eingibt
 */
public class IllegalUserInputException extends Exception {

	public IllegalUserInputException(String msg){
		super(msg);
	}
	
}
