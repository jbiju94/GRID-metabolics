package com.metabolics.repository;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import com.metabolics.model.fitbit.Activity;
import com.metabolics.model.fitbit.LifetimeActivity;

@Component
public class FitbitRepository {

	@Autowired
	OAuth2RestTemplate oAuthRestTemplate;

	@Value("${fitbit.api.resource.activitiesUri}")
	String fitbitActivitiesUri;

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

	@RequestMapping("/user")
	public Principal getUser(Principal principal) {
		return principal;
	}
}
