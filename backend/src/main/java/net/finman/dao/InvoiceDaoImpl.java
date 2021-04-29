package net.finman.dao;

import net.finman.exception.ResourceNotCreatedException;
import net.finman.exception.ResourceNotFoundException;
import net.finman.mapper.InvoiceMapper;
import net.finman.mapper.ItemMapper;
import net.finman.model.Invoice;
import net.finman.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.util.List;
import java.util.UUID;

@Repository
public class InvoiceDaoImpl implements InvoiceDao {
    @Autowired
    private NamedParameterJdbcTemplate template;

    private static final String INSERT_INVOICE = "INSERT INTO Invoices(source, serial_no, OCR, invoice_date, expiry_date, bankgiro, seller, customer, is_paid) VALUES (:source, :serial_no, :OCR, :invoice_date, :expiry_date, :bankgiro, :seller, :customer, :is_paid)";
    private static final String INSERT_INVOICE_ITEMS = "INSERT INTO InvoiceItems VALUES (:invoice, :seller, :name, :item_owner, :amount)";
    private static final String GET_INVOICES = "SELECT DISTINCT * FROM (SELECT *, jsonb_path_query(customer, '$.email') :: text as email FROM Invoices) AS info WHERE info.source=:source OR info.email=:email";
    private static final String GET_INVOICE_ITEMS = "SELECT * FROM InvoiceItems NATURAL JOIN Items WHERE invoice=:invoice AND seller=:seller";

    @Override
    public void createInvoice(Invoice inv) throws ResourceNotCreatedException {
        try {
            inv.setSerialNumber(UUID.randomUUID());

            SqlParameterSource invoiceParams = new MapSqlParameterSource()
                    .addValue("source", inv.getSource())
                    .addValue("serial_no", inv.getSerialNumber())
                    .addValue("OCR", inv.getOcr())
                    .addValue("invoice_date", inv.getInvoiceDate(), Types.DATE)
                    .addValue("expiry_date", inv.getExpiryDate(), Types.DATE)
                    .addValue("bankgiro", inv.getBankgiro())
                    .addValue("seller", inv.getSeller())
                    .addValue("customer", inv.getCustomer())
                    .addValue("is_paid", inv.getIsPaid());
            template.update(INSERT_INVOICE, invoiceParams);
        } catch (DataAccessException e) {
            throw new ResourceNotCreatedException("Failed to create invoice", e.getMessage());
        }
    }

    @Override
    public void addInvoiceItems(UUID serialNumber, String seller, List<Item> items) throws ResourceNotCreatedException {
        try {
            for (Item i : items) {
                SqlParameterSource itemsParams = new MapSqlParameterSource()
                        .addValue("invoice", serialNumber)
                        .addValue("seller", seller)
                        .addValue("name", i.getName())
                        .addValue("item_owner", i.getOwner())
                        .addValue("amount", i.getAmount());
                template.update(INSERT_INVOICE_ITEMS, itemsParams);
            }
        } catch (DataAccessException e) {
            throw new ResourceNotCreatedException("Failed to add items to invoice", e.getMessage());
        }
    }

    @Override
    public List<Invoice> getInvoices(String source) throws ResourceNotFoundException {
        try {
            SqlParameterSource invoiceParams = new MapSqlParameterSource()
                    .addValue("source", source)
                    .addValue("email", source);
            
            InvoiceMapper mapper = new InvoiceMapper();
            List<Invoice> invoices = template.query(GET_INVOICES, invoiceParams, mapper);

            // add the items to the invoices
            for (Invoice invoice : invoices){
                invoice.setItems(getInvoiceItems(invoice.getSerialNumber(), invoice.getSeller()));
            }
            
            if (invoices.size() == 0)
                throw new ResourceNotFoundException("You don't have any invoices!", "");

            return invoices;
        } catch(DataAccessException e) {
           throw new ResourceNotFoundException("Error communcating with database!", e.getMessage());
        }
    }

    @Override
    public List<Item> getInvoiceItems(UUID invoice, String seller) throws ResourceNotFoundException {
        try {
            SqlParameterSource invoiceItemParams = new MapSqlParameterSource()
                    .addValue("invoice", invoice)
                    .addValue("seller", seller);
            
            ItemMapper mapper = new ItemMapper();
            List<Item> items = template.query(GET_INVOICE_ITEMS, invoiceItemParams, mapper);

            return items;
        } catch(DataAccessException e) {
           throw new ResourceNotFoundException("Cannot retrieve invoice items!", e.getMessage());
        }
    }

}
