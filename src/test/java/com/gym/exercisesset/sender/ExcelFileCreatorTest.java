package com.gym.exercisesset.sender;

import com.gym.exercisesset.model.Exercise;
import com.gym.exercisesset.model.Training;
import com.gym.exercisesset.traininglist.ExerciseWithRepeat;
import org.junit.After;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

class ExcelFileCreatorTest {
    ExcelFileCreator creator = new ExcelFileCreator();

    @Test
    public void createFileFromSimpleTraining_shouldCreateFileWithReturnedName() throws IOException {
        Training training = new Training();
        Exercise squats = Exercise.builder()
                .name("przysiady")
                .youtubeSource("https://www.youtube.com/watch?v=gC2JDbEuwOI")
                .build();
        training.addExercise(new ExerciseWithRepeat(squats, 10));
        String file = creator.createFile("name", training);

        File tmpDir = new File("./" + file);
        boolean exists = tmpDir.exists();
        Assert.assertTrue(exists);
        cleanAfterTest(file);
    }

    private void cleanAfterTest(String fileName) {
        File file =  new File("./" + fileName);
        try {
            Files.deleteIfExists(file.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    Training training = new Training();
//    Exercise squats = Exercise.builder()
//            .name("przysiady")
//            .youtubeSource("https://www.youtube.com/watch?v=gC2JDbEuwOI")
//            .build();
//    List<String> pumpsExtraNote = new ArrayList<>();
//        pumpsExtraNote.add("Powrót marsz");
//        pumpsExtraNote.add("na kazda noge");
//    Exercise pumps = Exercise.builder()
//            .name("pompki")
//            .extraNote(pumpsExtraNote)
//            .youtubeSource("https://www.youtube.com/watch?v=boSpmZZp74U")
//            .build();
//        training.addExercise(new ExerciseWithRepeat(squats, 10));
//        training.addExercise(new ExerciseWithRepeat(pumps, 20));

    @After
    public void clean(){

    }
}