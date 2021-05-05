package net.finman.service;

import javax.mail.MessagingException;

import org.springframework.core.io.InputStreamSource;

import net.finman.exception.EmailNotSentException;

public interface EmailService {

    /**
     * Sends an email with an attachment to the given mail adress
     * 
     * @param to         The person to recieve the mail
     * @param subject    Subject of mail
     * @param text       Body of mail
     * @param attachment The attached file to the mail, should be invoice pdf
     * @throws EmailNotSentException
     * @throws MessagingException    When the email failed to send
     */
    void sendEmailWithAttachment(String to, String subject, String text, InputStreamSource attachment)
            throws EmailNotSentException;
}
