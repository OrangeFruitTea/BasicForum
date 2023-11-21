package com.example.basicfourm.ui;

import org.litepal.crud.LitePalSupport;

public class Users extends LitePalSupport {
    private int id;
    private String userName;
    private String userPwd;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserPwd(String userPhone) {
        this.userPwd = userPhone;
    }

    public String getUserPwd() {
        return userPwd;
    }
}
