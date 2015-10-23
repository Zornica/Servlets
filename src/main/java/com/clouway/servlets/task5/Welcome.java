package com.clouway.servlets.task5;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

/**
 * Created by clouway on 15-10-22.
 */
public class Welcome extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        String user = req.getParameter("user");
        PrintWriter out = resp.getWriter();
        out.write("<!DOCTYPE html>\n" +
                "<html>\n"+"<head>\n"+"<title>Your Bank</title>\n<h2>Welcome,"+user+"!</h2>\n"+"<body>\n"+
        "<form action=\"selecterServlet\" methd=\"GET\" >\n"+"<fieldset>\n" +
                "        <legend style=\"color: midnightblue\">Your online banking is here!</legend>"+
        "<p> If you want to check your bank account, please select 'check your money'.\n If you want to add money in your account, please select 'add money'.\n" +
                "And if you want to remove money from your account, please select 'remove money'."+"</p>"+
             " <input type=\"submit\" name=\"check\" value=\"check your money\" />\n" +
                "    <input type=\"submit\" name=\"add\" value=\"ad money\" />\n" +
                "    <input type=\"submit\" name=\"remove\" value=\"remove money\" />\n" +
                "</form>"+"</body>\n"+"</html>");
    }
}
