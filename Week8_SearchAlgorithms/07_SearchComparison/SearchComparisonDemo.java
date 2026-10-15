/*
 * CONCEPT: Compare linear and binary search using operation counts.
 *
 * Counting comparisons reveals algorithm growth without relying on noisy clock
 * measurements. Both methods search the same sorted array for a missing target.
 */
public class SearchComparisonDemo {

    static int linearComparisons(int[] values, int target) {
        int comparisons = 0;
        for (int value : values) {
            comparisons++;
            if (value == target) break;
        }
        return comparisons;
    }

    static int binaryComparisons(int[] values, int target) {
        int comparisons = 0;
        int low = 0;
        int high = values.length - 1;

        while (low <= high) {
            int middle = low + (high - low) / 2;
            comparisons++;
            if (values[middle] == target) break;
            if (values[middle] < target) low = middle + 1;
            else high = middle - 1;
        }
        return comparisons;
    }

    public static void main(String[] args) {
        int size = 1_000_000;
        int[] sorted = new int[size];

        for (int index = 0; index < sorted.length; index++) {
            sorted[index] = index * 2; // Even values keep odd target -1 absent.
        }

        int missingTarget = -1;
        System.out.println("Array size: " + size);
        System.out.println("Linear comparisons: " + linearComparisons(sorted, missingTarget));
        System.out.println("Binary comparisons: " + binaryComparisons(sorted, missingTarget));
    }
}
