package com.mysql.forumapi.MySQL.ForumAPI.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mysql.forumapi.MySQL.ForumAPI.enums.QuestionStatus;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    int questionId;
    @Column(name="title")
    String title;
    @Column(name="description")
    String description;
    @Column(name="viewCount")
    int viewCount;
    @Column(name="voteCount")
    int voteCount;
    @Column(name="creationTime")
    Date creationTime;
    @Column(name="updateTime")
    Date updateTime;
    @Column(name="status")
    QuestionStatus status;
    @Column(name="accountId")
    int accountId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id", nullable = false, insertable = false, updatable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Account account;

    public Question(int accountId) {
        this.accountId = accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    @JsonIgnore
    public Account getAccount() {
        return account;
    }

    @JsonIgnore
    public void setAccount(Account account) {
        this.account = account;
    }

    public int getAccountId(){
        return account.getId();
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public QuestionStatus getStatus() {
        return status;
    }

    public void setStatus(QuestionStatus status) {
        this.status = status;
    }

    public Question() {
    }

    @Override
    public String toString() {
        return "Question{" +
                "questionId=" + questionId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", viewCount=" + viewCount +
                ", voteCount=" + voteCount +
                ", creationTime=" + creationTime +
                ", updateTime=" + updateTime +
                ", accountId=" + accountId +
                ", status=" + status +
                '}';
    }

    public Question(int questionId, String title, String description, int viewCount, int voteCount, Date creationTime, Date updateTime, QuestionStatus status, int accountId) {
        this.questionId = questionId;
        this.title = title;
        this.description = description;
        this.viewCount = viewCount;
        this.voteCount = voteCount;
        this.creationTime = creationTime;
        this.updateTime = updateTime;
        this.status = status;
        this.accountId = accountId;
    }
}
