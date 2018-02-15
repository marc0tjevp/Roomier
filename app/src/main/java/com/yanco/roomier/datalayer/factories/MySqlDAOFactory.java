package com.yanco.roomier.datalayer.factories;

import com.yanco.roomier.datalayer.dao.EventDAO;
import com.yanco.roomier.datalayer.dao.MySqlEventDAO;
import com.yanco.roomier.datalayer.dao.MySqlProductDAO;
import com.yanco.roomier.datalayer.dao.MySqlTaskDAO;
import com.yanco.roomier.datalayer.dao.MySqlUserDAO;
import com.yanco.roomier.datalayer.dao.ProductDAO;
import com.yanco.roomier.datalayer.dao.TaskDAO;
import com.yanco.roomier.datalayer.dao.UserDAO;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by ywillems on 7-2-2018.
 */

public class MySqlDAOFactory extends DAOFactory {
    private MySqlDAOFactory instance;
    public static final String DRIVER = "/*driver here*/";
    public static final String DBURL = "/*conn string here*/";

    public MySqlDAOFactory() {
    }

    public MySqlDAOFactory getInstance(){
        if(instance == null){
            instance = new MySqlDAOFactory();
        }
        return instance;
    }

    @Override
    public UserDAO getUserDAO() {
        return new MySqlUserDAO();
    }

    @Override
    public EventDAO getEventDAO() {
        return new MySqlEventDAO();
    }

    @Override
    public ProductDAO getProductDAO() {
        return new MySqlProductDAO();
    }

    @Override
    public TaskDAO getTaskDAO() {
        return new MySqlTaskDAO();
    }
}