package com.healthcaresolutions.norgine.moviprepcolonoprep.common;

import java.sql.Timestamp;

/**
 * Repräsentiert einen Vorbereitungsschritt
 * 
 */
public class Step {
		
		private int daysBefore;
		private String time;
		private Timestamp timestamp;
		private String action;
		private String amount;
		
		private Status status;
		
		public Status getStatus() {
			return status;
		}
		public void setStatus(Status status) {
			this.status = status;
		}
		public int getDaysBefore() {
			return daysBefore;
		}
		public void setDaysBefore(int daysBefore) {
			this.daysBefore = daysBefore;
		}
		public String getTime() {
			return time;
		}
		public void setTime(String time) {
			this.time = time;
		}
		public String getAction() {
			return action;
		}
		public void setAction(String action) {
			this.action = action;
		}
		public String getAmount() {
			return amount;
		}
		public void setAmount(String amount) {
			this.amount = amount;
		}
		
		public Timestamp getTimeStamp()
		{
			return timestamp;
		}
		
		public void setTimestamp(Timestamp timestamp) {
			this.timestamp = timestamp;
		}

}
