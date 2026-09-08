// Import the two public classes from their different packages.
import bank.BankAccount;
import bank.utils.BankUtils;

public class BankAccountPractice {
    public static void main(String[] args) {
        // Each constructor call increments BankAccount's shared counter.
        BankAccount alice = new BankAccount("Alice");
        BankAccount bob = new BankAccount("Bob");
        BankAccount charlie = new BankAccount("Charlie");

        double depositAmount = 300.0;
        if (BankUtils.isAmountValid(depositAmount)) {
            alice.deposit(depositAmount);
            System.out.println("Deposit successful.");
        }

        double withdrawalAmount = 50.0;
        if (BankUtils.isAmountValid(withdrawalAmount)) {
            alice.withdraw(withdrawalAmount);
            System.out.println("Withdrawal successful.");
        }

        // Bob's valid deposit uses the same utility check.
        if (BankUtils.isAmountValid(300.0)) {
            bob.deposit(300.0);
        }

        alice.displayInfo();
        bob.displayInfo();
        charlie.displayInfo();

        // Call the static method with the class name because the count is shared.
        System.out.println("Total accounts created: " + BankAccount.getTotalAccounts());
    }
}

/* Expected output:
Deposit successful.
Withdrawal successful.
Name: Alice, Balance: $250.00
Name: Bob, Balance: $300.00
Name: Charlie, Balance: $0.00
Total accounts created: 3
*/
