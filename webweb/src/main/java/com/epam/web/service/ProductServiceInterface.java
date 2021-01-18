package com.epam.web.service;

import com.epam.web.entity.Product;
import com.epam.web.exception.ServiceException;

public interface ProductServiceInterface {
    Product findProductById(long id) throws ServiceException;
    void saveProduct(Product product) throws ServiceException;
    void deactive(long id_user,long id) throws ServiceException;
}
