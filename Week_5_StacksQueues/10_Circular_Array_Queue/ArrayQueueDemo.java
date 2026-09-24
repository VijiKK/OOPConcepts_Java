import java.util.Arrays; // Formats the physical storage array for display.

/*
 * CONCEPT: A circular array queue reuses cells without shifting elements.
 *
 * front is the index of the first queue element. size counts active elements.
 * The next rear position is (front + size) % capacity. Modulo wraps an index
 * from the end of the physical array back to index 0.
 */

interface QueueADT<E> {
    int size();              // Number of elements currently queued.
    boolean isEmpty();       // true when size is zero.
    E first();               // Inspect the front E.
    void enqueue(E element); // Insert an E at the rear.
    E dequeue();             // Remove and return the front E.
}

// This implementation uses indices rather than linked nodes.
class ArrayQueue<E> implements QueueADT<E> {
    private E[] data;  // Fixed-capacity physical storage.
    private int front; // Index of the logical first element.
    private int size;  // Number of active elements, not array capacity.

    /** Creates an empty circular queue with a fixed capacity. */
    @SuppressWarnings("unchecked")
    public ArrayQueue(int capacity) {
        data = (E[]) new Object[capacity];
        front = 0; // Index 0 is the first possible front position.
        size = 0;  // No cells contain queue elements yet.
    }

    /** Returns the logical number of queued elements. */
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E first() {
        return isEmpty() ? null : data[front];
    }

    /** Inserts at the calculated rear position in O(1) time. */
    public void enqueue(E element) {
        if (size == data.length) {
            throw new IllegalStateException("Queue is full");
        }

        // % wraps a value at data.length back into the valid index range.
        int available = (front + size) % data.length;
        data[available] = element; // Fill the first logical position after rear.
        size++;                    // The front does not move during enqueue.
    }

    /** Removes the front element and advances front in O(1) time. */
    public E dequeue() {
        if (isEmpty()) {
            return null;
        }

        E removed = data[front]; // Save the outgoing front value.
        data[front] = null; // Release the removed object reference.
        front = (front + 1) % data.length; // Move and wrap if necessary.
        size--;                            // One fewer active element.
        return removed;
    }

    /** Shows the physical cells plus the logical front and size. */
    public String storageView() {
        return Arrays.toString(data)
                + ", front = " + front + ", size = " + size;
    }
}

public class ArrayQueueDemo {

    /** Demonstrates dequeue reuse, wrap-around, and a full queue. */
    public static void main(String[] args) {
        ArrayQueue<String> queue = new ArrayQueue<String>(5);
        queue.enqueue("A"); // Stored at index 0.
        queue.enqueue("B"); // Stored at index 1.
        queue.enqueue("C"); // Stored at index 2.
        System.out.println("After enqueue: " + queue.storageView());

        System.out.println("Dequeued: " + queue.dequeue());
        System.out.println("After dequeue: " + queue.storageView());

        queue.enqueue("D"); // Stored at index 3.
        queue.enqueue("E"); // Stored at index 4.
        queue.enqueue("F"); // Wraps around and uses index 0.
        System.out.println("After wrap-around: " + queue.storageView());

        try {
            queue.enqueue("G");
        } catch (IllegalStateException exception) {
            System.out.println("Enqueue G failed: " + exception.getMessage());
        }
    }
}

/*
Expected output:
After enqueue: [A, B, C, null, null], front = 0, size = 3
Dequeued: A
After dequeue: [null, B, C, null, null], front = 1, size = 2
After wrap-around: [F, B, C, D, E], front = 1, size = 5
Enqueue G failed: Queue is full
*/
    /** Returns true when there are no logical elements. */
    /** Returns the front value without moving the front index. */
