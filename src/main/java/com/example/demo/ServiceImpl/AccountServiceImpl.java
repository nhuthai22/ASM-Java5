package com.example.demo.ServiceImpl;

import com.example.demo.Entity.Account;
import com.example.demo.Repository.AccountRepo;
import com.example.demo.Service.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    private final AccountRepo repo;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public AccountServiceImpl(AccountRepo repo, BCryptPasswordEncoder passwordEncoder) {
        this.repo = repo;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<Account> findAccountAll() {
        return repo.findAll();
    }

    @Override
    public Account findAccountByUsername(String username) {
        return repo.findByUsername(username);
    }

    @Override
    public Account saveAccount(Account account) {
        return repo.save(account);
    }

    @Override
    public Account register(Account account) {
        Account existingAccount = repo.findByUsername(account.getUsername());
        if (existingAccount != null) {
            return null;
        }
        String encodedPassword = passwordEncoder.encode(account.getPassword());
        account.setPassword(encodedPassword);
        return repo.save(account);
    }

    @Override
    public boolean authenticate(String username, String password) {
        Account account = repo.findByUsername(username);
        if (account != null) {
            return passwordEncoder.matches(password, account.getPassword());
        }
        return false;
    }
}
