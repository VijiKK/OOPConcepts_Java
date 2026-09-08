// This class belongs to the bank package because of its directory and declaration.
package bank;

public class BankAccount {
    // Each account object has its own holder and balance.
    private String accountHolder;
    private double balance;

    // All BankAccount objects share one totalAccounts variable.
    private static int totalAccounts;

    public BankAccount(String accountHolder) {
        this.accountHolder = accountHolder;
        balance = 0.0;
        totalAccounts++;
    }

    public void deposit(double amount) {
        balance = balance + amount;
    }

    public void withdraw(double amount) {
        // A withdrawal is accepted only when the account has enough money.
        if (amount <= balance) {
            balance = balance - amount;
        } else {
            System.out.println("Withdrawal rejected: insufficient balance.");
        }
    }

    public void displayInfo() {
        System.out.printf("Name: %s, Balance: $%.2f%n", accountHolder, balance);
    }

    public static int getTotalAccounts() {
        return totalAccounts;
    }
}
