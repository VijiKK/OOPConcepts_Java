// This BankAccount uses an exception to reject invalid input.
class BankAccount {
    // Only BankAccount methods can access this private state directly.
    private double balance;

    // deposit() either completes normally or throws an exception.
    void deposit(double amount) {
        if (amount < 0) {
            // throw deliberately creates an exceptional path for invalid data.
            throw new IllegalArgumentException("Deposit cannot be negative");
        }
        // These statements are skipped when the exception is thrown.
        balance = balance + amount;
        System.out.println("Deposited: $" + amount);
    }

    double getBalance() {
        // Return the balance without allowing callers to modify it directly.
        return balance;
    }
}

public class ThrowDemo {
    // main() acts as the caller that handles the possible exception.
    public static void main(String[] args) {
        // The balance begins at 0.0.
        BankAccount account = new BankAccount();
        // Positive input follows the normal path.
        account.deposit(50.0);

        // Place the risky call in a try block.
        try {
            account.deposit(-10.0);
        } catch (IllegalArgumentException exception) {
            // getMessage() retrieves the explanation supplied when it was thrown.
            System.out.println("Caught: " + exception.getMessage());
        }

        // The rejected deposit did not change the balance, and the program continues.
        System.out.println("Balance: $" + account.getBalance());
    }
}

/* Expected output:
Deposited: $50.0
Caught: Deposit cannot be negative
Balance: $50.0
*/
