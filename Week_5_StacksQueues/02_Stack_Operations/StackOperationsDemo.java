import java.util.ArrayDeque; // Concrete resizable-array implementation.
import java.util.Deque;      // Interface that supports stack operations.

/*
 * CONCEPT: All stack insertion, removal, and inspection occur at the top.
 *
 * push adds a new top. pop returns and removes the top. peek/top returns the
 * top without removing it. Java's ArrayDeque provides these stack operations.
 */
public class StackOperationsDemo {

    /** Runs a step-by-step stack operation trace. */
    public static void main(String[] args) {
        // The variable uses the general Deque interface type.
        Deque<String> stack = new ArrayDeque<String>();

        // push places its argument at the stack's top.
        stack.push("A");
        System.out.println("After push(A): " + stack);

        stack.push("B"); // B becomes the new top.
        stack.push("C"); // C becomes the new top.
        System.out.println("After push(B), push(C): " + stack);

        // peek() corresponds to the deck's top(): inspect without removal.
        System.out.println("Top value: " + stack.peek());
        System.out.println("After top/peek: " + stack);

        // C entered last, so C leaves first: LIFO.
        System.out.println("Popped: " + stack.pop());
        System.out.println("After pop: " + stack);
        System.out.println("Size: " + stack.size());
        System.out.println("Empty: " + stack.isEmpty());

        stack.pop(); // Remove B, which is now on top.
        stack.pop(); // Remove A, leaving the stack empty.

        // poll() returns null when empty; pop() would throw an exception.
        System.out.println("Empty poll: " + stack.poll());
    }
}

/*
Expected output:
After push(A): [A]
After push(B), push(C): [C, B, A]
Top value: C
After top/peek: [C, B, A]
Popped: C
After pop: [B, A]
Size: 2
Empty: false
Empty poll: null
*/
