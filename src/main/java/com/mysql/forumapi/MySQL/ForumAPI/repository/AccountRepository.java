package com.mysql.forumapi.MySQL.ForumAPI.repository;

import com.mysql.forumapi.MySQL.ForumAPI.entity.Account;
import com.mysql.forumapi.MySQL.ForumAPI.entity.Answer;
import com.mysql.forumapi.MySQL.ForumAPI.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Integer> {

    @Query(value = "select * from Account where id = ?1", nativeQuery = true)
    Optional<Account> getDetailsForAccountId(int accountId);

}
