# 💸 Java Expense Tracker

A simple console-based Java application to track income and expenses, view monthly/yearly summaries, and save/load data from a file.

## ✅ Features

- Add income or expense
- Categorize transactions (e.g. Salary, Rent, Food)
- View monthly summary (by month & year)
- Save/load transactions from `data/transactions.txt`

## 📂 Project Structure
expense-tracker/
├── data/ # Contains transactions.txt
├── src/
│ └── com.expensetracker/
│ ├── model/ # Transaction.java
│ ├── service/ # ExpenseManager.java
│ ├── util/ # FileHandler.java
│ └── Main.java # Program entry point


## ▶️ Run Instructions

1. Open in IntelliJ or any Java IDE
2. Ensure `data/transactions.txt` exists
3. Run `Main.java`

## 📝 Sample Input File
income,Salary,5000,2025-05-01
expense,Rent,1500,2025-05-02

## 💻 Requirements
- Java 8 or higher
