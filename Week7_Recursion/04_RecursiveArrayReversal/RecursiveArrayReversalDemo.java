import java.util.Arrays;

/*
 * CONCEPT: Extra parameters can identify the smaller recursive problem.
 *
 * left and right mark the portion that still needs reversing. Each call swaps
 * the outside pair and moves both indices inward until they meet or cross.
 */
public class RecursiveArrayReversalDemo {

    static void reverse(int[] values, int left, int right) {
        if (left >= right) {
            return; // Zero or one remaining element needs no swap.
        }

        int temporary = values[left]; // Save the left value before overwriting it.
        values[left] = values[right];  // Move the right value to the left side.
        values[right] = temporary;     // Move the saved value to the right side.

        System.out.println("After swapping indices " + left + " and " + right
                + ": " + Arrays.toString(values));

        reverse(values, left + 1, right - 1); // Recur on the smaller inner section.
    }

    public static void main(String[] args) {
        int[] values = {10, 20, 30, 40, 50};

        System.out.println("Before: " + Arrays.toString(values));
        reverse(values, 0, values.length - 1);
        System.out.println("After:  " + Arrays.toString(values));
    }
}
