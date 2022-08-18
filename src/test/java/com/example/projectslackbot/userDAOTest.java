package com.example.projectslackbot;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class userDAOTest {

    @Test
    void insert1()throws Exception {
        user u = new user("hello","okay",1);
        userDAO d = new userDAO();
        int i = d.insert(u);
        assertEquals(1,i);
    }

    @Test
    void delete1()throws Exception{
        userDAO d = new userDAO();
        int i = d.delete(1);
        assertEquals(0,i);
    }

    @Test
    void getusers1() throws  Exception{
        userDAO d = new userDAO();
        userslack e = d.getUsers();
        //assertNull(e);
        assertNotNull(e);
    }

    @Test
    void getreminders1()throws Exception{
        userDAO d = new userDAO();
        ArrayList<String> e = d.getreminders();
        assertEquals(10,e.size());

    }


}