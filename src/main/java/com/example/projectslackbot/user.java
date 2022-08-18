package com.example.projectslackbot;
import com.example.projectslackbot.TimerClock;
public class user{
    private String message;
    private int minutes_from_now;
    private String slack_handle;
    public user()
    {
        message = "";
        minutes_from_now = 0;
        slack_handle = "";
    }
    public user(String m,String h, int mn)
    {
        message = m ;
        minutes_from_now = mn;
        slack_handle = h;

    }

    public String getMessage()
    {
        return message;
    }
    public int getMinutes()
    {
        return minutes_from_now;
    }
    public String getHandle()
    {
        return slack_handle;
    }
}