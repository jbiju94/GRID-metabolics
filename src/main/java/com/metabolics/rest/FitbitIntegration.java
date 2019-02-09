package com.metabolics.rest;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.metabolics.model.fitbit.LifetimeActivity;
import com.metabolics.model.fitbit.heartrate.HeartRate;
import com.metabolics.repository.FitbitRepository;

@RestController
public class FitbitIntegration {

	@Autowired
	FitbitRepository fitbitRepository;

	@RequestMapping(value = "/lifetime-activity", method = RequestMethod.GET)
	public LifetimeActivity lifetimeActivity() {

		return fitbitRepository.getLifetimeActivity();
	}

	@RequestMapping(value = "/heart-rate", method = RequestMethod.GET)
	public HeartRate heartRate() {

		return fitbitRepository.getHeartRate();
	}

	@RequestMapping("/user")
	public Principal user(Principal principal) {
		return principal;
	}

}
