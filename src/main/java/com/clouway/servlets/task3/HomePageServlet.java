package com.clouway.servlets.task3;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by clouway on 15-10-16.
 */
public class HomePageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.write("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Home page</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h2>Home page</h2>\n" +
                "<form action=\"/myservlet\" method=\"post\">\n" +
                "    <p>\n" +
                "        <input type=\"radio\" name=\"link\" value=\"Second link\" checked/>\n" +
                "        <a href=\"myservlet?link=second_link\">Second link</a></p>\n" +
                "    <p>\n" +
                "        <input type=\"radio\" name=\"link\" value=\"Third link\"/>\n" +
                "        <a href=\"myservlet?link=third_link\" >Third link</a></p>\n" +
                "    <p>\n" +
                "        <input type=\"radio\" name=\"link\" value=\"Fourth link\"/>\n" +
                "        <a href=\"myservlet?link=fourth_link\" >Fourth link</a></p>\n" +
                "    <p>\n" +
                "        <input type=\"submit\" value=\"Submit\"></p>\n" +
                "</form>\n" +
                "</body>\n" +
                "</html>");
    }
}
