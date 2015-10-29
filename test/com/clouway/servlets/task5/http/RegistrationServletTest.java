package com.clouway.servlets.task5.http;

import com.clouway.servlets.task5.http.core.DataStoreCleaner;
import com.clouway.servlets.task5.http.core.RequestUser;
import com.clouway.servlets.task5.jdbc.ConnectionJDBC;
import org.jmock.Expectations;
import org.jmock.auto.Mock;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;
import java.sql.SQLException;

import static org.junit.Assert.*;

/**
 * Created by clouway on 15-10-29.
 */
public class RegistrationServletTest {


    private RegistrationServlet registrationServlet;
    ConnectionJDBC connect = new ConnectionJDBC();
    DataStoreCleaner cleaner = new DataStoreCleaner(connect.getConnection());
   final  RequestUser requestUser = new RequestUser("sisa","147258");


    @Rule
    public JUnitRuleMockery context = new JUnitRuleMockery();

    @Mock
    private HttpServletResponse response = null;

    @Mock
    private HttpServletRequest request = null;



    @Before
    public void setUp() throws SQLException {

        registrationServlet= new RegistrationServlet();
        cleaner.cleanUp(requestUser.user);
    }


    @Test
    public void registerUser() throws Exception {

       final  PrintWriter writer = new PrintWriter("register.txt");


        context.checking(new Expectations() {{

            oneOf(response).setContentType("text/html");

            oneOf(request).getParameter("user");
            will(returnValue(requestUser.user));


            oneOf(request).getParameter("password");
            will(returnValue(requestUser.password));

            oneOf(response).getWriter();
            will(returnValue(writer));


        }
        });

        registrationServlet.doGet(request, response);
    }

}