package com.healthcaresolutions.norgine.moviprepcolonoprep.common;


/**
 * Repräsentiert einen Patientendatensatz.
 * Kann auf Kundenwunsch angepasst werden.
 */
public class Patient {

	private int age;
	private String country;
	private String city;
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
}
