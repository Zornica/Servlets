package com.clouway.servlets.task5.core;

import com.clouway.servlets.task5.core.BankAccount;
import com.clouway.servlets.task5.jdbc.ConnectionJDBC;
import com.clouway.servlets.task5.jdbc.JDBCTemplate;
import com.clouway.servlets.task5.jdbc.Providers;
import com.clouway.servlets.task5.jdbc.RowFetcher;

import javax.servlet.http.HttpServletRequest;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by clouway on 15-10-26.
 */
public class Selector {
    private BankAccount account;
    private String message;
    private HttpServletRequest req;
    ConnectionJDBC connect = new ConnectionJDBC();
    JDBCTemplate jdbcTemplate = new JDBCTemplate(Providers.of(connect.getConnection()));
    private String user;
    private double currentSum;

    public Selector(HttpServletRequest req, String user) {
        this.req = req;
        this.user = user;
    }


    private void getcurrentSum() {
        String query = "select currentSum from register where user = '"+user+"'";
        currentSum = jdbcTemplate.execute(query, new RowFetcher<Double>() {
            @Override
            public Double fetch(ResultSet rs) throws SQLException {
                return rs.getDouble("currentSum");

            }
        });
        account = new BankAccount(currentSum);
    }

    public String select(double sum) {
        getcurrentSum();
        if (req.getParameter("check") != null) {
            message = "<p>You have " + account.currentState() + " in your account!</p>";
        } else if (req.getParameter("add") != null) {
            account.add(sum);
            message = "<p>You have " + account.currentState() + " in your account!</p>";
        } else if (req.getParameter("remove") != null) {
            account.remove(sum);
            message = "<p>You have " + account.currentState() + " in your account!</p>";
        }
        currentSum = account.currentState();
        updateSum();
        return message;
    }

    private void updateSum() {
        String query = "update register set currentSum = " + currentSum + " where user = '" + user + "'";
        jdbcTemplate.makeRequest(query);
    }
}
