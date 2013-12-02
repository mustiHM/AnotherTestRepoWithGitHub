package com.healthcaresolutions.norgine.moviprepcolonoprep;


import java.util.ArrayList;

import com.healthcaresolutions.norgine.moviprepcolonoprep.common.Medicine;
import com.healthcaresolutions.norgine.moviprepcolonoprep.common.Step;
import com.healthcaresolutions.norgine.moviprepcolonoprep.datalayer.impl.ConfigReaderImpl;
import com.healthcaresolutions.norgine.moviprepcolonoprep.logiclayer.WorkflowService;
import com.healthcaresolutions.norgine.moviprepcolonoprep.logiclayer.impl.WorkflowServiceImpl;

import com.healthcaresolutions.norgine.moviprepcolonoprep.logiclayer.NotificationService;

import android.os.Bundle;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	private Button btnAdministrateAppointment;
	private Button btnPreparation;
	private Button btnSettings;
	private Button btnInfo;
	private Button btnFoodList;
	private Button btnChecklist;
	private WorkflowService ws;
	private Thread thread;
	private Context contextForListener;
	private ClickListener listener;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		contextForListener = this;
		ClickListener listener = new ClickListener();
		
		btnAdministrateAppointment = (Button) findViewById(R.id.btnAdministrateAppointment);
		btnAdministrateAppointment.setOnClickListener(listener);
		btnPreparation = (Button) findViewById(R.id.btnPreparation);
		btnPreparation.setOnClickListener(listener);
		btnSettings = (Button) findViewById(R.id.btnSettings);
		btnSettings.setOnClickListener(listener);
		btnInfo = (Button) findViewById(R.id.btnInfo);
		btnInfo.setOnClickListener(listener);
		btnFoodList = (Button) findViewById(R.id.btnFoodList);
		btnFoodList.setOnClickListener(listener);
		btnChecklist = (Button) findViewById(R.id.btnCheckList);
		btnChecklist.setOnClickListener(listener);
		
		// Einlesen der Konfig beginnen
		
		ws = new WorkflowServiceImpl(contextForListener, null);
		thread = new Thread(ws);
		thread.start();
		
		Log.i(this.getLocalClassName(), "Main gebaut");
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	private class ClickListener implements OnClickListener{

		@Override
		public void onClick(View clickedObject) {
			if (clickedObject == btnAdministrateAppointment){
				Intent myIntent = new Intent(contextForListener, AdministrateAppointmentActivity.class);
				startActivity(myIntent);
			}
			if (clickedObject == btnPreparation){
				
			}
			if (clickedObject == btnSettings){
							
						}
			if (clickedObject == btnInfo){
				
			}
			if (clickedObject == btnChecklist){
				
			}
			if (clickedObject == btnFoodList){
						
			}
					
		
		}
	}
}
