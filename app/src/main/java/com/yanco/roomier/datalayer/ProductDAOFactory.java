package com.yanco.roomier.datalayer;

/**
 * Created by ywillems on 6-2-2018.
 */

public class ProductDAOFactory implements DAOFactory {
    private static ProductDAOFactory instance;

    public ProductDAOFactory getInstance(){
        if (instance == null){
            instance = new ProductDAOFactory();
        }
        return instance;
    }

    @Override
    public DAO createDAO() {
        return new ProductDAO();
    }
}
