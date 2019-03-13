package com.metabolics.service;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
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

		//Reduce Data Size - Group-by Month & Aggregate Data.
		Map<Object, IntSummaryStatistics> results = fitbitRepository.getHeartRate().getActivitiesHeart().stream()
				.filter(hr-> hr.getValue().getRestingHeartRate() != 0)
				.collect(Collectors.groupingBy(HeartRateActivity::getMonth, Collectors.summarizingInt(hr -> hr.getValue().getRestingHeartRate())));

		results.forEach((month,summary) -> {

			HeartRate hr= new HeartRate();
			hr.setMonth(month.toString());
			hr.setRestingHeartRate((int) summary.getAverage());
			heartRateResponseList.add(hr);
				});

		/*return results.entrySet()
				.stream()
				.map(e -> computeHeartRatePerMonthStatistics(e.getKey().toString(),e.getValue()))
				.collect(Collectors.toList());*/

		return heartRateResponseList;
	}

	/*private static HeartRate computeHeartRatePerMonthStatistics(String month, IntSummaryStatistics statistics) {
		return new HeartRate();// convert to HeartRateRoot given your inputs to method of conversion
	}*/

}
