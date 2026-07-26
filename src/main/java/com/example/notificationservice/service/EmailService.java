package com.example.notificationservice.service;

import com.example.notificationservice.dto.NotificationRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
public class EmailService {

    @Value("${spring.mail.host:smtp.gmail.com}")
    private String mailHost;

    @Value("${spring.mail.port:587}")
    private int mailPort;

    public void sendEmail(NotificationRequest request) {
        // Construct a dynamic MailSender using the user's incoming credentials
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(mailHost);
        mailSender.setPort(mailPort);
        mailSender.setUsername(request.getSenderEmail());
        mailSender.setPassword(request.getSenderPassword());

        // Configure standard SMTP properties
        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.ssl.trust", mailHost);
        // Build the email message
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(request.getSenderEmail());
        message.setTo(request.getRecipient());
        message.setSubject(request.getSubject());
        message.setText(request.getMessage());

        // Dispatch email
        mailSender.send(message);
        System.out.println("Email sent successfully on behalf of: " + request.getSenderEmail());
    }
}