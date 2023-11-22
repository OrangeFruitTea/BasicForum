package com.example.basicfourm.ui;

import com.example.basicfourm.R;

import org.litepal.crud.LitePalSupport;

import java.util.ArrayList;
import java.util.List;

public class PostList extends LitePalSupport
{
    //标题，内容，发布者,时间,postlist的objectID
    private String title;
    private String content;
    private String publisher;
    private String time;
    private String objectID;
    private int floor = 1;
    private List<ReplyList> commentList = new ArrayList<>();
    public void setTitle(String title){
        this.title=title;
    }

    public String getTitle(){
        return title;
    }

    public void setContent(String content){
        this.content=content;
    }

    public String getContent(){
        return content;
    }

    public void setPublisher(String publisher){
        this.publisher=publisher;
    }

    public String getPublisher(){
        return publisher;
    }

    public void setTime(String time){
        this.time=time;
    }

    public String getTime(){
        return time;
    }

    public void setObjectID(String objectID){this.objectID=objectID;}

    public String getObjectID(){return objectID;}

    public PostList(String title,String content,String publisher,String time,String objectID)
    {
        this.title=title;
        this.content=content;
        this.publisher=publisher;
        this.time=time;
        this.objectID=objectID;
        this.commentList.add(new ReplyList(content,publisher,time,this.floor,title));
        floor++;
    }
}
