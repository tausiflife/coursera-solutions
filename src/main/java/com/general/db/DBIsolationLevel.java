package com.general.db;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class DBIsolationLevel implements Runnable {

    protected Connection connection;
    protected Object lockObj;

    public DBIsolationLevel(Connection connection, Object lockObj) {
        this.connection = connection;
        this.lockObj = lockObj;
    }

    void closeConnection() {
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
