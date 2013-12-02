package com.healthcaresolutions.norgine.moviprepcolonoprep.datalayer.impl;

import java.util.ArrayList;

import android.app.Activity;
import android.content.res.AssetManager;

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
	private AssetManager manager;
	
	public ConfigReaderImpl(AssetManager manager)
	{
		this.manager = manager;	
	}
	
	@Override
	public ArrayList<Step> getWorkflowSteps() {
		return new ProcedureParserImpl(manager).getSteps();
	}

	@Override
	public Medicine getMedicine() {
		return new ProductParserImpl(manager).getMedicine();
	}

}
