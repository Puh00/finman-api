package net.finman.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import net.finman.dao.CustomerDao;
import net.finman.exception.ResourceNotCreatedException;
import net.finman.exception.ResourceNotFoundException;
import net.finman.model.UserCustomer;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Resource
    CustomerDao customerDao;

    @Override
    public void createCustomer(UserCustomer customer) throws ResourceNotCreatedException {
       customerDao.createCustomer(customer);
    }

    @Override
    public List<UserCustomer> getCustomers(String email) throws ResourceNotFoundException {
        return customerDao.getCustomers(email);
    }
    
}
