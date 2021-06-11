package net.finman.service;

import net.finman.exception.ResourceNotCreatedException;
import net.finman.model.Account;

public interface AccountService {
    /**
     * Creates an account and stores the entry in the database
     *
     * @param account The account model of a user
     */
    void createAccount(Account account) throws ResourceNotCreatedException;
}
