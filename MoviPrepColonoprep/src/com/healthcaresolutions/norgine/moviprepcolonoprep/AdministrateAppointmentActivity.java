package com.healthcaresolutions.norgine.moviprepcolonoprep;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class AdministrateAppointmentActivity extends Activity {

	private Button btnAddAppointment;
	private Button btnChangeAppointment;
	private Button btnDeleteAppointment;
	
	private Context contextForListener;
	private ClickListener listener;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_administrate_appointment);
		
		contextForListener = this;
		//listener = new ClickListener();
		
		btnAddAppointment = (Button) findViewById(R.id.btnAddAppointment);
		//btnAddAppointment.setOnClickListener(listener);
		btnChangeAppointment = (Button) findViewById(R.id.btnChangeAppointment);
		btnDeleteAppointment = (Button) findViewById(R.id.btnDeleteAppointment);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.administrate_appointment, menu);
		return true;
	}
	
	private class ClickListener implements OnClickListener{

		
		public void onClick(View clickedObject) {
			if (clickedObject == btnAddAppointment){
				Intent myIntent = new Intent(contextForListener, AddAppointment.class);
				startActivity(myIntent);
			}
			
		}
		
	}

}
