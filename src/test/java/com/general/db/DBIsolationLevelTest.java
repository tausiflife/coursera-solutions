package com.general.db;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.*;

public class DBIsolationLevelTest {
    private static DriverManagerDataSource dataSource = new DriverManagerDataSource();

    @BeforeClass
    public static void beforeClass() throws SQLException {
        dataSource.setUrl("jdbc:h2:mem:test;" +
                "INIT=RUNSCRIPT FROM 'C:/Users/TausifShakeel/Documents/personal/workspace/coursera-solutions/src/main/resources/create.sql'");
        dataSource.setUsername("sa");
        dataSource.setPassword("password");
    }

    private static Connection getConnectionWithReadCommittedIsolationLevel() throws SQLException {
        Connection conn = dataSource.getConnection();
        conn.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
        conn.setAutoCommit(false);
        return conn;
    }

    private static Connection getConnectionWithReadRepeatableIsolationLevel() throws SQLException {
        Connection conn = dataSource.getConnection();
        conn.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);
        conn.setAutoCommit(false);
        return conn;
    }

    @Test
    public void testReadCommittedIsolationLevel() throws SQLException, InterruptedException {
       Connection connection1 = getConnectionWithReadCommittedIsolationLevel();
       Connection connection2 = getConnectionWithReadCommittedIsolationLevel();
       Object object = new Object();
       Thread user1 = new Thread(new IsolationUser1(connection1, object));
       Thread user2 = new Thread(new IsolationUser2(connection2, object));
       user1.start();
       user2.start();
       user1.join();
       user2.join();
    }

    @Test
    public void testReadRepeatableIsolationLevel() throws SQLException, InterruptedException {
        Connection connection1 = getConnectionWithReadRepeatableIsolationLevel();
        Connection connection2 = getConnectionWithReadRepeatableIsolationLevel();
        Object object = new Object();
        Thread user1 = new Thread(new IsolationUser1(connection1, object));
        Thread user2 = new Thread(new IsolationUser2(connection2, object));
        user1.start();
        user2.start();
        user1.join();
        user2.join();
    }

}
