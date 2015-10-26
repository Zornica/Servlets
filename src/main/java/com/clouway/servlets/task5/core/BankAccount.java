package com.clouway.servlets.task5.core;

/**
 * Created by clouway on 15-10-21.
 */
public class BankAccount {

    public double currentSum;

    public BankAccount(double sum) {
        this.currentSum = sum;
    }

    public void add(double sum) {
        currentSum += sum;
    }

    public void remove(double sum) {
        currentSum -= sum;
    }

    public double currentState() {
        return currentSum;
    }
}
