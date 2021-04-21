package net.finman.dao;

import net.finman.exception.ResourceNotCreatedException;
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

    private static final String INSERT_INVOICE = "INSERT INTO Invoices(serial_no, OCR, invoice_date, expiry_date, bankgiro, seller, buyer) VALUES (:serial_no, :OCR, :invoice_date, :expiry_date, :bankgiro, :seller, :buyer)";
    private static final String INSERT_INVOICE_ITEMS = "INSERT INTO InvoiceItems VALUES (:invoice, :seller, :item_id, :item_owner, :amount)";

    @Override
    public void createInvoice(Invoice inv) throws ResourceNotCreatedException {
        try {
            UUID rUUID = UUID.randomUUID();
            inv.setSerialNumber(rUUID);
            
            SqlParameterSource invoiceParams = new MapSqlParameterSource()
                    .addValue("serial_no", rUUID)
                    .addValue("OCR", inv.getOcr())
                    .addValue("invoice_date", inv.getInvoiceDate(), Types.DATE)
                    .addValue("expiry_date", inv.getExpiryDate(), Types.DATE)
                    .addValue("bankgiro", inv.getBankgiro())
                    .addValue("seller", inv.getSeller())
                    .addValue("buyer", inv.getBuyer());
            template.update(INSERT_INVOICE, invoiceParams);
        } catch (DataAccessException e) {
            throw new ResourceNotCreatedException("Failed to create invoice", e.getMessage());
        }
    }

    @Override
    public void addInvoiceItems(UUID serialNumber, int seller, List<Item> items) throws ResourceNotCreatedException {
        try {
            for (Item i : items) {
                SqlParameterSource itemsParams = new MapSqlParameterSource()
                        .addValue("invoice", serialNumber)
                        .addValue("seller", seller)
                        .addValue("item_id", i.getId())
                        .addValue("item_owner", i.getOwner())
                        .addValue("amount", i.getAmount());
                template.update(INSERT_INVOICE_ITEMS, itemsParams);
            }
        } catch (DataAccessException e) {
            throw new ResourceNotCreatedException("Failed to add items to invoice", e.getMessage());
        }
    }
}
