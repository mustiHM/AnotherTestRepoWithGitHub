package com.healthcaresolutions.norgine.moviprepcolonoprep.datalayer;

import java.util.ArrayList;

import com.healthcaresolutions.norgine.moviprepcolonoprep.common.Medicine;
import com.healthcaresolutions.norgine.moviprepcolonoprep.common.Step;

/** 
 * Stellt Services zum Einlesen und Weiterverarbeiten der Konfig dar.
 * 
 */
public interface ConfigReader {

	/**
	 * Liest die Workflow-Konfig ein und gibt eine Liste mit Step-Objekten zur�ck.
	 * @return eine ArrayList mit Ablaufsschritten
	 */
	public ArrayList<Step> getWorkflowSteps();
	
	
	/**
	 * Liest die Medizin-Konfig ein und gibt ein Java Objekt zur�ck.
	 * @return das Medikament
	 */
	public Medicine getMedicine();
	
}
