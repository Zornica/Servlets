package com.clouway.servlets.task5;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by clouway on 15-10-23.
 */
public class MessageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter out = resp.getWriter();
        ServletContext sc = getServletContext();
        Object message = sc.getAttribute("message");
        out.write("<!DOCTYPE html>\n" + "<html>\n" + "<body>\n" + "<h2>" + message + "</h2>\n" + "</body></html>");
    }
}
