package com.yanco.roomier.datalayer.dao;

import android.content.ContentValues;
import android.database.Cursor;

import com.yanco.roomier.datalayer.SQLiteConnection;
import com.yanco.roomier.model.Task;
import com.yanco.roomier.model.User;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by ywillems on 15-2-2018.
 */

public class SqlLiteTaskDAO implements TaskDAO {

    private SQLiteConnection connection;
    private SqlLiteUserDAO userDAO;

    public SqlLiteTaskDAO(SQLiteConnection connection){
        this.connection = connection;
        this.userDAO = new SqlLiteUserDAO(connection);

    }

    @Override
    public List getAllTasks() {
        List<Task> tasks = new ArrayList<>();
        Cursor cursor = connection.getReadableDatabase().query("task", new String[]{"taskID", "taskName", "claimedBy", "taskCompleted", "createDate", "completedDate"}, null, null, null, null, null);

        while (cursor.moveToNext()){
           UUID uuid = UUID.fromString(cursor.getString(cursor.getColumnIndex("taskID")));
           String name = cursor.getString(cursor.getColumnIndex("taskname"));
           String claimedBy = cursor.getColumnName(cursor.getColumnIndex("claimedBy"));
           Boolean taskCompleted = cursor.getInt(cursor.getColumnIndex("taskCompleted")) > 0;
           Date createDate = Date.valueOf(cursor.getString(cursor.getColumnIndex("createDate")));
           Date completedDate = Date.valueOf(cursor.getString(cursor.getColumnIndex("completedDate")));

           User user = userDAO.getUser(claimedBy);
           Task task = new Task(uuid, name, taskCompleted, user, createDate, completedDate);

           tasks.add(task);
        }
        return tasks;
    }

    @Override
    public Task getTask(UUID taskId) {
        Task task = new Task();
        Cursor cursor = connection.getReadableDatabase().query("task", new String[]{"taskID", "taskName", "claimedBy", "taskCompleted", "createDate", "completedDate"}, null, null, null, null, null);

        while (cursor.moveToNext()){
            UUID uuid = UUID.fromString(cursor.getString(cursor.getColumnIndex("taskID")));
            String name = cursor.getString(cursor.getColumnIndex("taskname"));
            String claimedBy = cursor.getColumnName(cursor.getColumnIndex("claimedBy"));
            Boolean taskCompleted = cursor.getInt(cursor.getColumnIndex("taskCompleted")) > 0;
            Date createDate = Date.valueOf(cursor.getString(cursor.getColumnIndex("createDate")));
            Date completedDate = Date.valueOf(cursor.getString(cursor.getColumnIndex("completedDate")));

            User user = userDAO.getUser(claimedBy);

            task.setTaskID(uuid);
            task.setTaskName(name);
            task.setClaimedBy(user);
            task.setTaskCompleted(taskCompleted);
            task.setCreatedDate(createDate);
            task.setCompletedDate(completedDate);
        }
        return task;
    }

    @Override
    public void insert(Task task) {
        ContentValues insertValues = new ContentValues();
        insertValues.put("taskID", task.getTaskID().toString());
        insertValues.put("taskName", task.getTaskName());
        insertValues.put("claimedBy", task.getClaimedBy().getUserName());
        insertValues.put("taskCompleted", task.isTaskCompleted());
        insertValues.put("createDate", task.getCreatedDate().toString());
        insertValues.put("completedDate", task.getCompletedDate().toString());

        connection.getWritableDatabase().insert("task",null, insertValues);
    }

    @Override
    public void delete(UUID taskId) {
        connection.getWritableDatabase().delete("task", "taskID=?", new String[]{taskId.toString()});
    }

    @Override
    public void claimTask(User user, UUID taskId) {
        ContentValues updateValues = new ContentValues();
        updateValues.put("claimedBy", user.getUserName());
        connection.getWritableDatabase().update("task", updateValues, "taskID=?", new String[]{taskId.toString()});
    }

    @Override
    public void completeTask(UUID taskId) {
        ContentValues updateValues = new ContentValues();
        updateValues.put("taskCompleted", 1);
        updateValues.put("completedDate", new java.util.Date().toString());
    }
}
