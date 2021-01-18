package com.epam.web.service.impl;

import com.epam.web.dao.impl.ProductDao;
import com.epam.web.dao.impl.UserDao;
import com.epam.web.entity.Product;
import com.epam.web.entity.TypeAccess;
import com.epam.web.entity.TypeStatus;
import com.epam.web.exception.DAOException;
import com.epam.web.exception.ServiceException;
import com.epam.web.manager.MessageKey;
import com.epam.web.manager.impl.ErrorMessageManager;
import com.epam.web.service.ProductServiceInterface;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.util.List;

public class ProductService implements ProductServiceInterface {
    public static final Logger logger = LogManager.getLogger(ProductService.class);
    private ProductDao productDao = new ProductDao();
    private UserDao userDao = new UserDao();
    @Override
    public Product findProductById(long id) throws ServiceException {
        try {
            return productDao.findEntityById(id);
        } catch (DAOException e) {
            logger.error(e);
           throw new ServiceException(e);
        }
    }

    @Override
    public void saveProduct(Product product) throws ServiceException {
        try {
            if(product.getPrice().compareTo(BigDecimal.ZERO)>0) {
                productDao.create(product);
            }
        } catch (DAOException e) {
            logger.error(e);
            throw new ServiceException(e);
        }
    }

    @Override
    public void deactive(long id_user, long id) throws ServiceException{
        try {
            Product product = productDao.findEntityById(id);
            product.setStatus(TypeStatus.NONACTIVE);
            if(id_user!=product.getId_user()) {
                throw new ServiceException(ErrorMessageManager.INSTANCE.getMessage(MessageKey.ERROR_MESSAGE_WRONG_ACCESS));
            }
            productDao.update(product);
        } catch (DAOException e){
            logger.error(e);
            throw new ServiceException(e);
        }
    }

    public List<Product>
}
