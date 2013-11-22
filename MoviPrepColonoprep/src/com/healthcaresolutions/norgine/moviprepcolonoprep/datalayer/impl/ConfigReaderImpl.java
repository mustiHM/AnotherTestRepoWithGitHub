package com.healthcaresolutions.norgine.moviprepcolonoprep.datalayer.impl;

import java.util.ArrayList;

import com.healthcaresolutions.norgine.moviprepcolonoprep.common.Medicine;
import com.healthcaresolutions.norgine.moviprepcolonoprep.common.Step;
import com.healthcaresolutions.norgine.moviprepcolonoprep.datalayer.ConfigReader;

/**
 * Implementiert das Interface ConfigReader.
 * Kann intern eine Klasse wie XMLParser aufrufen.
 *
 */
public class ConfigReaderImpl implements ConfigReader {

	@Override
	public ArrayList<Step> getWorkflowSteps() {
		return new ProcedureParserImpl().getSteps();
	}

	@Override
	public Medicine getMedicine() {
		return new ProductParserImpl().getMedicine();
	}

}
