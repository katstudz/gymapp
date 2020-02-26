package com.gym.exercisesset.exercises;

import com.gym.exercisesset.model.Exercise;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ExerciseRepository extends MongoRepository<Exercise, Long> {
}
