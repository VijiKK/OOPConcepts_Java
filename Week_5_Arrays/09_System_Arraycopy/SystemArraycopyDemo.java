import java.util.Arrays;

/*
 * CONCEPT: System.arraycopy() can shift a block of array elements.
 *
 * Its arguments are:
 * System.arraycopy(source, sourceStart, destination, destinationStart, count)
 * The same array may be both source and destination, even when ranges overlap.
 */
public class SystemArraycopyDemo {

    public static void main(String[] args) {
        String[] data = {"A", "B", "C", "D", null, null};
        int size = 4;

        // Insert X at index 2 by shifting C and D one position right.
        int insertIndex = 2;
        int elementsToShift = size - insertIndex;
        System.arraycopy(data, insertIndex,
                data, insertIndex + 1, elementsToShift);
        data[insertIndex] = "X";
        size++;

        System.out.println("After insertion: "
                + Arrays.toString(Arrays.copyOf(data, size)));

        // Remove index 1 by copying all following values one cell left.
        int removeIndex = 1;
        String removed = data[removeIndex];
        elementsToShift = size - removeIndex - 1;
        System.arraycopy(data, removeIndex + 1,
                data, removeIndex, elementsToShift);
        size--;
        data[size] = null;

        System.out.println("Removed: " + removed);
        System.out.println("After removal: "
                + Arrays.toString(Arrays.copyOf(data, size)));

        // arraycopy is efficient, but moving n elements is still O(n).
    }
}

/*
Expected output:
After insertion: [A, B, X, C, D]
Removed: B
After removal: [A, X, C, D]
*/
