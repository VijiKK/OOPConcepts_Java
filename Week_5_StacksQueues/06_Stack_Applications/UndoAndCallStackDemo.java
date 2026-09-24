import java.util.ArrayDeque; // Concrete structure used for undo history.
import java.util.Deque;      // Interface exposing stack operations.

/*
 * CONCEPT: Stacks serve the most recent action or method call first.
 *
 * Undo history is an explicit stack we manage. The JVM call stack is managed
 * automatically: each method call pushes a frame and returning pops it.
 */
public class UndoAndCallStackDemo {

    /** Builds an undo stack and removes the most recent action. */
    public static void demonstrateUndo() {
        Deque<String> undoHistory = new ArrayDeque<String>();
        undoHistory.push("Typed a word");       // Oldest action.
        undoHistory.push("Made the word bold"); // Newer action.
        undoHistory.push("Deleted a line");     // Most recent action/top.

        System.out.println("Undo: " + undoHistory.pop());
        System.out.println("Next undo: " + undoHistory.peek());
    }

    /** Represents foo(): its JVM frame waits while bar() executes. */
    public static void mainCallsFoo() {
        System.out.println("Enter foo");
        fooCallsBar();
        System.out.println("Return to foo");
    }

    /** Represents bar(), the newest and therefore top JVM stack frame. */
    public static void fooCallsBar() {
        System.out.println("Enter bar");
        System.out.println("Return from bar");
    }

    /** Runs both the explicit undo stack and implicit JVM call stack examples. */
    public static void main(String[] args) {
        demonstrateUndo();
        System.out.println("Enter main");
        mainCallsFoo();
        System.out.println("Return to main");
    }
}

/*
Expected output:
Undo: Deleted a line
Next undo: Made the word bold
Enter main
Enter foo
Enter bar
Return from bar
Return to foo
Return to main
*/
