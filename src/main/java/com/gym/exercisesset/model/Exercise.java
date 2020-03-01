package com.gym.exercisesset.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.ToString;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Builder
@Document
@ToString
@AllArgsConstructor
public class Exercise {
    @Id ObjectId id;
    private String name;
    private String description;
    private String youtubeSource;
}
