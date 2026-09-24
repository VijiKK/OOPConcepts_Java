import java.util.ArrayDeque; // Efficient array-based Queue implementation.
import java.util.Queue;      // Standard Java FIFO interface.

/*
 * CONCEPT: java.util.Queue provides two method styles for boundary failures.
 *
 * add/remove/element throw an exception when their operation cannot succeed.
 * offer/poll/peek return a special value instead. For an empty queue, poll and
 * peek return null, matching the textbook Queue ADT's empty behavior.
 */
public class JavaQueueDemo {

    /** Compares exception-throwing and special-value queue methods. */
    public static void main(String[] args) {
        // Program to the Queue interface; choose ArrayDeque as implementation.
        Queue<String> queue = new ArrayDeque<String>();

        // offer corresponds to enqueue and reports success with a boolean.
        System.out.println("offer(A): " + queue.offer("A"));
        queue.offer("B"); // B waits behind A.
        queue.offer("C"); // C becomes the current rear.

        // peek corresponds to first: inspect without removal.
        System.out.println("peek(): " + queue.peek());

        // poll corresponds to dequeue: remove and return the front.
        System.out.println("poll(): " + queue.poll());
        System.out.println("After poll: " + queue);

        queue.poll(); // Remove B.
        queue.poll(); // Remove C; the queue is now empty.
        System.out.println("poll() when empty: " + queue.poll());
        System.out.println("peek() when empty: " + queue.peek());

        try { // remove(), unlike poll(), does not return null when empty.
            queue.remove();
        } catch (java.util.NoSuchElementException exception) {
            // Catch the standard exception so the demonstration can continue.
            System.out.println("remove() when empty throws NoSuchElementException");
        }
    }
}

/*
Expected output:
offer(A): true
peek(): A
poll(): A
After poll: [B, C]
poll() when empty: null
peek() when empty: null
remove() when empty throws NoSuchElementException
*/
