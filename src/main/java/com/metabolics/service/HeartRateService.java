package com.metabolics.service;

import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.DoubleSummaryStatistics;
import java.util.Map;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metabolics.model.fitbit.heartrate.HeartRate;
import com.metabolics.model.fitbit.heartrate.HeartRateActivity;
import com.metabolics.repository.FitbitRepository;

@Service("heartRateService")
public class HeartRateService {

	@Autowired
	private FitbitRepository fitbitRepository;

	public HeartRate getHeartRateAverage() {

		HeartRate heartRate = fitbitRepository.getHeartRate();

		Stream<HeartRateActivity> heartRateActivityStream = heartRate.getActivitiesHeart().stream();

		Map<Object, Long> result = heartRateActivityStream
				.collect(Collectors.groupingBy(hr1 -> hr1.getMonth(), Collectors.counting()));

		//heartRate.setActivitiesHeart(result);
		return heartRate;
	}

}
