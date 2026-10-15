import java.util.Arrays;

/*
 * PRACTICE 2: Implement iterative and recursive binary search.
 *
 * Both versions require sorted input and take O(log n) time. The iterative
 * version uses O(1) auxiliary space; recursion uses O(log n) call-stack space.
 */
public class BinarySearch {

    static int iterativeSearch(int[] sorted, int target) {
        int low = 0;
        int high = sorted.length - 1;

        while (low <= high) {
            int middle = low + (high - low) / 2;
            if (sorted[middle] == target) return middle;
            if (sorted[middle] < target) low = middle + 1;
            else high = middle - 1;
        }
        return -1;
    }

    static int recursiveSearch(int[] sorted, int target, int low, int high) {
        if (low > high) {
            return -1; // Base case: the range is empty.
        }

        int middle = low + (high - low) / 2;
        if (sorted[middle] == target) return middle;

        if (sorted[middle] < target) {
            return recursiveSearch(sorted, target, middle + 1, high);
        }
        return recursiveSearch(sorted, target, low, middle - 1);
    }

    public static void main(String[] args) {
        int[] sorted = {1, 2, 5, 8, 13, 16, 19};
        int target = 16;

        System.out.println("Sorted data: " + Arrays.toString(sorted));
        System.out.println("Iterative result: " + iterativeSearch(sorted, target));
        System.out.println("Recursive result: "
                + recursiveSearch(sorted, target, 0, sorted.length - 1));
    }
}
