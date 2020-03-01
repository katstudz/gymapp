package com.gym.exercisesset.sender;

import com.gym.exercisesset.model.Training;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MailSender {

    private final CsvCreator csvCreator;

    public SendResult sendTraining(String email, Training training) {
        csvCreator.createCSV(training);
        return SendResult.SUCCESS;
    }
}
