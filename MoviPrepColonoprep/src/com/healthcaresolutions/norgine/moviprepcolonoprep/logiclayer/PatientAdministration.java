package com.healthcaresolutions.norgine.moviprepcolonoprep.logiclayer;

import com.healthcaresolutions.norgine.moviprepcolonoprep.common.Patient;

/**
 * Bietet Dienste zum Verwalten eines Patienten an.
 */
public interface PatientAdministration {

	/**
	 * Speichert Daten des Patienten ab.
	 * @param p die Daten des Patienten
	 * @throws Exception falls Daten fehlerhaft
	 */
	public void insertInformation(Patient p) throws Exception;
	
	
	/**
	 * Aktualisiert die Patientendaten.
	 * @param p die Daten des Patienten
	 * @throws Exception falls Daten fehlerhaft
	 */
	public void updateInformation(Patient p) throws Exception;
	
	
	/**
	 * Gibt die Daten des Patienten zurück.
	 * @return die Daten des Patienten
	 */
	public Patient getInformation();
}
