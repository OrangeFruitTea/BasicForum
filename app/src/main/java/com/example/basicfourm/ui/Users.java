package com.example.basicfourm.ui;

import org.litepal.crud.LitePalSupport;

public class Users extends LitePalSupport {
    private long id;
    private String userName;
    private String userPwd;

    public void setId(int id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getUserPwd() {
        return userPwd;
    }
    public Users(String UserName,String UserPwd,long id)
    {
        this.userName= UserName;
        this.userPwd=UserPwd;
        this.id=id;
    }
}
