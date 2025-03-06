import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Account {
    private String accountNumber;
    private String accountHolderName;
    private double balance;
    private String pin;

    public Account(String accountNumber, String accountHolderName, String pin) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = 0.0;
        this.pin = pin;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public boolean validatePin(String inputPin) {
        return pin.equals(inputPin);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("$" + amount + " deposited successfully.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("$" + amount + " withdrawn successfully.");
        } else {
            System.out.println("Insufficient funds or invalid amount.");
        }
    }

    public void transfer(Account recipient, double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            recipient.balance += amount;
            System.out.println("$" + amount + " transferred successfully to account " + recipient.getAccountNumber());
        } else {
            System.out.println("Transfer failed. Insufficient funds or invalid amount.");
        }
    }
}

class Bank {
    private Map<String, Account> accounts;

    public Bank() {
        accounts = new HashMap<>();
    }

    public void createAccount(String accountNumber, String accountHolderName, String pin) {
        if (!accounts.containsKey(accountNumber)) {
            Account account = new Account(accountNumber, accountHolderName, pin);
            accounts.put(accountNumber, account);
            System.out.println("Account created successfully for " + accountHolderName);
        } else {
            System.out.println("Account number already exists.");
        }
    }

    public Account login(String accountNumber, String pin) {
        Account account = accounts.get(accountNumber);
        if (account != null && account.validatePin(pin)) {
            return account;
        }
        return null;
    }
}

public class BankingApp {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nWelcome to the Banking App");
            System.out.println("1. Create Account");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter account number: ");
                    String accountNumber = scanner.nextLine();
                    System.out.print("Enter account holder name: ");
                    String accountHolderName = scanner.nextLine();
                    System.out.print("Set PIN: ");
                    String pin = scanner.nextLine();
                    bank.createAccount(accountNumber, accountHolderName, pin);
                    break;

                case "2":
                    System.out.print("Enter account number: ");
                    String loginAccountNumber = scanner.nextLine();
                    System.out.print("Enter PIN: ");
                    String loginPin = scanner.nextLine();
                    Account account = bank.login(loginAccountNumber, loginPin);

                    if (account != null) {
                        boolean loggedIn = true;
                        while (loggedIn) {
                            System.out.println("\nWelcome, " + account.getAccountHolderName());
                            System.out.println("1. Check Balance");
                            System.out.println("2. Deposit");
                            System.out.println("3. Withdraw");
                            System.out.println("4. Transfer Funds");
                            System.out.println("5. Logout");
                            System.out.print("Choose an option: ");
                            String userChoice = scanner.nextLine();

                            switch (userChoice) {
                                case "1":
                                    System.out.println("Your balance is $" + account.getBalance());
                                    break;
                                case "2":
                                    System.out.print("Enter amount to deposit: ");
                                    double depositAmount = Double.parseDouble(scanner.nextLine());
                                    account.deposit(depositAmount);
                                    break;
                                case "3":
                                    System.out.print("Enter amount to withdraw: ");
                                    double withdrawAmount = Double.parseDouble(scanner.nextLine());
                                    account.withdraw(withdrawAmount);
                                    break;
                                case "4":
                                    System.out.print("Enter recipient's account number: ");
                                    String recipientAccountNumber = scanner.nextLine();
                                    Account recipient = bank.login(recipientAccountNumber, ""); // No PIN check for
                                                                                                // recipient
                                    if (recipient != null) {
                                        System.out.print("Enter amount to transfer: ");
                                        double transferAmount = Double.parseDouble(scanner.nextLine());
                                        account.transfer(recipient, transferAmount);
                                    } else {
                                        System.out.println("Recipient account not found.");
                                    }
                                    break;
                                case "5":
                                    System.out.println("Logging out...");
                                    loggedIn = false;
                                    break;
                                default:
                                    System.out.println("Invalid choice. Please try again.");
                                    break;
                            }
                        }
                    } else {
                        System.out.println("Invalid account number or PIN.");
                    }
                    break;

                case "3":
                    System.out.println("Thank you for using the Banking App. Goodbye!");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

        scanner.close();
    }
}