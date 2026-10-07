import java.util.Arrays;

/*
 * CONCEPT: Recursive binary search makes one call on half of a sorted range.
 *
 * Although its name contains "binary," this is linear recursion: each invocation
 * chooses only one recursive branch. Halving the range gives O(log n) time.
 */
public class RecursiveBinarySearchDemo {

    static int binarySearch(int[] values, int target, int low, int high, int depth) {
        if (low > high) {
            return -1; // Empty range means the target is absent.
        }

        int middle = low + (high - low) / 2;
        System.out.println("Depth " + depth + ": range [" + low + ", " + high
                + "], middle value " + values[middle]);

        if (values[middle] == target) {
            return middle;
        }

        if (target < values[middle]) {
            return binarySearch(values, target, low, middle - 1, depth + 1);
        }

        return binarySearch(values, target, middle + 1, high, depth + 1);
    }

    public static void main(String[] args) {
        int[] sorted = {2, 5, 8, 12, 16, 23, 38, 45, 56, 72, 91};
        int target = 72;

        System.out.println("Array: " + Arrays.toString(sorted));
        int index = binarySearch(sorted, target, 0, sorted.length - 1, 0);
        System.out.println("Target index: " + index);
        System.out.println("One call per level; range halves: O(log n).");
    }
}
