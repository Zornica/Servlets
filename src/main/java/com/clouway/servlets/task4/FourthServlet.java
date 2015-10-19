package com.clouway.servlets.task4;


import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by clouway on 15-10-16.
 */
public class FourthServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cookie[] cks = req.getCookies();
        String name = cks[0].getValue();

        Cookie ck = new Cookie("servletName",name);
        resp.addCookie(ck);
        resp.sendRedirect("visualizationServlet");


    }
}
