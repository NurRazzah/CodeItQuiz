package com.example.a16022738.codeitquiz;

import java.io.Serializable;

public class Users {

    private int userId;
    private String username;

    public Users(int userId, String username) {
        this.userId = userId;
        this.username = username;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
