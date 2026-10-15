/*
 * CONCEPT: Avoid midpoint overflow, off-by-one errors, and infinite loops.
 *
 * With inclusive boundaries, continue while low <= high. After checking middle,
 * update to middle+1 or middle-1 so the checked element leaves the range.
 */
public class BinarySearchPitfallsDemo {

    static int safeMiddle(int low, int high) {
        // This avoids possible overflow from (low + high) when both are very large.
        return low + (high - low) / 2;
    }

    static int correctSearch(int[] sorted, int target) {
        int low = 0;
        int high = sorted.length - 1;

        while (low <= high) { // Equality preserves a one-element search range.
            int middle = safeMiddle(low, high);
            if (sorted[middle] == target) return middle;

            if (sorted[middle] < target) {
                low = middle + 1; // Using middle alone could repeat forever.
            } else {
                high = middle - 1; // Exclude the value already checked.
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int low = 2_000_000_000;
        int high = 2_100_000_000;

        System.out.println("Safe middle of large indices: " + safeMiddle(low, high));
        System.out.println("Single-element search succeeds: "
                + correctSearch(new int[]{42}, 42));
        System.out.println("Missing value returns: "
                + correctSearch(new int[]{1, 3, 5, 7}, 4));
    }
}
