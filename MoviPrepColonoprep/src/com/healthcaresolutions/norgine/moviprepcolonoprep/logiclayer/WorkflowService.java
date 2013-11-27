package com.healthcaresolutions.norgine.moviprepcolonoprep.logiclayer;

import java.sql.Timestamp;
import java.util.ArrayList;

import com.healthcaresolutions.norgine.moviprepcolonoprep.common.Appointment;
import com.healthcaresolutions.norgine.moviprepcolonoprep.common.Step;
import com.healthcaresolutions.norgine.moviprepcolonoprep.common.exceptions.DBAccessException;
import com.healthcaresolutions.norgine.moviprepcolonoprep.common.exceptions.NoConfigFoundException;

/**
 * Bietet einen Dienst, der sich um die gesamten Ablauf der App kümmert.
 * Muss thread-ähnlich implementiert werden, zwecks Parallellauffähigkeit.
 */
public interface WorkflowService extends Runnable{
	
	/**
	 * Generiert einen vollständigen Ablaufplan ohne Zeitangaben und speichert diesen in die DB.
	 * Der Ablaufplan selber wird vom ConfigReader vorher eingelesen.
	 * @throws NoConfigFoundException falls keine Config gefunden wird.
	 * @throws DBAccessException falls es Probleme mit der DB gibt.
	 */
	public void generateWorkflow() throws NoConfigFoundException, DBAccessException;
	
	/**
	 * Aktualisiert alle Ablaufschritte aus der DB mit den passenden Zeitstempeln.
	 * @param a der Untersuchungstermin
	 * @throws NoConfigFoundException falls keine Config gefunden wird.
	 * @throws DBAccessException falls es Probleme mit der DB gibt.
	 */
	public void updateWorklow(Appointment a) throws NoConfigFoundException, DBAccessException;
	
	/**
	 * Liefert den gesamten Ablaufplan.
	 * @return Ablaufplan in Form einer ArrayList
	 * @throws DBAccessException falls es Probleme mit der DB gibt.
	 */
	public ArrayList<Step> getAllSteps() throws DBAccessException;
	

}
