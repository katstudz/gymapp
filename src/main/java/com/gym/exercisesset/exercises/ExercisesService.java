package com.gym.exercisesset.exercises;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ExercisesService {
    private  ExerciseRepository exerciseRepository;
    @Autowired
    ExercisesService(ExerciseRepository exerciseRepository){
        Exercise squats = Exercise.builder()
                .description("Przysiad jest ćwiczeniem siłowym, w którym uczestnik" +
                        " opuszcza biodra z pozycji stojącej, a następnie wstaje.")
                .name("przysiady")
                .youtubeSource("https://www.youtube.com/watch?v=gC2JDbEuwOI")
                .build();
        exerciseRepository.save(squats);

        Exercise pumps = Exercise.builder()
                .description("popularna nazwa ćwiczenia fizycznego wykonywanego w pozycji poziomej, " +
                        "twarzą do ziemi, polegającego na podnoszeniu i obniżaniu tułowia")
                .name("pompki")
                .youtubeSource("https://www.youtube.com/watch?v=boSpmZZp74U")
                .build();
        exerciseRepository.save(squats);
        exerciseRepository.save(pumps);
    }

    public void getAll() {
        var  all = exerciseRepository.findAll();
        log.info(all.toString());
    }

//    @Scheduled(fixedDelay = 1000)
//    public void test(){
//        var list = exerciseRepository.findAll();
//        System.out.println(list.size());
//    }

}
