package com.mysql.forumapi.MySQL.ForumAPI.repository;

import com.mysql.forumapi.MySQL.ForumAPI.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface QuestionRepository extends JpaRepository<Question, Integer> {

    @Query(value="select * from question where account_id = ?1", nativeQuery = true)
    List<Question> findByAccountId(int accountId);
}
