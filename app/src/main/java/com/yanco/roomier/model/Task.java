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
}
