package com.healthcaresolutions.norgine.moviprepcolonoprep.datalayer.impl;

import java.util.ArrayList;

import com.healthcaresolutions.norgine.moviprepcolonoprep.common.Appointment;
import com.healthcaresolutions.norgine.moviprepcolonoprep.common.Patient;
import com.healthcaresolutions.norgine.moviprepcolonoprep.common.Step;
import com.healthcaresolutions.norgine.moviprepcolonoprep.common.UserNotification;
import com.healthcaresolutions.norgine.moviprepcolonoprep.common.exceptions.DBAccessException;
import com.healthcaresolutions.norgine.moviprepcolonoprep.datalayer.DBAccessor;

public class DBAccessorImpl implements DBAccessor {

	public DBAccessorImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean insertAppointment(Appointment a) throws DBAccessException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Appointment getAppointment() throws DBAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateAppointment(Appointment a) throws DBAccessException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteAppointment() throws DBAccessException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insertPatientInformation(Patient p) throws DBAccessException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updatePatientInformation(Patient p) throws DBAccessException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Patient getPatientInformation() throws DBAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insertNotification(UserNotification n)
			throws DBAccessException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateNotification(UserNotification n)
			throws DBAccessException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<UserNotification> getNotifications(boolean onlyOpen)
			throws DBAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean saveWorkflow(ArrayList<Step> workflow)
			throws DBAccessException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Step> getWorkflow() throws DBAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteWorkflow() throws DBAccessException {
		// TODO Auto-generated method stub

	}

}
