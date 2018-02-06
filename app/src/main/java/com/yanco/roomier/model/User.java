package com.yanco.roomier.model;

import com.yanco.roomier.datalayer.dao.DAO;
import com.yanco.roomier.datalayer.factories.DAOFactory;

/**
 * Created by Marco on 06/02/2018.
 */

public class User {

    private String userName;
    private String email;

    public User(String userName, String email) {
        this.userName = userName;
        this.email = email;
    }

    public String getUserName() { return userName; }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void acceptEvent(Event event){
        event.getUsersAccepted().add(this);
    }

    public void denyEvent(Event event){
        event.getUsersDenied().add(this);
    }

    public void claimTask(Task task){
        task.setClaimedBy(this);
    }

    public void createEvent(Event event, DAO eventDAO){

    }
}
