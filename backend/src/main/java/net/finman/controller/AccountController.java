package net.finman.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.finman.exception.ResourceNotCreatedException;
import net.finman.model.Account;
import net.finman.service.AccountService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class AccountController {

    @Autowired
    AccountService accountService;
    
    @PostMapping("/account")
    public ResponseEntity<?> createAccount(@RequestBody Account account) throws ResourceNotCreatedException {
        accountService.createAccount(account); 
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
