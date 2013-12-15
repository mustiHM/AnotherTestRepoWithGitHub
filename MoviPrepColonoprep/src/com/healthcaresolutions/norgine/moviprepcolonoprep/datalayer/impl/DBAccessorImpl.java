package com.healthcaresolutions.norgine.moviprepcolonoprep.datalayer.impl;

import java.sql.Timestamp;
import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
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
	// Parameter ID entfernt, da es nur einen einzigen Appointment in der DB gibt
	public Appointment getAppointment() throws DBAccessException {
		Appointment a  = null;
		try{
			// hier werden alle Spalten der DB Tabelle angegeben
			String[] dbColumns = new String[]{"id", "hospital", "year", "month", "day", "hour", "min"};
			// die Methode query bekommt als ersten Parameter die Tabelle, dann die Spalten von oben, dann ein mögliches where statement und den rest null objekte, da keine sortierung wichtig
			Cursor c = getReadableDatabase().query("appointments", dbColumns, null, null, null, null, null, null);
			if(c.getCount()>0){
				c.moveToFirst();
				a = new Appointment();
				a.setId(c.getInt(c.getColumnIndex("id")));
				a.setHospital(c.getString(c.getColumnIndex("hospital")));
				a.setYear(c.getInt(c.getColumnIndex("year")));
				a.setMonth(c.getInt(c.getColumnIndex("month")));
				a.setDay(c.getInt(c.getColumnIndex("day")));
				a.setHour(c.getInt(c.getColumnIndex("hour")));
				a.setMin(c.getInt(c.getColumnIndex("min")));
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
	public boolean deleteAppointment() throws DBAccessException {
		//TODO Paremeter ID entfernt, da es nur einen Appointment in der DB gibt.
		try
		{
			getWritableDatabase().delete("appointments", null, null);
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
		Patient a  = null;
		try{
			// hier werden alle Spalten der DB Tabelle angegeben
			String[] dbColumns = new String[]{"id", "age", "country", "city"};
			// die Methode query bekommt als ersten Parameter die Tabelle, dann die Spalten von oben, dann ein mögliches where statement und den rest null objekte, da keine sortierung wichtig
			Cursor c = getReadableDatabase().query("patients", dbColumns, "id=" + id, null, null, null, null, null);
			if(c.getCount()>0){
				c.moveToFirst();
				a = new Patient();
				a.setId(c.getInt(c.getColumnIndex("id")));
				a.setAge(c.getInt(c.getColumnIndex("age")));
				a.setCountry(c.getString(c.getColumnIndex("country")));
				a.setCity(c.getString(c.getColumnIndex("city")));
			}
		}catch(Exception ex)
		{
			throw new DBAccessException(ex.getMessage());
		}
		return a;
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
			if (n.getStatus() == Status.DONE) 
			{
				insertValues.put("status", 1);
			}
			else
			{
				insertValues.put("status",0);
			}
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
			if (n.getStatus() == Status.DONE) 
			{
				updateValues.put("status", 1);
			}
			else
			{
				updateValues.put("status",0);
			}
			getWritableDatabase().update("notifications", updateValues, "id" + "=" + n.getId(), null);
		}catch(Exception ex)
		{
			throw new DBAccessException(ex.toString());
		}
		return true;
	}

	@Override
	public ArrayList<UserNotification> getNotifications(boolean onlyOpen)
			throws DBAccessException {
		ArrayList<UserNotification> n  = new ArrayList<UserNotification>();
		try{
			// hier werden alle Spalten der DB Tabelle angegeben
			String[] dbColumns = new String[]{"id", "title", "description", "time", "link", "open"};
			// die Methode query bekommt als ersten Parameter die Tabelle, dann die Spalten von oben, dann ein mögliches where statement und den rest null objekte, da keine sortierung wichtig
			String where = null;
			if (onlyOpen) where = "open=1";
			Cursor c = getReadableDatabase().query("notifications", dbColumns, where, null, null, null, null, null);
			if(c.getCount()>0){
				c.moveToFirst();
				for (int counter = 0; counter < c.getCount(); counter++) {
					UserNotification a = new UserNotification();
					a.setId(c.getInt(c.getColumnIndex("id")));
					a.setTitle(c.getString(c.getColumnIndex("title")));
					a.setDescribtion(c.getString(c.getColumnIndex("description")));
					a.setTime(c.getInt(c.getColumnIndex("time")));
					a.setLink(c.getString(c.getColumnIndex("link")));
					if (c.getInt(c.getColumnIndex("status")) == 1)
					{
						a.setStatus(Status.DONE);
					}
					else
					{
						a.setStatus(Status.OPEN);
					}
					n.add(a);
					
					if(c.moveToNext())
						Log.i(TAG, "Position des Cursor aufs nächste Element geschoben");
					else
						Log.i(TAG, "Position konnte nicht verschoben werden, da das letzte Element erreicht wurde!");
				}
			}
		}catch(Exception ex)
		{
			throw new DBAccessException(ex.getMessage());
		}
		return n;
	}

	@Override
	public boolean saveWorkflow(ArrayList<Step> workflow)
			throws DBAccessException {
		deleteWorkflow();
		Log.i("DBAccessorImpl", "Workflow aus DB gelöscht");
		for (Step step: workflow)
		{
			
				/*ContentValues insertValues = new ContentValues();
				insertValues.put("action", step.getAction());
				insertValues.put("amount", step.getAmount());
				insertValues.put("time", step.getTime());
				insertValues.put("days", step.getDaysBefore());
				insertValues.put("timestamp", step.getTimeStamp().toString());
				if (step.getStatus() == Status.DONE) 
				{
					insertValues.put("status", 1);
				}
				else
				{
					insertValues.put("status",0);
				}
				getWritableDatabase().insert("workflow", null, insertValues);*/
				
				SQLiteStatement stmt = getWritableDatabase().compileStatement("INSERT INTO workflow (action, amount, time, days, timestamp, status) VALUES (?,?,?,?,?,?)");
				/*
				 * "action TEXT,"+
						"amount TEXT,"+
						"time TEXT,"+
						"days TEXT,"+
						"timestamp TEXT,"+
						"status TEXT);");
				 */
				stmt.bindString(1, step.getAction());
				if(step.getAmount()==null){
					stmt.bindString(2, "");
				}
				else {
					stmt.bindString(2, step.getAmount());
				}
				stmt.bindString(3, step.getTime());
				stmt.bindString(4, "" + step.getDaysBefore()); // Umwandlung in einen String
				if(step.getTimeStamp()==null){
					stmt.bindString(5, "");
				}
				else{
					stmt.bindString(5, step.getTimeStamp().toString());
				}
				if(step.getStatus()==null){
					stmt.bindString(6, "");
				}
				else {
					stmt.bindString(6, step.getStatus().toString());
				}
				
				
				if(stmt.executeInsert() < 0)
					Log.e(TAG, "Ein Fehler ist beim Speichern des Workflows aufgetreten!");
				else
					Log.i(TAG, "Das Speichern des Workflows war erfolgreich!");
				
				
				stmt.close();
			
		}
		return true;
	}


	@Override
	public void deleteWorkflow() throws DBAccessException {
		try
		{
			getWritableDatabase().delete("workflow", null, null);
		}
		catch (Exception ex)
		{
			throw new DBAccessException(ex.toString());
		}

	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// erstellen der tabellen
		// wird nur bei der ersten nutzung der app aufgerufen
				
				db.execSQL("CREATE TABLE workflow (" + 
						"id INTEGER PRIMARY KEY AUTOINCREMENT," +
						"action TEXT,"+
						"amount TEXT,"+
						"time TEXT,"+
						"days TEXT,"+
						"timestamp TEXT,"+
						"status TEXT);");
						
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
						"id INTEGER PRIMARY KEY,"+
						"hospital TEXT," +
						"year INTEGER," +
						"month INTEGER," +
						"day INTEGER,"+
						"hour INTEGER,"+
						"min INTEGER);");
				
				Log.i(TAG, "appointments tabelle erstellt");
				
				db.execSQL("CREATE TABLE notifications (" +
						"id INTEGER PRIMARY KEY,"+
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

	@Override
	public ArrayList<Step> getWorkflow() throws DBAccessException {
		// TODO habe die ID als Parameter entfernt, da der gesamte Workflow zurückgeliefert werden soll. ID ist deshalb nicht nötig (siehe Javadoc vom Interface)
		
		ArrayList<Step> steps = new ArrayList<Step>();
		
		// alle infos aus der db holen
		String[] dbColumns = new String[]{"id as _id", "action", "amount", "time", "days", "timestamp", "status"};
		Cursor c = getReadableDatabase().query("workflow", dbColumns, null, null, null, null, null, null);
			
		Log.i(TAG, "Query erfolgreich durchgeführt");
		
		if(c.getCount()>0){
			
			c.moveToFirst();
			
			for (int counter = 0; counter < c.getCount(); counter++) {
				
				String action = c.getString(c.getColumnIndex("action"));
				String amount = c.getString(c.getColumnIndex("amount"));
				String time = c.getString(c.getColumnIndex("time"));
				String days = c.getString(c.getColumnIndex("days"));
				String timestamp = c.getString(c.getColumnIndex("timestamp"));
				String status = c.getString(c.getColumnIndex("status"));
				
				Step step = new Step();
				step.setAction(action);
				step.setAmount(amount);
				step.setTime(time);
				step.setDaysBefore(Integer.parseInt(days));
				if(timestamp.equals("")){
					step.setTimestamp(null);
				}
				else {
					step.setTimestamp(Timestamp.valueOf(timestamp));
				}
				if(status.equals(Status.DONE)){
					step.setStatus(Status.DONE);
				}
				else{
					step.setStatus(Status.OPEN);
				}
				
				steps.add(step);
				
				if(c.moveToNext())
					Log.i(TAG, "Position des Cursor aufs nächste Element geschoben");
				else
					Log.i(TAG, "Position konnte nicht verschoben werden, da das letzte Element erreicht wurde!");
				
				
			}
			
		}
		
		return steps;
	}
}
