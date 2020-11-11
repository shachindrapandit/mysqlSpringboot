package com.mysql.forumapi.MySQL.ForumAPI.repository;

import com.mysql.forumapi.MySQL.ForumAPI.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Integer> {
}
