package com.example.projectslackbot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class reminderTest {

    @Test
    void checkObject1() {
        user u = new user();
        assertFalse(reminder.checkObject(u));
        user n = new user("hello","hello",1);
        assertTrue(reminder.checkObject(n));
    }

    @Test
    void storeReminder1() throws Exception {
        user n = new user("hello","hello",1);
        int i = reminder.storeReminder(n);
        assertEquals(1,i);
    }

    @Test
    void getReminder1() {
        user u = new user("hello","laiba",2);
        String s = reminder.getReminder(u);

        String check = "You will recieve the reminder at "+"2022-8-17"+" "+"18:45:00"+ " PKT";
        assertEquals(check,s);
    }


}