package com.example.android.quakereport;

public class Earthquake {

    private String magnitude;
    private String place;
    private String time;

    public Earthquake(String magnitude, String place, String time) {
        this.magnitude = magnitude;
        this.place = place;
        this.time = time;
    }

    public String getMagnitude() {
        return magnitude;
    }

    public String getPlace() {
        return place;
    }

    public String getTime() {
        return time;
    }
}
