# 🏦 Bank Management System (Java Swing)

A desktop-based ATM and Banking management application developed using **Java Swing** and **AWT** for the graphical user interface, integrated with **MySQL** via **JDBC** for secure data persistence.

---

## 🚀 Features

* **Multi-Step Onboarding (`SignUp.java`, `SignUp2.java`, `Signup3.java`):** Complete user registration process collecting personal information, account types, and card/ATM preferences.
* **Authentication (`LoginPage.java`, `Connect.java`):** Card number and PIN verification with direct JDBC database connectivity.
* **Core Banking & ATM Operations:**
  * **Deposit (`Deposit.java`):** Credit funds instantly into accounts.
  * **Withdrawal (`Withdrawl.java`):** Cash withdrawal with real-time balance checks.
  * **Fast Cash (`FastCash.java`):** One-click quick withdrawal options for predefined amounts.
  * **PIN Change (`PinChange.java`):** Secure PIN update system.
* **Account Inquiry & Statements:**
  * **Balance Enquiry (`BalanceEnquiry.java`):** Instant account balance checking.
  * **Mini Statement (`MiniStatement.java`):** Tabular/textual log of recent account transactions.
* **Interactive Support (`ChatBotPanel.java`):** Built-in chatbot interface to assist users with navigation and banking queries.
* **Main Dashboard (`Transactions.java`):** Centralized ATM action menu managing user navigation across all features.

---

## 🛠️ Tech Stack

* **Language:** Java
* **GUI Framework:** Java Swing / AWT
* **Database:** MySQL
* **Connectivity:** JDBC (Java Database Connectivity)

---

## 📂 Project Structure

```text
Bank-Management-System/
└── src/
    └── com/
        └── bankmanagement/
            └── www/
                ├── BalanceEnquiry.java
                ├── ChatBotPanel.java
                ├── Connect.java
                ├── Deposit.java
                ├── FastCash.java
                ├── LoginPage.java
                ├── MiniStatement.java
                ├── PinChange.java
                ├── SignUp.java
                ├── SignUp2.java
                ├── Signup3.java
                ├── Transactions.java
                └── Withdrawl.java
