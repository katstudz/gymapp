package com.gym.exercisesset.sender.mail;

import com.gym.exercisesset.ExercisesSetApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ExercisesSetApplication.class })
@WebAppConfiguration
public class MailSenderTest {
    @Autowired
    private MailSender sender;

    @Test
    public void sendTest(){
        sender.sendSimpleMessage("katstudz@gmail.com", "subject", "Hello my dear");
    }
}