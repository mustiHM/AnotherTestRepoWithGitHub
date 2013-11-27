package com.healthcaresolutions.norgine.moviprepcolonoprep.common;

import java.io.Serializable;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Repräsentiert eine Benachrichtigung an den Benutzer
 */
public class UserNotification {

	private int id;
	private String title;
	private String description;
	private long time; // siehe http://developer.android.com/reference/android/support/v4/app/NotificationCompat.Builder.html#setWhen%28long%29
	private Class<?> classLink; // die Klasse auf die die Benachrichtigung weiterleitet
	private String link; // das gleiche wie classLink, nur als String -> wichtig für DB
	private Status status;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescribtion() {
		return description;
	}
	public void setDescribtion(String description) {
		this.description = description;
	}
	public long getTime() {
		return time;
	}
	public void setTime(long time) {
		this.time = time;
	}
	public Class<?> getClassLink() {
		return classLink;
	}
	public void setClassLink(Class<?> classLink) {
		this.classLink = classLink;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
}
