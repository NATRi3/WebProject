package com.epam.web.dao.impl;

import com.epam.web.dao.BaseDao;
import com.epam.web.entity.Order;
import com.epam.web.exception.DAOException;

import java.util.List;

public class OrderDao implements BaseDao<Order, Long> {
    @Override
    public List<Long> findAll() throws DAOException {
        return null;
    }

    @Override
    public Long findEntityById(Order order) throws DAOException {
        return null;
    }

    @Override
    public boolean delete(Order id) throws DAOException {
        return false;
    }

    @Override
    public Long update(Long aLong) throws DAOException {
        return null;
    }

    @Override
    public Long create(Long aLong) throws DAOException {
        return null;
    }
}
