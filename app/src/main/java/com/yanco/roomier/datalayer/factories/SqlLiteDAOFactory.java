package com.yanco.roomier.datalayer.factories;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.yanco.roomier.datalayer.SQLiteConnection;
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
    private SQLiteConnection connection;
    private SQLiteDatabase database;

    public SqlLiteDAOFactory(Context context){
        connection = new SQLiteConnection(context);
        database = connection.getWritableDatabase();
    }

    @Override
    public UserDAO getUserDAO() {
        return new SqlLiteUserDAO(connection);
    }

    @Override
    public ProductDAO getProductDAO() {
        return new SqlLiteProductDAO(connection);
    }

    @Override
    public TaskDAO getTaskDAO() {
        return new SqlLiteTaskDAO(connection);
    }

    @Override
    public EventDAO getEventDAO() {
        return new SqlLiteEventDAO(connection);
    }
}
