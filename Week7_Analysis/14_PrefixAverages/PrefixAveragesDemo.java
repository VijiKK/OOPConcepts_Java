import java.util.Arrays;

/*
 * CONCEPT: Two algorithms can solve the same problem with different growth rates.
 *
 * prefixAverageQuadratic recomputes each prefix sum: 1+2+...+n additions, O(n^2).
 * prefixAverageLinear keeps a running total: one pass with n additions, O(n).
 */
public class PrefixAveragesDemo {

    static double[] prefixAverageQuadratic(double[] values) {
        double[] averages = new double[values.length];

        for (int i = 0; i < values.length; i++) {
            double total = 0; // Restart the sum for every prefix.
            for (int j = 0; j <= i; j++) {
                total += values[j]; // Revisit earlier values many times.
            }
            averages[i] = total / (i + 1);
        }

        return averages;
    }

    static double[] prefixAverageLinear(double[] values) {
        double[] averages = new double[values.length];
        double runningTotal = 0; // Preserve work completed for earlier prefixes.

        for (int i = 0; i < values.length; i++) {
            runningTotal += values[i]; // Add only the new value.
            averages[i] = runningTotal / (i + 1);
        }

        return averages;
    }

    public static void main(String[] args) {
        double[] values = {10, 20, 30, 40};

        System.out.println("Input: " + Arrays.toString(values));
        System.out.println("Quadratic result: " + Arrays.toString(prefixAverageQuadratic(values)));
        System.out.println("Linear result:    " + Arrays.toString(prefixAverageLinear(values)));
        System.out.println("Same output, but O(n^2) versus O(n).");
    }
}
