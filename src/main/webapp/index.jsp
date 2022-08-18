<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="com.example.projectslackbot.*"%>
<%@page import="java.util.*" %>
<!DOCTYPE html>
<style>
    h1
    {
        text-align: center;
        color: black;
    }
</style>
<html>
<head>
    <title>Slack bot reminders list</title>
</head>
<body>
<h1><%= "Reminders List" %>
</h1>
<hr>
<%
  userDAO d = new userDAO();
  ArrayList<String> reminders =(ArrayList<String>) d.getreminders();
  for(int i = 0;i<reminders.size();i++)
  {

%>
<h3><%= reminders.get(i) %></h3>

<% } %>
</body>
</html>