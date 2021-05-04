package net.finman.service;

import java.io.File;

import javax.mail.MessagingException;

public interface EmailService {
    void sendEmailWithAttachment(String to, String subject, String text, File attachment) throws MessagingException;
}
