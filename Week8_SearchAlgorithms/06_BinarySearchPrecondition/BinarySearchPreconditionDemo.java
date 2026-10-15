import java.util.Arrays;

/*
 * CONCEPT: Ordinary binary search requires sorted, random-access data.
 *
 * Comparing with the middle value is useful only when ordering tells us which
 * half may contain the target. This example validates ascending order before
 * searching so an invalid precondition cannot silently produce a wrong answer.
 */
public class BinarySearchPreconditionDemo {

    static boolean isSortedAscending(int[] values) {
        for (int index = 1; index < values.length; index++) {
            if (values[index - 1] > values[index]) {
                return false; // One descending pair proves the array is not sorted.
            }
        }
        return true;
    }

    static int checkedBinarySearch(int[] values, int target) {
        if (!isSortedAscending(values)) {
            throw new IllegalArgumentException("Binary search requires sorted input");
        }

        int low = 0;
        int high = values.length - 1;

        while (low <= high) {
            int middle = low + (high - low) / 2;
            if (values[middle] == target) return middle;
            if (values[middle] < target) low = middle + 1;
            else high = middle - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] sorted = {1, 2, 5, 8, 13, 16, 19};
        int[] unsorted = {4, 2, 7, 1, 9, 5};

        System.out.println("Sorted input accepted: index=" + checkedBinarySearch(sorted, 16));
        System.out.println("Unsorted array: " + Arrays.toString(unsorted));

        try {
            checkedBinarySearch(unsorted, 9);
        } catch (IllegalArgumentException exception) {
            System.out.println("Rejected: " + exception.getMessage());
        }
    }
}
