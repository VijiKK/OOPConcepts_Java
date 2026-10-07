/*
 * COMPLEXITY LEVEL: O(n^3) - cubic time.
 *
 * Three independent loops each repeat n times. The innermost statement executes
 * n*n*n times. If n doubles, the operation count becomes eight times larger.
 */
public class CubicTimeDemo {

    static long countTriples(int n) {
        long triples = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    triples++; // Count the ordered triple (i, j, k).
                }
            }
        }

        return triples;
    }

    public static void main(String[] args) {
        for (int n : new int[]{2, 4, 8}) {
            System.out.println("n=" + n + ", triples=" + countTriples(n));
        }

        System.out.println("Doubling n multiplies the work by eight: O(n^3).");
    }
}
