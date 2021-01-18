package com.epam.web.pool;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionPool {
    private final DataSource dataSource;

    public ConnectionPool(String url, String user, String pass){
        dataSource = MySqlDataSourceFactory.createDataSource(url, user, pass);
    }
    public Connection getConnection() throws SQLException {
        Connection connection = dataSource.getConnection();
        return connection;
    }
}
