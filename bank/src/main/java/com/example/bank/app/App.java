package com.example.bank.app;

import java.util.List;
import java.util.Scanner;

import com.example.bank.dao.AccountDAO;
import com.example.bank.entity.Account;

public class App {

	public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        AccountDAO dao = new AccountDAO();

        int choice;

        do {
            System.out.println("**** Bank System ****");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. View Account");
            System.out.println("5. View All Accounts");
            System.out.println("6. Delete Account");
            System.out.println("7. Exit");

            choice = sc.nextInt();

            switch (choice) {

                case 1: {
                    Account acc = new Account();

                    System.out.print("Enter Name: ");
                    sc.nextLine();
                    acc.setName(sc.nextLine());

                    System.out.print("Enter Account Type (Savings/Current): ");
                    acc.setAccountType(sc.nextLine());

                    System.out.print("Enter Initial Balance: ");
                    acc.setBalance(sc.nextDouble());

                    dao.saveAccount(acc);

                    System.out.println("Account Created Successfully!");
                    break;
                }

                case 2: {
                    System.out.print("Enter Account ID: ");
                    int id = sc.nextInt();

                    Account acc = dao.getAccount(id);

                    if (acc != null) {
                        System.out.print("Enter Amount to Deposit: ");
                        double amount = sc.nextDouble();

                        acc.setBalance(acc.getBalance() + amount);
                        dao.updateAccount(acc);

                        System.out.println("Deposit Successful!");
                    } else {
                        System.out.println("Account Not Found!");
                    }
                    break;
                }

                case 3: {
                    System.out.print("Enter Account ID: ");
                    int id = sc.nextInt();

                    Account acc = dao.getAccount(id);

                    if (acc != null) {
                        System.out.print("Enter Amount to Withdraw: ");
                        double amount = sc.nextDouble();

                        if (acc.getBalance() >= amount) {
                            acc.setBalance(acc.getBalance() - amount);
                            dao.updateAccount(acc);
                            System.out.println("Withdrawal Successful!");
                        } else {
                            System.out.println("Insufficient Balance!");
                        }
                    } else {
                        System.out.println("Account Not Found!");
                    }
                    break;
                }

                case 4: {
                    System.out.print("Enter Account ID: ");
                    int id = sc.nextInt();

                    Account acc = dao.getAccount(id);

                    if (acc != null) {
                        System.out.println("ID: " + acc.getId());
                        System.out.println("Name: " + acc.getName());
                        System.out.println("Type: " + acc.getAccountType());
                        System.out.println("Balance: " + acc.getBalance());
                    } else {
                        System.out.println("Account Not Found!");
                    }
                    break;
                }

                case 5: {
                    List<Account> list = dao.getAllAccounts();

                    for (Account acc : list) {
                        System.out.println(
                                acc.getId() + " " +
                                acc.getName() + " " +
                                acc.getAccountType() + " " +
                                acc.getBalance()
                        );
                    }
                    break;
                }

                case 6: {
                    System.out.print("Enter Account ID to Delete: ");
                    int id = sc.nextInt();

                    if (dao.getAccount(id) != null) {
                        dao.deleteAccount(id);
                        System.out.println("Account Deleted Successfully!");
                    } else {
                        System.out.println("Account Not Found!");
                    }
                    break;
                }

                case 7:
                    System.out.println("Thank you for using Bank System!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 7);

        sc.close();
    }
}
