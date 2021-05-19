package net.finman.dao;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import net.finman.exception.ResourceNotCreatedException;
import net.finman.exception.ResourceNotFoundException;
import net.finman.mapper.CustomerMapper;

import java.sql.Types;

import com.fasterxml.jackson.core.JsonProcessingException;
import net.finman.model.UserCustomer;

@Repository
public class CustomerDaoImpl implements CustomerDao {

    private static final String INSERT_CUSTOMER = "INSERT INTO UserCustomers VALUES (:email, :customer)";
    private static final String GET_CUSTOMERS = "SELECT * FROM UserCustomers WHERE email=:email";

    @Autowired
    private NamedParameterJdbcTemplate template;

    @Override
    public void createCustomer(UserCustomer customer) throws ResourceNotCreatedException {

        ObjectMapper objectMapper = new ObjectMapper();
        String customerJson = "";
        try {
            customerJson = objectMapper.writeValueAsString(customer.getCustomer());
            System.out.println(customerJson);
        } catch (JsonProcessingException e) {
            throw new ResourceNotCreatedException("Invalid customer in CustomerDaoImplementation!", e.getMessage());
        }

        SqlParameterSource customerParams = new MapSqlParameterSource().addValue("email", customer.getUser())
                .addValue("customer", customerJson, Types.OTHER);
        template.update(INSERT_CUSTOMER, customerParams);

    }

    @Override
    public List<UserCustomer> getCustomers(String email) throws ResourceNotFoundException {
        try {
            SqlParameterSource customerParams = new MapSqlParameterSource().addValue("email", email);

            CustomerMapper customerMapper = new CustomerMapper();
            List<UserCustomer> customers = template.query(GET_CUSTOMERS, customerParams, customerMapper);
            if (customers.size() == 0) {
                throw new ResourceNotFoundException("You dont have any customers yet", "");
            }
            return customers;
        } catch (DataAccessException e) {
            throw new ResourceNotFoundException("Error communcating with database!", e.getMessage());
        }

    }

}
