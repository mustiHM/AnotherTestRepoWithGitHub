package com.healthcaresolutions.norgine.moviprepcolonoprep.logiclayer;

import java.sql.Timestamp;
import java.util.ArrayList;

import com.healthcaresolutions.norgine.moviprepcolonoprep.common.Appointment;
import com.healthcaresolutions.norgine.moviprepcolonoprep.common.Step;

/**
 * Bietet einen Dienst, der sich um die gesamten Ablauf der App k�mmert.
 * Muss thread-�hnlich implementiert werden, zwecks Parallellauff�higkeit.
 */
public interface WorkflowService {
	
	/**
	 * Generiert anhand des Untersuchungstermins einen vollst�ndigen Ablaufplan.
	 * Wird kein Termin mitgegeben, wird ein Ablaufplan ohne Zeitangaben erstellt.
	 * Wurde ein Termin gespeichert, werden die Ablaufschritte aus der DB mit einem Zeitstempel versehen.
	 * Der Ablaufplan selber wird vom ConfigReader vorher eingelesen.
	 * @param a der Untersuchungstermin
	 */
	public void generateWorkflow(Appointment a);
	
	/**
	 * Liefert den gesamten Ablaufplan.
	 * @return Ablaufplan in Form einer ArrayList
	 */
	public ArrayList<Step> getAllSteps();
	
	/**
	 * Liefert den n�chsten Vorbereitungsschritt.
	 * Bekommt von der DB den gesamten Plan und muss selbstst�ndig den n�chsten w�hlen.
	 * @param t der aktuelle Zeitstempel, kann mit new Timestamp(System.currentTimeMillis() ermittelt werden
	 * @return der n�chste Vorbereitungsschritt
	 */
	public Step getNextStep(Timestamp t);

}
