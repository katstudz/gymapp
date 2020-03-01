package com.gym.exercisesset.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Builder
@Document
@ToString
@AllArgsConstructor
@Getter
public class Exercise {
    @Id ObjectId id;
    private String name;
    private List<String> extraNote;
    private String youtubeSource;
}
