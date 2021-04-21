package net.finman.dao;

import net.finman.exception.ResourceNotCreatedException;
import net.finman.model.Invoice;
import net.finman.model.Item;

import java.util.List;
import java.util.UUID;

public interface InvoiceDao {
    /**
     * Creates an invoice without invoice items.
     *
     * @param inv Invoice.
     * @throws ResourceNotCreatedException If the sql insertion failed.
     */
    void createInvoice(Invoice inv) throws ResourceNotCreatedException;

    /**
     * Adds items to an invoice.
     *
     * @param serialNumber Serial number of the invoice associated with the seller.
     * @param seller       The seller of an invoice.
     * @param items        Items to be added to an invoice.
     * @throws ResourceNotCreatedException If the sql insertion failed.
     */
    void addInvoiceItems(UUID serialNumber, int seller, List<Item> items) throws ResourceNotCreatedException;
}
