/*
 * CONCEPT: Runtime experiments need repetition and careful interpretation.
 *
 * System.nanoTime measures elapsed time on this machine, but JVM warm-up and
 * system activity create noise. We warm up first, repeat many searches, and
 * also report comparisons because theory is more portable than one timing run.
 */
public class SearchTimingExperiment {

    static int linearSearch(int[] values, int target) {
        for (int index = 0; index < values.length; index++) {
            if (values[index] == target) return index;
        }
        return -1;
    }

    static int binarySearch(int[] values, int target) {
        int low = 0;
        int high = values.length - 1;
        while (low <= high) {
            int middle = low + (high - low) / 2;
            if (values[middle] == target) return middle;
            if (values[middle] < target) low = middle + 1;
            else high = middle - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] sorted = new int[100_000];
        for (int index = 0; index < sorted.length; index++) {
            sorted[index] = index;
        }

        int target = sorted.length; // Missing target creates a clear worst case.
        // One hundred repetitions are enough for a quick classroom demonstration.
        int repetitions = 100;
        int checksum = 0; // Use results so the calls remain observable.

        for (int warmup = 0; warmup < 1_000; warmup++) {
            checksum += binarySearch(sorted, target);
        }

        long start = System.nanoTime();
        for (int run = 0; run < repetitions; run++) {
            checksum += linearSearch(sorted, target);
        }
        long linearNanoseconds = System.nanoTime() - start;

        start = System.nanoTime();
        for (int run = 0; run < repetitions; run++) {
            checksum += binarySearch(sorted, target);
        }
        long binaryNanoseconds = System.nanoTime() - start;

        System.out.println("Repeated searches: " + repetitions);
        System.out.println("Linear total ns: " + linearNanoseconds);
        System.out.println("Binary total ns: " + binaryNanoseconds);
        System.out.println("Checksum: " + checksum);
        System.out.println("Times vary; growth classes remain O(n) and O(log n).");
    }
}
