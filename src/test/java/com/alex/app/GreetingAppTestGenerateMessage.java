package com.alex.app;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Locale;
import java.util.ResourceBundle;

import static org.junit.Assert.*;

public class GreetingAppTestGenerateMessage {
    private static ResourceBundle bundle;
    private GreetingApp greetingApp;
    private static Locale locale;

    @BeforeClass
    public static void beforeClass() {

      locale = Locale.getDefault();
    }

    @Before
    public void before() {

        greetingApp = new GreetingApp();
    }

    //morning => Доброе утро, Мир!
    @Test
    public void generateMessageMorning() {

        if (locale.getISO3Country().equals("RUS")) {
            bundle = ResourceBundle.getBundle("i18n.MessageResource", new Utf8Control());
        }
        else {
            bundle = ResourceBundle.getBundle("i18n.MessageResource", locale);
        }

        String keyValues = "morning";
        assertEquals("Доброе утро, Мир!", greetingApp.generateMessage(bundle, keyValues));
    }

    //day => Добрый день, Мир!
    @Test
    public void generateMessageDay() {

        if (locale.getISO3Country().equals("RUS")) {
            bundle = ResourceBundle.getBundle("i18n.MessageResource", new Utf8Control());
        }
        else {
            bundle = ResourceBundle.getBundle("i18n.MessageResource", locale);
        }

        String keyValues = "day";
        assertEquals("Добрый день, Мир!", greetingApp.generateMessage(bundle, keyValues));
    }

    //evening => Добрый вечер, Мир!
    @Test
    public void generateMessageEvening() {

        if (locale.getISO3Country().equals("RUS")) {
            bundle = ResourceBundle.getBundle("i18n.MessageResource", new Utf8Control());
        }
        else {
            bundle = ResourceBundle.getBundle("i18n.MessageResource", locale);
        }

        String keyValues = "evening";
        assertEquals("Добрый вечер, Мир!", greetingApp.generateMessage(bundle, keyValues));
    }

    //night => Доброй ночи, Мир!;
    @Test
    public void generateMessageNight() {

        if (locale.getISO3Country().equals("RUS")) {
            bundle = ResourceBundle.getBundle("i18n.MessageResource", new Utf8Control());
        }
        else {
            bundle = ResourceBundle.getBundle("i18n.MessageResource", locale);
        }

        String keyValues = "night";
        assertEquals("Доброй ночи, Мир!", greetingApp.generateMessage(bundle, keyValues));
    }

    //locale = German, morning => Guten Morgen, Welt!
    @Test
    public void generateMessageMorning_Locale_German() {

        locale = new Locale("de", "GE");

        if (locale.getISO3Country().equals("RUS")) {
            bundle = ResourceBundle.getBundle("i18n.MessageResource", new Utf8Control());
        }
        else {
            bundle = ResourceBundle.getBundle("i18n.MessageResource", locale);
        }

        String keyValues = "morning";
        assertEquals("Guten Morgen, Welt!", greetingApp.generateMessage(bundle, keyValues));
    }
}