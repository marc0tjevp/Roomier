package com.yanco.roomier.datalayer.dao;

import com.yanco.roomier.model.Task;
import com.yanco.roomier.model.User;

import java.util.Map;
import java.util.UUID;

/**
 * Created by ywillems on 7-2-2018.
 */

public interface TaskDAO {
    Map getAllTasks();
    Task getTask(UUID taskId);
    void insert(Task task);
    void delete(UUID taskId);
    void claimTask(User user, UUID taskId);
    void completeTask(UUID taskId);
}
