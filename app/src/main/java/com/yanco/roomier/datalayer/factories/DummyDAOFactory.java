package com.yanco.roomier.datalayer.factories;

import com.yanco.roomier.datalayer.dao.EventDAO;
import com.yanco.roomier.datalayer.dao.ProductDAO;
import com.yanco.roomier.datalayer.dao.TaskDAO;
import com.yanco.roomier.datalayer.dao.UserDAO;

/**
 * Created by ywillems on 7-2-2018.
 */

public class DummyDAOFactory extends DAOFactory {

    @Override
    public UserDAO getUserDAO() {
        return null;
    }

    @Override
    public ProductDAO getProductDAO() {
        return null;
    }

    @Override
    public TaskDAO getTaskDAO() {
        return null;
    }

    @Override
    public EventDAO getEventDAO() {
        return null;
    }
}
