class CashRegister {
    private double purchaseTotal;

    void recordPurchase(double amount) {
        purchaseTotal = purchaseTotal + amount;
    }

    double getPurchaseTotal() {
        return purchaseTotal;
    }
}

public class ManualUnitTestDemo {
    // This small helper compares an expected result with the actual result.
    static void checkEquals(String testName, double expected, double actual) {
        // A tolerance is useful because decimal calculations may have tiny rounding errors.
        double tolerance = 0.0001;

        if (Math.abs(expected - actual) < tolerance) {
            System.out.println("PASS: " + testName);
        } else {
            System.out.println("FAIL: " + testName);
            System.out.println("Expected " + expected + " but received " + actual);
        }
    }

    public static void main(String[] args) {
        CashRegister register = new CashRegister();
        register.recordPurchase(0.75);
        register.recordPurchase(1.50);

        // A test contains setup, an expected result, and the actual result.
        double expected = 2.25;
        double actual = register.getPurchaseTotal();
        checkEquals("two purchases", expected, actual);

        // JUnit automates this pattern in larger projects, but this demo needs no library.
        checkEquals("new register starts at zero", 0.0,
                new CashRegister().getPurchaseTotal());
    }
}

/* Expected output:
PASS: two purchases
PASS: new register starts at zero
*/
