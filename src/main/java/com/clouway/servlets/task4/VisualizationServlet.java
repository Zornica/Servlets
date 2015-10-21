package com.clouway.servlets.task4;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

/**
 * Created by clouway on 15-10-16.
 */
public class VisualizationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();


        ServletContext sc = getServletContext();
        Object name = sc.getAttribute("servletName");
        out.write("<!DOCTYPE html>\n" +"<html>\n"+"<body>\n"+"<h2>"+name+" was opened!</h2>\n"+"</body></html>");


    }
}
