package com.healthcaresolutions.norgine.moviprepcolonoprep.datalayer.impl;

import java.io.IOException;
import java.io.InputStream;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xmlpull.v1.XmlPullParserException;

import android.R;
import android.app.Activity;

import com.healthcaresolutions.norgine.moviprepcolonoprep.common.Medicine;
import com.healthcaresolutions.norgine.moviprepcolonoprep.datalayer.ProductParser;

public class ProductParserImpl extends Parser implements ProductParser {

	private Activity activity = null;
	
	public ProductParserImpl(Activity activity) {
		this.activity = activity;
	}

	@Override
	public Medicine getMedicine() {
		return readMedicineFromXML();
	}
	
	public Medicine readMedicineFromXML() {
		Medicine med = null;
		InputStream is = null;
		try {
			is = activity.getAssets().open("product.xml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		try{
			Document doc = readXmlFromStream(is);
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