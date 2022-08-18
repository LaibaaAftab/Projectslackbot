package com;

import org.junit.jupiter.api.Test;

import javax.ws.rs.ApplicationPath;

import static org.junit.jupiter.api.Assertions.*;

class ApplicationTest {
    @Test
    public void okay1()
    {
        Application a = new Application();
        assertNotNull(a);
    }

}