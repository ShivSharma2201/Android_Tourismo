package com.example.group_project_android;

import java.io.Serializable;

public class UserAct implements Serializable {
    UserDetails us;
    ActivityDetails act;

    public UserAct(UserDetails us, ActivityDetails act) {
        this.us = us;
        this.act = act;
    }

}
