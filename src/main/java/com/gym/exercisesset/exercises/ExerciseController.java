package com.gym.exercisesset.exercises;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExerciseController {
    private ExercisesService exercisesService;

    @GetMapping
    public void getAll(){
        exercisesService.getAll();
    }
}
