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
public class GreetingAppParameterizedUkrLocaleTest {

    static Locale locale;
    static ResourceBundle bundle;
    GreetingApp greetingApp = new GreetingApp();

    private String input;
    private String expectedOutput;

    public GreetingAppParameterizedUkrLocaleTest(String input, String expectedOutput) {
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

        locale = new Locale("ru", "UA");
        bundle = ResourceBundle.getBundle("i18n.MessageResource", locale);

        assertEquals(expectedOutput, greetingApp.generateMessage(bundle, input));
    }
}