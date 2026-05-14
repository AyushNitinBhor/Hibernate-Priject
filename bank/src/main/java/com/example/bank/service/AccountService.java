package com.example.bank.service;

import java.util.List;

import com.example.bank.dao.AccountDAO;
import com.example.bank.entity.Account;

public class AccountService {

    private AccountDAO dao = new AccountDAO();

    public void createAccount(String name, String type, double balance) {
        Account acc = new Account(name, type, balance);
        dao.saveAccount(acc);
    }

    public void deposit(int id, double amount) {
        Account acc = dao.getAccount(id);
        acc.setBalance(acc.getBalance() + amount);
        dao.updateAccount(acc);
    }

    public void withdraw(int id, double amount) {
        Account acc = dao.getAccount(id);
        if (acc.getBalance() >= amount) {
            acc.setBalance(acc.getBalance() - amount);
            dao.updateAccount(acc);
        } else {
            System.out.println("Insufficient Balance");
        }
    }

    public void showAllAccounts() {
        List<Account> list = dao.getAllAccounts();
        for (Account acc : list) {
            System.out.println(acc.getId() + " " + acc.getName() + " " + acc.getBalance());
        }
    }
}