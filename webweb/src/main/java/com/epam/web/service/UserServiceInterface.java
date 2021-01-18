package com.epam.web.service;

import com.epam.web.entity.User;
import com.epam.web.exception.ServiceException;

public interface UserServiceInterface {
    boolean activation(String code)throws ServiceException;
    User login(String email, String password) throws ServiceException;
    String registration(String email, String password, String name, String repeatPassword) throws ServiceException;
    boolean deleteUser(String email, String password) throws ServiceException;
    User getUserById(long id) throws ServiceException;
    User updateImage(User user) throws ServiceException;
}
