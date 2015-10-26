package com.clouway.servlets.task5.jdbc;

/**
 * Created by clouway on 15-10-26.
 */
public class Providers {

    public static <T> Provider<T> of(final T value) {
        return new Provider<T>() {
            @Override
            public T get() {
                return value;
            }
        };
    }
}
