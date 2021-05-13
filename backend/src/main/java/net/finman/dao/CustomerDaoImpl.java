package net.finman.dao;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import net.finman.exception.ResourceNotCreatedException;

import java.sql.Types;

import com.fasterxml.jackson.core.JsonProcessingException;
import net.finman.model.UserCustomer;

@Repository
public class CustomerDaoImpl implements CustomerDao {


    private static final String INSERT_CUSTOMER = "INSERT INTO UserCustomers VALUES (:user, :customer)";

    @Autowired
    private NamedParameterJdbcTemplate template;


    @Override
    public void createCustomer(UserCustomer customer) throws ResourceNotCreatedException {
        
        ObjectMapper objectMapper = new ObjectMapper();
        String customerJson = "";
        try{
            customerJson = objectMapper.writeValueAsString(customer);
            System.out.println(customerJson);
        } catch (JsonProcessingException e) {
            throw new ResourceNotCreatedException("Invalid customer in CustomerDaoImplementation!", e.getMessage());
        }
       
        SqlParameterSource customerParams = new MapSqlParameterSource()
            .addValue("user", customer.getUser())
            .addValue("customer", customerJson, Types.OTHER);
            template.update(INSERT_CUSTOMER, customerParams);
        
    }
    
}
