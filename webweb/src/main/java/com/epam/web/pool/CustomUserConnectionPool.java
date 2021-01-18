package com.epam.web.pool;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class CustomUserConnectionPool {
    public static final Logger logger = LogManager.getLogger(CustomUserConnectionPool.class);

    private static final int POOL_SIZE = 32;
    private BlockingQueue<Connection> freeConnections;
    private Queue<Connection> givenAwayConnection;

    public static CustomUserConnectionPool create(String url, String user, String pass) throws SQLException {
        CustomUserConnectionPool userConnectionPool = new CustomUserConnectionPool();
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        userConnectionPool.freeConnections = new LinkedBlockingDeque<>(POOL_SIZE);
        userConnectionPool.givenAwayConnection = new ArrayDeque<>();
        for (int i = 0; i<POOL_SIZE;i++) {
            userConnectionPool.freeConnections.add(DriverManager.getConnection(url, user, pass));
        }
        return userConnectionPool;
    }

    public Connection getConnection() throws SQLException {
        try {
            Connection connection = freeConnections.take();
            givenAwayConnection.add(connection);
            return connection;
        } catch (InterruptedException e) {
            logger.info(e);
            throw new SQLException();
        }
    }

    public void closeConnection(Connection connection) throws SQLException {
        if (connection != null) {
            givenAwayConnection.remove(connection);
            freeConnections.add(connection);
        } else {
            logger.info("Connection is null!");
            throw new SQLException("Connection is null!");
        }
    }

    public int getSize(){
        return freeConnections.size()+givenAwayConnection.size();
    }
}
