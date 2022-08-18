package com.example.projectslackbot;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import com.example.projectslackbot.user;
public class userDAO {
    private static PreparedStatement st;
    private static  Connection con;
    // Class.("com.mysql.jdbc.Driver");

    public int insert(user u) throws Exception
    {

            Date d = new Date(0);
            Time t=new Time(0);
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://127.0.0.1/reminder";
            con = DriverManager.getConnection(url, "root", "root");
            String query="Insert into slackbot(time,handle,message,date)VALUES(?,?,?,?)";
            st = con.prepareStatement(query);
            TimerClock curTime = new TimerClock();
            curTime.addMinutes(u.getMinutes());
            st.setTime(1,t.valueOf(curTime.getTime()));
            st.setString(2,u.getHandle());
            st.setString(3,u.getMessage());
            st.setDate(4,d.valueOf(curTime.getDate()));
        return st.executeUpdate();

    }
    public ArrayList<String> getreminders() throws Exception {
        ArrayList<String> a = new ArrayList<>();
           Class.forName("com.mysql.jdbc.Driver");
           String url = "jdbc:mysql://127.0.0.1/reminder";
           con = DriverManager.getConnection(url, "root", "root");
           String query = "Select * from slackbot";
           st = con.prepareStatement(query);
           ResultSet rs = st.executeQuery();
           int  i =1;
           while(rs.next())
           {
                String reminders = "";
               reminders = reminders+ Integer.toString(i);
               reminders = reminders+". Handle: ";
               reminders = reminders+rs.getString(3);
               reminders = reminders + " ,message: ";
               reminders = reminders + rs.getString(4);
               reminders = reminders + ", Time: ";
               reminders = reminders + rs.getString(2);
               reminders = reminders + ", Date: ";
               reminders = reminders + rs.getString(5);
               a.add(reminders);
               i++;

       }
      return a;
    }
    public userslack getUsers() throws Exception {
        userslack u = new userslack(0,"","");
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://127.0.0.1/reminder";
            con = DriverManager.getConnection(url, "root", "root");
            Date da = new Date(0);
            Time t = new Time(0);
            String query="Select * from slackbot where time = ? and date = ?";
            TimerClock v = new TimerClock();
            st = con.prepareStatement(query);
            st.setTime(1,t.valueOf(v.getTime()));
            st.setDate(2,da.valueOf(v.getDate()));
            ResultSet rs = st.executeQuery();
            while(rs.next())
            {
                u = new userslack(rs.getInt(1),rs.getString(4),rs.getString(3));
                return u;
            }
        return u;
    }
    public int delete(int ii) throws Exception
    {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://127.0.0.1/reminder";
        con = DriverManager.getConnection(url, "root", "root");
        String query="Delete from slackbot where reminderNo = ?";
        st = con.prepareStatement(query);
        st.setInt(1,ii);
        return st.executeUpdate();
    }
}
