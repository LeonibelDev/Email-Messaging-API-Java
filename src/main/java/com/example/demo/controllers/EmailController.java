package com.example.demo.controllers;

import com.example.demo.entity.MessageEntity;
import com.example.demo.service.EmailService;
import com.example.demo.template.EmailTemplate;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;

@RestController
@RequestMapping("/api/emails")
public class EmailController {

    @Autowired
    private EmailService emailService;

    private EmailTemplate emailTemplate;

    public EmailController(
        EmailService emailService,
        EmailTemplate emailTemplate
    ) {
        this.emailService = emailService;
        this.emailTemplate = emailTemplate;
    }

    @PostMapping("/send")
    public ResponseEntity<?> sendEmail(@RequestBody MessageEntity messageJson) {
        String from = "leonibel.ramirez@gmail.com";

        // google mail account credentials
        @Value("${email}")
        private String email;

        @Value("${password}")
        private String password;

        String host = "smtp.gmail.com";

        // config smtp
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");

        // config service
        Session session = emailService.getSession(props, email, password);

        // email template
        String emailTemplateFormated = emailTemplate.getTemplate(messageJson);

        // sender
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(email));
            message.setRecipients(
                Message.RecipientType.TO,
                InternetAddress.parse(messageJson.getRecipient())
            );
            message.setSubject(messageJson.getSubject());
            message.setContent(
                emailTemplateFormated,
                "text/html; charset=utf-8"
            );

            // send email
            Transport.send(message);
            Map response = new HashMap<>();
            response.put("message", "Email sent successfully");
            response.put("emailData", messageJson);

            return ResponseEntity.ok(response);
        } catch (MessagingException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(
                "Error sending email: " + e.getMessage()
            );
        }
    }
}
