/*
 * PRACTICE 1: Implement O(n), O(n^2), and O(log n) algorithms.
 *
 * Each method returns its main-operation count. Returning a count makes the
 * growth visible and avoids unreliable conclusions from very short timer tests.
 */
public class AlgorithmAnalysisPractice {

    static long linearAlgorithm(int n) {
        long operations = 0;

        for (int i = 0; i < n; i++) {
            operations++; // Executes n times, so the method is O(n).
        }

        return operations;
    }

    static long quadraticAlgorithm(int n) {
        long operations = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                operations++; // Executes n*n times, so the method is O(n^2).
            }
        }

        return operations;
    }

    static long logarithmicAlgorithm(int n) {
        long operations = 0;

        // Doubling value is equivalent to repeatedly halving the remaining ratio.
        for (int value = 1; value < n; value *= 2) {
            operations++; // Executes about log2(n) times.
        }

        return operations;
    }

    public static void main(String[] args) {
        int n = 16;

        System.out.println("O(n) operations: " + linearAlgorithm(n));
        System.out.println("O(n^2) operations: " + quadraticAlgorithm(n));
        System.out.println("O(log n) operations: " + logarithmicAlgorithm(n));
    }
}
