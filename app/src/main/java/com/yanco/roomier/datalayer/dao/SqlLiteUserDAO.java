package com.yanco.roomier.datalayer.dao;

import com.yanco.roomier.datalayer.SQLiteConnection;
import com.yanco.roomier.model.User;

/**
 * Created by ywillems on 15-2-2018.
 */

public class SqlLiteUserDAO implements UserDAO {

    private SQLiteConnection connection;

    public SqlLiteUserDAO(SQLiteConnection connection){
        this.connection = connection;
    }

    @Override
    public void insert(User user) {

    }
}
