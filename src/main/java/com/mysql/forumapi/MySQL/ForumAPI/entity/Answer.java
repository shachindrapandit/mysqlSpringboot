package com.mysql.forumapi.MySQL.ForumAPI.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mysql.forumapi.MySQL.ForumAPI.service.MemberService;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="Answer")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    int answerId;
    @Column(name="answer")
    String answer;
    @Column(name="accepted")
    boolean accepted;
    @Column(name="voteCount")
    int voteCount;
    @Column(name="flagCount")
    int flagCount;
    @Column(name="creationTime")
    Date creationTime;
    @Column(name="accountId")
    int accountId;
    @Column(name="questionId")
    int questionId;

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public Answer() {
    }

    @Override
    public String toString() {
        return "Answer{" +
                "answerId=" + answerId +
                ", answer='" + answer + '\'' +
                ", accepted=" + accepted +
                ", voteCount=" + voteCount +
                ", flagCount=" + flagCount +
                ", creationTime=" + creationTime +
                ", questionId=" + questionId +
                ", accountId=" + accountId +
                '}';
    }

    public Answer(int answerId, String answer, boolean accepted, int voteCount, int flagCount, Date creationTime, int accountId, int questionId) {
        this.answerId = answerId;
        this.answer = answer;
        this.accepted = accepted;
        this.voteCount = voteCount;
        this.flagCount = flagCount;
        this.creationTime = creationTime;
        this.accountId = accountId;
        this.questionId = questionId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id", nullable = false, insertable = false, updatable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Account account;

    @JsonIgnore
    public Account getAccount() {
        return account;
    }

    @JsonIgnore
    public void setAccount(Account account) {
        this.account = account;
    }

    public int getAnswerId() {
        return answerId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id", nullable = false, insertable = false, updatable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Question question;

    @JsonIgnore
    public Question getQuestion() {
        return question;
    }

    @JsonIgnore
    public void setQuestion(Question question) {
        this.question = question;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    public int getFlagCount() {
        return flagCount;
    }

    public void setFlagCount(int flagCount) {
        this.flagCount = flagCount;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

 //   private MemberService member;
    //private List<Photo> photoList;

    public boolean incrementVoteCount(){
        return false;
    }

}
