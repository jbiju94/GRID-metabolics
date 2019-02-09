package com.metabolics.model.fitbit.heartrate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class HeartRateZone {

    private int caloriesOut = 0;
    private int max = 0;
    private int min = 0;
    private int minutes = 0;
    private String name;
    
	public Integer getCaloriesOut() {
		return caloriesOut;
	}
	public void setCaloriesOut(Integer caloriesOut) {
		this.caloriesOut = caloriesOut;
	}
	public Integer getMax() {
		return max;
	}
	public void setMax(Integer max) {
		this.max = max;
	}
	public Integer getMin() {
		return min;
	}
	public void setMin(Integer min) {
		this.min = min;
	}
	public Integer getMinutes() {
		return minutes;
	}
	public void setMinutes(Integer minutes) {
		this.minutes = minutes;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
    
}
