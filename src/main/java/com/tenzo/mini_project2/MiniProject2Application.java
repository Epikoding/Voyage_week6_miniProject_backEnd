package com.tenzo.mini_project2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication
@EnableJpaAuditing
public class MiniProject2Application {

    public static void main(String[] args) {
        SpringApplication.run(MiniProject2Application.class, args);
    }

}
