package com.healthcaresolutions.norgine.moviprepcolonoprep.logiclayer;

import com.healthcaresolutions.norgine.moviprepcolonoprep.common.Appointment;

/**
 * Bietet Services zum Verwalten des Untersuchungstermins an
 */
public interface AppointmentAdministration {
	
	/**
	 * Speichert einen Untersuchungstermin im Android-Kalender und in der DB ab.
	 * @param a der Untersuchungstermin
	 * @return gibt an ob die Aktion erfolgreich war oder nicht
	 * @throws Exception falls Daten ungültig
	 */
	public boolean addAppointment(Appointment a) throws Exception;

	/**
	 * Aktualisiert die Daten eines Untersuchungstermins.
	 * @param a der neue Untersuchungstermin
	 * @return gibt an ob die Aktion erfolgreich war oder nicht
	 * @throws Exception falls vorher keine Daten gespeichert waren
	 */
	public boolean updateAppointment(Appointment a) throws Exception;
	
	/**
	 * Löscht den gespeicherten Untersuchungstermin
	 * @return gibt an ob die Aktion erfolgreich war oder nicht
	 * @throws Exception falls kein Datensatz zum Löschen existiert.
	 */
	public boolean deleteAppointment() throws Exception;
	
	public Appointment getAppointment() throws Exception;
}
