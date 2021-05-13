package net.finman.dao;

import net.finman.exception.ResourceNotCreatedException;
import net.finman.model.UserCustomer;

/**
 * Creates a customer and stores it in the database
 * @param  customer: the customer to be created
 */
public interface CustomerDao {
    void createCustomer (UserCustomer customer) throws ResourceNotCreatedException;
}