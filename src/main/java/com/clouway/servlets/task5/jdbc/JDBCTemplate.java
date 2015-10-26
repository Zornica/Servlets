package com.clouway.servlets.task5.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by clouway on 15-10-26.
 */
public class JDBCTemplate {

    private final Provider<Connection> dbConn;

    public JDBCTemplate(Provider<Connection> dbConn) {
        this.dbConn = dbConn;
    }

    public void execute(String query, String user, String password) {
        PreparedStatement stmt = null;
        try {
            stmt = dbConn.get().prepareStatement(query);
            stmt.setString(1, user);
            stmt.setString(2, password);
            stmt.setDouble(3, 0.0);
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException sql) {
                sql.printStackTrace();
            }
        }
    }

    public <T> List<T> execute(String query, RowFetcher<T> fetcher) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = dbConn.get().prepareStatement(query);
            List<T> addresses = new ArrayList<T>();
            rs = stmt.executeQuery();
            while (rs.next()) {
                addresses.add(fetcher.fetch(rs));
            }
            return addresses;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null && rs != null) {
                    stmt.close();
                    rs.close();
                }
            } catch (SQLException sql) {
                sql.printStackTrace();
            }
        }
        return null;
    }
}
