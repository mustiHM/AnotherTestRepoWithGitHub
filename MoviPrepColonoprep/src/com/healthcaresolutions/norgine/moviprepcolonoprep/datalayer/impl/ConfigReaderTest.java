package com.healthcaresolutions.norgine.moviprepcolonoprep.datalayer.impl;

public class ConfigReaderTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ConfigReaderImpl reader = new ConfigReaderImpl();
		System.out.println(reader.getMedicine().getName());
		System.out.println(reader.getWorkflowSteps().size());

	}

}
