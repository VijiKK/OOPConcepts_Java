/*
 * PRACTICE 2: Calculate x^n recursively.
 *
 * The direct recursive version reduces n by one per call and therefore uses
 * O(n) time and O(n) call-stack space. This example accepts nonnegative n.
 */
public class PowerCalculator {

    static double power(double x, int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Exponent must be nonnegative");
        }

        if (n == 0) {
            return 1.0; // Base case: every nonzero value to power zero equals one.
        }

        // Recursive case: solve the smaller exponent and multiply by one more x.
        return x * power(x, n - 1);
    }

    public static void main(String[] args) {
        double base = 2.0;
        int exponent = 10;

        System.out.println(base + "^" + exponent + " = " + power(base, exponent));
        System.out.println("Time complexity: O(n)");
        System.out.println("Call-stack space: O(n)");
    }
}
