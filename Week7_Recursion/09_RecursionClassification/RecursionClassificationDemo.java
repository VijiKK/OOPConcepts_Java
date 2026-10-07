/*
 * CONCEPT: Classify recursion by calls made from each non-base invocation.
 *
 * Linear recursion makes one recursive call. Binary recursion makes two.
 * Multiple recursion may make a variable number of calls, often in a loop.
 */
public class RecursionClassificationDemo {

    static int linearCount(int n) {
        if (n == 0) {
            return 1; // Count this base invocation.
        }

        return 1 + linearCount(n - 1); // One child call.
    }

    static int binaryCount(int n) {
        if (n == 0) {
            return 1;
        }

        return 1 + binaryCount(n - 1) + binaryCount(n - 1); // Two child calls.
    }

    static int multipleCount(int n) {
        if (n == 0) {
            return 1;
        }

        int calls = 1; // Count the current invocation.
        for (int branch = 0; branch < n; branch++) {
            calls += multipleCount(n - 1); // n child calls at this level.
        }
        return calls;
    }

    public static void main(String[] args) {
        int depth = 3;

        System.out.println("Linear invocation count: " + linearCount(depth));
        System.out.println("Binary invocation count: " + binaryCount(depth));
        System.out.println("Multiple invocation count: " + multipleCount(depth));
        System.out.println("Call structure influences growth, but duplicated work also matters.");
    }
}
