import java.util.Arrays;

/*
 * CONCEPT: Use a binary-search decision to find a peak element.
 *
 * A peak is not smaller than its neighbors. If the sequence rises from middle
 * to middle+1, some peak exists to the right. Otherwise, a peak exists at middle
 * or to its left. The search reaches one index in O(log n) time.
 */
public class PeakFindingDemo {

    static int findPeak(int[] values) {
        int low = 0;
        int high = values.length - 1;

        while (low < high) {
            int middle = low + (high - low) / 2;

            if (values[middle] < values[middle + 1]) {
                low = middle + 1; // Rising slope guarantees a peak on the right.
            } else {
                high = middle; // middle remains a possible peak; do not exclude it.
            }
        }

        return low; // low and high meet at a peak index.
    }

    public static void main(String[] args) {
        int[] values = {1, 3, 8, 12, 9, 5, 2};
        int peakIndex = findPeak(values);

        System.out.println("Values: " + Arrays.toString(values));
        System.out.println("Peak index: " + peakIndex);
        System.out.println("Peak value: " + values[peakIndex]);
    }
}
