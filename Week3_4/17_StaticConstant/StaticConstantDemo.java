class BankAccount {
    // public allows other classes to use the constant.
    // static gives the class one copy; final prevents reassignment.
    public static final double OVERDRAFT_FEE = 29.95;
}

public class StaticConstantDemo {
    public static void main(String[] args) {
        // Access a static member with the class name, not an object variable.
        double feeForTwoOverdrafts = 2 * BankAccount.OVERDRAFT_FEE;

        System.out.printf("One overdraft fee: $%.2f%n", BankAccount.OVERDRAFT_FEE);
        System.out.printf("Two overdraft fees: $%.2f%n", feeForTwoOverdrafts);
    }
}

/* Expected output:
One overdraft fee: $29.95
Two overdraft fees: $59.90
*/
