import java.util.Arrays;     // Formats arrays for readable output.
import java.util.ArrayDeque; // Supplies the concrete stack storage.
import java.util.Deque;      // Supplies push() and pop() operations.

/*
 * CONCEPT: Pushing values and then popping them reverses their order.
 *
 * The final item pushed becomes the first item popped. One generic method can
 * reverse arrays containing any reference type because it uses StackADT<E>.
 */
public class GenericReverseDemo {

    /**
     * Reverses one array in place.
     * <E> declares the method's element type; E[] is an array of that type.
     */
    public static <E> void reverse(E[] values) {
        // Deque<E> supplies type-safe stack operations for any reference type.
        Deque<E> stack = new ArrayDeque<E>();

        // Push from the array's beginning through its end.
        for (E value : values) { // value receives each array element in order.
            stack.push(value);
        }

        // Pop back into the array. LIFO produces reverse order.
        for (int index = 0; index < values.length; index++) {
            values[index] = stack.pop();
        }
    }

    /** Demonstrates type inference with Integer[] and String[]. */
    public static void main(String[] args) {
        // Integer and String are different choices for the method type E.
        Integer[] numbers = {1, 2, 3, 4};
        String[] words = {"red", "green", "blue"};

        reverse(numbers); // Java infers E as Integer.
        reverse(words);   // Java infers E as String.

        System.out.println("Reversed numbers: " + Arrays.toString(numbers));
        System.out.println("Reversed words: " + Arrays.toString(words));
    }
}

/*
Expected output:
Reversed numbers: [4, 3, 2, 1]
Reversed words: [blue, green, red]
*/
