import java.util.Arrays;

/*
 * CONCEPT: Linear search checks elements sequentially from left to right.
 *
 * It works with sorted or unsorted data. The trace prints every comparison so
 * students can see that return immediately stops the method after a match.
 */
public class LinearSearchTraceDemo {

    static int linearSearch(int[] values, int target) {
        for (int index = 0; index < values.length; index++) {
            System.out.println("Compare target " + target + " with values["
                    + index + "] = " + values[index]);

            if (values[index] == target) {
                System.out.println("Match found; return index " + index + ".");
                return index;
            }
        }

        System.out.println("Every element was checked; return -1.");
        return -1;
    }

    public static void main(String[] args) {
        int[] values = {4, 2, 7, 1, 9, 5};

        System.out.println("Array: " + Arrays.toString(values));
        System.out.println("\nSearch for 9:");
        linearSearch(values, 9);

        System.out.println("\nSearch for missing value 10:");
        linearSearch(values, 10);
    }
}
