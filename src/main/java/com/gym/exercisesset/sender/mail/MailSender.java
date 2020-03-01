package com.gym.exercisesset.sender.mail;

import com.gym.exercisesset.model.Training;
import com.gym.exercisesset.sender.ExcelFileCreator;
import com.gym.exercisesset.sender.SendResult;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Date;
import java.util.Properties;

@Service
@AllArgsConstructor
public class MailSender {

    private final ExcelFileCreator csvCreator;
    private final JavaMailSender mailSender;

    @SneakyThrows
    public SendResult sendTraining(String email, Training training) {
        csvCreator.createFile(email, training);
        return SendResult.SUCCESS;
    }

    @SneakyThrows
    public void sendSimpleMessage(String to, String subject, String text) {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("test123456super@gmail.com", "supertestExtra");
            }
        });
        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress("test123456super@gmail.com", false));

        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("enemvy@gmail.com"));
        msg.setSubject("Tutorials point email");
        msg.setContent("Tutorials point email", "text/html");
        msg.setSentDate(new Date());

        MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent("Tutorials point email", "text/html");

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);
        MimeBodyPart attachPart = new MimeBodyPart();

        attachPart.attachFile("/var/tmp/image19.png");
        multipart.addBodyPart(attachPart);
        msg.setContent(multipart);
        Transport.send(msg);


//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setTo(to);
//        message.setSubject(subject);
//        message.setText(text);
//        mailSender.send(message);
    }

}
