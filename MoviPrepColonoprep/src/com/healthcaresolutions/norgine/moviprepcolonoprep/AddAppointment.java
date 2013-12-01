package com.healthcaresolutions.norgine.moviprepcolonoprep;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;

public class AddAppointment extends Activity {

	private Context context;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_appointment);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
				getMenuInflater().inflate(R.menu.administrate_appointment, menu);
				return true;
	}
	
}
