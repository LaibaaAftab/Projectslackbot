package com.resources;

import org.junit.jupiter.api.Test;

import javax.ws.rs.core.Response;

import static org.junit.jupiter.api.Assertions.*;

class rcrcsTest {

    @Test
    void postReminder1() throws Exception {
        rcrcs r = new rcrcs();
        Response m = r.postReminder("{\n" +
                " \"message\":\"You met\",\n" +
                " \"minutes_from_now\":1,\n" +
                " \"slack_handle\":\"bsef19a524\"\n" +
                "}");
        assertEquals(200,m.getStatus());
    }

    @Test
    void postReminder2() throws Exception {
        rcrcs r = new rcrcs();
        Response m = r.postReminder("{\n" +
                " \"message\":\"You met\",\n" +
                " \"minutes_from_now\":0,\n" +
                " \"slack_handle\":\"bsef19a524\"\n" +
                "}");
        assertEquals(400,m.getStatus());
    }
}