package com.gym.exercisesset.exercises;

import com.gym.exercisesset.model.Exercise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ExerciseController {
    @Autowired
    private ExercisesService exercisesService;

    @GetMapping
    public List<Exercise> getAll(){
        return exercisesService.getAll();
    }
}
