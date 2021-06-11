package net.finman.controller;

import net.finman.exception.EmailNotSentException;
import net.finman.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/send-invoice")
    public ResponseEntity<?> sendInvoice(@RequestParam("file") MultipartFile file, @RequestParam("to") String to)
            throws EmailNotSentException {
        emailService.sendEmailWithAttachment(to, file);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
