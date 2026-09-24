import java.util.ArrayDeque; // Implements both Deque and Queue efficiently.
import java.util.Deque;      // Used here for LIFO stack behavior.
import java.util.Queue;      // Used here for FIFO scheduling behavior.

/*
 * CONCEPTS: Queue-based round robin and the stack/queue ordering difference.
 *
 * A scheduler removes the process at the queue front, gives it one turn, then
 * returns unfinished work to the rear. The same arrival order in a stack would
 * instead serve the most recently added process first.
 */
public class RoundRobinDemo {

    /** Gives each process a turn, then compares FIFO and LIFO access. */
    public static void main(String[] args) {
        Queue<String> processes = new ArrayDeque<String>();
        processes.offer("P1"); // First process waiting.
        processes.offer("P2"); // Second process waiting.
        processes.offer("P3"); // Third process waiting.

        System.out.println("Round-robin turns:");
        for (int turn = 1; turn <= 5; turn++) {
            // Remove the process that has waited the longest.
            String current = processes.poll();
            System.out.println("Turn " + turn + ": " + current);
            // Put unfinished work at the rear so others receive turns first.
            processes.offer(current);
        }
        System.out.println("Queue after five turns: " + processes);

        // Build fresh structures with the same arrival order for comparison.
        Queue<String> comparisonQueue = new ArrayDeque<String>();
        comparisonQueue.offer("P1"); // Queue front remains P1.
        comparisonQueue.offer("P2");
        comparisonQueue.offer("P3"); // Queue rear becomes P3.

        Deque<String> stack = new ArrayDeque<String>();
        stack.push("P1"); // Oldest item moves toward the stack bottom.
        stack.push("P2");
        stack.push("P3"); // Newest item becomes the stack top.

        System.out.println("Queue serves first arrival: "
                + comparisonQueue.peek());
        System.out.println("Stack serves last arrival: " + stack.peek());
    }
}

/*
Expected output:
Round-robin turns:
Turn 1: P1
Turn 2: P2
Turn 3: P3
Turn 4: P1
Turn 5: P2
Queue after five turns: [P3, P1, P2]
Queue serves first arrival: P1
Stack serves last arrival: P3
*/
