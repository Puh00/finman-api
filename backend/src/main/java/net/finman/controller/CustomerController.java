package net.finman.controller;

import net.finman.exception.ResourceNotCreatedException;
import net.finman.exception.ResourceNotFoundException;
import net.finman.model.UserCustomer;
import net.finman.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping("/customer")
    public ResponseEntity<?> createCustomer(@RequestBody UserCustomer customer) throws ResourceNotCreatedException {
        customerService.createCustomer(customer);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/customer/{email}")
    public ResponseEntity<?> getCustomers(@PathVariable String email) throws ResourceNotFoundException {
        return new ResponseEntity<>(customerService.getCustomers(email), HttpStatus.OK);
    }

}
