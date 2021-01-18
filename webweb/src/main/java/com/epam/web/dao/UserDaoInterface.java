package com.epam.web.dao;

import com.epam.web.entity.User;
import com.epam.web.exception.DAOException;

public interface UserDaoInterface {
    boolean isEmailExists(String email) throws DAOException;

    User findEntityByEmailAndPassword(String email, String pass) throws DAOException;

    boolean delete(String email, String password) throws DAOException;

    User createUser(User user, String password) throws DAOException;
}
