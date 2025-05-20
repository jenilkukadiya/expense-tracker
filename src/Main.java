package com.expensetracker;

import com.expensetracker.model.Transaction;
import com.expensetracker.service.ExpenseManager;
import com.expensetracker.util.FileHandler;

import java.time.LocalDate;
import java.time.Month;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ExpenseManager manager = new ExpenseManager();

        // Load transactions from file
        FileHandler.loadFromFile(manager.getTransactions(), "data/transactions.txt");

        boolean running = true;

        while (running) {
            System.out.println("\n--- Expense Tracker ---");
            System.out.println("1. Add Transaction");
            System.out.println("2. Show Monthly Summary");
            System.out.println("3. Save and Exit");
            System.out.print("Choose option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Type (income/expense): ");
                    String type = scanner.nextLine();

                    System.out.print("Enter category: ");
                    String category = scanner.nextLine();

                    System.out.print("Enter amount: ");
                    double amount = scanner.nextDouble();

                    System.out.print("Enter date (YYYY-MM-DD): ");
                    String dateStr = scanner.next();
                    LocalDate date = LocalDate.parse(dateStr);

                    manager.addTransaction(new Transaction(type, category, amount, date));
                    break;

                case 2:
                    try {
                        System.out.print("Enter year (e.g., 2025): ");
                        int year = Integer.parseInt(scanner.next());

                        System.out.print("Enter month (1-12): ");
                        int monthNum = Integer.parseInt(scanner.next());

                        if (monthNum < 1 || monthNum > 12) {
                            System.out.println("Invalid month number. Please enter between 1 and 12.");
                        } else {
                            manager.printMonthlySummary(year, Month.of(monthNum));
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter numeric values for year and month.");
                    }
                    break;

                case 3:
                    FileHandler.saveToFile(manager.getTransactions(), "data/transactions.txt");
                    System.out.println("Saved. Exiting...");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }
        scanner.close();
    }
}
