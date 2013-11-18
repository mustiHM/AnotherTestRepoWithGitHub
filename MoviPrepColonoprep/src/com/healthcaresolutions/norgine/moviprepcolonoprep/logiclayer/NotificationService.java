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
	public void notificateUser(UserNotification n);
	
	
	/**
	 * Speichert eine Benachrichtigung in die DB
	 * @param n die zu speichernde Benachrichtigung
	 */
	public void addNotification(UserNotification n);
	
	
	/**
	 * Aktualisiert eine Benachrichtigung in der Datenbank
	 * @param n die zu aktualisierende Benachrichtigung
	 */
	public void updateNotification(UserNotification n);
	
	
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
