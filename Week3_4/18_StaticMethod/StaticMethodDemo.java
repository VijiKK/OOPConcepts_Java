class Financial {
    // A static utility method performs a calculation that needs no object state.
    static double percentOf(double percentage, double amount) {
        return (percentage / 100.0) * amount;
    }
}

class Account {
    private double balance;

    Account(double balance) {
        this.balance = balance;
    }

    // An instance method reads state stored in one particular Account object.
    double getBalance() {
        return balance;
    }
}

public class StaticMethodDemo {
    // main() is static because Java calls it before creating any program objects.
    public static void main(String[] args) {
        double purchaseTotal = 100.0;
        double taxRate = 9.25;

        // Call the method with its class name; no new Financial() object is needed.
        double tax = Financial.percentOf(taxRate, purchaseTotal);

        // An instance method needs an object because it reads that object's balance.
        Account account = new Account(250.0);
        double balance = account.getBalance();

        System.out.printf("Purchase: $%.2f%n", purchaseTotal);
        System.out.printf("Tax: $%.2f%n", tax);
        System.out.printf("Account balance: $%.2f%n", balance);
    }
}

/* Expected output:
Purchase: $100.00
Tax: $9.25
Account balance: $250.00
*/
