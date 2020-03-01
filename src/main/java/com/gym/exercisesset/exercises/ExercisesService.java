package com.gym.exercisesset.exercises;

import com.gym.exercisesset.model.Exercise;
import com.gym.exercisesset.repository.ExerciseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ExercisesService {
    private ExerciseRepository exerciseRepository;
    @Autowired
    ExercisesService(ExerciseRepository exerciseRepository){
        this.exerciseRepository = exerciseRepository;
        Exercise squats = Exercise.builder()
                .name("przysiady")
                .youtubeSource("https://www.youtube.com/watch?v=gC2JDbEuwOI")
                .build();
        exerciseRepository.save(squats);

        Exercise pumps = Exercise.builder()
                .name("pompki")
                .youtubeSource("https://www.youtube.com/watch?v=boSpmZZp74U")
                .build();
        exerciseRepository.save(squats);
        exerciseRepository.save(pumps);
    }

    public List<Exercise> getAll() {
        return exerciseRepository.findAll();
    }

    public Optional<Exercise> findExerciseByName(String name){
        return exerciseRepository.findByName(name);
    }

//    @Scheduled(fixedDelay = 1000)
//    public void test(){
//        var list = exerciseRepository.findAll();
//        System.out.println(list.size());
//    }

}
