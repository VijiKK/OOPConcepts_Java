class Financial {
    // A static utility method performs a calculation that needs no object state.
    static double percentOf(double percentage, double amount) {
        return (percentage / 100.0) * amount;
    }
}

public class StaticMethodDemo {
    // main() is static because Java calls it before creating any program objects.
    public static void main(String[] args) {
        double purchaseTotal = 80.0;
        double taxRate = 9.25;

        // Call the method with its class name; no new Financial() object is needed.
        double tax = Financial.percentOf(taxRate, purchaseTotal);

        System.out.printf("Purchase: $%.2f%n", purchaseTotal);
        System.out.printf("Tax: $%.2f%n", tax);
    }
}

/* Expected output:
Purchase: $80.00
Tax: $7.40
*/
