package net.finman.dao;

import net.finman.exception.ResourceNotCreatedException;
import net.finman.exception.ResourceNotFoundException;
import net.finman.mapper.InvoiceMapper;
import net.finman.model.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.util.List;
import java.util.SplittableRandom;
import java.util.UUID;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
public class InvoiceDaoImpl implements InvoiceDao {
    @Autowired
    private NamedParameterJdbcTemplate template;

    private static final String INSERT_INVOICE = "INSERT INTO Invoices(source, serial_no, OCR, invoice_date, expiry_date, bankgiro, seller, customer, invoice_items,  is_paid) VALUES (:source, :serial_no, :OCR, :invoice_date, :expiry_date, :bankgiro, :seller, :customer, :invoice_items, :is_paid)";
    private static final String GET_INVOICES = "SELECT DISTINCT * FROM (SELECT *, trim('\"' FROM jsonb_path_query(customer, '$.email') :: VARCHAR(128)) as email FROM Invoices) AS info WHERE info.source=:source OR info.email=:email";
    @Override
    public void createInvoice(Invoice inv) throws ResourceNotCreatedException {
        try {
            inv.setSerialNumber(UUID.randomUUID());
            inv.setBankgiro("556036-0793");
            inv.setOcr(generateOcr());

            ObjectMapper objectMapper = new ObjectMapper();

            String customerJson = "";
            String invoiceItemsJson = "";
            try {
                customerJson = objectMapper.writeValueAsString(inv.getCustomer());
            } catch (JsonProcessingException e) {
                throw new ResourceNotCreatedException("Invalid customer JSON!", e.getMessage());
            }
            try {
                invoiceItemsJson = objectMapper.writeValueAsString(inv.getInvoiceItems());
            } catch (JsonProcessingException e) {
                throw new ResourceNotCreatedException("Invalid invoiceItem JSON!", e.getMessage());
            }

            SqlParameterSource invoiceParams = new MapSqlParameterSource()
                    .addValue("source", inv.getSource())
                    .addValue("serial_no", inv.getSerialNumber())
                    .addValue("OCR", inv.getOcr())
                    .addValue("invoice_date", inv.getInvoiceDate(), Types.DATE)
                    .addValue("expiry_date", inv.getExpiryDate(), Types.DATE)
                    .addValue("bankgiro", inv.getBankgiro())
                    .addValue("seller", inv.getSeller())
                    .addValue("customer", customerJson, Types.OTHER)
                    .addValue("invoice_items", invoiceItemsJson, Types.OTHER)
                    .addValue("is_paid", inv.getIsPaid());
            template.update(INSERT_INVOICE, invoiceParams);
        } catch (DataAccessException e) {
            throw new ResourceNotCreatedException("Failed to create invoice", e.getMessage());
        }
    }

    private String generateOcr(){
        long ocr;
        SplittableRandom rng = new SplittableRandom();
        ocr = rng.longs(1, 1000000000, 9999999999L).sum();
        return Long.toString(ocr);
    }


    @Override
    public List<Invoice> getInvoices(String source) throws ResourceNotFoundException {
        try {
            SqlParameterSource invoiceParams = new MapSqlParameterSource()
                    .addValue("source", source)
                    .addValue("email", source);

            InvoiceMapper mapper = new InvoiceMapper();
            List<Invoice> invoices = template.query(GET_INVOICES, invoiceParams, mapper);


            if (invoices.size() == 0)
                throw new ResourceNotFoundException("You don't have any invoices!", "");

            return invoices;
        } catch(DataAccessException e) {
            throw new ResourceNotFoundException("Error communcating with database!", e.getMessage());
        }
    }


}
