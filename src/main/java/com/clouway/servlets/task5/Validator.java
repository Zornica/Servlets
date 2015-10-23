package com.clouway.servlets.task5;

import javax.xml.transform.Result;
import java.sql.*;

/**
 * Created by clouway on 15-10-22.
 */
public class Validator {
    public static boolean checkUser(String user, String password) {
        boolean st = false;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "clouway.com");
            PreparedStatement ps = con.prepareStatement("select * from register where user = ? and password = ?");
            ps.setString(1, user);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            st = rs.next();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return st;
    }
}
