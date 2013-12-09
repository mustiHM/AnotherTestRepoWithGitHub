package com.healthcaresolutions.norgine.moviprepcolonoprep.datalayer.impl;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xmlpull.v1.XmlPullParserException;

import android.R;
import android.app.Activity;
import android.content.res.AssetManager;
import android.util.Log;

import com.healthcaresolutions.norgine.moviprepcolonoprep.common.Medicine;
import com.healthcaresolutions.norgine.moviprepcolonoprep.datalayer.ProductParser;

public class ProductParserImpl extends Parser implements ProductParser {

	private Activity activity = null;
	private AssetManager manager;
	
	public ProductParserImpl(AssetManager manager) {
		this.manager = manager;
	}

	@Override
	public Medicine getMedicine() {
		return readMedicineFromXML();
	}
	
	public Medicine readMedicineFromXML() {
		Medicine med = null;
		
		/*InputStream is = null;
		try {
			is = manager.open("product.xml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		URL url;
	       HttpURLConnection urlConnection = null;
		try {
			url = new URL("http://www.bestofdesigns.be/healtysol/product.xml");
			urlConnection = (HttpURLConnection) url.openConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Log.d("url",e.getMessage());
		}
				
		try{
			Document doc = readXmlFromStream(new BufferedInputStream(urlConnection.getInputStream()));
			med = new Medicine();
			NodeList nl = doc.getElementsByTagName("name");
			String text = getTextFromNodeList(nl);
			med.setName(text);
			nl = doc.getElementsByTagName("link");
			text = getTextFromNodeList(nl);
			med.setLink(text);
			nl = doc.getElementsByTagName("description");
			text = getTextFromNodeList(nl);
			med.setDescribtion(text);	
		}
		catch(Exception ex)
		{
			System.out.println(ex.toString());
		}
		return med;
	}
}