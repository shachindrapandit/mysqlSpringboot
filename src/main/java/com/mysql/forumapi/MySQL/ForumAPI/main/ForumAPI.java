package com.mysql.forumapi.MySQL.ForumAPI.main;

import com.mysql.forumapi.MySQL.ForumAPI.entity.Answer;
import com.mysql.forumapi.MySQL.ForumAPI.entity.Comment;
import com.mysql.forumapi.MySQL.ForumAPI.service.MemberService;
import com.mysql.forumapi.MySQL.ForumAPI.entity.Question;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ForumAPI {

    List<MemberService> memberList;
    List<Question> questionList;
    List<Answer> answerList;
    List<Comment> commentList;

//    public static List<Question> searchForQuestion(String query){ }

//    public static List<MemberService> searchForMember(String query){ }

}
