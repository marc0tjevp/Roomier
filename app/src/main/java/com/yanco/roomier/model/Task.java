package com.yanco.roomier.model;

import java.sql.Date;
import java.util.UUID;

/**
 * Created by Marco on 06/02/2018.
 */

public class Task {

    private UUID taskID;
    private String taskName;
    private boolean taskCompleted;
    private User claimedBy;
    private Date createdDate;
    private Date completedDate;

    public Task(UUID taskID, String taskName, Date createdDate) {
        this.taskID = taskID;
        this.taskName = taskName;
        this.taskCompleted = false;
        this.claimedBy = null;
        this.createdDate = createdDate;
        this.completedDate = null;
    }

    public Task(UUID taskID, String taskName, boolean taskCompleted, User claimedBy, Date createdDate, Date completedDate) {
        this.taskID = taskID;
        this.taskName = taskName;
        this.taskCompleted = taskCompleted;
        this.claimedBy = claimedBy;
        this.createdDate = createdDate;
        this.completedDate = completedDate;
    }

    public Task(){}

    public UUID getTaskID() {
        return taskID;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public boolean isTaskCompleted() {
        return taskCompleted;
    }

    public void setTaskCompleted(boolean taskCompleted) {
        this.taskCompleted = taskCompleted;
    }

    public User getClaimedBy() {
        return claimedBy;
    }

    public void setClaimedBy(User claimedBy) {
        this.claimedBy = claimedBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getCompletedDate() {
        return completedDate;
    }

    public void setCompletedDate(Date completedDate) {
        this.completedDate = completedDate;
    }
}
