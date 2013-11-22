package com.healthcaresolutions.norgine.moviprepcolonoprep.datalayer.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public abstract class Parser {
	
	public static String getTextFromNodeList(NodeList nl) throws Exception
	{
		if (nl.getLength() == 0) return null;
		if (nl.getLength() > 1) throw new Exception("Error in xml file. Tag double");
		String value = null;
		for (int i = 0; i < nl.getLength(); i++) {
        	if (nl.item(i).getNodeType() == Node.ELEMENT_NODE) {
                Element el = (Element) nl.item(i);
                value = el.getTextContent();
        	}
        }
		return value;
	}
	
	public static Document readXmlFromStream(InputStream is) throws SAXException, IOException, ParserConfigurationException {
    
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		dbf.setValidating(false);
		dbf.setIgnoringComments(false);
		dbf.setIgnoringElementContentWhitespace(true);
		dbf.setNamespaceAware(true);
		// dbf.setCoalescing(true);
		// dbf.setExpandEntityReferences(true);

		DocumentBuilder db = null;
		db = dbf.newDocumentBuilder();
		db.setEntityResolver(new NullResolver());

		// db.setErrorHandler( new MyErrorHandler());

		return db.parse(is);
}
}

class NullResolver implements EntityResolver {
public InputSource resolveEntity(String publicId, String systemId) throws SAXException,
    IOException {
  return new InputSource(new StringReader(""));
}
}
