package net.finman.controller;

import net.finman.exception.ResourceNotCreatedException;
import net.finman.model.Account;
import net.finman.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
