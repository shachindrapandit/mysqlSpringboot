package com.mysql.forumapi.MySQL.ForumAPI.controller;

import com.mysql.forumapi.MySQL.ForumAPI.entity.Account;
import com.mysql.forumapi.MySQL.ForumAPI.entity.Question;
import com.mysql.forumapi.MySQL.ForumAPI.repository.AccountRepository;
import com.mysql.forumapi.MySQL.ForumAPI.service.AccountService;
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

    //Account

    @GetMapping(value="/getAccountDetails")
    public List<Account> getAccountDetails(){
        return accountService.getAccount();
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

}
