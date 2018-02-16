package com.yanco.roomier.datalayer.dao;

import com.yanco.roomier.model.User;

import java.util.UUID;

/**
 * Created by ywillems on 7-2-2018.
 */

public interface UserDAO {
    void insert(User user);
    User getUser(String userName);
}
