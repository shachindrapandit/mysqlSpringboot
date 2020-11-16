package com.mysql.forumapi.MySQL.ForumAPI.service;

import com.mysql.forumapi.MySQL.ForumAPI.entity.Account;
import com.mysql.forumapi.MySQL.ForumAPI.entity.Answer;
import com.mysql.forumapi.MySQL.ForumAPI.entity.Comment;
import com.mysql.forumapi.MySQL.ForumAPI.entity.Question;
import com.mysql.forumapi.MySQL.ForumAPI.repository.AccountRepository;
import com.mysql.forumapi.MySQL.ForumAPI.repository.AnswerRepository;
import com.mysql.forumapi.MySQL.ForumAPI.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class QuestionService {

    // private MemberService member;

    //List<Photo> photoList;
//    List<Comment> commentList;
//    List<Tag> tagList;
    //   List<Answer> answerList;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private AnswerRepository answerRepository;

    public List<Question> getAllQuestion(){
        return questionRepository.findAll();
    }

    public Optional<Question> getQuestionById(int id){
        if(!questionRepository.existsById(id)){
            throw new NoSuchElementException("Question id" +id+ "not found");
        }
        return questionRepository.findById(id);
    }

    public List<Question> getQuestionByAccountId(int id){
        return questionRepository.findByAccountId(id);
    }

    public Question createQuestion(int accountId, Question question){
        Set<Question> questions = new HashSet<>();
        Set<Answer> answerSet = new HashSet<>();
        Account account1 = new Account();
        Answer answer = new Answer();

        Optional<Account> byId = accountRepository.findById(accountId);

        if(!byId.isPresent()){
            throw new NoSuchElementException("Account with id" +accountId+ "not exist");
        }

        Account account = byId.get();

        //tie question to account
        question.setAccount(account);

        Question question1 = questionRepository.save(question);

        //tie account to question
        questions.add(question);
        account1.setQuestionSet(questions);

        return question1;
    }




    public boolean close(){
        return false;
    }

    public boolean addComment(Comment comment){
        return false;
    }

    public boolean addAnswer(Answer answer){
        return false;
    }



}
