import java.util.Arrays;

/*
 * CONCEPT: Iterative binary search repeatedly halves a sorted search range.
 *
 * low and high are inclusive boundary indices. The loop continues while the
 * range is nonempty. The safe midpoint formula avoids adding low and high.
 */
public class IterativeBinarySearchDemo {

    static int binarySearch(int[] sorted, int target) {
        int low = 0;                    // First possible target index.
        int high = sorted.length - 1;   // Last possible target index.

        while (low <= high) {
            int middle = low + (high - low) / 2;

            System.out.println("low=" + low + ", high=" + high
                    + ", middle=" + middle + ", value=" + sorted[middle]);

            if (sorted[middle] == target) {
                return middle; // Success: return the original array index.
            }

            if (sorted[middle] < target) {
                low = middle + 1; // Discard middle and everything to its left.
            } else {
                high = middle - 1; // Discard middle and everything to its right.
            }
        }

        return -1; // low > high means the remaining range is empty.
    }

    public static void main(String[] args) {
        int[] sorted = {1, 2, 5, 8, 13, 16, 19};

        System.out.println("Sorted array: " + Arrays.toString(sorted));
        System.out.println("Index of 16: " + binarySearch(sorted, 16));
        System.out.println("Worst-case time O(log n); auxiliary space O(1).");
    }
}
