package com.metabolics.repository;

import com.metabolics.model.fitbit.heartrate.HeartRateRoot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.stereotype.Component;

import com.metabolics.model.fitbit.Activity;
import com.metabolics.model.fitbit.LifetimeActivity;

@Component
public class FitbitRepository {

	@Autowired
	OAuth2RestTemplate oAuthRestTemplate;

	@Value("${fitbit.api.resource.activitiesUri}")
	String fitbitActivitiesUri;
	@Value("${fitbit.api.resource.heartRateTimeSeriesUri}")
	String heartRateTimeSeriesUri;

	public HeartRateRoot getHeartRate() {
		/*
		 * ResponseEntity<Object[]> responseEntity =
		 * oAuthRestTemplate.getForEntity(fitbitActivitiesUri, Object[].class); return
		 * responseEntity.getBody();
		 */
		HeartRateRoot hrate;
		try {
			hrate = oAuthRestTemplate.getForObject(heartRateTimeSeriesUri, HeartRateRoot.class);
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
