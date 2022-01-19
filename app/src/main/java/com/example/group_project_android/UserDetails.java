package com.example.group_project_android;

import java.io.Serializable;

public class UserDetails implements Serializable {
    String Name;
    String Email;
    String Password;
    int id;

    public UserDetails(String name, String email, String password,int id) {
        this.Name = name;
        this.Email = email;
        this.Password = password;
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }


    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
