package com.example.projectslackbot;

import org.junit.jupiter.api.Test;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.SimpleTrigger;
import org.quartz.Trigger;
import com.example.projectslackbot.schedularJava;
import java.util.Date;
import java.util.UUID;

import static com.example.projectslackbot.schedularJava.scheduler;
import static org.junit.jupiter.api.Assertions.*;
import static org.quartz.TriggerBuilder.newTrigger;

class createQuartsJobTest {

    @Test
    void execute1()throws Exception
    {
        schedularJava j = new schedularJava();

        UUID randomUUID = UUID.randomUUID();
        String randomStr =  randomUUID.toString().replaceAll("_", "");

        int i = j.schedularevent(0,"m","m","m","m");
        assertEquals(1,i);
    }
}