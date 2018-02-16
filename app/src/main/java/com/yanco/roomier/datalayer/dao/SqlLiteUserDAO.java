package com.yanco.roomier.datalayer.dao;

import android.content.ContentValues;
import android.database.Cursor;

import com.yanco.roomier.datalayer.SQLiteConnection;
import com.yanco.roomier.model.User;

import java.util.UUID;

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
        ContentValues insertValues = new ContentValues();
        connection.getWritableDatabase().insert("user", null, insertValues);
    }

    @Override
    public User getUser(String userName) {
        User user = new User();
        Cursor cursor = connection.getReadableDatabase().query("user", new String[]{"userName", "email"}, "userName=?", new String[]{userName}, null, null, null);

        while(cursor.moveToNext()){
            String name = cursor.getString(cursor.getColumnIndex("userName"));
            String email = cursor.getString(cursor.getColumnIndex("email"));

            user.setUserName(name);
            user.setEmail(email);
        }

        return user;
    }
}
