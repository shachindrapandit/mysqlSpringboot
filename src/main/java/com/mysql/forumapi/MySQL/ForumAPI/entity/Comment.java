package com.mysql.forumapi.MySQL.ForumAPI.entity;

import com.mysql.forumapi.MySQL.ForumAPI.service.MemberService;

import java.util.Date;

public class Comment {

    String text;
    Date creationTime;
    int flagCount;
    int voteCount;

    private MemberService member;

    public boolean incrementVoteCount(){
        return false;
    }
}
