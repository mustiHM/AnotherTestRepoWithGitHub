package com.healthcaresolutions.norgine.moviprepcolonoprep.datalayer.impl;


import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import android.R;
import android.app.Activity;
import android.content.res.AssetManager;
import android.util.Log;

import com.healthcaresolutions.norgine.moviprepcolonoprep.common.Step;
import com.healthcaresolutions.norgine.moviprepcolonoprep.datalayer.ProcedureParser;


public class ProcedureParserImpl extends Parser implements ProcedureParser{
	
	private Activity activity = null;
	private AssetManager manager = null; 
	
	public ProcedureParserImpl(AssetManager manager)
	{
		this.manager = manager;
	}

	public ArrayList<Step> getSteps()
	{
		return readStepsFromXML();
	}
	
	public ArrayList<Step> readStepsFromXML()
	{
		//to read from local xml
		/*
		
		InputStream is = null;
		try {
			is = manager.open("procedure.xml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
	       ArrayList<Step> steps = new ArrayList<Step>();
	       URL url;
	       HttpURLConnection urlConnection = null;
		try {
			url = new URL("http://www.bestofdesigns.be/healtysol/procedure.xml");
			urlConnection = (HttpURLConnection) url.openConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Log.d("url",e.getMessage());
		}
	       
		try{
			Document doc = readXmlFromStream(new BufferedInputStream(urlConnection.getInputStream()));
			NodeList nl = doc.getElementsByTagName("step");
			if (nl != null && nl.getLength() > 0) {
		        for (int i = 0; i < nl.getLength(); i++) {
		        	if (nl.item(i).getNodeType() == Node.ELEMENT_NODE) {
		                Element el = (Element) nl.item(i);
		                Step step = new Step();
		                //get the days before
		                NodeList daysbefore = el.getElementsByTagName("daysbefore");
		                String text = getTextFromNodeList(daysbefore);
		                step.setDaysBefore(Integer.parseInt(text));
		                //get the time
		                NodeList time = el.getElementsByTagName("time");
		                text = getTextFromNodeList(time);
		                step.setTime(text);
		                //get the action
		                NodeList action = el.getElementsByTagName("action");
		                text = getTextFromNodeList(action);
		                step.setAction(text);
		                //get the amount
		                NodeList amount = el.getElementsByTagName("amount");
		                text = getTextFromNodeList(amount);
		                step.setAmount(text);
		                steps.add(step);
		        	}
		        }
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		finally{
			urlConnection.disconnect();
		}
		
		return steps;
	}	
}

