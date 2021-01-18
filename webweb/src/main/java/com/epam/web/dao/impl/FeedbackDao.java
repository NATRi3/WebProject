package com.epam.web.dao.impl;

import com.epam.web.dao.BaseDao;
import com.epam.web.entity.Feedback;
import com.epam.web.exception.DAOException;

import java.util.List;

public class FeedbackDao implements BaseDao<Feedback, Long> {
    @Override
    public List<Long> findAll() throws DAOException {
        return null;
    }

    @Override
    public Long findEntityById(Feedback feedback) throws DAOException {
        return null;
    }

    @Override
    public boolean delete(Feedback id) throws DAOException {
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
