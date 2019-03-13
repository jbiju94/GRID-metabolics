package com.metabolics.model.response;

public class HeartRate {

    private String month;
    private int restingHeartRate;
    private String user;

    public void setUser(String user) {
        this.user = user;
    }

    public String getMonth() {
        return month;
    }

    public int getRestingHeartRate() {
        return restingHeartRate;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public void setRestingHeartRate(int restingHeartRate) {
        this.restingHeartRate = restingHeartRate;
    }


}
