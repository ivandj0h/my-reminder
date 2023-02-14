package com.ivandjoh.reminder.utils;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

public class QuartzScheduler {

    public static void executeTask(int args) {
        try {
            // Create a JobDetail object that specifies the details of the job to be executed
            JobDetail job = JobBuilder.newJob(CheckDoctorJob.class)
                    .withIdentity("Check Doctor Online", "doctor")
                    .build();

            // Create a Trigger object that specifies the schedule for the job
            Trigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity("doctorTrigger", "doctor")
                    .withSchedule(CronScheduleBuilder.cronSchedule("0 * * * * ?"))
                    .build();

            // Create a SchedulerFactory object to create a Scheduler instance
            SchedulerFactory factory = new StdSchedulerFactory();
            Scheduler scheduler = factory.getScheduler();

            // Schedule the job and trigger with the scheduler
            scheduler.scheduleJob(job, trigger);

            // Start the scheduler
            scheduler.start();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    public static class CheckDoctorJob implements Job {

        public void execute(JobExecutionContext context) throws JobExecutionException {
            System.out.println("Job executed at " + new Date());
        }
    }
}
