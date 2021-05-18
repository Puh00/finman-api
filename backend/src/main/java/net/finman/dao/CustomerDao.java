package net.finman.dao;

import java.util.List;

import net.finman.exception.ResourceNotCreatedException;
import net.finman.exception.ResourceNotFoundException;
import net.finman.model.UserCustomer;

/**
 * Creates a customer and stores it in the database
 * @param  customer: the customer to be created
 */
public interface CustomerDao {
    void createCustomer (UserCustomer customer) throws ResourceNotCreatedException;

    List<UserCustomer> getCustomers(String email) throws ResourceNotFoundException;
}

