/*
 * CONCEPT: Linear-search best, worst, and average cases.
 *
 * A first-position match takes one comparison: O(1) best case. A last-position
 * match or missing target takes n comparisons: O(n) worst case. Average work
 * also grows linearly, and the algorithm uses O(1) auxiliary space.
 */
public class LinearSearchComplexityDemo {

    static int countComparisons(int[] values, int target) {
        int comparisons = 0;

        for (int value : values) {
            comparisons++; // Count the equality test about to occur.
            if (value == target) {
                return comparisons;
            }
        }

        return comparisons;
    }

    public static void main(String[] args) {
        int[] values = {4, 2, 7, 1, 9, 5};

        System.out.println("First element target: " + countComparisons(values, 4));
        System.out.println("Last element target: " + countComparisons(values, 5));
        System.out.println("Missing target: " + countComparisons(values, 10));
        System.out.println("Best O(1); average O(n); worst O(n); space O(1).");
    }
}
