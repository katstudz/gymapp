package com.gym.exercisesset.traininglist;

import com.gym.exercisesset.exception.NoExerciseWithSelectedName;
import com.gym.exercisesset.exercises.ExercisesService;
import com.gym.exercisesset.model.Exercise;
import com.gym.exercisesset.model.Training;
import com.gym.exercisesset.sender.MailSender;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

//todo make Session prototype
@Service
public class TrainingListService {

    private ExercisesService exercisesService;
    private MailSender mailSender;
    private Training training;

    @Autowired
    TrainingListService(ExercisesService exercisesService,
                        MailSender mailSender){
        this.exercisesService = exercisesService;
        this.mailSender = mailSender;
        training = new Training();
    }


    @SneakyThrows
    public void addExerciseToTraining (String exerciseName, int repeat){
        Optional<Exercise> optionalExercise = exercisesService.findExerciseByName(exerciseName);
        if(optionalExercise.isEmpty())
            throw  new NoExerciseWithSelectedName(exerciseName);
        Exercise exercise = optionalExercise.get();
        training.addExercise(new ExerciseWithRepeat(exercise, repeat));
    }

    public void sendTraining(String email){
        mailSender.sendTraining(email, training);
    }

}
