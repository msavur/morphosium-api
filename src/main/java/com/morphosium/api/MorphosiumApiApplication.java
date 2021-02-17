package com.morphosium.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@ComponentScan(basePackages = {"com.morphosium"})
@EntityScan(basePackages = {"com.morphosium"})
@EnableJpaRepositories(basePackages = "com.morphosium")
public class MorphosiumApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(MorphosiumApiApplication.class, args);
    }

}
