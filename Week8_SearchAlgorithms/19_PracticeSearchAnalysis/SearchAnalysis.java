/*
 * PRACTICE 3: Compare linear, iterative binary, and recursive binary search.
 *
 * The requested array contains 10,000 sorted integers. Target 10,000 is absent,
 * creating a worst case for linear search. Timings are machine-dependent, so the
 * table also reports comparisons, which more directly show O(n) versus O(log n).
 */
public class SearchAnalysis {

    static class Result {
        int index;       // Search result: found index or -1.
        int comparisons; // Number of inspected array values.
        long nanoseconds;// Elapsed time for this individual measurement.
    }

    static Result linearSearch(int[] values, int target) {
        Result result = new Result();
        long start = System.nanoTime();

        for (int index = 0; index < values.length; index++) {
            result.comparisons++;
            if (values[index] == target) {
                result.index = index;
                result.nanoseconds = System.nanoTime() - start;
                return result;
            }
        }

        result.index = -1;
        result.nanoseconds = System.nanoTime() - start;
        return result;
    }

    static Result iterativeBinarySearch(int[] values, int target) {
        Result result = new Result();
        int low = 0;
        int high = values.length - 1;
        long start = System.nanoTime();

        while (low <= high) {
            int middle = low + (high - low) / 2;
            result.comparisons++;
            if (values[middle] == target) {
                result.index = middle;
                result.nanoseconds = System.nanoTime() - start;
                return result;
            }
            if (values[middle] < target) low = middle + 1;
            else high = middle - 1;
        }

        result.index = -1;
        result.nanoseconds = System.nanoTime() - start;
        return result;
    }

    static int recursiveComparisons;

    static int recursiveBinarySearch(int[] values, int target, int low, int high) {
        if (low > high) return -1;
        int middle = low + (high - low) / 2;
        recursiveComparisons++;
        if (values[middle] == target) return middle;
        if (values[middle] < target) {
            return recursiveBinarySearch(values, target, middle + 1, high);
        }
        return recursiveBinarySearch(values, target, low, middle - 1);
    }

    public static void main(String[] args) {
        int[] data = new int[10_000];
        for (int index = 0; index < data.length; index++) {
            data[index] = index;
        }

        int target = 10_000;
        Result linear = linearSearch(data, target);
        Result iterative = iterativeBinarySearch(data, target);

        recursiveComparisons = 0;
        long start = System.nanoTime();
        int recursiveIndex = recursiveBinarySearch(data, target, 0, data.length - 1);
        long recursiveTime = System.nanoTime() - start;

        System.out.println("| Algorithm          | Result | Comparisons | Time (ns) |");
        System.out.println("|--------------------|--------|-------------|-----------|");
        System.out.printf("| Linear             | %6d | %11d | %9d |%n",
                linear.index, linear.comparisons, linear.nanoseconds);
        System.out.printf("| Binary iterative   | %6d | %11d | %9d |%n",
                iterative.index, iterative.comparisons, iterative.nanoseconds);
        System.out.printf("| Binary recursive   | %6d | %11d | %9d |%n",
                recursiveIndex, recursiveComparisons, recursiveTime);
        System.out.println("Timing values vary; comparison counts show the growth difference.");
    }
}
