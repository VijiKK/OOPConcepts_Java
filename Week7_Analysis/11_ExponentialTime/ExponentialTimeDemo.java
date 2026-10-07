/*
 * COMPLEXITY LEVEL: O(2^n) - exponential time.
 *
 * Every input item creates two choices: exclude it or include it. Those choices
 * form a binary recursion tree with 2^n leaves, one for every possible subset.
 * This version counts the leaves without printing subset contents, so the work
 * represented by the demonstration is directly O(2^n).
 */
public class ExponentialTimeDemo {

    static long countSubsets(int numberOfItems, int index) {
        if (index == numberOfItems) {
            return 1; // One leaf represents one completed subset decision.
        }

        // Count all subsets that exclude the current item.
        long excludingCurrent = countSubsets(numberOfItems, index + 1);

        // Count all subsets that include the current item.
        long includingCurrent = countSubsets(numberOfItems, index + 1);

        return excludingCurrent + includingCurrent;
    }

    public static void main(String[] args) {
        for (int n : new int[]{4, 8, 16}) {
            long subsets = countSubsets(n, 0);
            System.out.println("n=" + n + ", possible subsets=" + subsets);
        }

        System.out.println("Each added item doubles the number of recursive branches.");
        System.out.println("Growth: O(2^n)");
    }
}
