/*
 * COMPLEXITY LEVEL: O(n) - linear time.
 *
 * Linear search may inspect every array element. When n doubles, the worst-case
 * number of comparisons also doubles.
 */
public class LinearTimeDemo {

    static int linearSearch(int[] values, int target) {
        for (int i = 0; i < values.length; i++) {
            System.out.println("Compare target with index " + i);
            if (values[i] == target) {
                return i; // Stop early when the target is found.
            }
        }

        return -1; // Reaching here means all n values were checked.
    }

    public static void main(String[] args) {
        int[] values = {8, 3, 12, 6, 19, 4};
        int index = linearSearch(values, 4); // The target is at the worst-case position.

        System.out.println("Target index: " + index);
        System.out.println("Worst-case growth: O(n)");
    }
}
