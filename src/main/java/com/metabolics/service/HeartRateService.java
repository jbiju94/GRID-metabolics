package com.metabolics.service;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.Map;

import com.metabolics.model.response.HeartRate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metabolics.model.fitbit.heartrate.HeartRateActivity;
import com.metabolics.repository.FitbitRepository;

@Service("heartRateService")
public class HeartRateService {

	@Autowired
	private FitbitRepository fitbitRepository;

	public List<HeartRate> getHeartRateDetails() {

		List<HeartRate> heartRateResponseList = new ArrayList<>();

		/* Reduce Data Size
		*  - Filter out Zero Values
		*  - Group data
		*/
		Map<String, List<HeartRateActivity>> heartRateActivityGrouped = fitbitRepository.getHeartRate().getActivitiesHeart()
				.stream()
				.filter(hr-> hr.getValue().getRestingHeartRate() != 0)
				.collect(Collectors.groupingBy(HeartRateActivity::getYearMonth));

		heartRateActivityGrouped.forEach((k,v) -> {
			IntSummaryStatistics hrStats = v.stream()
					.mapToInt((x) -> x.getValue().getRestingHeartRate())
					.summaryStatistics();

			HeartRate hr = new HeartRate(k.substring(5),k.substring(0,4),(int)hrStats.getAverage(),"JOSEPH BIJU");
			heartRateResponseList.add(hr);
		});

		return heartRateResponseList;
	}

}
