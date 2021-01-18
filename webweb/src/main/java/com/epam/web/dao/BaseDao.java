package com.epam.web.dao;

import com.epam.web.entity.User;
import com.epam.web.exception.DAOException;
import com.epam.web.pool.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public interface BaseDao<T,K> {
    static final Logger logger = LogManager.getLogger(BaseDao.class);
    static final String user = "root";
    static final String pass = "root";
    static final String url = "jdbc:mysql://localhost:3306/users?serverTimezone=Europe/Moscow";
    public static ConnectionPool connectionPool = new ConnectionPool(url,user,pass);
    List<K> findAll() throws DAOException;
    K findEntityById (T t) throws DAOException;
    boolean delete (T id) throws DAOException;
    K update(K k) throws DAOException;
    K create (K k) throws DAOException;
    default void close(Statement statement){
        try{
            if(statement!=null){
                statement.close();
            }
        }catch (SQLException e){
            logger.info(e);
        }
    }
    default void close (Connection connection){
        try{
            if (connection != null){
                connection.close();
            }
        }catch (SQLException e){
            logger.info(e);
        }
    }
}
