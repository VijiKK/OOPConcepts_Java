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

        // The same field remembers and accumulates each purchase amount.
        tracker.recordPurchase(10.00);
        System.out.println("After $10.00 purchase: $" + tracker.getAmountDue());

        tracker.recordPurchase(5.50);
        System.out.println("After $5.50 purchase: $" + tracker.getAmountDue());

        tracker.recordPurchase(2.00);
        System.out.println("After $2.00 purchase: $" + tracker.getAmountDue());

        // clear() demonstrates that a method can reset the stored total.
        tracker.clear();
        System.out.println("After clear: $" + tracker.getAmountDue());
    }
}

/* Expected output:
After $10.00 purchase: $10.0
After $5.50 purchase: $15.5
After $2.00 purchase: $17.5
After clear: $0.0
*/
