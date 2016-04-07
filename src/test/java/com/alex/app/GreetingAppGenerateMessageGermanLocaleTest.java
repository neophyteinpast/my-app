package com.alex.app;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Locale;
import java.util.ResourceBundle;

import static org.junit.Assert.assertEquals;

public class GreetingAppGenerateMessageGermanLocaleTest {

    private static ResourceBundle bundle;
    private GreetingApp greetingApp;
    private static Locale locale;

    @BeforeClass
    public static void beforeClass() {

      locale = new Locale("de", "DE");
    }

    @Before
    public void before() {

        greetingApp = new GreetingApp();

         bundle = ResourceBundle.getBundle("i18n.MessageResource", locale);
    }

    //morning => Guten Morgen, Welt!!
    @Test
    public void generateMessageMorning() {

        String keyValues = "morning";
        assertEquals("Guten Morgen, Welt!", greetingApp.generateMessage(bundle, keyValues));
    }

    //day => Guten Tag, Welt!
    @Test
    public void generateMessageDay() {

        String keyValues = "day";
        assertEquals("Guten Tag, Welt!", greetingApp.generateMessage(bundle, keyValues));
    }

    //evening => Guten Abend Welt!
    @Test
    public void generateMessageEvening() {

        String keyValues = "evening";
        assertEquals("Guten Abend Welt!", greetingApp.generateMessage(bundle, keyValues));
    }

    //night => Gute Nacht, Welt!;
    @Test
    public void generateMessageNight() {

        String keyValues = "night";
        assertEquals("Gute Nacht, Welt!", greetingApp.generateMessage(bundle, keyValues));
    }
}