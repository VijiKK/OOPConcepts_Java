/*
 * COMPLEXITY LEVEL: O(1) - constant time.
 *
 * Direct array access performs the same number of main operations regardless
 * of the array length. O(1) does not mean one operation; it means the operation
 * count does not grow with input size n.
 */
public class ConstantTimeDemo {

    static int firstElement(int[] values) {
        if (values.length == 0) {
            throw new IllegalArgumentException("Array must not be empty");
        }

        return values[0]; // Index zero is accessed directly in constant time.
    }

    public static void main(String[] args) {
        int[] small = {10, 20, 30};
        int[] larger = new int[1_000_000];
        larger[0] = 99;

        System.out.println("First of 3 elements: " + firstElement(small));
        System.out.println("First of 1,000,000 elements: " + firstElement(larger));
        System.out.println("Each call performs one direct array access: O(1).");
    }
}
