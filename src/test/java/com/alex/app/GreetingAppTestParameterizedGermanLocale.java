package com.alex.app;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Locale;
import java.util.ResourceBundle;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class GreetingAppTestParameterizedGermanLocale {

    static Locale locale;
    static ResourceBundle bundle;
    GreetingApp greetingApp = new GreetingApp();

    private String input;
    private String expectedOutput;

    public GreetingAppTestParameterizedGermanLocale(String input, String expectedOutput) {
        this.input = input;
        this.expectedOutput = expectedOutput;
    }

    @Parameterized.Parameters
    public static Collection<String[]> testConditionsGerman() {
        String[][] expectedValues = {{"morning", "Guten Morgen, Welt!"}, {"day", "Guten Tag, Welt!"}, {"evening", "Guten Abend Welt!"}, {"night", "Gute Nacht, Welt!"}};
        return Arrays.asList(expectedValues);
    }

    @Test
    public void displayMessage_German() {

        locale = new Locale("de", "GE");

        if (locale.getISO3Country().equals("RUS")) {
            bundle = ResourceBundle.getBundle("i18n.MessageResource", new Utf8Control());
        }
        else {
            bundle = ResourceBundle.getBundle("i18n.MessageResource", locale);
        }

        assertEquals(expectedOutput, greetingApp.generateMessage(bundle, input));
    }
}