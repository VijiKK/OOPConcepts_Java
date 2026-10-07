import java.util.Arrays;

/*
 * COMPLEXITY LEVEL: O(log n) - logarithmic time.
 *
 * Binary search checks the middle of a sorted range and discards half of the
 * remaining values after each comparison. The problem sizes follow roughly
 * n, n/2, n/4, n/8, ... until no range remains.
 */
public class LogarithmicTimeDemo {

    static int binarySearch(int[] sorted, int target) {
        int low = 0;                 // First possible target index.
        int high = sorted.length - 1;// Last possible target index.
        int comparisons = 0;         // Count middle-value comparisons.

        while (low <= high) {
            int middle = low + (high - low) / 2; // Avoid overflow while finding middle.
            comparisons++;
            System.out.println("Check index " + middle + " with value " + sorted[middle]);

            if (sorted[middle] == target) {
                System.out.println("Comparisons: " + comparisons);
                return middle;
            } else if (sorted[middle] < target) {
                low = middle + 1; // Discard the left half, including middle.
            } else {
                high = middle - 1; // Discard the right half, including middle.
            }
        }

        System.out.println("Comparisons: " + comparisons);
        return -1; // -1 indicates that the target is absent.
    }

    public static void main(String[] args) {
        int[] values = {2, 5, 8, 12, 16, 23, 38, 45, 56, 72, 91};
        System.out.println("Sorted input: " + Arrays.toString(values));
        System.out.println("Index of 72: " + binarySearch(values, 72));
        System.out.println("Growth: O(log n)");
    }
}
