package com.clouway.servlets.task5.http.core;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by clouway on 15-10-29.
 */
public class DataStoreCleaner {
    private final Connection connection;
    private Statement stmt;

    public DataStoreCleaner(Connection connection) {
        this.connection = connection;
    }

    public void cleanUp(String user)throws SQLException {
        try {

            stmt = connection.createStatement();
            stmt.executeUpdate("DELETE FROM register WHERE user = '"+user+"'");

        } finally {
            stmt.close();
        }
    }
}
