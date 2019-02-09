package com.metabolics.model.fitbit.heartrate;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class HeartRate {

	@JsonProperty("activities-heart")
	private List<HeartRateActivity> activitiesHeart;

	public List<HeartRateActivity> getActivitiesHeart() {
		return activitiesHeart;
	}

	public void setActivitiesHeart(List<HeartRateActivity> activitiesHeart) {
		this.activitiesHeart = activitiesHeart;
	}

}
