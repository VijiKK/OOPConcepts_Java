import java.util.Arrays;

/*
 * CONCEPT: Find the first occurrence of a duplicate target in sorted data.
 *
 * Ordinary binary search may return any matching index. This variant records a
 * match and continues left because an earlier copy may still exist.
 */
public class FirstOccurrenceDemo {

    static int firstOccurrence(int[] sorted, int target) {
        int low = 0;
        int high = sorted.length - 1;
        int result = -1; // Preserve -1 unless at least one match appears.

        while (low <= high) {
            int middle = low + (high - low) / 2;

            if (sorted[middle] == target) {
                result = middle;    // Save this valid match.
                high = middle - 1; // Continue searching for an earlier match.
            } else if (sorted[middle] < target) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] sorted = {1, 2, 2, 2, 5, 8, 8, 13};

        System.out.println("Array: " + Arrays.toString(sorted));
        System.out.println("First index of 2: " + firstOccurrence(sorted, 2));
        System.out.println("Time complexity: O(log n)");
    }
}
