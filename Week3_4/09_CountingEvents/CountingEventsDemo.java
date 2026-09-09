class PurchaseCounter {
    // This field stores how many purchase events have occurred.
    private int itemCount;

    // Each call represents one purchase, regardless of its dollar amount.
    void recordPurchase() {
        itemCount++;
    }

    // This accessor reports how many events have been recorded.
    int getItemCount() {
        return itemCount;
    }

    // Reset the counter when a new transaction begins.
    void clear() {
        itemCount = 0;
    }
}

public class CountingEventsDemo {
    public static void main(String[] args) {
        PurchaseCounter counter = new PurchaseCounter();

        // Three method calls represent three separate purchase events.
        counter.recordPurchase();
        counter.recordPurchase();
        counter.recordPurchase();
        System.out.println("Number of purchases: " + counter.getItemCount());

        counter.clear();
        System.out.println("After clear: " + counter.getItemCount());
    }
}

/* Expected output:
Number of purchases: 3
After clear: 0
*/
