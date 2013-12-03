package com.healthcaresolutions.norgine.moviprepcolonoprep;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Preparation extends Activity {

	private Button btnNextStep;
	private Button btnOverview;
	
	private Context contextForListener;
	private ClickListener listener;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_preparation);
		
		contextForListener = this;
		listener = new ClickListener();
				
		btnNextStep = (Button) findViewById(R.id.btnNextStep);
		btnNextStep.setOnClickListener(listener);
		btnOverview = (Button) findViewById(R.id.btnOverview);
		btnOverview.setOnClickListener(listener);
	}
	
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.medicine_info, menu);
		return true;
	}
	
	
	private class ClickListener implements OnClickListener{
		
		public void onClick(View clickedObject) {
			if (clickedObject == btnNextStep){
				//Intent myIntent = new Intent(contextForListener, Medicine_info.class);
				//startActivity(myIntent);
			}
			else if (clickedObject == btnOverview){
				//Intent myIntent = new Intent(contextForListener, Medicine_info.class);
				//startActivity(myIntent);
			}
		}
	}
}
