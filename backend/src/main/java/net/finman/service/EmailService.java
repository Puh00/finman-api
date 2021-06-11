package net.finman.service;

import net.finman.exception.EmailNotSentException;
import org.springframework.core.io.InputStreamSource;

import javax.mail.MessagingException;

public interface EmailService {

    /**
     * Sends an email with an attachment to the given mail adress
     *
     * @param to         The person to recieve the mail
     * @param attachment The attached file to the mail, should be invoice pdf
     * @throws EmailNotSentException
     * @throws MessagingException    When the email failed to send
     */
    void sendEmailWithAttachment(String to, InputStreamSource attachment) throws EmailNotSentException;
}
