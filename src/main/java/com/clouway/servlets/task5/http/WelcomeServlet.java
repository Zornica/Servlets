package com.clouway.servlets.task5.http;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by clouway on 15-10-22.
 */
public class WelcomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        String user = req.getParameter("user");
        PrintWriter out = resp.getWriter();
        out.write("<!DOCTYPE html>\n" +
                "<html>\n" + "<head>\n" + "<title>Your Bank</title>\n<h2>WelcomeServlet," + user + "!</h2>\n" + "<body style=\"background-color:gainsboro\">\n" +
                "<form action=\"selectorServlet\" methd=\"GET\"  style=\" background-color: floralwhite; position: absolute;\">\n" + "<fieldset>\n" +
                "        <legend style=\"color: midnightblue\">Your online banking is here!</legend>" +
                "<p> Choose sum:<input type=\"text\" name=\"money\">" + "</p>" +
                " <input type=\"submit\" name=\"check\" value=\"check your money\" />\n" +
                "    <input type=\"submit\" name=\"add\" value=\"add money\" />\n" +
                "    <input type=\"submit\" name=\"remove\" value=\"remove money\" />\n" +
                "</form>" + "</body>\n" + "</html>");

        ServletContext sc = getServletContext();
        sc.setAttribute("user", user);
    }


}
