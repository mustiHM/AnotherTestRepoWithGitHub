package com.healthcaresolutions.norgine.moviprepcolonoprep.datalayer.impl;

import java.util.ArrayList;

import android.app.Activity;

import com.healthcaresolutions.norgine.moviprepcolonoprep.common.Medicine;
import com.healthcaresolutions.norgine.moviprepcolonoprep.common.Step;
import com.healthcaresolutions.norgine.moviprepcolonoprep.datalayer.ConfigReader;

/**
 * Implementiert das Interface ConfigReader.
 * Kann intern eine Klasse wie XMLParser aufrufen.
 *
 */
public class ConfigReaderImpl implements ConfigReader {

	private Activity activity = null;
	
	public ConfigReaderImpl(Activity activity)
	{
		this.activity = activity;	
	}
	
	@Override
	public ArrayList<Step> getWorkflowSteps() {
		return new ProcedureParserImpl(activity).getSteps();
	}

	@Override
	public Medicine getMedicine() {
		return new ProductParserImpl(activity).getMedicine();
	}

}
