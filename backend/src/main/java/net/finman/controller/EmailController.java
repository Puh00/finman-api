package net.finman.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import net.finman.service.EmailService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class EmailController {

    @Autowired
    private EmailService emailService;
    
    @PostMapping("/send-invoice")
	public ResponseEntity<?> sendInvoice(@RequestParam("file") MultipartFile file) {

        File attachment = convertToFile(file);

        try {
            System.out.println("!!");
            emailService.sendEmailWithAttachment("yenanw@mail.com", "Invoice from A.Finman", "Hello here is your invoice pls pay q:^)", attachment);
        } catch (MessagingException e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
        
		return ResponseEntity.ok().build();
	}


    private File convertToFile(MultipartFile mulFile) {
        File file = new File("src/main/resources/invoice.pdf");
        System.out.println("!!!");
        try {
            mulFile.transferTo(file);
        } catch (IllegalStateException | IOException e) {
            e.printStackTrace();
        }

        return file;
    }
}
