package com.alex.app;

import org.apache.log4j.*;

import java.util.Locale;
import java.util.ResourceBundle;


/**
 * Created by Alex on 12.03.2016.
 */
public class GreetingApp {

    final static Logger logger = Logger.getLogger(GreetingApp.class);

    private static ResourceBundle bundle;

    DayTime morning = new DayTime(6, 0, 0);
    DayTime day = new DayTime(9, 0, 0);
    DayTime evening = new DayTime(19, 0, 0);
    DayTime night = new DayTime(23, 0, 0);
    DayTime midnight = new DayTime(23, 59, 59);
    DayTime startNewDay = new DayTime(0, 0, 0);
    DayTime rightNow = new DayTime();

    public static void main(String[] args) {


        Locale locale = Locale.getDefault();

        if (locale.getISO3Country().equals("RUS")) {
            bundle = ResourceBundle.getBundle("i18n.MessageResource", new Utf8Control());
            logger.info("The bundle is on language: " + locale.getDisplayLanguage());
        }
        else {
            bundle = ResourceBundle.getBundle("i18n.MessageResource", locale);
            logger.info("The bundle is on language: " + locale.getDisplayLanguage());
        }

        GreetingApp greetingApp = new GreetingApp();
        greetingApp.printMessage();
    }

    public String sayGreeting(DayTime now) {

        logger.info("Entering the sayGreeting method");

        if (now.startTime.getTime().after(morning.startTime.getTime()) && now.startTime.getTime().before(day.startTime.getTime())) {
            logger.info("The sayGreeting method returned the value \"morning\"");
            return "morning";
        }

        if (now.startTime.getTime().after(day.startTime.getTime()) && now.startTime.getTime().before(evening.startTime.getTime())) {
            logger.info("The sayGreeting method returned the value \"day\"");
            return "day";
        }

        if (now.startTime.getTime().after(evening.startTime.getTime()) && now.startTime.getTime().before(night.startTime.getTime())) {
            logger.info("The sayGreeting method returned the value \"evening\"");
            return "evening";
        }

        if ((now.startTime.getTime().after(night.startTime.getTime()) && now.startTime.getTime().before(midnight.startTime.getTime()))
            || (now.startTime.getTime().after(startNewDay.startTime.getTime()) && now.startTime.getTime().before(morning.startTime.getTime()))) {
            logger.info("The sayGreeting method returned the value \"night\"");
            return "night";
        }

        else return null;
    }

    private String currentValue;

    public String generateMessage(ResourceBundle bundle, String keyValue) {

        logger.info("Entering the generateMessage method");
        currentValue = bundle.getString(keyValue);
        logger.info("The generateMessage returned the message " + "\"" + bundle.getString(keyValue) + "\"");
        return currentValue;
    }

    public void printMessage() {

        logger.info("Entering the printMessage method");
        System.out.println(generateMessage(bundle, sayGreeting(rightNow)));
    }
}
