package net.finman.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import net.finman.exception.EmailNotSentException;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender emailSender;

    private static final String EMAIL_SUBJECT = "Invoice from A.Finman";
    private static final String EMAIL_BODY = "Hello here is your invoice pls pay q:^)";

    @Override
    public void sendEmailWithAttachment(String to, InputStreamSource attachment) throws EmailNotSentException {
        try {
            MimeMessage message = emailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setTo(to);
            helper.setSubject(EMAIL_SUBJECT);
            helper.setText(EMAIL_BODY);
            helper.addAttachment("invoice.pdf", attachment);

            emailSender.send(message);
        } catch (MessagingException e) {
            throw new EmailNotSentException("The email was not sent!", e.getMessage());
        }
    }

}
