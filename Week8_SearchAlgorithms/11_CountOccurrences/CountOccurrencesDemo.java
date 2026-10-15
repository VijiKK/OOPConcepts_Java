import java.util.Arrays;

/*
 * CONCEPT: Count duplicates with two boundary searches.
 *
 * For a present target, count = lastIndex - firstIndex + 1. Each boundary uses
 * O(log n) time, and two logarithmic searches remain O(log n).
 */
public class CountOccurrencesDemo {

    static int boundary(int[] sorted, int target, boolean findFirst) {
        int low = 0;
        int high = sorted.length - 1;
        int result = -1;

        while (low <= high) {
            int middle = low + (high - low) / 2;
            if (sorted[middle] == target) {
                result = middle;
                if (findFirst) high = middle - 1;
                else low = middle + 1;
            } else if (sorted[middle] < target) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }
        return result;
    }

    static int countOccurrences(int[] sorted, int target) {
        int first = boundary(sorted, target, true);
        if (first == -1) return 0; // Avoid a meaningless last-first calculation.
        int last = boundary(sorted, target, false);
        return last - first + 1;
    }

    public static void main(String[] args) {
        int[] sorted = {1, 2, 2, 2, 5, 8, 8, 13};

        System.out.println("Array: " + Arrays.toString(sorted));
        System.out.println("Number of 2s: " + countOccurrences(sorted, 2));
        System.out.println("Number of 7s: " + countOccurrences(sorted, 7));
    }
}
