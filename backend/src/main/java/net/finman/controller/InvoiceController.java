package net.finman.controller;

import net.finman.dao.InvoiceDao;
import net.finman.model.Invoice;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class InvoiceController {
    @Resource
    InvoiceDao invoiceDao;

    @PostMapping("/invoices")
    public void createInvoice(@RequestBody Invoice inv) {
        invoiceDao.createInvoice(inv);
    }
}
