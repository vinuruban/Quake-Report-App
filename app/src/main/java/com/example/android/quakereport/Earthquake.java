package com.example.android.quakereport;

public class Earthquake {

    private String magnitude;
    private String distance;
    private String location;
    private String date;
    private String time;
    private String url;

    public Earthquake(String magnitude, String distance, String location, String date, String time, String url) {
        this.magnitude = magnitude;
        this.distance = distance;
        this.location = location;
        this.date = date;
        this.time = time;
        this.url = url;
    }

    public String getMagnitude() {
        return magnitude;
    }

    public String getDistance() {
        return distance;
    }

    public String getLocation() {
        return location;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getUrl() {
        return url;
    }
}
