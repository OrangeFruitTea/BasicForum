package com.example.basicfourm.ui;

import org.litepal.LitePal;
import org.litepal.crud.LitePalSupport;

import java.util.List;

public class PostManager extends LitePalSupport
{
    private int ObjectId = 1;
    public int getObjectId(){return ObjectId++;}
    public PostList getPostById(int ObjectId){return LitePal.where("objectid=?",String.valueOf(ObjectId)).findFirst(PostList.class);}
    public List<PostList> getAllPost(){return LitePal.findAll(PostList.class);}
    public ReplyList getCommentForCertainPostByFloor(int PostId,int Floor){return LitePal.where("postlist_id=? and floor=?",String.valueOf(PostId),String.valueOf(Floor)).findFirst(ReplyList.class);}
    public List<ReplyList> getAllComment(){return LitePal.findAll(ReplyList.class);}
    public List<ReplyList> getAllCommentForCertainPostWithId(int PostId){return LitePal.where("postlist_id=?",String.valueOf(PostId)).find(ReplyList.class);}
    public List<ReplyList> getAllCommentForCertainPostWithObject(PostList thepost){return LitePal.where("postlist_id=?",String.valueOf(thepost.getObjectID())).find(ReplyList.class);}
    public PostManager(int ObjectId)
    {
        this.ObjectId=ObjectId;
    }
}
