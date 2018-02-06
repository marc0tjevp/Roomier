package com.yanco.roomier.datalayer;

/**
 * Created by ywillems on 6-2-2018.
 */

public class TaskDAOFactory implements DAOFactory {
    private static TaskDAOFactory instance;

    public TaskDAOFactory getInstance(){
        if (instance == null){
            instance = new TaskDAOFactory();
        }
        return instance;
    }

    @Override
    public DAO createDAO() {
        return new TaskDAO();
    }
}
