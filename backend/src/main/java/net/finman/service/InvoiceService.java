package net.finman.service;

import net.finman.exception.EmailNotSentException;
import net.finman.exception.ResourceNotCreatedException;
import net.finman.exception.ResourceNotFoundException;
import net.finman.model.Invoice;
import org.springframework.core.io.InputStreamSource;

import java.util.List;

public interface InvoiceService {
    /**
     * Creates an invoice and sends it to the given mail address, if either the
     * creation process failed or the email sending process is failed, everything is
     * rolled back.
     *
     * @param invoiceJson The JSON string of an invoice
     * @param pdf         The pdf file of an invoice
     * @param to          The mail address to send the invoice to
     * @throws ResourceNotCreatedException If the invoice JSON failed to parse or
     *                                     the database failed to create a new row
     *                                     for this invoice
     * @throws EmailNotSentException       If the email failed to send in some way
     */
    void createAndSendInvoice(String invoiceJson, InputStreamSource pdf, String to)
            throws ResourceNotCreatedException, EmailNotSentException;

    /**
     * Returns all invoices related to a specific user. Both the invoices the user
     * has sent and the invoices the user has recieved. Changes nothing upon
     * failure.
     *
     * @param source Email of a user in the finman website
     * @return all invoices a user has sent or recieved.
     * @throws ResourceNotFoundException if the user doenst have any invoices or if
     *                                   the get-method fails for some reason.
     */
    List<Invoice> getInvoices(String source) throws ResourceNotFoundException;
}
