package com.savemysaving.model;

import java.util.Date;

public class Customer {
    Integer id;
    Integer user_id;
    String email;
    String name;
    String phone;
    String gender;
    Date created_at;
    Date updated_at;
    public Customer (Integer id, Integer user_id, String email, String name, String phone, String gender, Date created_at, Date updated_at){
        this.id = id;
        this.user_id= user_id;
        this.email = email;
        this.name=name;
        this.phone=phone;
        this.gender=gender;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", gender='" + gender + '\'' +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                '}';
    }



}
