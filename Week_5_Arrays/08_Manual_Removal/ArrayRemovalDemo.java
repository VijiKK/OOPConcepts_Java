import java.util.Arrays;

/*
 * CONCEPT: Removing an array element leaves a hole that must be filled.
 *
 * Elements after the removed index shift one cell left. The old last active
 * cell is cleared so it no longer keeps an unnecessary object reference.
 */
public class ArrayRemovalDemo {

    public static String remove(String[] data, int size, int index) {
        // Only active elements, indices 0 through size - 1, can be removed.
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }

        // Save the value before its cell is overwritten by shifting.
        String removedValue = data[index];

        // Copy each following element into the hole on its left.
        for (int position = index; position < size - 1; position++) {
            data[position] = data[position + 1];
        }

        // Clear the former last active cell.
        data[size - 1] = null;
        return removedValue;
    }

    public static String activeElements(String[] data, int size) {
        return Arrays.toString(Arrays.copyOf(data, size));
    }

    public static void main(String[] args) {
        String[] letters = {"A", "B", "C", "D", "E", null};
        int size = 5;

        System.out.println("Initial: " + activeElements(letters, size));

        // Removing the last active cell needs no shifting: O(1).
        String removed = remove(letters, size, size - 1);
        size--;
        System.out.println("Removed from end: " + removed);
        System.out.println("After end removal: "
                + activeElements(letters, size));

        // Removing index 1 shifts the later elements left: O(n).
        removed = remove(letters, size, 1);
        size--;
        System.out.println("Removed from middle: " + removed);
        System.out.println("After middle removal: "
                + activeElements(letters, size));

        // Removing index 0 shifts every remaining element: O(n).
        removed = remove(letters, size, 0);
        size--;
        System.out.println("Removed from beginning: " + removed);
        System.out.println("After beginning removal: "
                + activeElements(letters, size));
    }
}

/*
Expected output:
Initial: [A, B, C, D, E]
Removed from end: E
After end removal: [A, B, C, D]
Removed from middle: B
After middle removal: [A, C, D]
Removed from beginning: A
After beginning removal: [C, D]
*/
