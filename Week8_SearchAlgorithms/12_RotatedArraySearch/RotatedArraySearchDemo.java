import java.util.Arrays;

/*
 * CONCEPT: Search a sorted array that has been rotated around a pivot.
 *
 * At least one half around middle remains normally sorted. We identify that half
 * and decide whether the target lies inside it. The range still halves each time,
 * so the method runs in O(log n) when distinct values are used.
 */
public class RotatedArraySearchDemo {

    static int search(int[] values, int target) {
        int low = 0;
        int high = values.length - 1;

        while (low <= high) {
            int middle = low + (high - low) / 2;
            if (values[middle] == target) return middle;

            if (values[low] <= values[middle]) { // Left half is sorted.
                if (values[low] <= target && target < values[middle]) {
                    high = middle - 1; // Target lies inside the sorted left half.
                } else {
                    low = middle + 1;
                }
            } else { // Otherwise, the right half is sorted.
                if (values[middle] < target && target <= values[high]) {
                    low = middle + 1; // Target lies inside the sorted right half.
                } else {
                    high = middle - 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] rotated = {5, 6, 7, 1, 2, 3, 4};

        System.out.println("Rotated array: " + Arrays.toString(rotated));
        System.out.println("Index of 2: " + search(rotated, 2));
        System.out.println("Index of 8: " + search(rotated, 8));
    }
}
