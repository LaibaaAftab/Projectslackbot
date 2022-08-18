package com.example.projectslackbot;

import org.junit.jupiter.api.Test;
import org.quartz.Scheduler;

import static org.junit.jupiter.api.Assertions.*;

class schedularJavaTest {

    @Test
    void schedularevent()throws Exception {
        schedularJava s = new schedularJava();
        int i = s.schedularevent(1,"l","l","l","l");
        assertEquals(1,i);
    }
}