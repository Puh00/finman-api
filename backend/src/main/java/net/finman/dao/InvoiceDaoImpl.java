package net.finman.dao;

import net.finman.model.Invoice;
import net.finman.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Types;

@Repository
public class InvoiceDaoImpl implements InvoiceDao {
    @Autowired
    private NamedParameterJdbcTemplate template;

    private static final String INSERT_INVOICE = "INSERT INTO Invoices VALUES (:serial_no, :invoice_no, :VAT, :OCR, :invoice_date, :expiry_date, :bankgiro, :reg_no, :seller, :buyer)";
    private static final String INSERT_INVOICE_ITEMS = "INSERT INTO InvoiceItems VALUES (:invoice, :item_id, :item_owner, :amount)";

    @Override
    @Transactional
    public void createInvoice(Invoice inv) {
        try {
            SqlParameterSource invoiceParams = new MapSqlParameterSource()
                    .addValue("serial_no", inv.getSerialNumber())
                    .addValue("invoice_no", inv.getInvoiceNumber())
                    .addValue("VAT", inv.getVat())
                    .addValue("OCR", inv.getOcr())
                    .addValue("invoice_date", inv.getInvoiceDate(), Types.DATE)
                    .addValue("expiry_date", inv.getExpiryDate(), Types.DATE)
                    .addValue("bankgiro", inv.getBankgiro())
                    .addValue("reg_no", inv.getRegNumber())
                    .addValue("seller", inv.getSeller())
                    .addValue("buyer", inv.getBuyer());
            template.update(INSERT_INVOICE, invoiceParams);

            for (Item i : inv.getItems()) {
                SqlParameterSource itemsParams = new MapSqlParameterSource()
                        .addValue("invoice", inv.getSerialNumber())
                        .addValue("item_id", i.getId())
                        .addValue("item_owner", i.getOwner())
                        .addValue("amount", i.getAmount());
                template.update(INSERT_INVOICE_ITEMS, itemsParams);
            }
        }
        catch (DataAccessException e) {
            System.out.println("git gud");
        }
    }
}
