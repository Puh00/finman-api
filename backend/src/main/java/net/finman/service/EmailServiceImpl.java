package net.finman.service;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender emailSender;

    @Override
    public void sendEmailWithAttachment(String to, String subject, String text, File attachment) throws MessagingException {

        MimeMessage message = emailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        
        helper.setFrom("alexIsNoob@noobmail.com");
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(text);
        helper.addAttachment("invoice.pdf", attachment);

        emailSender.send(message);
    }
    
}
