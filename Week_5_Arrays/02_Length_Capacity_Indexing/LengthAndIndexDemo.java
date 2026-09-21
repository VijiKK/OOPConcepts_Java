/*
 * CONCEPTS: Array length, capacity, valid indices, and bounds errors.
 *
 * For an array of length 5, the valid indices are 0 through 4. The array's
 * length is fixed when the array is created and is read through array.length.
 */
public class LengthAndIndexDemo {

    public static void main(String[] args) {
        // new int[5] allocates exactly five integer cells.
        int[] values = new int[5];

        int firstIndex = 0;
        int lastIndex = values.length - 1;

        System.out.println("Length/capacity: " + values.length);
        System.out.println("First valid index: " + firstIndex);
        System.out.println("Last valid index: " + lastIndex);

        // Access by a known index is O(1).
        values[2] = 25;
        System.out.println("Value at index 2: " + values[2]);

        /*
         * values[5] is invalid. Java checks array bounds at runtime and throws
         * ArrayIndexOutOfBoundsException instead of accessing unknown memory.
         */
        try {
            System.out.println(values[5]);
        } catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println("Index 5 is outside the array.");
        }
    }
}

/*
Expected output:
Length/capacity: 5
First valid index: 0
Last valid index: 4
Value at index 2: 25
Index 5 is outside the array.
*/
