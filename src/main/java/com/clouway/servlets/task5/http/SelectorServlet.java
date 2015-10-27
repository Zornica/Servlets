package com.clouway.servlets.task5.http;

import com.clouway.servlets.task5.core.Selector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

/**
 * Created by clouway on 15-10-22.
 */
public class SelectorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletContext scr = getServletContext();
        String user = scr.getAttribute("user").toString();
        Double money = Double.parseDouble(req.getParameter("money"));
        PrintWriter out = resp.getWriter();
        String message = null;

            Selector selector = new Selector(req,user);
            message = selector.select(money);

        ServletContext sc = getServletContext();
        sc.setAttribute("message", message);
        RequestDispatcher rd = req.getRequestDispatcher("messageServlet");
        rd.forward(req, resp);
    }
}
