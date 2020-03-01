package com.gym.exercisesset.traininglist;

import com.gym.exercisesset.model.Exercise;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExerciseWithRepeat {
    private Exercise exercise;
    private int repeat;
}
