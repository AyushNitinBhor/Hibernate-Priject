package com.example.bank.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String accountType;
    private double balance;

    public Account() {}

    public Account(String name, String accountType, double balance) {
        this.name = name;
        this.accountType = accountType;
        this.balance = balance;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getAccountType() { return accountType; }
    public double getBalance() { return balance; }

    public void setName(String name) { this.name = name; }
    public void setAccountType(String accountType) { this.accountType = accountType; }
    public void setBalance(double balance) { this.balance = balance; }
}