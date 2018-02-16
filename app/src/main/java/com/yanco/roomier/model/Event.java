package com.yanco.roomier.model;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.UUID;

/**
 * Created by Marco on 06/02/2018.
 */

public class Event {

    private UUID eventID;
    private String eventName;
    private Time startTime;
    private Time endTime;
    private Date date;
    private boolean status;
    private List<User> usersAccepted;
    private List<User> usersDenied;
    private User createdBy;

    public Event(UUID eventID, String eventName, Time startTime, Time endTime, Date date, boolean status, List<User> usersAccepted, List<User> usersDenied, User createdBy) {
        this.eventID = eventID;
        this.eventName = eventName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.date = date;
        this.status = status;
        this.usersAccepted = usersAccepted;
        this.usersDenied = usersDenied;
        this.createdBy = createdBy;
    }

    public Event(){}

    public UUID getEventID() {
        return eventID;
    }

    public void setEventID(UUID eventID) {
        this.eventID = eventID;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<User> getUsersAccepted() {
        return usersAccepted;
    }

    public void setUsersAccepted(List<User> usersAccepted) {
        this.usersAccepted = usersAccepted;
    }

    public List<User> getUsersDenied() {
        return usersDenied;
    }

    public void setUsersDenied(List<User> usersDenied) {
        this.usersDenied = usersDenied;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }
}
