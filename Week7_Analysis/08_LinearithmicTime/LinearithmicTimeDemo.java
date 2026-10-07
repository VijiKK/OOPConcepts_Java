/*
 * COMPLEXITY LEVEL: O(n log n) - linearithmic time.
 *
 * The outer loop performs n iterations. During each iteration, the inner value
 * doubles until it passes n, which takes about log2(n) iterations. Multiplying
 * the loop counts gives n * log n.
 */
public class LinearithmicTimeDemo {

    static long performWork(int n) {
        long operations = 0; // Count the body executions instead of timing them.

        for (int i = 0; i < n; i++) { // This loop repeats n times.
            for (int size = 1; size < n; size *= 2) {
                operations++; // This executes about log2(n) times per outer pass.
            }
        }

        return operations;
    }

    public static void main(String[] args) {
        for (int n : new int[]{8, 16, 32}) {
            System.out.println("n=" + n + ", body executions=" + performWork(n));
        }

        System.out.println("The measured count follows n log2(n): O(n log n).");
    }
}
