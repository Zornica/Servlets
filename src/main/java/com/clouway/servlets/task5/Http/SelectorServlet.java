package com.clouway.servlets.task5.Http;

import com.clouway.servlets.task5.core.BankAccount;
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
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "clouway.com");
            PreparedStatement ps = con.prepareStatement("select currentSum from register where user = ? ");
            ps.setString(1, user);
            ResultSet rs = ps.executeQuery();
            double sum = 0.0;
            if (rs.next()) {
                sum = rs.getDouble("currentSum");
            }

            BankAccount account = new BankAccount(sum);

            Selector selector = new Selector(account, req);
            message = selector.select(money);

            PreparedStatement p = con.prepareStatement("update register set currentSum = ? where user =? ");
            p.setDouble(1, account.currentState());
            p.setString(2, user);
            p.execute();

            ServletContext sc = getServletContext();
            sc.setAttribute("message", message);
            RequestDispatcher rd = req.getRequestDispatcher("messageServlet");
            rd.forward(req, resp);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
