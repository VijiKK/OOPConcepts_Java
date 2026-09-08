import java.util.ArrayList;

class BalanceCalculator {
    // This method reads the list but does not add, remove, or replace its elements.
    static double getTotalBalance(ArrayList<Double> balances) {
        double total = 0.0;

        // The enhanced for loop visits each value without modifying the collection.
        for (double balance : balances) {
            total = total + balance;
        }

        return total;
    }
}

public class SideEffectsDemo {
    public static void main(String[] args) {
        ArrayList<Double> balances = new ArrayList<Double>();
        balances.add(100.0);
        balances.add(250.0);

        int sizeBefore = balances.size();
        double total = BalanceCalculator.getTotalBalance(balances);

        System.out.println("Total: $" + total);
        System.out.println("List size before: " + sizeBefore);
        System.out.println("List size after: " + balances.size());
    }
}

/* Expected output:
Total: $350.0
List size before: 2
List size after: 2
*/
