package com.gym.exercisesset.sender;

import com.gym.exercisesset.model.Training;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MailSender {

    private final ExcelFileCreator csvCreator;

    @SneakyThrows
    public SendResult sendTraining(String email, Training training) {
        csvCreator.createFile(email, training);
        return SendResult.SUCCESS;
    }
}
