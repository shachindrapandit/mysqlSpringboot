package com.mysql.forumapi.MySQL.ForumAPI.controller;

import com.mysql.forumapi.MySQL.ForumAPI.entity.Account;
import com.mysql.forumapi.MySQL.ForumAPI.entity.Answer;
import com.mysql.forumapi.MySQL.ForumAPI.entity.Question;
import com.mysql.forumapi.MySQL.ForumAPI.repository.AccountRepository;
import com.mysql.forumapi.MySQL.ForumAPI.service.AccountService;
import com.mysql.forumapi.MySQL.ForumAPI.service.AnswerService;
import com.mysql.forumapi.MySQL.ForumAPI.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/forumAPI")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private QuestionService questionService;

    @Autowired
    private AnswerService answerService;

    //Account

    @GetMapping(value="/getAccountDetails/{id}")
    public List<Account> getAccountDetails(@PathVariable(value="id") int id){
        return accountService.getAccount(id);
    }

    @PostMapping(value="/toAccount", consumes = "application/json", produces = "application/json")
    public Account createAccount(@RequestBody Account account){
        return accountService.createAccount(account);
    }

    @GetMapping(value="/getAllQuestions")
    public List<Question> getQuestions(){
        return questionService.getAllQuestion();
    }

    @GetMapping(value="/getAllQuestionsByAccount/{accountId}")
    public List<Question> getQuestionsByAccount(@PathVariable(value="accountId") int id){
         List list = new ArrayList();
         list.add(questionService.getQuestionByAccountId(id));
         return list;
    }

    //Question

    @PostMapping(value="{accountId}/question", consumes = "application/json", produces = "application/json")
    public Question createQuestion(@PathVariable(value="accountId") int id, @RequestBody Question question){
        return questionService.createQuestion(id, question);
    }

    @GetMapping(value = "/question/{questionId}")
    public Optional<Question> getQuestionById(@PathVariable(value="questionId") int id){
        return questionService.getQuestionById(id);
    }

    //Answer

    @PostMapping(value="{questionId}/{accountId}/answer", consumes = "application/json", produces = "application/json")
    public Answer createAnswer(@PathVariable(value="accountId") int accountId, @PathVariable(value="questionId") int questionId, @RequestBody Answer answer){
        return answerService.createAnswer(accountId, questionId, answer);
    }

    @GetMapping(value = "/answer/{answerId}")
    public Optional<Answer> getAnswerById(@PathVariable(value="answerId") int id){
        return answerService.getAnswerById(id);
    }

    @GetMapping(value = "/getAllAnswersByAccount/{accountId}")
    public List<Answer> getAllAnswerByAccount(@PathVariable(value="accountId") int id){
        return answerService.getAnswerByAccountId(id);
    }

    @GetMapping(value = "/getAllAnswersByQuestion/{questionId}")
    public Optional<Answer> getAnswerByQuestionId(@PathVariable(value="questionId") int id){
        return answerService.getAnswerByQuestionId(id);
    }




}
