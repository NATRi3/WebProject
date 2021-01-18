package com.epam.web.dao.impl;

import com.epam.web.dao.BaseDao;
import com.epam.web.dao.UserDaoInterface;
import com.epam.web.entity.TypeAccess;
import com.epam.web.entity.TypeRole;
import com.epam.web.entity.User;
import com.epam.web.exception.DAOException;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao implements BaseDao<Long, User>, UserDaoInterface {
    private static final Logger logger = LogManager.getLogger(UserDao.class);
    private static final String SQL_SELECT_ALL =
            "SELECT idusers, name, email, access, image_name, role FROM users";
    private static final String SQL_SELECT_BY_EMAIL ="SELECT email FROM users.users WHERE email = ?";
    private static final String SQL_SELECT_BY_EMAIL_AND_PASSWORD ="SELECT name, email,idusers,access,image_name,role FROM users.users WHERE email = ? AND password = ?";
    private static final String SQL_SELECT_BY_ID = "SELECT name,email,idusers,access,image_name,role FROM users WHERE idusers = ?";
    private static final String SQL_INSERT_USER = "INSERT INTO `users`.`users` (`idusers`,`email`, `name`, `password`,`access`)VALUES (?,?, ?, ?,?);";
    private static final String SQL_DELETE_USER ="DELETE FROM users.users WHERE email=? AND password=?";
    private static final String SQL_UPDATE = "UPDATE `users`.`users`SET email = ? AND name =? AND access = ? AND image_name = ? AND role = ? WHERE idusers = ? LIMIT 1;";

    @Override
    public List<User> findAll() throws DAOException {
        List<User> result = new ArrayList<>();
        try(Connection connection = connection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_ALL);){
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int idUser = resultSet.getInt("idusers");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                TypeAccess access = TypeAccess.valueOf(resultSet.getString("access"));
                String image = resultSet.getString("image_name");
                TypeRole role = TypeRole.valueOf(resultSet.getString("role"));
                User user = new User(idUser,name,email,access,image,role);
                result.add(user);
            }
        } catch (SQLException e) {
            logger.info(e);
            throw new DAOException(e);
        }
        return result;
    }
    @Override
    public boolean isEmailExists(String email) throws DAOException {
        try(Connection connection = connection();
            PreparedStatement statement = connection.prepareStatement(SQL_SELECT_BY_EMAIL)){
            statement.setString(1,email);
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next();
        }catch (SQLException e) {
            throw new DAOException(e);
        }
    }
    @Override
    public User findEntityByEmailAndPassword(String email, String pass) throws DAOException {
        try(Connection connection = connection();
            PreparedStatement statement = connection.prepareStatement(SQL_SELECT_BY_EMAIL_AND_PASSWORD)){
            statement.setString(1,email);
            statement.setString(2,encryption(pass));
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            String name = resultSet.getString("name");
            String dbEmail = resultSet.getString("email");
            int id = resultSet.getInt("idusers");
            TypeAccess access = TypeAccess.valueOf(resultSet.getString("access"));
            String image = resultSet.getString("image_name");
            TypeRole role = TypeRole.valueOf(resultSet.getString("role"));
            return new User(id,name,dbEmail,access,image,role);
        }catch (SQLException e) {
            logger.info(e);
            throw new DAOException(e);
        }
    }

    @Override
    public User findEntityById(Long id) throws DAOException {
        try (Connection connection = connection();
            PreparedStatement statement = connection.prepareStatement(SQL_SELECT_BY_ID)){
            statement.setLong(1,id);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            String name = resultSet.getString("name");
            String email = resultSet.getString("email");
            long idUser = resultSet.getInt("idusers");
            TypeAccess access = TypeAccess.valueOf(resultSet.getString("access"));
            String imageName = resultSet.getString("image_name");
            TypeRole role = TypeRole.valueOf(resultSet.getString("role"));
            return new User(idUser,name,email,access,imageName,role);
        }catch (SQLException e) {
            logger.info(e);
            throw new DAOException(e);
        }
    }

    @Override
    public boolean delete(Long id) throws DAOException{
        return false;
    }

    @Override
    public boolean delete(String email, String password) throws DAOException {
        try(Connection connection = connection();
            PreparedStatement statement = connection.prepareStatement(SQL_DELETE_USER)){
            connection.setAutoCommit(false);
            statement.setString(1, email);
            statement.setString(2,password);
            int operation = statement.executeUpdate();
            if(operation==1){
                connection.commit();
                return true;
            }else {
                connection.rollback();
                return false;
            }
        } catch (SQLException e) {
            logger.error(e);
            throw new DAOException(e);
        }
    }

    @Override
    public User createUser(User user, String password) throws DAOException {
        try(Connection connection = connection();
            PreparedStatement statement = connection.prepareStatement(SQL_INSERT_USER)){
            statement.setLong(1,user.getId());
            statement.setString(2,user.getEmail());
            statement.setString(3,user.getName());
            statement.setString(4,password);
            statement.setString(5, user.getAccess().toString());
            statement.executeUpdate();
            return user;
        }catch (SQLException ex) {
            logger.info(ex);
            throw new DAOException("Something wrong with DataBase");
        }
    }

    @Override
    public User update(User user) throws DAOException {
        try (Connection connection = connection();
            PreparedStatement statement = connection.prepareStatement(SQL_UPDATE)){
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getName());
            statement.setString(3, String.valueOf(user.getAccess()));
            statement.setString(4, user.getImageName());
            statement.setString(5, String.valueOf(user.getRole()));
            statement.setLong(6, user.getId());
            statement.executeUpdate();
            return user;
        }catch (SQLException ex) {
            logger.info(ex);
            throw new DAOException("Something wrong with DataBase");
        }
    }

    @Override
    public User create(User user) throws DAOException {
        throw new UnsupportedOperationException();
    }

    private Connection connection() throws SQLException {
        return connectionPool.getConnection();
    }

    private String encryption(String pass){
        return DigestUtils.md5Hex(pass);
    }
}
