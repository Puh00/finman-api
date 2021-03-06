package net.finman.service;

import net.finman.exception.ResourceNotCreatedException;
import net.finman.exception.ResourceNotFoundException;
import net.finman.model.UserCustomer;

import java.util.List;

public interface CustomerService {
    /**
     * Creates a customer and stores it in the database.
     *
     * @param customer The customer model to be added.
     * @throws ResourceNotCreatedException
     */
    void createCustomer(UserCustomer customer) throws ResourceNotCreatedException;

    /**
     * @param email
     * @return a list of all customers a user has created
     * @throws ResourceNotFoundException
     */
    List<UserCustomer> getCustomers(String email) throws ResourceNotFoundException;

}
