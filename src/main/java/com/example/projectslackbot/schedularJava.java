package com.example.projectslackbot;

import org.apache.log4j.BasicConfigurator;
//import org.quartz.CronScheduleBuilder;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import static org.quartz.TriggerBuilder.*;
import java.util.Date;


public class schedularJava {


    private static String NAME_OF_JOB = "Job1";
    private static String NAME_OF_GROUP = "group1";
    private static String NAME_OF_TRIGGER = "triggerStart";

    //create variable scheduler of type Scheduler
    public static Scheduler scheduler;

    public int schedularevent(int i,String j,String g,String tr,String tg) throws Exception
    {

        NAME_OF_JOB = j;
        NAME_OF_GROUP =g;

        BasicConfigurator.configure();

        //show message to know about the main thread
        System.out.println(" The name of the QuartzScheduler main thread is: " + Thread.currentThread().getName());

        //initialize scheduler instance from Quartz
        scheduler = new StdSchedulerFactory().getScheduler();

        //start scheduler
        scheduler.start();

        //create scheduler trigger based on the time interval
        TimerClock t = new TimerClock();
        t.addMinutes(i);
        Date d = new Date();
        d.setHours(t.getHour());
        d.setMinutes(t.getMinutes());
        d.setSeconds(t.getSeconds());
        Trigger triggerNew =createTrigger(d,j,g,tr,tg);

        //schedule trigger
        scheduleJob(triggerNew);
        return 1;
    }
    //create scheduleJob() method to schedule a job
    private static int scheduleJob(Trigger triggerNew) throws Exception {

        //create an instance of the JoDetails to connect Quartz job to the CreateQuartzJob
        JobDetail jobInstance = JobBuilder.newJob(createQuartsJob.class).withIdentity(NAME_OF_JOB, NAME_OF_GROUP).build();

        //invoke scheduleJob method to connect the Quartz scheduler to the jobInstance and the triggerNew
        scheduler.scheduleJob(jobInstance, triggerNew);
        return 1;
    }
    //create createTrigger() method that returns a trigger based on the time interval
    private static Trigger createTrigger(Date d,String m,String n,String tr,String tg) {
        System.out.println(d);
        SimpleTrigger trigger = (SimpleTrigger) newTrigger()
                .withIdentity(tr, tg)
                .startAt(d)
                .forJob(m,n)
                .build();
        return trigger;
    }
}
