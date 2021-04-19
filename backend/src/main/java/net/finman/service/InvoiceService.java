package net.finman.service;

import net.finman.exception.ResourceNotCreatedException;
import net.finman.model.Invoice;

public interface InvoiceService {
    /**
     * Creates an invoice along with its items and stores the invoice in the database.
     * Changes nothing upon failure.
     *
     * @param inv Invoice.
     * @throws ResourceNotCreatedException If the sql insertion failed.
     */
    void createInvoice(Invoice inv) throws ResourceNotCreatedException;
}
