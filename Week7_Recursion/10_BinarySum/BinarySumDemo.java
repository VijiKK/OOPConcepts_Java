import java.util.Arrays;

/*
 * CONCEPT: BinarySum divides an array range into two recursive halves.
 *
 * Each non-base call makes two calls, so this is binary recursion. However,
 * the calls divide the same n elements without repeated leaf work. There are
 * O(n) total calls and O(log n) stack depth, so total time is O(n).
 */
public class BinarySumDemo {

    static int binarySum(int[] values, int start, int length, int depth) {
        String indent = "  ".repeat(depth);

        if (length == 0) {
            return 0; // An empty range contributes nothing.
        }

        if (length == 1) {
            System.out.println(indent + "Leaf value: " + values[start]);
            return values[start];
        }

        int leftLength = length / 2;
        int rightLength = length - leftLength; // Also supports odd range lengths.

        int leftSum = binarySum(values, start, leftLength, depth + 1);
        int rightSum = binarySum(values, start + leftLength, rightLength, depth + 1);
        int total = leftSum + rightSum;

        System.out.println(indent + "Combine " + leftSum + " + " + rightSum
                + " = " + total);
        return total;
    }

    public static void main(String[] args) {
        int[] values = {4, 3, 6, 2, 8, 5, 1, 7};

        System.out.println("Values: " + Arrays.toString(values));
        System.out.println("Sum: " + binarySum(values, 0, values.length, 0));
        System.out.println("Binary recursion can still have O(n) total work.");
    }
}
