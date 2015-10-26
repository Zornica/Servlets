package com.clouway.servlets.task5.core;

import com.clouway.servlets.task5.jdbc.ConnectionJDBC;
import com.clouway.servlets.task5.jdbc.JDBCTemplate;
import com.clouway.servlets.task5.jdbc.Providers;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by clouway on 15-10-26.
 */
public class Registration {

    ConnectionJDBC connect = new ConnectionJDBC();
    JDBCTemplate jdbcTemplate = new JDBCTemplate(Providers.of(connect.getConnection()));


    public void insert(String user,String password){
        String query = "insert into register values(?,?,?)";
        jdbcTemplate.execute(query,user,password);
    }

}
