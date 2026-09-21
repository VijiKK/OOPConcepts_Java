/*
 * CONCEPT: An array is an ordered, fixed-length collection whose elements
 * all have the same declared type.
 *
 * Each cell has a zero-based index. Reading or changing one known index takes
 * constant time, written O(1), because Java can go directly to that cell.
 */
public class ArrayDefinitionDemo {

    public static void main(String[] args) {
        // Array literal: create an int array and provide all five values.
        int[] scores = {92, 85, 78, 96, 88};

        // Index 0 refers to the first cell, not index 1.
        System.out.println("First score: " + scores[0]);

        // Index 2 refers to the third cell.
        System.out.println("Third score: " + scores[2]);

        // An array cell is a variable, so its value can be changed.
        scores[2] = 80;
        System.out.println("Updated third score: " + scores[2]);

        // Every element must be an int because scores has type int[].
        // WRONG (leave commented): scores[0] = "ninety-two";
    }
}

/*
Expected output:
First score: 92
Third score: 78
Updated third score: 80
*/
