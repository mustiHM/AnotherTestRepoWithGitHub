package com.healthcaresolutions.norgine.moviprepcolonoprep.datalayer.impl;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.healthcaresolutions.norgine.moviprepcolonoprep.common.Appointment;
import com.healthcaresolutions.norgine.moviprepcolonoprep.common.Patient;
import com.healthcaresolutions.norgine.moviprepcolonoprep.common.Status;
import com.healthcaresolutions.norgine.moviprepcolonoprep.common.Step;
import com.healthcaresolutions.norgine.moviprepcolonoprep.common.UserNotification;
import com.healthcaresolutions.norgine.moviprepcolonoprep.common.exceptions.DBAccessException;
import com.healthcaresolutions.norgine.moviprepcolonoprep.datalayer.DBAccessor;

public class DBAccessorImpl extends SQLiteOpenHelper implements DBAccessor {

	public final static String TAG = DBAccessorImpl.class.getSimpleName();
	
	public DBAccessorImpl(Context context) {
		super(context, "colonoprep", null, 1);
	}

	@Override
	public boolean insertAppointment(Appointment a) throws DBAccessException {
		try
		{
			ContentValues insertValues = new ContentValues();
			insertValues.put("id", a.getId());
			insertValues.put("hospital", a.getHospital());
			insertValues.put("year", a.getYear());
			insertValues.put("month", a.getMonth());
			insertValues.put("day", a.getDay());
			insertValues.put("hour", a.getHour());
			insertValues.put("min", a.getMin());
			getWritableDatabase().insert("appointments", null, insertValues);
		}catch(Exception ex)
		{
			throw new DBAccessException(ex.getMessage());
		}
		//succes
		return true;
	}

	@Override
	//TODO HOW DOES THIS WORK????
	public Appointment getAppointment(int id) throws DBAccessException {
		Appointment a  = null;
		try{
			// hier werden alle Spalten der DB Tabelle angegeben
			String[] dbColumns = new String[]{"id as _id", "hospital", "year", "month", "day", "hour", "min"};
			// die Methode query bekommt als ersten Parameter die Tabelle, dann die Spalten von oben, dann ein mögliches where statement und den rest null objekte, da keine sortierung wichtig
			Cursor c = getReadableDatabase().query("appointments", dbColumns, null, null, null, null, null, null);
			if(c.getCount()>0){
				String x = null;
			}
		}catch(Exception ex)
		{
			throw new DBAccessException(ex.getMessage());
		}
		return a;
	}

	@Override
	public boolean updateAppointment(Appointment a) throws DBAccessException {
		try{
			ContentValues updateValues = new ContentValues();
			updateValues.put("id", a.getId());
			updateValues.put("hospital", a.getHospital());
			updateValues.put("year", a.getYear());
			updateValues.put("month", a.getMonth());
			updateValues.put("day", a.getDay());
			updateValues.put("hour", a.getHour());
			updateValues.put("min", a.getMin());
			getWritableDatabase().update("appointments", updateValues, "id" + "=" + a.getId(), null);
		}catch(Exception ex)
		{
			throw new DBAccessException(ex.toString());
		}
		return true;
	}

	@Override
	public boolean deleteAppointment(Appointment a) throws DBAccessException {
		try
		{
			getWritableDatabase().delete("appointments", "id=" + a.getId(), null);
		}
		catch (Exception ex)
		{
			throw new DBAccessException(ex.toString());
		}
		return true;
	}

	@Override
	public boolean insertPatientInformation(Patient p) throws DBAccessException {
		try
		{
			ContentValues insertValues = new ContentValues();
			insertValues.put("id", p.getId());
			insertValues.put("age", p.getAge());
			insertValues.put("country", p.getCountry());
			insertValues.put("city", p.getCity());
			getWritableDatabase().insert("patients", null, insertValues);
		}catch(Exception ex)
		{
			throw new DBAccessException(ex.getMessage());
		}
		//succes
		return true;
	}

	@Override
	public boolean updatePatientInformation(Patient p) throws DBAccessException {
		try{
			ContentValues updateValues = new ContentValues();
			updateValues.put("id", p.getId());
			updateValues.put("age", p.getAge());
			updateValues.put("country", p.getCountry());
			updateValues.put("city", p.getCity());
			getWritableDatabase().update("patients", updateValues, "id" + "=" + p.getId(), null);
		}catch(Exception ex)
		{
			throw new DBAccessException(ex.toString());
		}
		return true;
	}

	@Override
	public Patient getPatientInformation(int id) throws DBAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insertNotification(UserNotification n)
			throws DBAccessException {
		try
		{
			ContentValues insertValues = new ContentValues();
			insertValues.put("id", n.getId());
			insertValues.put("title", n.getTitle());
			insertValues.put("description", n.getDescribtion());
			insertValues.put("time", n.getTime());
			insertValues.put("link", n.getLink());
			getWritableDatabase().insert("notifications", null, insertValues);
		}catch(Exception ex)
		{
			throw new DBAccessException(ex.getMessage());
		}
		return true;
	}

	@Override
	public boolean updateNotification(UserNotification n)
			throws DBAccessException {
		try{
			ContentValues updateValues = new ContentValues();
			updateValues.put("id", n.getId());
			updateValues.put("title", n.getTitle());
			updateValues.put("description", n.getDescribtion());
			updateValues.put("time", n.getTime());
			updateValues.put("link", n.getLink());
			getWritableDatabase().update("patients", updateValues, "id" + "=" + n.getId(), null);
		}catch(Exception ex)
		{
			throw new DBAccessException(ex.toString());
		}
		return true;
	}

	@Override
	public ArrayList<UserNotification> getNotifications(boolean onlyOpen)
			throws DBAccessException {
		// TODO Get where open is set on 1!!
		return null;
	}

	@Override
	public boolean saveWorkflow(ArrayList<Step> workflow)
			throws DBAccessException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Step> getWorkflow(int id) throws DBAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteWorkflow() throws DBAccessException {
		// TODO Auto-generated method stub

	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// erstellen der tabellen
		// wird nur bei der ersten nutzung der app aufgerufen
				
				db.execSQL("CREATE TABLE workflows (" + 
						"id INTEGER PRIMARY KEY AUTOINCREMENT," +
						"Step TEXT);");
						
				Log.i(TAG, "workflows tabelle erstellt");
				
				db.execSQL("CREATE TABLE products (" +
						"name TEXT PRIMARY KEY,"+
						"description TEXT,"+
						"producer TEXT);");
				
				Log.i(TAG, "products tabelle erstellt");
				
				db.execSQL("CREATE TABLE patients (" +
						"id INTEGER PRIMARY KEY,"+
						"age INTEGER,"+
						"country TEXT,"+
						"city TEXT);");
				
				Log.i(TAG, "patienten tabelle erstellt");
				
				db.execSQL("CREATE TABLE appointments (" +
						"id INTEGER PRIMARY,"+
						"hospital TEXT," +
						"year INTEGER," +
						"month INTEGER," +
						"day INTEGER,"+
						"hour INTEGER,"+
						"min INTEGER);");
				
				Log.i(TAG, "appointments tabelle erstellt");
				
				db.execSQL("CREATE TABLE notifications (" +
						"id INTEGER PRIMARY,"+
						"title TEXT," +
						"description TEXT," +
						"time INTEGER," +
						"link TEXT,"+
						"open INTEGER DEFAULT 0);");
				
				Log.i(TAG, "notifications tabelle erstellt");
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}
}
