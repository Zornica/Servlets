package com.clouway.servlets.task1;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class ThreeLinksServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        HttpSession session = req.getSession();
        String link = req.getParameter("link");
        Integer count = (Integer) session.getAttribute(link);
        if (count == null) {
            count = 1;
        } else {
            count += 1;
        }
        if (link != null) {
            session.setAttribute(link, count);
        }
        PrintWriter out = resp.getWriter();
        out.write("<!Doctype html>\n" + "<html>\n" +
                "<body>\n" +
                "<p>\n" + "<a href=" + "test?link=first_link" + " name = " + "tutorialspoint" + ">first link</a>\n" +
                "<div >Visits count: " + session.getAttribute("first_link") + "</div>\n" + "</p>\n" +
                "<p>\n" + "<a href=" + "test?link=second_link" + ">second link</a>\n" +
                "<div >Visits count: " + session.getAttribute("second_link") + "</div>\n" + "</p>\n" +
                "<p>\n" + "<a href=" + "test?link=third_link" + ">third link</a>\n" +
                "<div >Visits count: " + session.getAttribute("third_link") + "</div>\n" + "</p>\n" +
                "</body>\n" + "</html>");
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
