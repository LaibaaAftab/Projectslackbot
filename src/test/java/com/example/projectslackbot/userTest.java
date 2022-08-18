package com.example.projectslackbot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class userTest {

    @Test
    void getMessage1() {
        user u = new user("laiba","laiba",1);
        String s = u.getMessage();
        assertEquals("laiba",s);
    }

    @Test
    void getMinutes1() {
        user u = new user("h","laiba",1);
        int i = u.getMinutes();
        assertEquals(1,i);
    }

    @Test
    void getHandle1() {
        user u = new user("h","laiba",1);
        String s = u.getHandle();
        assertEquals("laiba",s);
    }
}