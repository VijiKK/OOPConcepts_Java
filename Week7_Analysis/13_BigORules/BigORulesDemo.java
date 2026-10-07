/*
 * CONCEPT: Find Big-O by keeping the dominant term.
 *
 * Constant factors and lower-order terms matter for exact work, but they do not
 * change the asymptotic growth class. Big-O describes an upper growth bound.
 */
public class BigORulesDemo {

    static long linearFunction(long n) {
        return 7 * n - 2; // The n term dominates, so this is O(n).
    }

    static long cubicFunction(long n) {
        return 3 * n * n * n + 20 * n * n + 5; // n^3 dominates: O(n^3).
    }

    static double logarithmicFunction(long n) {
        return 3 * (Math.log(n) / Math.log(2)) + 5; // log n dominates: O(log n).
    }

    public static void main(String[] args) {
        long n = 100;

        System.out.println("7n - 2 at n=100: " + linearFunction(n) + " -> O(n)");
        System.out.println("3n^3 + 20n^2 + 5 at n=100: " + cubicFunction(n) + " -> O(n^3)");
        System.out.println("3log2(n) + 5 at n=100: " + logarithmicFunction(n) + " -> O(log n)");
        System.out.println("Rule: drop constants and lower-order terms after identifying growth.");
    }
}
