package com.alex.app;

import java.io.*;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.logging.*;

/**
 * Created by Alex on 12.03.2016.
 */
public class GreetingApp {

    private static final Logger LOGGER = Logger.getLogger(GreetingApp.class.getName());

    public static ResourceBundle bundle;

    DayTime morning = new DayTime(6, 0, 0);
    DayTime day = new DayTime(9, 0, 0);
    DayTime evening = new DayTime(19, 0, 0);
    DayTime night = new DayTime(23, 0, 0);
    DayTime midnight = new DayTime(23, 59, 59);
    DayTime startNewDay = new DayTime(0, 0, 0);
    static DayTime rightNow = new DayTime();

    public static void main(String[] args) throws MissingResourceException, NullPointerException {

        Handler fileHandler;
        Formatter simpleFormatter;

        try {
            fileHandler = new FileHandler("./greetingApp.formatter.log");
            simpleFormatter = new SimpleFormatter();
            LOGGER.addHandler(fileHandler);
            LOGGER.info("Finest message: Logger with DEFAULT FORMATTER");
            fileHandler.setFormatter(simpleFormatter);
            fileHandler.setLevel(Level.ALL);
            LOGGER.setLevel(Level.ALL);
            LOGGER.finest("Finest message: Logger with SIMPLE FORMATTER");
        }
        catch (FileNotFoundException e) {
            LOGGER.log(Level.SEVERE, "File not found", e);
        }
        catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error occur in FileHandler.", e);
        }

        bundle = ResourceBundle.getBundle("i18n.MessageResource", new UTF8Control());

        GreetingApp greetingApp = new GreetingApp();
        greetingApp.printMessage();
    }

    public String sayGreeting(DayTime now) {
        if (now.startTime.getTime().after(morning.startTime.getTime()) && now.startTime.getTime().before(day.startTime.getTime())) {
            return "morning";
        }

        if (now.startTime.getTime().after(day.startTime.getTime()) && now.startTime.getTime().before(evening.startTime.getTime())) {
            return "day";
        }

        if (now.startTime.getTime().after(evening.startTime.getTime()) && now.startTime.getTime().before(night.startTime.getTime())) {
            return "evening";
        }

        if ((now.startTime.getTime().after(night.startTime.getTime()) && now.startTime.getTime().before(midnight.startTime.getTime()))
            || (now.startTime.getTime().after(startNewDay.startTime.getTime()) && now.startTime.getTime().before(morning.startTime.getTime()))) {
            return "night";
        }

        else return null;
    }

    String currentValue;

    public String generateMessage(ResourceBundle bundle, String keyValue) {

        currentValue = bundle.getString(keyValue);
        return currentValue;
    }

    public void printMessage() {
        System.out.println(generateMessage(bundle, sayGreeting(rightNow)));
    }
}
