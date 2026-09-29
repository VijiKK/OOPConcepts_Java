import java.util.Arrays; // Displays the complete physical array.

/*
 * CONCEPT: In an array representation, indices encode relationships.
 * left(i)=2i+1, right(i)=2i+2, parent(i)=(i-1)/2 using integer division.
 */
public class ArrayTreeRepresentationDemo {

    /** Calculates the left-child index for a parent index. */
    private static int leftIndex(int index) { return 2 * index + 1; }

    /** Calculates the right-child index for a parent index. */
    private static int rightIndex(int index) { return 2 * index + 2; }

    /** Calculates a non-root node's parent index. */
    private static int parentIndex(int index) { return (index - 1) / 2; }

    /** Stores a complete A-G tree and demonstrates each formula. */
    public static void main(String[] args) {
        String[] tree = {"A", "B", "C", "D", "E", "F", "G"};
        int bIndex = 1; // B is the root's left child.
        int cIndex = 2; // C is the root's right child.
        int gIndex = 6; // G is the right child of C.

        System.out.println("Array: " + Arrays.toString(tree));
        System.out.println("B left: index " + leftIndex(bIndex)
                + " = " + tree[leftIndex(bIndex)]);
        System.out.println("B right: index " + rightIndex(bIndex)
                + " = " + tree[rightIndex(bIndex)]);
        System.out.println("C left/right indices: " + leftIndex(cIndex)
                + "/" + rightIndex(cIndex));
        System.out.println("G parent: index " + parentIndex(gIndex)
                + " = " + tree[parentIndex(gIndex)]);
    }
}

/* Expected output:
Array: [A, B, C, D, E, F, G]
B left: index 3 = D
B right: index 4 = E
C left/right indices: 5/6
G parent: index 2 = C
*/
