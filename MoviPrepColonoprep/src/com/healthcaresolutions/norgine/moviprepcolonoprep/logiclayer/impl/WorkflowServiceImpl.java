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
			throw new NoConfigFoundException("Keine Config für den Ablauf gefunden!");
		}
	}

	@Override
	public ArrayList<Step> getAllSteps() throws DBAccessException {
		
		steps = db.getWorkflow();
		
		return steps;
	}


	@Override
	public void updateWorklow(Appointment a) throws DBAccessException {
		// Ablaufplan von DB laden
		steps = db.getWorkflow();
		
		// Ablaufplan von der Config laden
		ArrayList<Step> configSteps = cr.getWorkflowSteps();
		
		// TODO Anhand der Zeitdaten aus der Config (configSteps), die Objekte der DB (steps) aktualisieren 
		
	}

}
