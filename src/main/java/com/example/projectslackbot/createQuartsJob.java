package com.example.projectslackbot;

import org.apache.log4j.Logger;
import org.quartz.*;
import com.example.projectslackbot.userDAO;

import java.util.ArrayList;

//create CreateQuartzJob class that implements Job
public class createQuartsJob implements Job{

    //Create instance of logger
    private Logger log = Logger.getLogger(createQuartsJob.class);
    public static JobDetail jobDetail;
    public static JobKey reportIdToRun;

    //execute Job by using execute() method of the Job interface
    public void execute(JobExecutionContext jExeCtx) throws JobExecutionException {//handle JobExecutionException
        jobDetail = jExeCtx.getJobDetail();
        reportIdToRun =jobDetail.getKey();
        userDAO d = new userDAO();
        try {
        userslack User = d.getUsers();
        d.delete(User.primaryKey);
        slackAPI.sendmessage(User.message,User.handle);
            }
            catch (Exception e)
            {
                System.out.println(e.toString());
            }
    }
}
