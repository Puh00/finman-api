
package net.finman.service;

import net.finman.dao.InvoiceDao;
import net.finman.exception.EmailNotSentException;
import net.finman.exception.ResourceNotCreatedException;
import net.finman.exception.ResourceNotFoundException;
import net.finman.model.Invoice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import javax.annotation.Resource;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    @Resource
    private InvoiceDao invoiceDao;
    @Autowired
    private EmailService emailService;

    @Override
    @Transactional
    public void createAndSendInvoice(String invoiceJson, InputStreamSource pdf, String to)
            throws ResourceNotCreatedException, EmailNotSentException {

        ObjectMapper objectMapper = new ObjectMapper();

        Invoice invoice;
        try {
            invoice = objectMapper.readValue(invoiceJson, Invoice.class);

            invoiceDao.createInvoice(invoice);
            //invoiceDao.addInvoiceItems(invoice.getSerialNumber(), invoice.getSeller(), invoice.getItems());
        } catch (JsonProcessingException e) {
            throw new ResourceNotCreatedException("Invalid invoice JSON!", e.getMessage());
        }

        emailService.sendEmailWithAttachment(to, pdf);
    }

    @Override
    public List<Invoice> getInvoices(String source) throws ResourceNotFoundException {
        return invoiceDao.getInvoices(source);
    }
}
