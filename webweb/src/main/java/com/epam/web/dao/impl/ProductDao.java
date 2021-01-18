package com.epam.web.dao.impl;

import com.epam.web.dao.BaseDao;
import com.epam.web.dao.ProductDaoInterface;
import com.epam.web.entity.Product;
import com.epam.web.entity.TypeStatus;
import com.epam.web.exception.DAOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDao implements BaseDao<Long, Product>, ProductDaoInterface {
    private static final Logger logger = LogManager.getLogger(ProductDao.class);
    private static final String SQL_SELECT_ALL =
        "SELECT id_product,name,info,price,imagen_name,id_user,status FROM product";
    private static final String SQL_INSERT_PRODUCT =
        "INSERT INTO product (`name`, `info`, `imagen`,`price`)VALUES (?, ?, ?, ?);";
    private static final String SQL_UPDATE_PRODUCT_BY_ID =
        "UPDATE product SET name = ? AND info = ? AND price = ? AND imagen_name = ? AND id_user = ? AND status = ? WHERE id_product = ?";


    @Override
    public List<Product> findAll() throws DAOException {
        List<Product> products = new ArrayList<>();
        try (Connection connection = connection();
            PreparedStatement statement = connection.prepareStatement(SQL_SELECT_ALL)){
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                long id = resultSet.getInt("idproduct");
                String name = resultSet.getString("name");
                String info = resultSet.getString("info");
                BigDecimal price = resultSet.getBigDecimal("price");
                String imagen = resultSet.getString("imagen");
                long id_user = resultSet.getLong("id_user");
                TypeStatus status = TypeStatus.valueOf(resultSet.getString("status"));
                products.add(new Product(id,name,info,price,imagen,id_user,status));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public Product findEntityById(Long id) throws DAOException {
        return null;
    }

    @Override
    public boolean delete(Long id) throws DAOException {
        return false;
    }

    @Override
    public Product create(Product product) throws DAOException {
        try (Connection connection = connection();
            PreparedStatement statement = connection.prepareStatement(SQL_INSERT_PRODUCT)){
            statement.setString(1, product.getName());
            statement.setString(2, product.getInfo());
            statement.setString(3, product.getImageName());
            statement.setBigDecimal(4, product.getPrice());
            statement.executeUpdate();
            return product;
        } catch (SQLException e) {
            logger.error(e);
            throw new DAOException(e);
        }
    }

    private Connection connection() throws SQLException {
        return connectionPool.getConnection();
    }

    @Override
    public Product update(Product product) throws DAOException {
        try (Connection connection = connection();
            PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_PRODUCT_BY_ID)){
            statement.setString(1, product.getName());
            statement.setString(2, product.getInfo());
            statement.setString(3, product.getImageName());
            statement.setBigDecimal(4, product.getPrice());
            statement.executeUpdate();
            return product;
        } catch (SQLException e) {
            logger.error(e);
            throw new DAOException(e);
        }
    }
}
