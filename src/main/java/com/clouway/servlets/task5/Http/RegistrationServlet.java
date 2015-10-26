package com.clouway.servlets.task5.Http;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

/**
 * Created by clouway on 15-10-26.
 */
public class RegistrationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String user = req.getParameter("user");
        String password = req.getParameter("password");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "clouway.com");
            PreparedStatement ps = con.prepareStatement("insert into register values(?,?,?)");
            ps.setString(1, user);
            ps.setString(2, password);
            ps.setDouble(3, 0.0);
            ps.execute();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        resp.getWriter().write("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Your bank</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<p><h1> You have registration!</h1></p>\n" +
                "<p> <a href=\"index.html\"> Home page</p>\n" +
                "</body>\n" +
                "</html>");
    }
}
