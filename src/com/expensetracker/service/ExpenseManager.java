package com.expensetracker.service;

import com.expensetracker.model.Transaction;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ExpenseManager {
    private List<Transaction> transactions;

    public ExpenseManager() {
        this.transactions = new ArrayList<>();
    }

    public void addTransaction(Transaction t) {
        transactions.add(t);
    }

    public void printMonthlySummary(int year, Month month) {
        System.out.println("\n--- Summary for " + month + " " + year + " ---");

        double income = 0;
        double expense = 0;

        for (Transaction t : transactions) {
            if (t.getDate().getYear() == year && t.getDate().getMonth() == month) {
                if (t.getType().equalsIgnoreCase("income")) {
                    income += t.getAmount();
                } else {
                    expense += t.getAmount();
                }
                System.out.println(t.getType() + " | " + t.getCategory() + " | " + t.getAmount() + " | " + t.getDate());
            }
        }

        System.out.println("Total Income: " + income);
        System.out.println("Total Expense: " + expense);
        System.out.println("Balance: " + (income - expense));
    }


    public List<Transaction> getTransactions() {
        return transactions;
    }
}
