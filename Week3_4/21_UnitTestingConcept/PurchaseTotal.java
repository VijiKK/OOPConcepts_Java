// Production code: this class records the total of several purchases.
class PurchaseTotal {
    private double total;

    void recordPurchase(double amount) {
        total = total + amount;
    }

    double getTotal() {
        return total;
    }
}
