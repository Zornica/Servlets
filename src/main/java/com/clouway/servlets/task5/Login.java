package com.clouway.servlets.task5;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by clouway on 15-10-22.
 */
public class Login extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String user = req.getParameter("user");
        String password = req.getParameter("password");
        if (Validate.checkUser(user, password)) {
            RequestDispatcher rc = req.getRequestDispatcher("welcome");
            rc.forward(req, resp);
        } else {
            resp.getWriter().write("Username or password is not correct!");
            RequestDispatcher rs = req.getRequestDispatcher("index.html");
            rs.include(req, resp);
        }
    }
}
