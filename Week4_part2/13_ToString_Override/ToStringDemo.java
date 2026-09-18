/*
 * CONCEPT: Override toString() to provide meaningful object text.
 *
 * Object's default toString() identifies the class and object hash, but it
 * does not explain the object's important data. BankAccount replaces it with
 * a useful description that is also used automatically in concatenation.
 */

class PlainBankAccount {
    private double balance;

    public PlainBankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }
}

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    @Override
    public String toString() {
        return "BankAccount[balance=" + balance + "]";
    }
}

public class ToStringDemo {

    public static void main(String[] args) {
        PlainBankAccount plain = new PlainBankAccount(5000);
        BankAccount useful = new BankAccount(5000);

        // Avoid printing the unpredictable hash characters; test the pattern.
        System.out.println("Default text starts with PlainBankAccount@: "
                + plain.toString().startsWith("PlainBankAccount@"));

        // Concatenation automatically calls useful.toString().
        System.out.println("Customized text: " + useful);
    }
}

/*
Expected output:
Default text starts with PlainBankAccount@: true
Customized text: BankAccount[balance=5000.0]
*/
