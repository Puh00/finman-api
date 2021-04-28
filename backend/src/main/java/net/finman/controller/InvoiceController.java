package net.finman.controller;

import net.finman.exception.ResourceNotCreatedException;
import net.finman.exception.ResourceNotFoundException;
import net.finman.model.Invoice;
import net.finman.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class InvoiceController {

    @Autowired
    InvoiceService invoiceService;

    @PostMapping("/invoices")
    public ResponseEntity<?> createInvoice(@RequestBody Invoice inv) throws ResourceNotCreatedException {
        invoiceService.createInvoice(inv);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/invoices/{source}")
    public ResponseEntity<?> getInvoices(@PathVariable String source) throws ResourceNotFoundException {
        return new ResponseEntity<>(invoiceService.getInvoices(source), HttpStatus.FOUND);
    }
}
