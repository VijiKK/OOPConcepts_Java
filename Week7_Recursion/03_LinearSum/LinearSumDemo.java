import java.util.Arrays;

/*
 * CONCEPT: Linear recursion makes one recursive call in each non-base case.
 *
 * linearSum(values, n) returns the sum of the first n array elements. Each call
 * reduces n by one, and the answers are added while calls return.
 */
public class LinearSumDemo {

    static int linearSum(int[] values, int n) {
        if (n == 0) {
            return 0; // The sum of zero elements is zero.
        }

        int sumOfSmallerPrefix = linearSum(values, n - 1); // One recursive call.
        int lastValue = values[n - 1];                     // New element in this prefix.

        System.out.println("Returning sum(first " + n + ") = "
                + sumOfSmallerPrefix + " + " + lastValue);
        return sumOfSmallerPrefix + lastValue;
    }

    public static void main(String[] args) {
        int[] values = {4, 3, 6, 2, 8};

        System.out.println("Array: " + Arrays.toString(values));
        System.out.println("Sum: " + linearSum(values, values.length));
        System.out.println("One call per level means linear recursion and O(n) time.");
    }
}
