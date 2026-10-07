import java.util.Arrays;

/*
 * PRACTICE 3: Find an array maximum iteratively and recursively.
 *
 * Both methods examine all n elements and therefore take O(n) time. The loop
 * uses O(1) extra space, while recursion uses O(n) call-stack space.
 */
public class ArrayOperations {

    static int findMaxIterative(int[] values) {
        validate(values); // Reject input for which no maximum exists.
        int maximum = values[0];

        for (int i = 1; i < values.length; i++) {
            if (values[i] > maximum) {
                maximum = values[i];
            }
        }

        return maximum;
    }

    static int findMaxRecursive(int[] values, int index) {
        validate(values);

        if (index == values.length - 1) {
            return values[index]; // Base case: one remaining value is its own maximum.
        }

        int maximumOfRest = findMaxRecursive(values, index + 1);
        return Math.max(values[index], maximumOfRest); // Combine current and smaller result.
    }

    static void validate(int[] values) {
        if (values == null || values.length == 0) {
            throw new IllegalArgumentException("Array must not be null or empty");
        }
    }

    public static void main(String[] args) {
        int[] values = {14, 3, 27, 9, 18};

        System.out.println("Values: " + Arrays.toString(values));
        System.out.println("Iterative maximum: " + findMaxIterative(values));
        System.out.println("Recursive maximum: " + findMaxRecursive(values, 0));
        System.out.println("Both use O(n) time; their extra-space costs differ.");
    }
}
