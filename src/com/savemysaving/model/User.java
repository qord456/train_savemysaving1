package com.savemysaving.model;

import java.util.Date;

public class User {
    Integer id;
    String username, password;

    public User(Integer id, String username, String password){
        this.id = id;
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}


