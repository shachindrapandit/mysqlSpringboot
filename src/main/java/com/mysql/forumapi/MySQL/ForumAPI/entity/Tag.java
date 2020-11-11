package com.mysql.forumapi.MySQL.ForumAPI.entity;

import javax.persistence.Entity;
import java.util.List;

public class Tag {

    String TagName;
    String description;

    List<Question> questionList;

}
