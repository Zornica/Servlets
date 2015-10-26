package com.clouway.servlets.task5.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by clouway on 15-10-26.
 */
public interface RowFetcher<T> {

    T fetch(ResultSet rs) throws SQLException;

}
