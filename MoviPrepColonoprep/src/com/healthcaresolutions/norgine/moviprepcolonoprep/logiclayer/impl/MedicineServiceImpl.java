package com.healthcaresolutions.norgine.moviprepcolonoprep.logiclayer.impl;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import com.healthcaresolutions.norgine.moviprepcolonoprep.common.Medicine;
import com.healthcaresolutions.norgine.moviprepcolonoprep.datalayer.ConfigReader;
import com.healthcaresolutions.norgine.moviprepcolonoprep.datalayer.impl.ConfigReaderImpl;
import com.healthcaresolutions.norgine.moviprepcolonoprep.logiclayer.MedicineService;

public class MedicineServiceImpl implements MedicineService {

	private Medicine defaultMedicine; // Standart-Medikament, falls keine Config verfügbar.
	//TODO switch with real activity.
	private ConfigReader cr;
	private Context context;
	private AssetManager manager;
	
	public MedicineServiceImpl(Context context){
		this.context = context;
		manager = context.getAssets();
		cr = new ConfigReaderImpl(manager);
	}
	
	public Medicine getMedicineInfo() {
		
		defaultMedicine = cr.getMedicine();
		
		if(defaultMedicine == null){
			Log.i("MedicineServiceImpl", "Keine Konfig gefunden, deshalb wird eigene Methode genutzt");
			initialize();
		}
		
		return defaultMedicine;
	}
	
	private void initialize(){
		defaultMedicine = new Medicine();
		defaultMedicine.setName("Test-Medikament");
		defaultMedicine.setDescribtion("Das ist ein Test-Medikament das genutzt wird, weil keine Config verfügbar ist.");
		defaultMedicine.setLink("http://www.google.de");
	}

}
