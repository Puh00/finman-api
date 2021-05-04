package net.finman.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import net.finman.exception.EmailNotSentException;
import net.finman.service.EmailService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class EmailController {

    @Autowired
    private EmailService emailService;

    private static final String EMAIL_SUBJECT = "Invoice from A.Finman";
    private static final String EMAIL_BODY = "Hello here is your invoice pls pay q:^)"; 

    @PostMapping("/send-invoice")
	public ResponseEntity<?> sendInvoice(@RequestParam("file") MultipartFile file, @RequestParam("to") String to) throws EmailNotSentException {
        emailService.sendEmailWithAttachment(to, EMAIL_SUBJECT, EMAIL_BODY, file);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
