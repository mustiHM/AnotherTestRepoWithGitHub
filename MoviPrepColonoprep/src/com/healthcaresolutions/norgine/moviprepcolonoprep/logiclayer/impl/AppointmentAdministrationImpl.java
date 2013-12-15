package com.healthcaresolutions.norgine.moviprepcolonoprep.logiclayer.impl;

import android.content.Context;

import com.healthcaresolutions.norgine.moviprepcolonoprep.common.Appointment;
import com.healthcaresolutions.norgine.moviprepcolonoprep.common.exceptions.IllegalUserInputException;
import com.healthcaresolutions.norgine.moviprepcolonoprep.datalayer.DBAccessor;
import com.healthcaresolutions.norgine.moviprepcolonoprep.datalayer.impl.DBAccessorImpl;
import com.healthcaresolutions.norgine.moviprepcolonoprep.logiclayer.AppointmentAdministration;

/**
 * Diese Implementierung ermöglicht noch KEINE Synchronisierung mit dem Android Kalender.
 * Sprengt den Umfang des Prototypen!
 */
public class AppointmentAdministrationImpl implements AppointmentAdministration {

	private DBAccessor db;
	private Context context;
	
	public AppointmentAdministrationImpl(Context context){
		this.context = context;
		db = new DBAccessorImpl(context);
	}
	
	@Override
	public boolean addAppointment(Appointment a) throws Exception{
		
		if(a != null){
			return db.insertAppointment(a);
		}
		else{
			throw new IllegalUserInputException("Der eingegebene Termin ist ungültig!");
		}

	}

	@Override
	public boolean updateAppointment(Appointment a) throws Exception {
		
		if(a != null){
			Appointment old = db.getAppointment();
			a.setId(old.getId());
			return db.updateAppointment(a);
		}
		else{
			throw new IllegalUserInputException("Der eingegebene Termin ist ungültig!");
		}
	}

	@Override
	public boolean deleteAppointment() throws Exception {
		
		return db.deleteAppointment();

	}

	@Override
	public Appointment getAppointment() throws Exception {
		return db.getAppointment();
		}

}
