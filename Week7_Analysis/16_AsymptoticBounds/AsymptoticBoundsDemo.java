/*
 * CONCEPT: Big-O, Big-Omega, and Big-Theta.
 *
 * O(g(n)) gives an asymptotic upper bound. Omega(g(n)) gives a lower bound.
 * Theta(g(n)) gives a tight bound because both bounds have the same growth rate.
 * The example f(n)=5n^2+3n+2 is Theta(n^2).
 */
public class AsymptoticBoundsDemo {

    static long f(long n) {
        return 5 * n * n + 3 * n + 2;
    }

    static long lowerBound(long n) {
        return 5 * n * n; // f(n) is always at least this value for positive n.
    }

    static long upperBound(long n) {
        return 10 * n * n; // For n >= 1, this simple bound stays above f(n).
    }

    public static void main(String[] args) {
        for (long n : new long[]{1, 10, 100}) {
            long value = f(n);
            boolean aboveLower = value >= lowerBound(n);
            boolean belowUpper = value <= upperBound(n);

            System.out.println("n=" + n + ", 5n^2 <= f(n) <= 10n^2: "
                    + (aboveLower && belowUpper));
        }

        System.out.println("f(n) is Omega(n^2) and O(n^2), so f(n) is Theta(n^2).");
    }
}
