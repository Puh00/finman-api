package net.finman.service;
import net.finman.exception.ResourceNotCreatedException;
import net.finman.model.UserCustomer;

public interface CustomerService {
    /**
     * Creates a customer and stores it in the database.
     * @param customer The customer model to be added.
     * @throws ResourceNotCreatedException
     */
    void createCustomer(UserCustomer customer) throws ResourceNotCreatedException;
    
}
