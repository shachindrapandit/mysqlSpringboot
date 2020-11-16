package com.mysql.forumapi.MySQL.ForumAPI.service;

import com.mysql.forumapi.MySQL.ForumAPI.entity.Account;
import com.mysql.forumapi.MySQL.ForumAPI.entity.Answer;
import com.mysql.forumapi.MySQL.ForumAPI.entity.Question;
import com.mysql.forumapi.MySQL.ForumAPI.repository.AccountRepository;
import com.mysql.forumapi.MySQL.ForumAPI.repository.AnswerRepository;
import com.mysql.forumapi.MySQL.ForumAPI.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AnswerService {

    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private QuestionRepository questionRepository;

    public List<Answer> getAllAnswers(){
        return answerRepository.findAll();
    }

    public Optional<Answer> getAnswerById(int id){
        return answerRepository.findById(id);
    }

    public Optional<Answer> getAnswerByQuestionId(int id){
        return answerRepository.findByQuestionId(id);
    }

    public List<Answer> getAnswerByAccountId(int id){
        return answerRepository.findByAccountId(id);
    }

    public Answer createAnswer(int accountId, int questionId, Answer answer){
        Set<Answer> answerSet = new HashSet<>();
        Account account1 = new Account();

        Question question1 = new Question();
        Optional<Account> byId = accountRepository.findById(accountId);
        List<Question> byQuestionId = questionRepository.findQuestionId(accountId);

        if(!byId.isPresent()){
            throw new NoSuchElementException("Account with id" +accountId+ "not exist");
        }

        Account account = byId.get();
        Question question = new Question();

        //tie answer to account
        answer.setAccount(account);

        Answer answer1 = answerRepository.save(answer);

        //tie account to answer
        answerSet.add(answer);
        account1.setAnswerSet(answerSet);

        //tie answer to question
        answer.setQuestion(question);

        //tie question to answer
        question1.setAnswerSet(answerSet);

        return answer1;
    }








}
