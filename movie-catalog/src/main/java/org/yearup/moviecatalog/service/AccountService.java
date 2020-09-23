package org.yearup.moviecatalog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yearup.moviecatalog.domain.Account;
import org.yearup.moviecatalog.exception.ResourceNotFoundException;
import org.yearup.moviecatalog.repository.AccountRepository;
import org.yearup.moviecatalog.repository.MovieRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;
    private MovieRepository movieRepository;

    protected void verifyAccount(Long accountId) throws ResourceNotFoundException {
        Optional<Account> account = accountRepository.findById(accountId);
        if (account.isEmpty()){
            throw new ResourceNotFoundException("Account with id " + accountId + " not found");
        }
    }

    public Account createAccount(Account account){
        return accountRepository.save(account);

    }

    public List<Account> getAllAccounts(){
        return new ArrayList<>(accountRepository.findAll());
    }

    public Optional<Account> getAccountById(Long accountId){
        return accountRepository.findById(accountId);
    }

    public void updateAccount(Account account, Long accountId){
        for (Account account1 : accountRepository.findAll()){
            if (account1.getUserId().equals(accountId)){
                accountRepository.save(account);
            }
        }
    }

    public void deleteAccountById(Long accountId){
        accountRepository.deleteById(accountId);
    }

}
