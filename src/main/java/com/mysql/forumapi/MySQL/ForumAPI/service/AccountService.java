package com.mysql.forumapi.MySQL.ForumAPI.service;

import com.mysql.forumapi.MySQL.ForumAPI.entity.Account;
import com.mysql.forumapi.MySQL.ForumAPI.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository repository;

    public List<Account> getAccount(){
        return repository.findAll();
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
