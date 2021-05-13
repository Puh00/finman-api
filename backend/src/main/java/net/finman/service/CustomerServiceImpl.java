package net.finman.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import net.finman.dao.CustomerDao;
import net.finman.exception.ResourceNotCreatedException;
import net.finman.model.UserCustomer;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Resource
    CustomerDao customerDao;

    @Override
    public void createCustomer(UserCustomer customer) throws ResourceNotCreatedException {
       customerDao.createCustomer(customer);
    }
    
}
