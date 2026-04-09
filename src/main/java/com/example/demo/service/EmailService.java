package com.example.demo.service;

import jakarta.mail.Authenticator;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import java.util.Properties;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    public Session getSession(
        Properties props,
        String username,
        String password
    ) {
        Session session = Session.getInstance(
            props,
            new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            }
        );

        return session;
    }
}
