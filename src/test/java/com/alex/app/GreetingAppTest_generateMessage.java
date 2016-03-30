package com.alex.app;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ResourceBundle;

import static org.junit.Assert.*;

public class GreetingAppTest_generateMessage {
    public static ResourceBundle bundle;
    GreetingApp greetingApp;

    @BeforeClass
    public static void beforeClass() {
        bundle = ResourceBundle.getBundle("i18n.MessageResource", new UTF8Control());
    }

    @Before
    public void before() {
        greetingApp = new GreetingApp();
    }

    //morning => Доброе утро, Мир!
    @Test
    public void generateMessageMorning() {

        String keyValues = "morning";
        assertEquals("Доброе утро, Мир!", greetingApp.generateMessage(bundle, keyValues));
    }

    //day => Добрый день, Мир!
    @Test
    public void generateMessageDay() {

        String keyValues = "day";
        assertEquals("Добрый день, Мир!", greetingApp.generateMessage(bundle, keyValues));
    }

    //evening => Добрый вечер, Мир!
    @Test
    public void generateMessageEvening() {

        String keyValues = "evening";
        assertEquals("Добрый вечер, Мир!", greetingApp.generateMessage(bundle, keyValues));
    }

    //night => Доброй ночи, Мир!;
    @Test
    public void generateMessageNight() {

        String keyValues = "night";
        assertEquals("Доброй ночи, Мир!", greetingApp.generateMessage(bundle, keyValues));
    }

}