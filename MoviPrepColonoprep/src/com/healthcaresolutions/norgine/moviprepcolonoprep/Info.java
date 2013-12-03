package com.healthcaresolutions.norgine.moviprepcolonoprep;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Info extends Activity {

	private Button btnMedicineInfo;
	private Button btnImprint;
	
	private Context contextForListener;
	private ClickListener listener;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_info);
		
		contextForListener = this;
		listener = new ClickListener();
		
		btnMedicineInfo = (Button) findViewById(R.id.btnMedicineInfo);
		btnMedicineInfo.setOnClickListener(listener);
		btnImprint = (Button) findViewById(R.id.btnImprint);
		btnImprint.setOnClickListener(listener);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.medicine_info, menu);
		return true;
	}
	
	private class ClickListener implements OnClickListener{
		
		public void onClick(View clickedObject) {
			if (clickedObject == btnMedicineInfo){
				Intent myIntent = new Intent(contextForListener, Medicine_info.class);
				startActivity(myIntent);
			}
			else if (clickedObject == btnImprint){
				Intent myIntent = new Intent(contextForListener, Imprint.class);
				startActivity(myIntent);
			}
		}
		
	}
	
}
