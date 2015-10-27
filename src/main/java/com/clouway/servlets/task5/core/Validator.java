package com.clouway.servlets.task5.core;

import com.clouway.servlets.task5.jdbc.ConnectionJDBC;
import java.sql.*;


public class Validator {
    public static boolean checkUser(String user, String password) {
        boolean st = false;
        String query ="select * from register where user = ? and password = ?";
        try {
            ConnectionJDBC con = new ConnectionJDBC();
            PreparedStatement ps = con.getConnection().prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            st = rs.next();
        }  catch (SQLException e) {
            e.printStackTrace();
        }
        return st;
    }
}
