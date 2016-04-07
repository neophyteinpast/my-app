package com.alex.app;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Locale;
import java.util.ResourceBundle;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class GreetingAppParameterizedDefaultLocaleTest {

    static Locale locale;
    static ResourceBundle bundle;
    GreetingApp greetingApp = new GreetingApp();

    private String input;
    private String expectedOutput;

    public GreetingAppParameterizedDefaultLocaleTest(String input, String expectedOutput) {
        this.input = input;
        this.expectedOutput = expectedOutput;
    }

    @Parameterized.Parameters
    public static Collection<String[]> testConditions() {
        String[][] expectedValues = {{"morning", "Доброе утро, Мир!"}, {"day", "Добрый день, Мир!"}, {"evening", "Добрый вечер, Мир!"}, {"night", "Доброй ночи, Мир!"}};
        return Arrays.asList(expectedValues);
    }

    @Test
    public void displayMessage() {

        locale = Locale.getDefault();

        if (locale.getISO3Country().equals("RUS")) {
            bundle = ResourceBundle.getBundle("i18n.MessageResource", new Utf8Control());
        }
        else {
            bundle = ResourceBundle.getBundle("i18n.MessageResource", locale);
        }

        assertEquals(expectedOutput, greetingApp.generateMessage(bundle, input));
    }
}