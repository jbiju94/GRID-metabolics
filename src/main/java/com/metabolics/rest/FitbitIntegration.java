package com.metabolics.rest;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.metabolics.model.fitbit.LifetimeActivity;
import com.metabolics.model.response.HeartRate;
import com.metabolics.repository.FitbitRepository;
import com.metabolics.service.HeartRateService;

@RestController
public class FitbitIntegration {

	@Autowired
	FitbitRepository fitbitRepository;
	
	@Autowired
	HeartRateService heartRateService;

	@RequestMapping(value = "/lifetime-activity", method = RequestMethod.GET)
	public LifetimeActivity lifetimeActivity() {

		return fitbitRepository.getLifetimeActivity();
	}

	@RequestMapping(value = "/heart-rate", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody List<HeartRate> heartRate() {

		return heartRateService.getHeartRateDetails();
	}

	@RequestMapping("/user")
	public Principal user(Principal principal) {
		return principal;
	}

}
