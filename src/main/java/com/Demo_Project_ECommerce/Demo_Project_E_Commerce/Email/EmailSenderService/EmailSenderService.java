package com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Email.EmailSenderService;

import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Email.EmailBodyBuilder.EmailBodyBuilder;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class EmailSenderService {
    private final JavaMailSender mailSender;

    private final EmailBodyBuilder emailBodyBuilder;

    @Async
    public void sendMail(String toEmail, String subject, String body) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("muthubharathi.g@tothenew.com");
        mailMessage.setTo(toEmail);
        mailMessage.setSubject(subject);
        mailMessage.setText(body);
        mailSender.send(mailMessage);

    }

}
