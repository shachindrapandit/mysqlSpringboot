package com.mysql.forumapi.MySQL.ForumAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.mysql.forumapi.MySQL.ForumAPI.repository")
public class MySqlForumApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MySqlForumApiApplication.class, args);

		}

}


