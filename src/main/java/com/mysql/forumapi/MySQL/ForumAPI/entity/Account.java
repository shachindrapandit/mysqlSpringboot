package com.mysql.forumapi.MySQL.ForumAPI.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="Account")
public class Account {

    @Id
    @Column(name="id")
    int id;

    @Column(name="password")
    String password;

    @Column(name="AccountStatus")
    String accountStatus;

    @Column(name="name")
    String memberName;

    @Column(name="emailId")
    String emailId;

    @Column(name="phone")
    long phone;

    @Column(name="resetPassword")
    boolean resetPassword;

    @OneToMany(mappedBy = "account", fetch = FetchType.LAZY)
    private Set<Question> questionSet = new HashSet<>();

    public Set<Question> getQuestionSet() {
        return questionSet;
    }

    public void setQuestionSet(Set<Question> questionSet) {
        this.questionSet = questionSet;
    }

    @OneToMany(mappedBy = "account", fetch = FetchType.LAZY)
    private Set<Answer> answerSet = new HashSet<>();

    public Set<Answer> getAnswerSet() {
        return answerSet;
    }

    public void setAnswerSet(Set<Answer> answerSet) {
        this.answerSet = answerSet;
    }


    public Account() {
    }

    public Account(int id, String password, String accountStatus, String memberName, String emailId, long phone, boolean resetPassword) {
        this.id = id;
        this.password = password;
        this.accountStatus = accountStatus;
        this.memberName = memberName;
        this.emailId = emailId;
        this.phone = phone;
        this.resetPassword = resetPassword;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", AccountStatus='" + accountStatus + '\'' +
                ", MemberName='" + memberName + '\'' +
                ", emailId='" + emailId + '\'' +
                ", phone=" + phone +
                ", resetPassword=" + resetPassword +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public boolean isResetPassword() {
        return resetPassword;
    }

    public void setResetPassword(boolean resetPassword) {
        this.resetPassword = resetPassword;
    }
}

