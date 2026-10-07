/*
 * CONCEPT: Compare common growth rates numerically.
 *
 * These numbers represent approximate operation counts, not elapsed time.
 * The table shows why a better growth rate matters increasingly as n grows.
 */
public class GrowthRateComparisonDemo {

    static long powerOfTwoCapped(int n) {
        // A long cannot hold 2^n for large n, so report Long.MAX_VALUE after overflow risk.
        return n >= 63 ? Long.MAX_VALUE : 1L << n;
    }

    static void printRow(int n) {
        long log = (long) Math.ceil(Math.log(n) / Math.log(2));
        long nLogN = n * log;
        long quadratic = (long) n * n;
        long cubic = quadratic * n;
        long exponential = powerOfTwoCapped(n);

        System.out.printf("%3d %5d %7d %8d %10d %12d %15s%n",
                n, 1, log, n, nLogN, quadratic,
                exponential == Long.MAX_VALUE ? "too large" : exponential);
        System.out.println("    O(n^3) for this n = " + cubic);
    }

    public static void main(String[] args) {
        System.out.println("  n  O(1) O(log n)   O(n) O(n log n)     O(n^2)          O(2^n)");
        printRow(8);
        printRow(16);
        printRow(32);

        System.out.println("Growth order:");
        System.out.println("O(1) < O(log n) < O(n) < O(n log n) < O(n^2) < O(n^3) < O(2^n)");
    }
}
