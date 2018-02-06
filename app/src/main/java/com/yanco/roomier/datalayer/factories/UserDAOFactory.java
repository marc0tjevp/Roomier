package com.yanco.roomier.datalayer.factories;

import com.yanco.roomier.datalayer.dao.UserDAO;
import com.yanco.roomier.datalayer.dao.DAO;

/**
 * Created by ywillems on 6-2-2018.
 */

public class UserDAOFactory implements DAOFactory {

    private static UserDAOFactory instance;

    public UserDAOFactory getInstance(){
        if (instance == null){
            instance = new UserDAOFactory();
        }
        return instance;
    }

    @Override
    public DAO createDAO() {
        return new UserDAO();
    }
}
