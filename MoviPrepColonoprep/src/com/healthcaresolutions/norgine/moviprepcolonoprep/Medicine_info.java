package com.healthcaresolutions.norgine.moviprepcolonoprep;

import com.healthcaresolutions.norgine.moviprepcolonoprep.common.Medicine;
import com.healthcaresolutions.norgine.moviprepcolonoprep.logiclayer.MedicineService;
import com.healthcaresolutions.norgine.moviprepcolonoprep.logiclayer.impl.MedicineServiceImpl;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.widget.TextView;

public class Medicine_info extends Activity {

	private TextView txtmedicinename;
	private TextView txtmedicinedescription;
	private TextView txtmedicinemanufacturer;
	
	private Context contextForListener;
	private MedicineService medicineService;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_medicine_info);
		
		contextForListener = this;
		medicineService = new MedicineServiceImpl(contextForListener);
		
		txtmedicinename = (TextView) findViewById(R.id.txtmedicinename);
		txtmedicinedescription = (TextView) findViewById(R.id.txtmedicinedescription);
		txtmedicinemanufacturer = (TextView) findViewById(R.id.txtmedicinemanufacturer);
		
		Medicine m = medicineService.getMedicineInfo();
		
		txtmedicinename.setText(m.getName());
		txtmedicinedescription.setText(m.getDescribtion());
		txtmedicinemanufacturer.setText(m.getLink());
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.medicine_info, menu);
		return true;
	}

}
