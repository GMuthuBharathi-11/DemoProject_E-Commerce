package com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Email.EmailSenderService;

import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Email.EmailBodyBuilder.Email_Body_Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class Email_Sender_Service
{
        private JavaMailSender mailSender;
        @Autowired
        Email_Body_Builder emailBodyBuilder;

        public void sendSimpleEmail(String toEmail, String subject, String body) {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("muthubharathi.g@tothenew.com");
            message.setTo(toEmail);
            message.setText(emailBodyBuilder.build(body));
            message.setSubject(subject);
            mailSender.send(message);
            System.out.println("Mail Send...");
        }
}
