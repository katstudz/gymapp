package com.gym.exercisesset.exercises;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExerciseController {
    @Autowired
    private ExercisesService exercisesService;

    @GetMapping
    public void getAll(){
        exercisesService.getAll();
    }
}
