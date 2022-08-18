package com.example.projectslackbot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class slackAPITest {

    @Test
    void sendmessage1() {
        int i = slackAPI.sendmessage("hello","Laiba Aftab");
        assertEquals(-1,i);

    }

    @Test
    void sendmessage2() {
        int i = slackAPI.sendmessage("hello","Laiba Aftab");
        assertEquals(1,i);

    }
}