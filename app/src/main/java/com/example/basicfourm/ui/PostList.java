package com.example.basicfourm.ui;

import com.example.basicfourm.R;

import org.litepal.crud.LitePalSupport;

import java.util.ArrayList;
import java.util.List;

public class PostList extends LitePalSupport
{
    //标题，内容，发布者,时间,postlist的objectID
    private String title;
    private String subtitle;
    private String content;
    private Users publisher;
    private String time;
    private int objectID;
    private int floor = 1;
    private List<ReplyList> commentList = new ArrayList<>();
    public void setTitle(String title){
        this.title=title;
    }

    public String getTitle(){
        return title;
    }

    public void setSubTitle(String subtitle){
        this.subtitle=subtitle;
    }

    public String getSubTitle(){
        return subtitle;
    }

    public void setContent(String content){
        this.content=content;
    }

    public String getContent(){
        return content;
    }

    public void setPublisher(Users publisher){
        this.publisher=publisher;
    }

    public Users getPublisher(){
        return publisher;
    }

    public void setTime(String time){
        this.time=time;
    }

    public String getTime(){
        return time;
    }

    public void setObjectID(int objectID){this.objectID=objectID;}

    public int getObjectID(){return objectID;}

    public  int getFloor(){return floor;}
    public int getFloorForComment(){return floor++;}

    public PostList(String title,String subtitle,String content,Users publisher,String time,int objectID)
    {
        this.title=title;
        this.subtitle=subtitle;
        this.content=content;
        this.publisher=publisher;
        this.time=time;
        this.objectID=objectID;
        this.commentList.add(new ReplyList(content,publisher,time,this.floor,title));
        floor++;
        NewPostActivity.ObjectId++;
    }
}
