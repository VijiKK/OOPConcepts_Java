class PurchaseTracker {
    // This instance field remembers the running total between method calls.
    private double purchaseTotal;

    // Add one purchase amount to the current total.
    void recordPurchase(double amount) {
        purchaseTotal = purchaseTotal + amount;
    }

    // An accessor reports the total without changing it.
    double getAmountDue() {
        return purchaseTotal;
    }

    // Reset the same object so it can begin a new transaction.
    void clear() {
        purchaseTotal = 0.0;
    }
}

public class KeepingTotalDemo {
    public static void main(String[] args) {
        PurchaseTracker tracker = new PurchaseTracker();

        tracker.recordPurchase(2.50);
        tracker.recordPurchase(1.25);
        System.out.println("Amount due: $" + tracker.getAmountDue());

        tracker.clear();
        System.out.println("After clear: $" + tracker.getAmountDue());
    }
}

/* Expected output:
Amount due: $3.75
After clear: $0.0
*/
