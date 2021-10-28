package com.example.web2.model;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class Clock implements Comparable<Clock>{
    private final String dateString;
    private double start;
    private final Date date;

    public Clock() {
        this.date = new Date();
        DateFormat dateFormat = DateFormat.getTimeInstance(DateFormat.DEFAULT, new Locale("RU", "ru"));
        dateString = dateFormat.format(date);
    }

    public void start() {
        start = (double) System.currentTimeMillis() * 1e6;
    }

    public void finish() {
        double finish = (double) System.currentTimeMillis() * 1e6 - start;
    }

    public String getDateString() {
        return dateString;
    }

    @Override
    public int compareTo(Clock o) {
        return date.compareTo(o.date);
    }
}
