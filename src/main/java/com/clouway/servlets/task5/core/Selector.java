package com.clouway.servlets.task5.core;

import com.clouway.servlets.task5.core.BankAccount;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by clouway on 15-10-26.
 */
public class Selector {
    private BankAccount account;
    private String message;
    private HttpServletRequest req;

    public Selector(BankAccount account, HttpServletRequest req){
        this.account = account;
        this.req = req;
    }

    public String select(double sum){
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
