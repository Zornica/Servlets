package com.clouway.servlets.task5.core;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

/**
 * Created by clouway on 15-10-26.
 */
public class JettyServer {

    public static void main(String[] args) throws Exception {

        Server server = new Server(8080);
        WebAppContext webAppcontext = new WebAppContext();
        webAppcontext.setContextPath("/");
        webAppcontext.setWar("src/main/webapp");
        server.setHandler(webAppcontext);
        server.start();
        server.join();

    }


}
