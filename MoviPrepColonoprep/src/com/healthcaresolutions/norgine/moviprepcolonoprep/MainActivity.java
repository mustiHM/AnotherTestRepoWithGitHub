package com.healthcaresolutions.norgine.moviprepcolonoprep;


import com.healthcaresolutions.norgine.moviprepcolonoprep.logiclayer.WorkflowService;
import com.healthcaresolutions.norgine.moviprepcolonoprep.logiclayer.impl.WorkflowServiceImpl;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	private Button btnAdministrateAppointment;
	private Button btnOverview;
	private Button btnSettings;
	private Button btnInfo;
	private Button btnFoodList;
	private Button btnChecklist;
	private WorkflowService ws;
	private Thread thread;
	private Context contextForListener;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		contextForListener = this;
		ClickListener listener = new ClickListener();
		
		btnAdministrateAppointment = (Button) findViewById(R.id.btnAdministrateAppointment);
		btnAdministrateAppointment.setOnClickListener(listener);
		btnOverview = (Button) findViewById(R.id.btnOverview);
		btnSettings = (Button) findViewById(R.id.btnSettings);
		btnInfo = (Button) findViewById(R.id.btnInfo);
		btnFoodList = (Button) findViewById(R.id.btnFoodList);
		btnChecklist = (Button) findViewById(R.id.btnCheckList);
		
		// Einlesen der Konfig beginnen
		
		ws = new WorkflowServiceImpl(null);
		thread = new Thread(ws);
		thread.start();
		
		
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
			if (clickedObject == btnOverview){
				
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
