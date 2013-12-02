package com.healthcaresolutions.norgine.moviprepcolonoprep.logiclayer.impl;

import android.app.Activity;

import com.healthcaresolutions.norgine.moviprepcolonoprep.common.Medicine;
import com.healthcaresolutions.norgine.moviprepcolonoprep.datalayer.ConfigReader;
import com.healthcaresolutions.norgine.moviprepcolonoprep.datalayer.impl.ConfigReaderImpl;
import com.healthcaresolutions.norgine.moviprepcolonoprep.logiclayer.MedicineService;

public class MedicineServiceImpl implements MedicineService {

	private Medicine defaultMedicine; // Standart-Medikament, falls keine Config verfügbar.
	//TODO switch with real activity.
	private ConfigReader cr = new ConfigReaderImpl(new Activity());
	
	public Medicine getMedicineInfo() {
		
		defaultMedicine = cr.getMedicine();
		
		if(defaultMedicine == null){
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
