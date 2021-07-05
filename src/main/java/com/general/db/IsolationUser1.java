package com.general.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class IsolationUser1 extends DBIsolationLevel {

    public IsolationUser1(Connection connection, Object lockObj) {
        super(connection, lockObj);
    }

    @Override
    public void run() {
        synchronized (this.lockObj) {
            try {
                System.out.println("User 1 has started transaction");
                lockObj.notify();
                lockObj.wait();
                PreparedStatement preparedStatement = connection.prepareStatement("update employee set name=? where id=?");
                preparedStatement.setString(1, "emp1updated");
                preparedStatement.setInt(2, 1);
                preparedStatement.executeUpdate();
                connection.commit();
                System.out.println("User 1 has updated employee 1");
                lockObj.notify();
            } catch (InterruptedException | SQLException e) {

            } finally {
                closeConnection();
            }

        }
    }


}
