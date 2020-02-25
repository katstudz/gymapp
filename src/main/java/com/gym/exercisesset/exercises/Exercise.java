package com.gym.exercisesset.exercises;

import lombok.AllArgsConstructor;
import lombok.Builder;

import java.util.PrimitiveIterator;

@Builder
@AllArgsConstructor
public class Exercise {
    private String name;
    private String description;
    private String youtubeSource;
}
