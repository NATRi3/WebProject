package com.epam.web.pool;

import com.mysql.cj.jdbc.MysqlDataSource;

public class MySqlDataSourceFactory {
    public static MysqlDataSource createDataSource(String url, String user, String pass){
        MysqlDataSource mysqlDataSource = new MysqlDataSource();
        mysqlDataSource.setUrl(url);
        mysqlDataSource.setUser(user);
        mysqlDataSource.setPassword(pass);
        return mysqlDataSource;
    }
}
