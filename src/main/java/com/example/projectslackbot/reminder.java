package com.example.projectslackbot;

import javax.ws.rs.core.Response;
import java.util.ArrayList;

public class reminder {
    public static boolean checkObject(user setREm)
    {
        if(setREm.getHandle().equals("") || setREm.getMessage().equals("") || setREm.getMinutes()<=0 )
        {
            return false;
        }
        return true;
    }

    public static int storeReminder(user setREm)throws Exception
    {
        userDAO database = new userDAO();
        return database.insert(setREm);
    }

    public static String getReminder(user setREm)
    {
        TimerClock curTime = new TimerClock();
        curTime.addMinutes(setREm.getMinutes());
        String message = "You will recieve the reminder at "+curTime.getDate()+" "+curTime.getTime() + " PKT";
        return message;
    }



}
