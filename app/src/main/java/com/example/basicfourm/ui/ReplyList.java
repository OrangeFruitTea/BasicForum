package com.example.basicfourm.ui;

import org.litepal.crud.LitePalSupport;

public class ReplyList extends LitePalSupport
{
    //回复内容，回复者，所属贴子ID,时间，楼层，标题（只在一楼显示）
    private  String reply;
    private  String replyer;
    private  String belongTo;
    private  String timeInReply;
    private  String floor;
    private  String title;

    public void setReply(String reply){
        this.reply=reply;
    }

    public String getReply(){
        return reply;
    }

    public void setReplyer(String replyer){
        this.replyer=replyer;
    }

    public String getReplyer(){
        return replyer;
    }

    public void setBelongTo(String belongTo){
        this.belongTo=belongTo;
    }

    public String getBelongto(){
        return belongTo;
    }

    public void setFloor(String floor){
        this.floor=floor;
    }

    public String getFloor(){
        return floor;
    }

    public void setTimeInReply(String timeInReply){this.timeInReply=timeInReply;}

    public String getTimeInReply(){return timeInReply;}

    public void setTitle(String title){
        this.title=title;
    }

    public String getTitle(){return title;}
}
