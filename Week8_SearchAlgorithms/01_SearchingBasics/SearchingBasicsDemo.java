import java.util.Arrays;

/*
 * CONCEPT: Searching means locating a target value in a collection.
 *
 * A successful array search returns the target's zero-based index. A failed
 * search returns -1 because -1 can never be a valid Java array index.
 */
public class SearchingBasicsDemo {

    static int search(int[] values, int target) {
        // Start at index zero and inspect each valid index in order.
        for (int index = 0; index < values.length; index++) {
            if (values[index] == target) {
                return index; // Return immediately when the target is found.
            }
        }

        return -1; // The loop ended without finding the target.
    }

    public static void main(String[] args) {
        int[] values = {4, 2, 7, 1, 9, 5};

        System.out.println("Array: " + Arrays.toString(values));
        System.out.println("Index of 9: " + search(values, 9));
        System.out.println("Index of 10: " + search(values, 10));
        System.out.println("Valid indices run from 0 to " + (values.length - 1) + ".");
    }
}
