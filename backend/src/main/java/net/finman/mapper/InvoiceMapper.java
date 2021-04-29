package net.finman.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import org.springframework.jdbc.core.RowMapper;

import net.finman.model.Invoice;

public class InvoiceMapper implements RowMapper<Invoice> {

    @Override
    public Invoice mapRow(ResultSet rs, int rowNum) throws SQLException {
        Invoice invoice = new Invoice();
        invoice.setSource(rs.getString("source"));
        invoice.setSerialNumber(UUID.fromString(rs.getString("serial_no")));
        invoice.setVat(rs.getInt("VAT"));
        invoice.setOcr(rs.getString("OCR"));
        invoice.setInvoiceDate(rs.getString("invoice_date"));
        invoice.setExpiryDate(rs.getString("expiry_date"));
        invoice.setBankgiro(rs.getString("bankgiro"));
        invoice.setSeller(rs.getString("seller"));
        invoice.setCustomer(rs.getString("customer"));
        invoice.setIsPaid(rs.getBoolean("is_paid"));
        return invoice;
    }
}