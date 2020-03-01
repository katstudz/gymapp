package com.gym.exercisesset.model;

import com.gym.exercisesset.traininglist.ExerciseWithRepeat;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document
public class Training {
    List<ExerciseWithRepeat> exercisesWithRepeat = new ArrayList<>();

    public void addExercise(ExerciseWithRepeat exercise){
        exercisesWithRepeat.add(exercise);
    }
}
