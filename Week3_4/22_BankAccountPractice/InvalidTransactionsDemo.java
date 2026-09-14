import bank.BankAccount;
import bank.utils.BankUtils;

public class InvalidTransactionsDemo {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("Test Account");

        // The utility rejects an invalid amount before the application calls deposit().
        double invalidAmount = -5.0;
        if (!BankUtils.isAmountValid(invalidAmount)) {
            System.out.println("Utility rejected a negative amount.");
        }

        // BankAccount also protects its own balance if a caller forgets the utility.
        account.deposit(invalidAmount);

        // A positive amount can still be too large for the current balance.
        account.withdraw(10.0);
        System.out.printf("Balance after rejected operations: $%.2f%n",
                account.getBalance());
    }
}

/* Expected output:
Utility rejected a negative amount.
Deposit rejected: amount must be positive.
Withdrawal rejected: insufficient balance.
Balance after rejected operations: $0.00
*/
