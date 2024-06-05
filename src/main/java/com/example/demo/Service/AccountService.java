package com.example.demo.Service;

import java.util.List;

import com.example.demo.Entity.Account;

public interface AccountService {
    List<Account> findAccountAll();

    Account saveAccount(Account account);
    Account register(Account account);
    boolean authenticate(String username, String password);
    Account findAccountByUsername(String username); // Thêm phương thức này
}
