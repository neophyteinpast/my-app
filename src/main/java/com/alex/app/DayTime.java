package com.alex.app;

import java.util.Calendar;

/**
 * Created by Alex on 15.03.2016.
 */
public class DayTime {

    Calendar startTime;

    public DayTime() {
        this.startTime = Calendar.getInstance();
    }

    public DayTime(int startHour, int startMinute, int startSeconds) {
        this.startTime = Calendar.getInstance();
        this.startTime.set(Calendar.HOUR_OF_DAY, startHour);
        this.startTime.set(Calendar.MINUTE, startMinute);
        this.startTime.set(Calendar.SECOND, startSeconds);

    }
}
