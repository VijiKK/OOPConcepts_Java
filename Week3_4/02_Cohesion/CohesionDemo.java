// Coin has one responsibility: describe a type of coin.
class Coin {
    private String name;
    private double value;

    Coin(String name, double value) {
        this.name = name;
        this.value = value;
    }

    double getValue() {
        return value;
    }

    String getName() {
        return name;
    }
}

// CashRegister has one responsibility: keep track of payments.
class CashRegister {
    private double payment;

    // The register asks Coin for its value instead of storing every coin value itself.
    void receivePayment(int coinCount, Coin coinType) {
        payment = payment + coinCount * coinType.getValue();
        System.out.println("Received " + coinCount + " " + coinType.getName() + " coin(s).");
    }

    double getPayment() {
        return payment;
    }
}

public class CohesionDemo {
    public static void main(String[] args) {
        Coin quarter = new Coin("quarter", 0.25);
        CashRegister register = new CashRegister();

        register.receivePayment(4, quarter);
        System.out.println("Payment total: $" + register.getPayment());
    }
}

/* Expected output:
Received 4 quarter coin(s).
Payment total: $1.0
*/
