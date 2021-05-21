package net.finman.service;

import net.finman.dao.AccountDao;
import net.finman.exception.ResourceNotCreatedException;
import net.finman.model.Account;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountDao accountDao;

    @Override
    public void createAccount(Account account) throws ResourceNotCreatedException {
        accountDao.createAccount(account);
    }

}
