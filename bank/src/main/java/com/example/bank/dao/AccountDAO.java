package com.example.bank.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.bank.entity.Account;
import com.example.bank.util.HibernateUtil;

public class AccountDAO {

public void saveAccount(Account account) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction tx = session.beginTransaction();
    session.save(account);
    tx.commit();
    session.close();
}

public Account getAccount(int id) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Account acc = session.get(Account.class, id);
    session.close();
    return acc;
}

public List<Account> getAllAccounts() {
    Session session = HibernateUtil.getSessionFactory().openSession();
    List<Account> list = session.createQuery("from Account", Account.class).list();
    session.close();
    return list;
}

public void updateAccount(Account account) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction tx = session.beginTransaction();
    session.update(account);
    tx.commit();
    session.close();
}

public void deleteAccount(int id) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction tx = session.beginTransaction();
    Account acc = session.get(Account.class, id);
    if (acc != null) {
        session.delete(acc);
    }
    tx.commit();
    session.close();
}
}