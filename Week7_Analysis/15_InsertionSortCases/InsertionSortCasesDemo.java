import java.util.Arrays;

/*
 * CONCEPT: Best-case and worst-case analysis of insertion sort.
 *
 * An already sorted array needs about n comparisons and no shifts: O(n).
 * A reverse-sorted array shifts across the growing sorted portion, producing
 * about n(n-1)/2 comparisons and shifts: O(n^2).
 */
public class InsertionSortCasesDemo {

    static class Counts {
        int comparisons; // Count comparisons between the key and earlier values.
        int shifts;      // Count values moved one position to the right.
    }

    static Counts insertionSort(int[] values) {
        Counts counts = new Counts();

        for (int i = 1; i < values.length; i++) {
            int key = values[i]; // Save the value that must enter the sorted portion.
            int j = i - 1;       // Begin with the item immediately to its left.

            while (j >= 0) {
                counts.comparisons++;
                if (values[j] <= key) {
                    break; // The correct insertion position has been found.
                }

                values[j + 1] = values[j]; // Shift a larger value right.
                counts.shifts++;
                j--;
            }

            values[j + 1] = key; // Insert the saved key in the open position.
        }

        return counts;
    }

    static void demonstrate(String label, int[] values) {
        Counts counts = insertionSort(values);
        System.out.println(label + ": " + Arrays.toString(values));
        System.out.println("  comparisons=" + counts.comparisons + ", shifts=" + counts.shifts);
    }

    public static void main(String[] args) {
        demonstrate("Already sorted", new int[]{1, 2, 3, 4, 5, 6});
        demonstrate("Reverse sorted", new int[]{6, 5, 4, 3, 2, 1});
        System.out.println("Best case O(n); worst case O(n^2).");
    }
}
