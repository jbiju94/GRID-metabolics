package com.metabolics.model.response;

public class HeartRate {

    private String month;
    private String year;
    private String user;
    private int restingHeartRate;

    public HeartRate(String tMonth, String tYear, int tRestingHeartRate, String tUser ){
        month = tMonth;
        year = tYear;
        restingHeartRate = tRestingHeartRate;
        user = tUser;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setRestingHeartRate(int restingHeartRate) {
        this.restingHeartRate = restingHeartRate;
    }

    public String getMonth() {
        return month;
    }

    public String getYear() {
        return year;
    }

    public String getUser() {
        return user;
    }

    public int getRestingHeartRate() {
        return restingHeartRate;
    }
}
