/*
 * CONCEPT: Correct recursion can still be inefficient.
 *
 * binaryFibonacci repeats the same subproblems and grows exponentially. The
 * improved method returns both F(n) and F(n-1), so each level needs one call.
 * That version takes O(n) time instead of exponential time.
 */
public class FibonacciComparisonDemo {

    private static long binaryCalls;
    private static long linearCalls;

    static long binaryFibonacci(int n) {
        binaryCalls++; // Count every invocation, including base cases.

        if (n <= 1) {
            return n;
        }

        return binaryFibonacci(n - 1) + binaryFibonacci(n - 2);
    }

    static long[] linearFibonacci(int n) {
        linearCalls++;

        if (n == 0) {
            return new long[]{0, 0}; // Pair represents F(0) and a harmless prior value.
        }

        if (n == 1) {
            return new long[]{1, 0}; // Pair contains F(1) and F(0).
        }

        long[] previous = linearFibonacci(n - 1); // One recursive call.
        long current = previous[0] + previous[1]; // F(n)=F(n-1)+F(n-2).
        return new long[]{current, previous[0]};
    }

    public static void main(String[] args) {
        int n = 10;
        long binaryAnswer = binaryFibonacci(n);
        long linearAnswer = linearFibonacci(n)[0];

        System.out.println("F(" + n + ") = " + binaryAnswer);
        System.out.println("Binary recursive calls: " + binaryCalls);
        System.out.println("Improved answer: " + linearAnswer);
        System.out.println("Improved linear calls: " + linearCalls);
        System.out.println("Repeated subproblems cause the large difference.");
    }
}
