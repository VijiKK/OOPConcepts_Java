import java.util.Arrays;

/*
 * CONCEPT: Recursive binary search replaces the loop with recursive calls.
 *
 * Each call receives the current low and high boundaries. The empty-range base
 * case returns -1. Time is O(log n), while active calls use O(log n) stack space.
 */
public class RecursiveBinarySearchDemo {

    static int binarySearch(int[] sorted, int target, int low, int high, int depth) {
        if (low > high) {
            System.out.println("Depth " + depth + ": empty range; return -1.");
            return -1;
        }

        int middle = low + (high - low) / 2;
        System.out.println("Depth " + depth + ": [" + low + ", " + high
                + "], middle value=" + sorted[middle]);

        if (sorted[middle] == target) {
            return middle; // Successful stopping condition.
        }

        if (sorted[middle] < target) {
            return binarySearch(sorted, target, middle + 1, high, depth + 1);
        }

        return binarySearch(sorted, target, low, middle - 1, depth + 1);
    }

    public static void main(String[] args) {
        int[] sorted = {1, 2, 5, 8, 13, 16, 19};

        System.out.println("Array: " + Arrays.toString(sorted));
        int index = binarySearch(sorted, 16, 0, sorted.length - 1, 0);
        System.out.println("Index of 16: " + index);
        System.out.println("Time O(log n); call-stack space O(log n).");
    }
}
