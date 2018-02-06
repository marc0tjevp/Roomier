package com.yanco.roomier.model;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
