package com.alex.app;

import org.junit.Test;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.ResourceBundle;

import static org.junit.Assert.*;

public class GreetingAppTest_Parameterized_ResourseBundle {

    static ResourceBundle bundle = ResourceBundle.getBundle("i18n.MessageResource", new UTF8Control());
    GreetingApp greetingApp = new GreetingApp();

    private String input;
    private String expectedOutput;

    public GreetingAppTest_Parameterized_ResourseBundle(String input, String expectedOutput) {
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

        assertEquals(expectedOutput, greetingApp.generateMessage(bundle, input));
    }

}