// BankAccount contains account logic and does not decide how results are displayed.
class BankAccount {
    private double balance;

    BankAccount(double openingBalance) {
        balance = openingBalance;
    }

    // This accessor returns data rather than printing it.
    double getBalance() {
        return balance;
    }
}

public class DecouplingDemo {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(250.0);

        // The application chooses console output; BankAccount remains reusable.
        System.out.println("The balance is now $" + account.getBalance());
    }
}

/* Expected output:
The balance is now $250.0
*/
