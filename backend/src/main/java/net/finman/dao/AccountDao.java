package net.finman.dao;

import net.finman.exception.ResourceNotCreatedException;
import net.finman.model.Account;

public interface AccountDao {
    /**
     * Creates an account and stores the entry in the database
     *
     * @param account The account model of a user
     */
    void createAccount(Account account) throws ResourceNotCreatedException;
}
