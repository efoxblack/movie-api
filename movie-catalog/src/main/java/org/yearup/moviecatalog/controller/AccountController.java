package org.yearup.moviecatalog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.yearup.moviecatalog.domain.Account;
import org.yearup.moviecatalog.dto.SuccessDetail;
import org.yearup.moviecatalog.service.AccountService;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(method = RequestMethod.GET, value = "/accounts")
    public ResponseEntity<List<Account>> getAllAccounts(){
        List<Account> accounts = accountService.getAllAccounts();
        SuccessDetail successfulResponseDetail = new SuccessDetail(HttpStatus.OK.value(), "Success", accounts);
        return new ResponseEntity(successfulResponseDetail, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/accounts/{accountId}")
    public ResponseEntity<?> getAccountById(@PathVariable Long accountId){
        Optional<Account> account = accountService.getAccountById(accountId);
        SuccessDetail successfulResponseDetail = new SuccessDetail(HttpStatus.OK.value(), "Success", account);
        return new ResponseEntity(successfulResponseDetail, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/accounts")
    public ResponseEntity<?> createAccount(@Valid @RequestBody Account account){
        Account a = accountService.createAccount(account);
        HttpHeaders headers = new HttpHeaders();
        URI newAccountUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/accounts")
                .buildAndExpand(account.getUserId())
                .toUri();
        headers.setLocation(newAccountUri);
        SuccessDetail successfulResponseDetail = new SuccessDetail(HttpStatus.CREATED.value(), "Created Account", account);
        return new ResponseEntity<>(successfulResponseDetail, headers, HttpStatus.CREATED);
    }
    @RequestMapping(method = RequestMethod.PUT, value = "/accounts/{accountId}")
    public ResponseEntity<?> updateAccount(@RequestBody Account account, @PathVariable Long accountId){
        accountService.updateAccount(account, accountId);
        SuccessDetail successfulResponseDetail = new SuccessDetail(HttpStatus.ACCEPTED.value(), "Updated Account", account);
        return new ResponseEntity<>(successfulResponseDetail, HttpStatus.ACCEPTED);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/accounts/{accountId}")
    public ResponseEntity<?> deleteAccount(@PathVariable Long accountId){
        accountService.deleteAccountById(accountId);
        SuccessDetail successfulResponseDetail = new SuccessDetail(HttpStatus.NO_CONTENT.value(), "Deleted Account", null);
        return new ResponseEntity<>(successfulResponseDetail, HttpStatus.NO_CONTENT);
    }
}