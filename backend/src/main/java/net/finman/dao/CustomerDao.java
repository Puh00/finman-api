package net.finman.dao;

import java.util.List;

import net.finman.exception.ResourceNotCreatedException;
import net.finman.exception.ResourceNotFoundException;
import net.finman.model.UserCustomer;

public interface CustomerDao {
    /**
     * Creates a customer and stores it in the database
     * 
     * @param customer: the customer to be created
     */
    void createCustomer(UserCustomer customer) throws ResourceNotCreatedException;

    /**
     * 
     * @param email
     * @return returns a list of all customers that a user has created
     * @throws ResourceNotFoundException
     */
    List<UserCustomer> getCustomers(String email) throws ResourceNotFoundException;
}
