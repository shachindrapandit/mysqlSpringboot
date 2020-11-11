package com.mysql.forumapi.MySQL.ForumAPI.service;

import com.mysql.forumapi.MySQL.ForumAPI.entity.Account;
import com.mysql.forumapi.MySQL.ForumAPI.entity.Answer;
import com.mysql.forumapi.MySQL.ForumAPI.entity.Question;
import com.mysql.forumapi.MySQL.ForumAPI.entity.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    List<Question> questionList;
    List<Answer> answerList;

    private Account account;

    public boolean createTag(Tag tag){
        return false;
    }

    public boolean replyAnswer(Answer answer){
        return false;
    }

    public void getEmail(){
        account.getEmailId();
    }

    public boolean createQuestion(Question question){
        return false;
    }

}
