package com.healthcaresolutions.norgine.moviprepcolonoprep.logiclayer;

import java.util.ArrayList;

import com.healthcaresolutions.norgine.moviprepcolonoprep.common.UserNotification;

/**
 * Bietet Dienste zum Verwalten von Benachrichtigungen an.
 */
public interface NotificationService {
	
	/**
	 * Schickt eine Benachrichtigung an den Nutzer
	 * @param n die Benachrichtigung die verschickt werden soll
	 */
	public void notifyUser(UserNotification n);
	
	
	/**
	 * Speichert eine Benachrichtigung in die DB
	 * @param n die zu speichernde Benachrichtigung
	 * @return gibt an ob die Aktion erfolgreich war oder nicht
	 * @throws falls DB Probleme
	 */
	public boolean addNotification(UserNotification n) throws Exception;
	
	
	/**
	 * Aktualisiert eine Benachrichtigung in der Datenbank
	 * @param n die zu aktualisierende Benachrichtigung
	 * @return gibt an ob die Aktion erfolgreich war oder nicht
	 * @throws falls DB Probleme
	 */
	public boolean updateNotification(UserNotification n) throws Exception;
	
	
	/**
	 * Gibt alle Benachrichtigungen zurück
	 * @return eine Liste mit allen Benachrichtigungen
	 */
	public ArrayList<UserNotification> getAllNotifications();
	
	
	/**
	 * Gibt alle noch offenen Benachrichtigungen zurück
	 * @return eine Liste mit offenen Benachrichtigungen
	 */
	public ArrayList<UserNotification> getAllOpenNotifications();

}
