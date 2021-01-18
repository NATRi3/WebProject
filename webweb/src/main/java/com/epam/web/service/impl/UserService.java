package com.epam.web.service.impl;

import com.epam.web.dao.impl.UserDao;
import com.epam.web.entity.TypeAccess;
import com.epam.web.entity.User;
import com.epam.web.exception.DAOException;
import com.epam.web.exception.ServiceException;
import com.epam.web.manager.MessageKey;
import com.epam.web.manager.impl.ErrorMessageManager;
import com.epam.web.service.UserServiceInterface;
import com.epam.web.validator.DataValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Random;

public class UserService implements UserServiceInterface {
    private static final Logger logger = LogManager.getLogger(UserService.class);
    private static final UserDao userDao = new UserDao();
    public static final DataValidator validator = new DataValidator();

    @Override
    public boolean activation(String code) throws ServiceException {
        try {
            long id = Long.parseLong(code);
            User activeUser = userDao.findEntityById(id);
            activeUser.setAccess(TypeAccess.ACTIVE);
            userDao.update(activeUser);
            return true;
        } catch (DAOException e) {
            logger.error("Failed activation attempt");
            throw new ServiceException(e);
        }
    }

    @Override
    public User login(String email, String password) throws ServiceException {
        User user;
        try {
            if (!(validator.isEmailValid(email))||!(validator.isPasswordValid(password))){
                throw new ServiceException(ErrorMessageManager.INSTANCE.getMessage(MessageKey.ERROR_MESSAGE_INVALID_PARAM));
            }
            user = userDao.findEntityByEmailAndPassword(email, password);
            return user;
        } catch (DAOException e) {
            logger.info("Failed login, wrong email or password " + email);
            throw new ServiceException(ErrorMessageManager.INSTANCE.getMessage(MessageKey.ERROR_MESSAGE_WRONG_EMAIL_OR_PASS));
        }
    }

    @Override
    public String registration(String name, String email, String password, String repeatPassword) throws ServiceException {
        try {
            if(userDao.isEmailExists(email)) {
                throw new ServiceException("Email is exists");
            }
            if (!(validator.isEmailValid(email))||!(validator.isPasswordValid(password))){
                throw new ServiceException("Invalid parameters");
            }
            try {
                User user1 = new User(createId(), name, email, TypeAccess.BLOCKED);
                userDao.create(user1);
                SendMail sendMail = new SendMail();
                sendMail.sendActivationMailTo(email, userDao.findEntityByEmailAndPassword(email,password).getId());
                return name;
            } catch (DAOException ex) {
                throw new ServiceException(ex);
            }
        } catch (DAOException e) {
            throw new ServiceException("Something go wrong try again");
        }
    }


    @Override
    public boolean deleteUser(String email, String password) {
        boolean result = false;
        try {
            result = userDao.delete(email,password);
        } catch (DAOException e) {
            logger.error("Failed delete attempt");
        }
        return result;
    }

    @Override
    public User getUserById(long id) throws ServiceException {
        try {
            return userDao.findEntityById(id);
        } catch (DAOException e) {
            logger.error(e);
            throw new ServiceException(e);
        }
    }

    @Override
    public User updateImage(User user) throws ServiceException {
        try {
            return userDao.update(user);
        } catch (DAOException e){
            logger.error(e);
            throw new ServiceException(e);
        }
    }
    private long createId(){
        return Math.abs(new Random().nextInt());
    }
}
