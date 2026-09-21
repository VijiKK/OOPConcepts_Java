import java.util.Arrays;

/*
 * CONCEPT: Java provides two common ways to create an array.
 *
 * 1. Use an array literal when the initial values are already known.
 * 2. Use new elementType[length] when the required capacity is known.
 */
public class ArrayCreationDemo {

    public static void main(String[] args) {
        // The values determine both the contents and the length.
        int[] knownValues = {90, 85, 76, 92};

        // The length is known, but values will be assigned later.
        int[] knownSize = new int[4];

        // New primitive-array cells receive default values; int defaults to 0.
        System.out.println("Literal array: "
                + Arrays.toString(knownValues));
        System.out.println("New int array defaults: "
                + Arrays.toString(knownSize));

        // Fill individual cells after allocation.
        knownSize[0] = 70;
        knownSize[1] = 75;
        System.out.println("After assignments: "
                + Arrays.toString(knownSize));

        // The brackets may follow the type. int[] is preferred Java style.
        String[] courses = new String[2];
        boolean[] attendance = new boolean[2];

        // Object references default to null; boolean values default to false.
        System.out.println("String defaults: " + Arrays.toString(courses));
        System.out.println("Boolean defaults: "
                + Arrays.toString(attendance));
    }
}

/*
Expected output:
Literal array: [90, 85, 76, 92]
New int array defaults: [0, 0, 0, 0]
After assignments: [70, 75, 0, 0]
String defaults: [null, null]
Boolean defaults: [false, false]
*/
