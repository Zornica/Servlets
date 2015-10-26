package com.clouway.servlets.task5.Http;

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
        out.write("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Your bank</title>\n" +
                "</head>\n" +
                "<body style=\"background-color:gainsboro\">\n" +
                "<p><h1>"+message +"</h1></p>\n"+
                "</body>\n" +
                "</html>");
    }
}
