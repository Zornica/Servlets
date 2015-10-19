package com.clouway.servlets.task3;

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
public class CounterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        HttpSession session = req.getSession();
        String link = req.getParameter("link");
        Integer count = (Integer) session.getAttribute(link);
        PrintWriter out = resp.getWriter();
        if (link != null) {
            if (count == null) {
                count = 1;
                session.setAttribute(link, count);
                out.write("<!DOCTYPE html>\n"+"<html>\n"+"<body>\n"+"<h2>Greetings!You are the first client!\n"
                        +link+" was opened!</h2>\n"+"</body></html>");
            } else {
                count += 1;
                session.setAttribute(link, count);
                out.write("<!DOCTYPE html>\n"+"<html>\n"+"<body>\n"+"<h2>"
                        +link+" was opened!</h2>\n"+"</body></html>");
            }

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
