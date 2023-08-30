package com.nagarro.rl.week6.p2;

import com.nagarro.rl.week6.p1.Account;

public class BankSimulation {
    public static void main(String[] args) {
        Account account = new Account("George", 1L, 100);

        account.withdraw(10, 0.2f);

        System.out.println("Your balance: " + account.getBalance());

        account.withdraw(10, 0.2f);

        System.out.println("Your balance: " + account.getBalance());
    }
}
