package net.finman.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import net.finman.dao.AccountDao;
import net.finman.exception.ResourceNotCreatedException;
import net.finman.model.Account;

@Service
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountDao accountDao;

    @Override
    public void createAccount(Account account) throws ResourceNotCreatedException {
        accountDao.createAccount(account);
    }

}
