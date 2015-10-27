package com.clouway.servlets.task5.http;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.clouway.servlets.task5.core.JettyServer;
import org.jmock.Expectations;
import org.jmock.auto.Mock;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.io.PrintWriter;


/**
 * Created by clouway on 15-10-26.
 */
public class LoginServletTest {

    private LoginServlet loginServlet;


    @Rule
    public JUnitRuleMockery context = new JUnitRuleMockery();

    @Mock
    private HttpServletResponse response = null;

    @Mock
    private HttpServletRequest request = null;



    @Before
    public void setUp() {

        loginServlet = new LoginServlet();
    }


    @Test
    public void loginWithExistingUser() throws Exception {

        final RequestUser requestUser = new RequestUser("koko","123789");


        context.checking(new Expectations() {{

            oneOf(response).setContentType("text/html");

            oneOf(request).getParameter("user");
            will(returnValue(requestUser.user));


            oneOf(request).getParameter("password");
            will(returnValue(requestUser.password));

            oneOf(request).getRequestDispatcher("welcomeServlet");
        }
        });

        loginServlet.doGet(request, response);
    }

    @Test
    public void loginWithNotExistingUser() throws Exception {

        final RequestUser requestUser = new RequestUser("ivan", "password");
        final PrintWriter writer = new PrintWriter("loginMessage.txt");

        context.checking(new Expectations() {{

            oneOf(response).setContentType("text/html");

            oneOf(request).getParameter("user");
            will(returnValue(requestUser.user));

            oneOf(request).getParameter("password");
            will(returnValue(requestUser.password));

            oneOf(response).getWriter();
            will(returnValue(writer));

            oneOf(request).getRequestDispatcher("index.html").include(request, response);

        }
        });

        loginServlet.doGet(request, response);
    }



}

