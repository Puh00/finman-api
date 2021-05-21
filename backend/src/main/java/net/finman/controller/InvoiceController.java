package net.finman.controller;

import net.finman.exception.EmailNotSentException;
import net.finman.exception.ResourceNotCreatedException;
import net.finman.exception.ResourceNotFoundException;
import net.finman.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @PostMapping("/invoices")
    public ResponseEntity<?> createAndSendInvoice(@RequestParam("invoice") MultipartFile invoiceJson,
                                                  @RequestParam("file") MultipartFile pdf,
                                                  @RequestParam("to") String to)
            throws ResourceNotCreatedException, EmailNotSentException {

        try {
            invoiceService.createAndSendInvoice(new String(invoiceJson.getBytes()), pdf, to);
        } catch (IOException e) {
            throw new ResourceNotCreatedException("Invoice JSON is corrupt!", e.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/invoices/{source}")
    public ResponseEntity<?> getInvoices(@PathVariable String source) throws ResourceNotFoundException {
        return new ResponseEntity<>(invoiceService.getInvoices(source), HttpStatus.OK);
    }
}
