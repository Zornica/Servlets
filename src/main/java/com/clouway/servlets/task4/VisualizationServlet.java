package com.clouway.servlets.task4;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by clouway on 15-10-16.
 */
public class VisualizationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();
        Cookie[] cks = req.getCookies();
        out.write("<!DOCTYPE html>\n" +"<html>\n"+"<body>\n"+"<h2>"+cks[0].getValue()+" was opened!</h2>\n"+"</body></html>");


    }
}
