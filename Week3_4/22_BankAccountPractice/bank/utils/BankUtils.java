package bank.utils;

// BankUtils groups utility behavior that does not depend on one account object.
public class BankUtils {
    // A static method can be called with the class name.
    public static boolean isAmountValid(double amount) {
        return amount > 0;
    }
}
