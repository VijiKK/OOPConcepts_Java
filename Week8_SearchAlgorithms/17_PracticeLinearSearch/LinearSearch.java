import java.util.Arrays;

/*
 * PRACTICE 1: Implement linear search and measure one execution.
 *
 * Best time is O(1); average and worst time are O(n). Auxiliary space is O(1).
 * A single nanoTime measurement is shown because the worksheet requests it,
 * but it should not be treated as a stable performance benchmark.
 */
public class LinearSearch {

    /**
     * Searches an array sequentially.
     *
     * @param values array to search
     * @param target value to find
     * @return target index, or -1 when the target is absent
     */
    static int search(int[] values, int target) {
        for (int index = 0; index < values.length; index++) {
            if (values[index] == target) {
                return index;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] data = {4, 2, 7, 1, 9, 5};
        int target = 9;

        long startTime = System.nanoTime();
        int result = search(data, target);
        long elapsedTime = System.nanoTime() - startTime;

        System.out.println("Data: " + Arrays.toString(data));
        System.out.println("Found at index: " + result);
        System.out.println("Measured runtime: " + elapsedTime + " ns");
    }
}
