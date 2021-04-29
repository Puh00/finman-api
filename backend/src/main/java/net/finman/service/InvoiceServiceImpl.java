package net.finman.service;

import net.finman.dao.InvoiceDao;
import net.finman.exception.ResourceNotCreatedException;
import net.finman.exception.ResourceNotFoundException;
import net.finman.model.Invoice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import javax.annotation.Resource;

@Service
public class InvoiceServiceImpl implements InvoiceService {
    @Resource
    private InvoiceDao invoiceDao;

    @Override
    @Transactional
    public void createInvoice(Invoice inv) throws ResourceNotCreatedException {
        invoiceDao.createInvoice(inv);
        invoiceDao.addInvoiceItems(inv.getSerialNumber(), inv.getSeller(), inv.getItems());
    }

    @Override
    public List<Invoice> getInvoices(String source) throws ResourceNotFoundException {
        return invoiceDao.getInvoices(source);
    }
}
