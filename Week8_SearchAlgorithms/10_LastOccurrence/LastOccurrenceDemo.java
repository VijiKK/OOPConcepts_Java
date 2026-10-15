import java.util.Arrays;

/*
 * CONCEPT: Find the last occurrence of a duplicate target in sorted data.
 *
 * This is the mirror image of first-occurrence search. After a match, save its
 * index and continue right because a later duplicate may still exist.
 */
public class LastOccurrenceDemo {

    static int lastOccurrence(int[] sorted, int target) {
        int low = 0;
        int high = sorted.length - 1;
        int result = -1;

        while (low <= high) {
            int middle = low + (high - low) / 2;

            if (sorted[middle] == target) {
                result = middle;  // Save this match.
                low = middle + 1; // Search the later portion for another copy.
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
        System.out.println("Last index of 2: " + lastOccurrence(sorted, 2));
        System.out.println("Time complexity: O(log n)");
    }
}
