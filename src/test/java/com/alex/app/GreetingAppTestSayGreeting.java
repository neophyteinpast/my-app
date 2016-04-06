package com.alex.app;

import org.junit.Test;

import static org.junit.Assert.*;

public class GreetingAppTestSayGreeting {

    GreetingApp greetingApp = new GreetingApp();

    @Test
    public void sayGreetingMorning() {
        DayTime nowAtMorning = new DayTime(7, 22, 58);
        assertEquals("morning", greetingApp.sayGreeting(nowAtMorning));
    }

    @Test
    public void sayGreetingDay() {
        DayTime nowAtDay = new DayTime(15, 22, 58);
        assertEquals("day", greetingApp.sayGreeting(nowAtDay));
    }

    @Test
    public void sayGreetingEvening() {
        DayTime nowAtEvening = new DayTime(20, 22, 58);
        assertEquals("evening", greetingApp.sayGreeting(nowAtEvening));
    }

    @Test
    public void sayGreetingNight() {
        DayTime nowAtNight = new DayTime(0, 2, 58);
        assertEquals("night", greetingApp.sayGreeting(nowAtNight));
    }

}