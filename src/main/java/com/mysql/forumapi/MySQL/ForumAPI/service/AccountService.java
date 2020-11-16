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
public class AccountService {

    @Autowired
    private AccountRepository repository;

    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private QuestionRepository questionRepository;

    Set<Answer> answerSet = new HashSet<>();
    List<Account> accountList = new ArrayList<>();
    Set<Question> questionSet = new HashSet<>();

    public List<Account> getAccount(int id){

        Optional<Account> accountId = repository.getDetailsForAccountId(id);
        Account account = accountId.get();

        List<Answer> optionalAnswer = answerRepository.findByAccountId(id);
        List<Question> questionList = questionRepository.findByAccountId(id);

        for(Answer answer: optionalAnswer) {
            answerSet.add(answer);
        }

        for(Question question: questionList)
            questionSet.add(question);

        account.setAnswerSet(answerSet);
        account.setQuestionSet(questionSet);
        accountList.add(account);

        return accountList;
    }

    public Account createAccount(Account account){
        return repository.save(account);
    }

    public Account updateAccountById(int id, Account accountRequest){
        if(!repository.existsById(id))
            throw new NoSuchElementException("Account with id" +id+ "not found");


        Optional<Account> account = repository.findById(id);

        /* replace Author to Account
          if (!author.isPresent()) {
            throw new ResourceNotFoundException("Author with id " + authorId + " not found");
        }

        Author author1 = author.get();
        author1.setFirstName(authorRequest.getFirstName());
        author1.setLastName(authorRequest.getLastName());
        return authorDao.save(author1);
         */

        return accountRequest;
    }

}
