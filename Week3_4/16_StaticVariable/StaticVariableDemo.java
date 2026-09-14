class BankAccount {
    // Each object receives its own copies of these instance variables.
    private int accountNumber;
    private String accountHolder;
    private double balance;

    // The class has one shared copy of this static variable.
    private static int lastAssignedNumber = 1000;

    BankAccount(String accountHolder) {
        this.accountHolder = accountHolder;

        // Every constructor call updates the same shared value.
        lastAssignedNumber++;
        accountNumber = lastAssignedNumber;
    }

    void displayInfo() {
        System.out.println(accountHolder + " has account " + accountNumber
                + " and balance $" + balance + ".");
    }

    void deposit(double amount) {
        // Only this account's balance changes; the static counter does not.
        balance = balance + amount;
    }

    static int getLastAssignedNumber() {
        return lastAssignedNumber;
    }
}

public class StaticVariableDemo {
    public static void main(String[] args) {
        BankAccount first = new BankAccount("Alice");
        BankAccount second = new BankAccount("Bob");
        BankAccount third = new BankAccount("Charlie");
        first.deposit(50.0);

        // Each account has its own balance and number, while both constructors
        // updated the one counter stored at the class level.
        first.displayInfo();
        second.displayInfo();
        third.displayInfo();
        System.out.println("Shared last assigned number: "
                + BankAccount.getLastAssignedNumber());
    }
}

/* Expected output:
Alice has account 1001 and balance $50.0.
Bob has account 1002 and balance $0.0.
Charlie has account 1003 and balance $0.0.
Shared last assigned number: 1003
*/
