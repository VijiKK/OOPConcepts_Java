/*
 * CONCEPT: Count primitive operations under a simplified RAM model.
 *
 * We assume assignments, comparisons, arithmetic, array access, method calls,
 * and returns each take constant time. Exact counting conventions can differ,
 * but both exact formulas below have linear dominant growth.
 */
public class PrimitiveOperationsDemo {

    static long simplifiedOperationCount(int n) {
        long operations = 1; // Count the assignment used to initialize a total.

        operations += 1; // Count the loop-variable initialization.
        operations += n + 1; // Count n successful tests and one final failed test.
        operations += n; // Count n loop increments.
        operations += 3L * n; // Approximate array access, addition, and assignment.
        operations += 1; // Count the return operation.

        return operations;
    }

    public static void main(String[] args) {
        for (int n : new int[]{5, 10, 20}) {
            long operations = simplifiedOperationCount(n);
            System.out.println("n=" + n + ", estimated primitive operations=" + operations);
        }

        System.out.println("Doubling n approximately doubles the work: O(n).");
    }
}
