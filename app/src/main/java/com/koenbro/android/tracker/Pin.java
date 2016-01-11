package com.koenbro.android.tracker;

import android.text.format.Time;

/**
 * @author laszlo
 * @date 1/10/16.
 */
public class Pin {
    private Time now;
    private String date;
    private String time;
    private GPSTracker gps;
    private double lat;
    private double lon;

    public Pin() {
        now = new Time(Time.getCurrentTimezone());
        gps = new GPSTracker(ApplicationContextProvider.getContext());
    }

    private void timeStamp() {
        now.setToNow();
        date = now.year + "-" + (now.month + 1) + "-" + now.monthDay;
        time = now.format("%k:%M:%S");
    }

    private void locationStamp() {
        //chekc if GPS is enabled
        if (gps.canGetLocation()) {
            lat = gps.getLatitude();
            lon = gps.getLongitude();

        } else {
            /*
            Can't get location; GPS or Network is not enabled
            Ask user to enable GPS/network in settings
             */
            gps.showSettingsAlert();
        }
    }

    public Time getNow() {
        return now;
    }

    public void setNow(Time now) {
        this.now = now;
    }

    /**
     * Obtain and return the current day
     *
     * @return day  formatted as y-m-d
     */
    public String getDate() {
        timeStamp();
        return date;
    }

    /**
     * Obtain and return the current time
     *
     * @return time    formatted as h:m:s
     */
    public String getTime() {
        timeStamp();
        return time;
    }

    /**
     * Obtain a fresh location and return the latitude
     *
     * @return double  latitude
     */
    public double getLat() {
        locationStamp();
        return lat;
    }

    /**
     * Obtain a fresh location and return the longitude
     *
     * @return double  longitude
     */
    public double getLon() {
        locationStamp();
        return lon;
    }

    @Override
    public String toString() {
        return "Location pinned at " + time;
    }

}
