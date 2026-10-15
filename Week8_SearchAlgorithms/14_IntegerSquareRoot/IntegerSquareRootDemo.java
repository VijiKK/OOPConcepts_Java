/*
 * CONCEPT: Binary search can search a numeric answer space, not only an array.
 *
 * integerSquareRoot returns floor(sqrt(x)): the largest integer whose square is
 * at most x. Division is used instead of middle*middle to avoid multiplication
 * overflow for large positive integers.
 */
public class IntegerSquareRootDemo {

    static int integerSquareRoot(int x) {
        if (x < 0) {
            throw new IllegalArgumentException("x must be nonnegative");
        }

        int low = 0;
        int high = x;
        int result = 0;

        while (low <= high) {
            int middle = low + (high - low) / 2;

            if (middle == 0 || middle <= x / middle) {
                result = middle;  // middle is valid; remember it.
                low = middle + 1; // Search for a larger valid answer.
            } else {
                high = middle - 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println("floor(sqrt(25)) = " + integerSquareRoot(25));
        System.out.println("floor(sqrt(30)) = " + integerSquareRoot(30));
        System.out.println("Time complexity: O(log x)");
    }
}
