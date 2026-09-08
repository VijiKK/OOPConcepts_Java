class BankAccount {
    // Each object receives its own copies of these instance variables.
    private int accountNumber;
    private String accountHolder;

    // The class has one shared copy of this static variable.
    private static int lastAssignedNumber = 1000;

    BankAccount(String accountHolder) {
        this.accountHolder = accountHolder;

        // Every constructor call updates the same shared value.
        lastAssignedNumber++;
        accountNumber = lastAssignedNumber;
    }

    void displayInfo() {
        System.out.println(accountHolder + " has account " + accountNumber + ".");
    }
}

public class StaticVariableDemo {
    public static void main(String[] args) {
        BankAccount first = new BankAccount("Alice");
        BankAccount second = new BankAccount("Bob");

        // Different objects receive different numbers from one shared counter.
        first.displayInfo();
        second.displayInfo();
    }
}

/* Expected output:
Alice has account 1001.
Bob has account 1002.
*/
