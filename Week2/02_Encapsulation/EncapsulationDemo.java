// BankAccount protects its data and provides controlled operations on that data.
class BankAccount {
    // private prevents code outside BankAccount from changing balance directly.
    private double balance;

    // A getter provides read-only access to the current balance.
    public double getBalance() {
        // Returning the value lets callers read it without changing it directly.
        return balance;
    }

    // This method controls how balance may be changed.
    public void deposit(double amount) {
        // Validate the request before modifying the private field.
        if (amount > 0) {
            // This assignment is allowed because it occurs inside BankAccount.
            balance = balance + amount;
            System.out.println("Deposited: $" + amount);
        } else {
            // No exception is used yet; this lesson reports invalid input simply.
            System.out.println("Deposit must be positive.");
        }
    }
}

public class EncapsulationDemo {
    // main() demonstrates using the public interface of BankAccount.
    public static void main(String[] args) {
        // balance begins at Java's default value for double, which is 0.0.
        BankAccount account = new BankAccount();
        // account.balance is unavailable here because balance is private.
        // This valid deposit changes the balance.
        account.deposit(100.0);
        // This invalid deposit is rejected, so the balance remains unchanged.
        account.deposit(-20.0);
        // getBalance() is the controlled way to read the private field.
        System.out.println("Balance: $" + account.getBalance());
    }
}

/* Expected output:
Deposited: $100.0
Deposit must be positive.
Balance: $100.0
*/
