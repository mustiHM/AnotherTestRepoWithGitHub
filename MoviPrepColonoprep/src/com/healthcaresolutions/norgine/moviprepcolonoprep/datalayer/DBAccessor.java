package com.healthcaresolutions.norgine.moviprepcolonoprep.datalayer;

import java.util.ArrayList;

import com.healthcaresolutions.norgine.moviprepcolonoprep.common.Appointment;
import com.healthcaresolutions.norgine.moviprepcolonoprep.common.Patient;
import com.healthcaresolutions.norgine.moviprepcolonoprep.common.Step;
import com.healthcaresolutions.norgine.moviprepcolonoprep.common.UserNotification;
import com.healthcaresolutions.norgine.moviprepcolonoprep.common.exceptions.DBAccessException;

/**
 * Ermöglicht den Zugriff auf die Datenbank
 */
public interface DBAccessor {

	/**
	 * Speichert einen Termin in die DB.
	 * @param a der Termin
	 * @return gibt an ob die Aktion erfolgreich war oder nicht
	 * @throws DBAccessException falls ein DB Problem auftritt
	 */
	public boolean insertAppointment(Appointment a) throws DBAccessException;
	
	/**
	 * Gibt einen Termin aus der DB zurück
	 * @return einen Termin
	 * @throws DBAccessException falls ein DB Problem auftritt
	 */
	public Appointment getAppointment() throws DBAccessException;
	
	
	/**
	 * Aktualisiert einen Termin in der DB
	 * @param a der Termin
	 * @return gibt an ob die Aktion erfolgreich war oder nicht
	 * @throws DBAccessException falls ein DB Problem auftritt
	 */
	public boolean updateAppointment(Appointment a) throws DBAccessException;
	
	/**
	 * Löscht einen Termin aus der DB
	 * @return gibt an ob die Aktion erfolgreich war oder nicht
	 * @throws DBAccessException falls ein DB Problem auftritt
	 */
	public boolean deleteAppointment() throws DBAccessException;
	
	
	/**
	 * Speichert Patientendaten in die DB
	 * @param p die Patientendaten
	 * @return gibt an ob die Aktion erfolgreich war oder nicht
	 * @throws DBAccessException falls ein DB Problem auftritt
	 */
	public boolean insertPatientInformation(Patient p) throws DBAccessException;
	
	/**
	 * Aktualisiert die Patienteninfos in der DB
	 * @param p die Patientendaten
	 * @return gibt an ob die Aktion erfolgreich war oder nicht
	 * @throws DBAccessException falls ein DB Problem auftritt
	 */
	public boolean updatePatientInformation(Patient p) throws DBAccessException;
	
	/**
	 * Liefert alle Patientendaten aus der DB
	 * @return gespeicherte Patientendaten
	 * @throws DBAccessException falls ein DB Problem auftritt
	 */
	public Patient getPatientInformation() throws DBAccessException;
	
	/**
	 * Speichert eine Benachrichtigung in die DB
	 * @param n die zu speichernde Benachrichtigung
	 * @return gibt an ob die Aktion erfolgreich war oder nicht
	 * @throws DBAccessException falls ein DB Problem auftritt
	 */
	public boolean insertNotification(UserNotification n) throws DBAccessException;
	
	/**
	 * Aktualisiert eine Benachrichtigung in der DB
	 * @param n die zu speichernde Benachrichtigung
	 * @return gibt an ob die Aktion erfolgreich war oder nicht
	 * @throws DBAccessException falls ein DB Problem auftritt
	 */
	public boolean updateNotification(UserNotification n) throws DBAccessException;
	
	/**
	 * Gibt Benachrichtigungen aus der DB zurück
	 * @param onlyOpen gibt an, ob nur neue oder alle Benachrichtigungen zurückgegeben werden sollen.
	 * @return Benachrichtigungen
	 * @throws DBAccessException falls ein DB Problem auftritt
	 */
	public ArrayList<UserNotification> getNotifications(boolean onlyOpen) throws DBAccessException;
	
	/**
	 * Speichert den Ablaufplan in die Datenbank.
	 * Löscht vorher den bestehenden Ablaufplan.
	 * @param workflow der Ablaufplan
	 * @return gibt an ob die Aktion erfolgreich war oder nicht
	 * @throws DBAccessException falls ein DB Problem auftritt
	 */
	public boolean saveWorkflow(ArrayList<Step> workflow) throws DBAccessException;
	
	/**
	 * Gibt den gesamten Ablaufplan aus der DB zurück
	 * @return den Ablaufplan
	 * @throws DBAccessException falls ein DB Problem auftritt
	 */
	public ArrayList<Step> getWorkflow() throws DBAccessException;
	
}
