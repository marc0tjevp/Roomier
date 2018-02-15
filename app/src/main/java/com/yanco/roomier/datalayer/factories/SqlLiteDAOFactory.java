package com.yanco.roomier.datalayer.factories;

import com.yanco.roomier.datalayer.dao.EventDAO;
import com.yanco.roomier.datalayer.dao.ProductDAO;
import com.yanco.roomier.datalayer.dao.SqlLiteEventDAO;
import com.yanco.roomier.datalayer.dao.SqlLiteProductDAO;
import com.yanco.roomier.datalayer.dao.SqlLiteTaskDAO;
import com.yanco.roomier.datalayer.dao.SqlLiteUserDAO;
import com.yanco.roomier.datalayer.dao.TaskDAO;
import com.yanco.roomier.datalayer.dao.UserDAO;

/**
 * Created by ywillems on 15-2-2018.
 */

public class SqlLiteDAOFactory extends DAOFactory {
    @Override
    public UserDAO getUserDAO() {
        return new SqlLiteUserDAO();
    }

    @Override
    public ProductDAO getProductDAO() {
        return new SqlLiteProductDAO();
    }

    @Override
    public TaskDAO getTaskDAO() {
        return new SqlLiteTaskDAO();
    }

    @Override
    public EventDAO getEventDAO() {
//        return new SqlLiteEventDAO();
        return null;
    }
}
