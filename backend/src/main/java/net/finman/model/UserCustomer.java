package net.finman.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UserCustomer {

    private String email;
    private Customer customer;

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void convertAndSetCustomerJsonToObject(String customer) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            this.customer = objectMapper.readValue(customer, Customer.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public Customer getCustomer() {
        return customer;
    }
}
