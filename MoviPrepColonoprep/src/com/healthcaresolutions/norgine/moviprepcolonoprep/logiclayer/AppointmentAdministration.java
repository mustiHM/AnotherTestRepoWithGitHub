package com.healthcaresolutions.norgine.moviprepcolonoprep.logiclayer;

import com.healthcaresolutions.norgine.moviprepcolonoprep.common.Appointment;

/**
 * Bietet Services zum Verwalten des Untersuchungstermins an
 */
public interface AppointmentAdministration {
	
	/**
	 * Speichert einen Untersuchungstermin in der Datenbank ab.
	 * @param a der Untersuchungstermin
	 */
	public void addAppointment(Appointment a);

	/**
	 * Aktualisiert die Daten eines Untersuchungstermins.
	 * @param a der neue Untersuchungstermin
	 * @throws Exception falls vorher keine Daten gespeichert waren
	 */
	public void updateAppointment(Appointment a) throws Exception;
	
	/**
	 * Löscht den gespeicherten Untersuchungstermin
	 * @throws Exception falls kein Datensatz zum Löschen existiert.
	 */
	public void deleteAppointment() throws Exception;
}
