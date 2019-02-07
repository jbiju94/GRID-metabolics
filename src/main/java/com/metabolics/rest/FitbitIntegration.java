package com.metabolics.rest;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.metabolics.model.fitbit.LifetimeActivity;
import com.metabolics.repository.FitbitRepository;

@RestController
public class FitbitIntegration {

	@Autowired
	FitbitRepository fitbitRepository;

	@RequestMapping("/lifetime-activity")
	public LifetimeActivity lifetimeActivity() {

		return fitbitRepository.getLifetimeActivity();
	}

	@RequestMapping("/user")
	public Principal user(Principal principal) {
		return principal;
	}

}
