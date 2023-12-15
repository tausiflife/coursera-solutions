package com.general.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class IsolationUser2 extends DBIsolationLevel {

    public IsolationUser2(Connection connection, Object lockObj) {
        super(connection, lockObj);
    }

    @Override
    public void run() {
        synchronized (this.lockObj) {
            try {
                System.out.println("User 2 has started transaction");
                PreparedStatement preparedStatement = connection.prepareStatement("select id,name from employee");
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    System.out.println(String.format("Employee with id = %d and name = %s",
                            resultSet.getInt("id"), resultSet.getString("name")));
                }
                System.out.println("User 2 has selected records");
                lockObj.notify();
                lockObj.wait();
                preparedStatement = connection.prepareStatement("select id,name from employee");
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    System.out.println(String.format("Employee with id = %d and name = %s",
                            resultSet.getInt("id"), resultSet.getString("name")));
                }
                System.out.println("User 2 has selected records again");
            } catch (InterruptedException | SQLException e) {
                e.printStackTrace();
                lockObj.notifyAll();
            } finally {
                closeConnection();
            }

        }
    }


}
