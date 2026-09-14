// A companion test class checks PurchaseTotal without manual output inspection.
public class PurchaseTotalTest {
    static void assertClose(String testName, double expected, double actual) {
        // Decimal calculations can differ by a tiny rounding amount.
        double tolerance = 0.0001;
        if (Math.abs(expected - actual) < tolerance) {
            System.out.println("PASS: " + testName);
        } else {
            throw new AssertionError(testName + ": expected " + expected
                    + ", actual " + actual);
        }
    }

    public static void main(String[] args) {
        // Arrange: create the object and input values for this test.
        PurchaseTotal purchases = new PurchaseTotal();

        // Act: call the behavior being tested.
        purchases.recordPurchase(0.75);
        purchases.recordPurchase(1.50);

        // Assert: compare the expected result with the actual result.
        assertClose("two purchases", 2.25, purchases.getTotal());

        // A second test checks the unchanged starting state of a fresh object.
        assertClose("new total starts at zero", 0.0,
                new PurchaseTotal().getTotal());
    }
}

/* Expected output:
PASS: two purchases
PASS: new total starts at zero
*/
