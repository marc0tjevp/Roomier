package com.yanco.roomier.datalayer.factories;

import com.yanco.roomier.datalayer.dao.EventDAO;
import com.yanco.roomier.datalayer.dao.ProductDAO;
import com.yanco.roomier.datalayer.dao.TaskDAO;
import com.yanco.roomier.datalayer.dao.UserDAO;
import com.yanco.roomier.model.Event;

import java.sql.SQLException;

/**
 * Created by ywillems on 6-2-2018.
 */

public abstract class DAOFactory {

    protected static DAOFactory factory;

    public static DAOFactory getFactory() {
        return factory;
    }

    public static void setFactory(DAOFactory factory) {
        factory = factory;
    }

    public abstract UserDAO getUserDAO();
    public abstract ProductDAO getProductDAO();
    public abstract TaskDAO getTaskDAO();
    public abstract EventDAO getEventDAO();
}
