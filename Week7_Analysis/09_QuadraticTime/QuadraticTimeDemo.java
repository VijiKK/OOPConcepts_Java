/*
 * COMPLEXITY LEVEL: O(n^2) - quadratic time.
 *
 * Two loops each run n times. The inner statement therefore executes n*n times.
 * If n doubles, the operation count becomes about four times larger.
 */
public class QuadraticTimeDemo {

    static long compareEveryOrderedPair(int n) {
        long comparisons = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                comparisons++; // Count work for the ordered pair (i, j).
            }
        }

        return comparisons;
    }

    public static void main(String[] args) {
        for (int n : new int[]{5, 10, 20}) {
            System.out.println("n=" + n + ", pair comparisons=" + compareEveryOrderedPair(n));
        }

        System.out.println("Doubling n multiplies the work by four: O(n^2).");
    }
}
