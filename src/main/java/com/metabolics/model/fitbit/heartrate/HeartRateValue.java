package com.metabolics.model.fitbit.heartrate;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class HeartRateValue  {

	private List<HeartRateZone> heartRateZones;
	private int restingHeartRate = 0;


	public List<HeartRateZone> getHeartRateZones() {
		return heartRateZones;
	}

	public void setHeartRateZones(List<HeartRateZone> heartRateZones) {
		this.heartRateZones = heartRateZones;
	}

	public int getRestingHeartRate() {
		return restingHeartRate;
	}

	public void setRestingHeartRate(int restingHeartRate) {
		this.restingHeartRate = restingHeartRate;
	}

}
