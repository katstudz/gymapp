package com.gym.exercisesset.repository;

import com.gym.exercisesset.model.Exercise;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ExerciseRepository extends MongoRepository<Exercise, Long> {
    Optional<Exercise> findByName(String name);
}
