package com.yanco.roomier.datalayer.dao;

import com.yanco.roomier.model.Task;
import com.yanco.roomier.model.User;

import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by ywillems on 7-2-2018.
 */

public class MySqlTaskDAO implements TaskDAO {
    @Override
    public List getAllTasks() {
        return null;
    }

    @Override
    public Task getTask(UUID taskId) {
        return null;
    }

    @Override
    public void insert(Task task) {

    }

    @Override
    public void delete(UUID taskId) {

    }

    @Override
    public void claimTask(User user, UUID taskId) {

    }

    @Override
    public void completeTask(UUID taskId) {

    }
}
