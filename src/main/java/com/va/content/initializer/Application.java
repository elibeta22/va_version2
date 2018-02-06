package com.va.content.initializer;

/**
 * Created by eli on 2/3/2018.
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.va.content")
@EnableJpaRepositories("com.va.content.repositories")
@EntityScan("com.va.content.models")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}