package com.mysql.forumapi.MySQL.ForumAPI.entity;

import com.mysql.forumapi.MySQL.ForumAPI.service.MemberService;

import java.util.Date;

public class Answer {

    String answer;
    boolean accepted;
    int voteCount;
    int flagCount;
    Date creationTime;

    private MemberService member;
    //private List<Photo> photoList;

    public boolean incrementVoteCount(){
        return false;
    }

}
