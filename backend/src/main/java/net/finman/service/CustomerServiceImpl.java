package net.finman.service;

import net.finman.dao.CustomerDao;
import net.finman.exception.ResourceNotCreatedException;
import net.finman.exception.ResourceNotFoundException;
import net.finman.model.UserCustomer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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
