import java.util.Arrays;

/*
 * CONCEPT: Analyze arrayMax by counting comparisons.
 *
 * The method must compare every element after the first with the current maximum.
 * It always performs n-1 comparisons, although the number of assignments differs
 * between inputs. The worst and best cases therefore both have O(n) growth.
 */
public class ArrayMaxAnalysisDemo {

    static class Result {
        int maximum;   // Final maximum value.
        int comparisons; // Number of greater-than tests.
        int updates;     // Number of times maximum changed.
    }

    static Result arrayMax(int[] values) {
        if (values.length == 0) {
            throw new IllegalArgumentException("Array must not be empty");
        }

        Result result = new Result();
        result.maximum = values[0]; // Use the first value as the initial candidate.

        for (int i = 1; i < values.length; i++) {
            result.comparisons++; // One comparison occurs for every remaining value.
            if (values[i] > result.maximum) {
                result.maximum = values[i]; // Update only when a larger value appears.
                result.updates++;
            }
        }

        return result;
    }

    static void demonstrate(int[] values) {
        Result result = arrayMax(values);
        System.out.println(Arrays.toString(values)
                + " -> max=" + result.maximum
                + ", comparisons=" + result.comparisons
                + ", updates=" + result.updates);
    }

    public static void main(String[] args) {
        demonstrate(new int[]{9, 7, 5, 3, 1}); // Best case for maximum updates: zero.
        demonstrate(new int[]{1, 3, 5, 7, 9}); // Worst case for updates: n-1.
        System.out.println("Both inputs still require n-1 comparisons: O(n).");
    }
}
