package com.example.projectslackbot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TimerClockTest {

    @Test
    void getTime1() {
        TimerClock t = new TimerClock();
        String s = "23:7:00";
        assertEquals(s,t.getTime());
    }

    @Test
    void addMinutes1(){
        TimerClock t = new TimerClock();
        assertEquals(7,t.addMinutes(120));
    }

    @Test
    void getHour1() {
        TimerClock t = new TimerClock();
        assertEquals(23,t.getHour());
    }

    @Test
    void getMinute1() {
        TimerClock t = new TimerClock();
        assertEquals(5,t.getMinutes());
    }

    @Test
    void getSeconds1() {
        TimerClock t = new TimerClock();
        int i = t.getSeconds();
        assertEquals(0,i);
    }

    @Test
    void getDate1() {
        TimerClock t = new TimerClock();
        String s = t.getDate();
        assertEquals("2022-8-18",s);
    }
}