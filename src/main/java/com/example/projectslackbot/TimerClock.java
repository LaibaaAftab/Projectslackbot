package com.example.projectslackbot;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimerClock {

    private int Year;
    private int month;
    private int day;
    private int hour;
    private int minute;
    private int seconds;
    public TimerClock()
    {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YYYY:MM:dd:HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        //String[] currentTime = (dtf.format(now)).split(":");
        String t = dtf.format(now);
        String[] currentTime=t.split(":");
        Year = Integer.parseInt(currentTime[0]);
        month = Integer.parseInt(currentTime[1]);
        day = Integer.parseInt(currentTime[2]);
        hour = Integer.parseInt(currentTime[3]);
        minute = Integer.parseInt(currentTime[4]);
        seconds = 0;
    }
    public String getTime()
    {
        String s =Integer.toString(hour)+":"+Integer.toString(minute)+":"+"00";
        return s;
    }
    public int addMinutes(int m)
    {
        if(m>=0)
        {
            minute = minute + m;
            int leftm = minute / 60;
            int lefts = minute % 60;
            if(leftm>0) {
                minute =lefts ;
                hour = hour + leftm;
                leftm = hour / 24;
                lefts = hour % 24;
                if(leftm>0) {
                    hour =  lefts;
                    day = day + leftm;
                    leftm = day / 30;
                    lefts = day % 30;
                    if(leftm>0) {
                        day = lefts;
                        month = month + lefts;
                        leftm = month / 12;
                        lefts = month % 12;
                        if(leftm>0)
                        {
                            month = 1;
                            Year = Year + lefts;
                        }
                    }
                }
            }
        }
        return minute;
    }
    public int getHour()
    {
        return hour;
    }
    public int getMinutes()
    {
        return minute;}
    public int getSeconds()
    {
        return seconds;
    }
    public String getDate()
    {
        return Integer.toString(Year)+"-"+Integer.toString(month)+"-"+Integer.toString(day);
    }
}
