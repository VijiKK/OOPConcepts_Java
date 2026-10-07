/*
 * CONCEPT: Common recursion errors are a missing base case or no progress.
 *
 * The unsafe examples are shown as comments so this program remains runnable.
 * The corrected method validates negative input, stops at zero, and subtracts
 * one on each call so every chain reaches the base case.
 */
public class CommonRecursionMistakesDemo {

    /*
     * Missing base case:
     * static void neverStops(int n) {
     *     neverStops(n - 1);
     * }
     *
     * No progress:
     * static void sameProblem(int n) {
     *     if (n == 0) return;
     *     sameProblem(n); // n never changes.
     * }
     */

    static int sumDownToZero(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n must be nonnegative");
        }

        if (n == 0) {
            return 0; // Reachable base case.
        }

        return n + sumDownToZero(n - 1); // n decreases, guaranteeing progress.
    }

    public static void main(String[] args) {
        System.out.println("5 + 4 + 3 + 2 + 1 = " + sumDownToZero(5));
        System.out.println("Base case present: yes");
        System.out.println("Each call moves toward it: yes");
    }
}
