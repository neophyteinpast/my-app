package com.alex.app;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Locale;
import java.util.ResourceBundle;

import static org.junit.Assert.assertEquals;

public class GreetingAppGenerateMessageRusLocaleTest {

    private static ResourceBundle bundle;
    private GreetingApp greetingApp;
    private static Locale locale;

    @BeforeClass
    public static void beforeClass() {

      locale = new Locale("ru", "RU");
    }

    @Before
    public void before() {

        greetingApp = new GreetingApp();

        bundle = ResourceBundle.getBundle("i18n.MessageResource", new Utf8Control());
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