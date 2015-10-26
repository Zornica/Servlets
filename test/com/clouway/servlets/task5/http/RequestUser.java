package com.clouway.servlets.task5.http;

/**
 * Created by clouway on 15-10-26.
 */
public class RequestUser {
    public final String user;
    public final String password;

    public RequestUser(String user,String password){
        this.user = user;
        this.password=password;
    }
}
