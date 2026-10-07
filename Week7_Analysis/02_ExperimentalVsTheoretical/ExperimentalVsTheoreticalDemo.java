/*
 * CONCEPT: Experimental measurement versus theoretical analysis.
 *
 * A timer reports performance for one machine, Java runtime, and input.
 * A theoretical operation count describes how work grows with n and is less
 * dependent on the computer. Timing results naturally vary between runs.
 */
public class ExperimentalVsTheoreticalDemo {

    static long doLinearWork(int n) {
        long checksum = 0; // The checksum prevents the loop from being meaningless.

        for (int i = 0; i < n; i++) {
            checksum += i; // This main operation repeats n times.
        }

        return checksum;
    }

    public static void main(String[] args) {
        int n = 1_000_000; // Choose the input size for this experiment.

        long start = System.nanoTime(); // Record the clock before the algorithm.
        long checksum = doLinearWork(n); // Run the code being measured.
        long end = System.nanoTime();   // Record the clock after the algorithm.

        long elapsedNanoseconds = end - start; // Compute this run's measured time.

        System.out.println("Input size n: " + n);
        System.out.println("Checksum: " + checksum);
        System.out.println("Measured time (ns): " + elapsedNanoseconds);
        System.out.println("Theoretical main-operation count: " + n);
        System.out.println("Theoretical growth: O(n)");
        System.out.println("Run again: the measured time may change.");
    }
}
