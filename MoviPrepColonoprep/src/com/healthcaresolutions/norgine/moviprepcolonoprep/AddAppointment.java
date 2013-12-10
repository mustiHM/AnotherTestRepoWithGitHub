package com.healthcaresolutions.norgine.moviprepcolonoprep;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

public class AddAppointment extends Activity {

	private Context contextForListener;
	private ClickListener listener;
	
	private Button btnsafe;
	private DatePicker datePicker;
	private TimePicker timePicker;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_appointment);
		
		contextForListener = this;
		listener = new ClickListener();
		
		btnsafe = (Button) findViewById(R.id.btnsafe);
		btnsafe.setOnClickListener(listener);
		
		datePicker = (DatePicker) findViewById(R.id.datePicker1);
		timePicker = (TimePicker) findViewById(R.id.timePicker1);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
				getMenuInflater().inflate(R.menu.administrate_appointment, menu);
				return true;
	}
	
private class ClickListener implements OnClickListener{

		
		public void onClick(View clickedObject) {
			if (clickedObject == btnsafe){
				Log.i("listener", "Datum:" + datePicker.getDayOfMonth() + "." + (datePicker.getMonth()+1) + "." + datePicker.getYear());
				Log.i("listener", "Zeit:" + timePicker.getCurrentHour() + ":" + timePicker.getCurrentMinute());
				
				
				Toast.makeText(getApplicationContext(), "Der Termin wurde gespeichert.", Toast.LENGTH_SHORT).show();
				finish();
			}
					
		}
}
	
}
