package com.yanco.roomier.datalayer.factories;

import com.yanco.roomier.datalayer.dao.EventDAO;
import com.yanco.roomier.datalayer.dao.DAO;

/**
 * Created by Gebruiker on 6-2-2018.
 */

public class EventDAOFactory implements DAOFactory {
    private static EventDAOFactory instance;

    public EventDAOFactory getInstance(){
        if (instance == null){
            instance = new EventDAOFactory();
        }
        return instance;
    }

    @Override
    public DAO createDAO() {
        return new EventDAO();
    }
}
