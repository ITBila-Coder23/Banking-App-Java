# Banking-App-Java

Description

The Banking App is a simple console-based application that simulates basic banking operations. Users can create accounts, log in, check balances, deposit and withdraw money, and transfer funds between accounts. It supports basic PIN authentication for security.

Features

Account Creation: Allows users to create a new account with a unique account number, holder name, and PIN.

Login: Users can log in to their account using their account number and PIN.

Check Balance: Users can view their account balance.

Deposit Funds: Users can deposit money into their account.

Withdraw Funds: Users can withdraw money from their account (if sufficient balance exists).

Transfer Funds: Users can transfer funds to another account.

Logout: Users can log out of their account.


Requirements

Java 8+ (The app is developed in Java, and requires a Java environment to run.)


Installation

1. Clone this repository or download the source code.


2. Compile the BankingApp.java file using any Java IDE or the terminal.



javac BankingApp.java

3. Run the application.



java BankingApp

Usage

1. Create an account: You can create an account by selecting option 1 and entering your account details (account number, account holder name, and PIN).


2. Login: After account creation, select option 2 to log in by entering your account number and PIN.


3. Banking operations: Once logged in, you can perform various operations, such as checking balance, depositing, withdrawing, and transferring funds.



Example

Welcome to the Banking App
1. Create Account
2. Login
3. Exit
Choose an option: 1
Enter account number: 123456
Enter account holder name: John Doe
Set PIN: 1234
Account created successfully for John Doe

Welcome to the Banking App
1. Create Account
2. Login
3. Exit
Choose an option: 2
Enter account number: 123456
Enter PIN: 1234
Welcome, John Doe
1. Check Balance
2. Deposit
3. Withdraw
4. Transfer Funds
5. Logout
Choose an option: 1
Your balance is $0.0

Error Handling

If an account number already exists, the app will display an error message.

Invalid PIN or account number during login will result in a login failure message.

Insufficient funds or invalid amounts during deposit, withdrawal, or transfer will show appropriate error messages.

License

MIT License. See LICENSE file for details

