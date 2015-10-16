package com.clouway.servlets.task2;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by clouway on 15-10-13.
 */
public class ThreePagesServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        HttpSession session = req.getSession();
        String link = req.getParameter("link");
        if(link!=null){
            PrintWriter out = resp.getWriter();
            out.write("<!DOCTYPE html>\n"+"<html>\n"+"<body>\n"+"<h2>"+link+" was opened!</h2>\n"+"</body></html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
