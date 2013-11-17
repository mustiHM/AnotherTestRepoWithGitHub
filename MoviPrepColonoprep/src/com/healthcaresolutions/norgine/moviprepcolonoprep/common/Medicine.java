package com.healthcaresolutions.norgine.moviprepcolonoprep.common;

/**
 * Repräsentiert ein Medikament.
 * Kann auf Kundenwunsch noch erweitert werden.
 */
public class Medicine {

	private String name;
	private String describtion;
	private String link; // link zur Herstellerseite
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescribtion() {
		return describtion;
	}
	public void setDescribtion(String describtion) {
		this.describtion = describtion;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	
}
