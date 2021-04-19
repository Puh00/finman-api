package net.finman.service;

import net.finman.dao.InvoiceDao;
import net.finman.exception.ResourceNotCreatedException;
import net.finman.model.Invoice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class InvoiceServiceImpl implements InvoiceService {
    @Resource
    private InvoiceDao invoiceDao;

    @Override
    @Transactional
    public void createInvoice(Invoice inv) throws ResourceNotCreatedException {
        invoiceDao.createInvoice(inv);
        invoiceDao.addInvoiceItems(inv.getSerialNumber(), inv.getItems());
    }
}
