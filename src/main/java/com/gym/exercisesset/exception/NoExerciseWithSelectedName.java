package com.gym.exercisesset.exception;

public class NoExerciseWithSelectedName extends Exception{
    public NoExerciseWithSelectedName (String name){
        super("No Exercise with:  " + name);
    }
}
