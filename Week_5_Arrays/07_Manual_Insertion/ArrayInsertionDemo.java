import java.util.Arrays;

/*
 * CONCEPT: Inserting into an array may require shifting elements right.
 *
 * The physical array length is the capacity. The logical size counts only
 * meaningful elements. An unused cell must exist before insertion can occur.
 */
public class ArrayInsertionDemo {

    public static int insert(String[] data, int size,
            int index, String value) {
        // Valid insertion positions range from 0 through size.
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }

        // A fixed array cannot accept another element when every cell is used.
        if (size == data.length) {
            throw new IllegalStateException("The array is full.");
        }

        /*
         * Work backward so a value is not overwritten before it is copied.
         * Move data[size - 1] first, then continue toward the insertion index.
         */
        for (int position = size; position > index; position--) {
            data[position] = data[position - 1];
        }

        // The shift created an open cell at index.
        data[index] = value;
        return size + 1;
    }

    public static String activeElements(String[] data, int size) {
        return Arrays.toString(Arrays.copyOf(data, size));
    }

    public static void main(String[] args) {
        String[] letters = new String[7];
        letters[0] = "A";
        letters[1] = "B";
        letters[2] = "C";
        letters[3] = "D";
        int size = 4;

        System.out.println("Initial: " + activeElements(letters, size));

        // End insertion performs no shifts when free capacity exists: O(1).
        size = insert(letters, size, size, "E");
        System.out.println("After end insertion: "
                + activeElements(letters, size));

        // Middle insertion shifts the elements at and after index 2: O(n).
        size = insert(letters, size, 2, "X");
        System.out.println("After middle insertion: "
                + activeElements(letters, size));

        // Beginning insertion shifts every existing element: O(n).
        size = insert(letters, size, 0, "Z");
        System.out.println("After beginning insertion: "
                + activeElements(letters, size));
    }
}

/*
Expected output:
Initial: [A, B, C, D]
After end insertion: [A, B, C, D, E]
After middle insertion: [A, B, X, C, D, E]
After beginning insertion: [Z, A, B, X, C, D, E]
*/
