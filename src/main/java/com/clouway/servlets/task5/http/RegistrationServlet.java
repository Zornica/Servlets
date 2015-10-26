package com.clouway.servlets.task5.http;

import com.clouway.servlets.task5.core.Registration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

/**
 * Created by clouway on 15-10-26.
 */
public class RegistrationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String user = req.getParameter("user");
        String password = req.getParameter("password");

        Registration registration=new Registration();
        registration.insert(user,password);

        resp.getWriter().write("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Your bank</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<p><h1> You have registration!</h1></p>\n" +
                "<p> <a href=\"index.html\"> Home page</p>\n" +
                "</body>\n" +
                "</html>");
    }
}
