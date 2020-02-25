package com.gym.exercisesset;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableMongoRepositories(basePackages = "com.gym.exercisesset")
public class ExercisesSetApplication {
    public static void main(String[] args) {
        SpringApplication.run(ExercisesSetApplication.class, args);
    }

}
