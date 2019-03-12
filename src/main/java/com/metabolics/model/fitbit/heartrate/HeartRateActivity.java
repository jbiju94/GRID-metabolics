package com.metabolics.model.fitbit.heartrate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class HeartRateActivity {

	private String dateTime;
	private HeartRateValue value;

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public HeartRateValue getValue() {
		return value;
	}

	public void setValue(HeartRateValue value) {
		this.value = value;
	}
	
	public int getMonth() {
		return Integer.parseInt(dateTime.substring(5, 7));
	}

}
