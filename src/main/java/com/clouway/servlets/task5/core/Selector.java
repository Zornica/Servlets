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

    public Selector(HttpServletRequest req){

        this.req = req;
    }

    public String select(double sum){
        String query="select currentSum from register where user = ? ";
 /*        double currentSum = jdbcTemplate.execute(query, new RowFetcher<Double>() {
            @Override
            public Double fetch(ResultSet rs) throws SQLException {
                return  rs.getDouble("currentSum");

            }
        });*/

        if (req.getParameter("check") != null) {
            message = "<p>You have " + account.currentState() + " in your account!</p>";
        } else if (req.getParameter("add") != null) {
            account.add(sum);
            message = "<p>You have " + account.currentState() + " in your account!</p>";
        } else if (req.getParameter("remove") != null) {
            account.remove(sum);
            message = "<p>You have " + account.currentState() + " in your account!</p>";
        }
        return message;
    }
}
