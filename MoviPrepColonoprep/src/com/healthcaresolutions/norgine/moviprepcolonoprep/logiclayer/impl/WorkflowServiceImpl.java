package com.healthcaresolutions.norgine.moviprepcolonoprep.logiclayer.impl;

import java.sql.Timestamp;
import java.util.ArrayList;

import com.healthcaresolutions.norgine.moviprepcolonoprep.common.Appointment;
import com.healthcaresolutions.norgine.moviprepcolonoprep.common.Step;
import com.healthcaresolutions.norgine.moviprepcolonoprep.common.exceptions.DBAccessException;
import com.healthcaresolutions.norgine.moviprepcolonoprep.common.exceptions.NoConfigFoundException;
import com.healthcaresolutions.norgine.moviprepcolonoprep.datalayer.ConfigReader;
import com.healthcaresolutions.norgine.moviprepcolonoprep.datalayer.DBAccessor;
import com.healthcaresolutions.norgine.moviprepcolonoprep.logiclayer.WorkflowService;

public class WorkflowServiceImpl extends Thread implements WorkflowService {

	private ConfigReader cr;
	private DBAccessor db;
	private ArrayList<Step> steps;
	
	@Override
	public void generateWorkflow() throws NoConfigFoundException, DBAccessException{
		
		// Ablaufplan von der Config einlesen
		steps = cr.getWorkflowSteps();
		
		if(steps != null){
			// Ablauf in DB eintragen
			db.saveWorkflow(steps);
		}
		else {
			// falls keine Steps vorhanden
			throw new NoConfigFoundException("Keine Config f�r den Ablauf gefunden!");
		}
	}

	@Override
	public ArrayList<Step> getAllSteps() throws DBAccessException {
		
		steps = db.getWorkflow();
		
		return steps;
	}


	@Override
	public void updateWorklow(Appointment a) throws DBAccessException {
		// Ablaufplan von der Config laden
		steps = cr.getWorkflowSteps();
		
		// TODO Anhand des Termins die Objekte aus steps aktualisieren 
		
		// da es bei Updates der App passieren kann, dass der Ablaufplan sich �ndert, m�ssen vorherige Ablaufpl�ne gel�scht werden
		db.deleteWorkflow();
		
		for (Step step : steps) {
			int seperator = step.getTime().indexOf(":");
			String s = step.getTime().substring(0, seperator-1); // -1, damit das ":" nicht dabei ist
			int hour = Integer.parseInt(s);
			s = step.getTime().substring(seperator+1); // +1, damit das ":" nicht dabei ist
			int min = Integer.parseInt(s);
			// dieser Konstruktor ist zwar veraltet, aber f�r unseren Zweck perfekt
			step.setTimestamp(new Timestamp(a.getYear(), a.getMonth(), a.getDay()-step.getDaysBefore(), hour, min, 0, 0));
		}
		
	}

}
