package com.ivandjoh.reminder.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Timer;
import java.util.TimerTask;

public class ReminderHelper {

    Timer timer;

    private static final Logger log = LoggerFactory.getLogger(ReminderHelper.class);

    public ReminderHelper(int minutes) {
        timer = new Timer();
        timer.schedule(new RemindTask(), minutes * 60 * 1000);
    }

    class RemindTask extends TimerTask {
        public void run() {
            System.out.println("Time's up!");
            timer.cancel(); //Terminate the timer thread
        }
    }

    public static void executeTask(int args) {
        log.info("Task scheduled Started.");
        new ReminderHelper(args);
        System.out.println("Please wait for " + args + " minutes.");
    }
}
