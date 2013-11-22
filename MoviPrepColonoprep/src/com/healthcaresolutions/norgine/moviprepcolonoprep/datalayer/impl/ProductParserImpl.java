package com.healthcaresolutions.norgine.moviprepcolonoprep.datalayer.impl;

import java.io.InputStream;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import com.healthcaresolutions.norgine.moviprepcolonoprep.common.Medicine;
import com.healthcaresolutions.norgine.moviprepcolonoprep.datalayer.ProductParser;

public class ProductParserImpl extends Parser implements ProductParser{

	
	@Override
	public Medicine getMedicine() {
		return readMedicineFromXML();
	}
	
	public Medicine readMedicineFromXML() {
		Medicine med = null;
		InputStream is = ClassLoader.getSystemResourceAsStream("com.healthcaresolutions.norgine.moviprepcolonoprep.datalayer.files/product.xml");
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