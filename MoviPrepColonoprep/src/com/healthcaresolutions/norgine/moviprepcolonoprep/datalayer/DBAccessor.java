package com.healthcaresolutions.norgine.moviprepcolonoprep.datalayer;

import java.util.ArrayList;

import com.healthcaresolutions.norgine.moviprepcolonoprep.common.Appointment;
import com.healthcaresolutions.norgine.moviprepcolonoprep.common.Patient;
import com.healthcaresolutions.norgine.moviprepcolonoprep.common.Step;
import com.healthcaresolutions.norgine.moviprepcolonoprep.common.UserNotification;

/**
 * Ermöglicht den Zugriff auf die Datenbank
 */
public interface DBAccessor {

	/**
	 * Speichert einen Termin in die DB.
	 * @param a der Termin
	 * @return gibt an ob die Aktion erfolgreich war oder nicht
	 * @throws Exception falls ein DB Problem auftritt
	 */
	public boolean insertAppointment(Appointment a) throws Exception;
	
	/**
	 * Gibt einen Termin aus der DB zurück
	 * @return einen Termin
	 * @throws Exception falls ein DB Problem auftritt
	 */
	public Appointment getAppointment() throws Exception;
	
	
	/**
	 * Aktualisiert einen Termin in der DB
	 * @param a der Termin
	 * @return gibt an ob die Aktion erfolgreich war oder nicht
	 * @throws Exception falls ein DB Problem auftritt
	 */
	public boolean updateAppointment(Appointment a) throws Exception;
	
	/**
	 * Löscht einen Termin aus der DB
	 * @return gibt an ob die Aktion erfolgreich war oder nicht
	 * @throws Exception falls ein DB Problem auftritt
	 */
	public boolean deleteAppointment() throws Exception;
	
	
	/**
	 * Speichert Patientendaten in die DB
	 * @param p die Patientendaten
	 * @return gibt an ob die Aktion erfolgreich war oder nicht
	 * @throws Exception falls ein DB Problem auftritt
	 */
	public boolean insertPatientInformation(Patient p) throws Exception;
	
	/**
	 * Aktualisiert die Patienteninfos in der DB
	 * @param p die Patientendaten
	 * @return gibt an ob die Aktion erfolgreich war oder nicht
	 * @throws Exception falls ein DB Problem auftritt
	 */
	public boolean updatePatientInformation(Patient p) throws Exception;
	
	/**
	 * Liefert alle Patientendaten aus der DB
	 * @return gespeicherte Patientendaten
	 * @throws Exception falls ein DB Problem auftritt
	 */
	public Patient getPatientInformation() throws Exception;
	
	/**
	 * Speichert eine Benachrichtigung in die DB
	 * @param n die zu speichernde Benachrichtigung
	 * @return gibt an ob die Aktion erfolgreich war oder nicht
	 * @throws Exception falls ein DB Problem auftritt
	 */
	public boolean insertNotification(UserNotification n) throws Exception;
	
	/**
	 * Aktualisiert eine Benachrichtigung in der DB
	 * @param n die zu speichernde Benachrichtigung
	 * @return gibt an ob die Aktion erfolgreich war oder nicht
	 * @throws Exception falls ein DB Problem auftritt
	 */
	public boolean updateNotification(UserNotification n) throws Exception;
	
	/**
	 * Gibt Benachrichtigungen aus der DB zurück
	 * @param onlyOpen gibt an, ob nur neue oder alle Benachrichtigungen zurückgegeben werden sollen.
	 * @return Benachrichtigungen
	 * @throws Exception falls ein DB Problem auftritt
	 */
	public ArrayList<UserNotification> getNotifications(boolean onlyOpen) throws Exception;
	
	/**
	 * Speichert den Ablaufplan in die Datenbank
	 * @param workflow der Ablaufplan
	 * @return gibt an ob die Aktion erfolgreich war oder nicht
	 * @throws Exception falls ein DB Problem auftritt
	 */
	public boolean saveWorkflow(ArrayList<Step> workflow) throws Exception;
	
	/**
	 * Gibt den gesamten Ablaufplan aus der DB zurück
	 * @return den Ablaufplan
	 * @throws Exception falls ein DB Problem auftritt
	 */
	public ArrayList<Step> getWorkflow() throws Exception;
	
}
