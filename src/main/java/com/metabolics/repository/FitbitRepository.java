package com.metabolics.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.stereotype.Component;

import com.metabolics.model.fitbit.Activity;
import com.metabolics.model.fitbit.LifetimeActivity;
import com.metabolics.model.fitbit.heartrate.HeartRate;

@Component
public class FitbitRepository {

	@Autowired
	OAuth2RestTemplate oAuthRestTemplate;

	@Value("${fitbit.api.resource.activitiesUri}")
	String fitbitActivitiesUri;
	@Value("${fitbit.api.resource.heartRateTimeSeriesUri}")
	String heartRateTimeSeriesUri;

	public HeartRate getHeartRate() {
		/*
		 * ResponseEntity<Object[]> responseEntity =
		 * oAuthRestTemplate.getForEntity(fitbitActivitiesUri, Object[].class); return
		 * responseEntity.getBody();
		 */
		HeartRate hrate;
		try {
			hrate = oAuthRestTemplate.getForObject(heartRateTimeSeriesUri, HeartRate.class);
			return hrate;
		} catch (Exception e) {
			System.out.print("Error");
		}

		return null;

	}

	public LifetimeActivity getLifetimeActivity() {
		LifetimeActivity lifetimeActivity;

		try {
			Activity a = oAuthRestTemplate.getForObject(fitbitActivitiesUri, Activity.class);
			lifetimeActivity = a.getLifetime().getTotal();
		} catch (Exception e) {
			lifetimeActivity = new LifetimeActivity();
		}

		return lifetimeActivity;
	}
}
