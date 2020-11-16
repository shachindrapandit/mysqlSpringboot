package com.mysql.forumapi.MySQL.ForumAPI.repository;

import com.mysql.forumapi.MySQL.ForumAPI.entity.Answer;
import com.mysql.forumapi.MySQL.ForumAPI.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AnswerRepository extends JpaRepository<Answer, Integer> {

    @Query(value="select * from answer where question_id = ?1", nativeQuery = true)
    Optional<Answer> findByQuestionId(int questionId);

    @Query(value="select * from Answer where account_id = ?1", nativeQuery = true)
    List<Answer> findByAccountId(int accountId);

}
