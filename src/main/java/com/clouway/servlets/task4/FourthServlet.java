package com.clouway.servlets.task4;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Created by clouway on 15-10-16.
 */
public class FourthServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletContext sc = getServletContext();
        Object name = sc.getAttribute("sevletName");
        RequestDispatcher rd = req.getRequestDispatcher("visualizationServlet");
        rd.forward(req, resp);

    }
}
