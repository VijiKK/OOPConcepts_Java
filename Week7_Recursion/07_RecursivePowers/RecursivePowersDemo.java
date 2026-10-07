/*
 * CONCEPT: Reducing by one gives O(n); halving gives O(log n).
 *
 * The repeated-squaring method computes the smaller recursive answer once,
 * stores it in halfPower, and uses that value twice. Calling the method twice
 * would create unnecessary duplicated recursion.
 */
public class RecursivePowersDemo {

    static long simplePower(long base, int exponent) {
        if (exponent == 0) {
            return 1;
        }

        return base * simplePower(base, exponent - 1); // Reduce exponent by one.
    }

    static long fastPower(long base, int exponent) {
        if (exponent == 0) {
            return 1;
        }

        long halfPower = fastPower(base, exponent / 2); // Make one halving call.
        long squared = halfPower * halfPower;           // Reuse its result twice.

        if (exponent % 2 == 0) {
            return squared; // x^n = (x^(n/2))^2 when n is even.
        }

        return base * squared; // One extra base handles an odd exponent.
    }

    public static void main(String[] args) {
        long base = 2;
        int exponent = 10;

        System.out.println("Simple power: " + simplePower(base, exponent));
        System.out.println("Fast power:   " + fastPower(base, exponent));
        System.out.println("Simple O(n); repeated squaring O(log n).");
    }
}
