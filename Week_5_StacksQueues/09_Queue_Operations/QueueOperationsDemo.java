/*
 * CONCEPT: A queue follows First In, First Out (FIFO).
 *
 * enqueue adds at the rear. dequeue removes from the front. first examines the
 * front without removing it. This linked implementation keeps both front and
 * rear references so enqueue and dequeue each run in O(1) time.
 */

interface QueueADT<E> {
    int size();              // Return the number of queued elements.
    boolean isEmpty();       // Return true when the queue has no elements.
    E first();               // Inspect the front E without removing it.
    void enqueue(E element); // Add an E at the rear.
    E dequeue();             // Remove and return the front E.
}

// E keeps the queue type-safe while allowing different element types.
class LinkedQueue<E> implements QueueADT<E> {
    // Each node stores one element and the node behind it in the queue.
    private static class Node<E> {
        private E element;    // Value stored in this node.
        private Node<E> next; // Next node toward the queue rear.

        /** Creates an unlinked node containing one element. */
        public Node(E nodeElement) {
            element = nodeElement; // Save the caller's value.
        }
    }

    private Node<E> front; // Node that dequeue removes next.
    private Node<E> rear;  // Node after which enqueue adds.
    private int size;      // Number of nodes currently linked.

    /** Returns the number of nodes. */
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E first() {
        return isEmpty() ? null : front.element;
    }

    /** Links a new node at the rear in O(1) time. */
    public void enqueue(E element) {
        Node<E> newest = new Node<E>(element); // Future rear node.
        if (isEmpty()) {
            front = newest; // The first node is also the front.
        } else {
            rear.next = newest; // Old rear now points to new rear.
        }
        rear = newest; // Update the stored rear reference.
        size++;        // Record the additional element.
    }

    /** Unlinks and returns the front node in O(1) time. */
    public E dequeue() {
        if (isEmpty()) {
            return null;
        }

        E removed = front.element; // Save the value before unlinking.
        front = front.next;        // Second node becomes the front.
        size--;                    // Record the removal.
        if (size == 0) {
            rear = null; // Removing the only node also clears the rear.
        }
        return removed;
    }
}

public class QueueOperationsDemo {

    /** Walks through FIFO operations and an empty-queue boundary case. */
    public static void main(String[] args) {
        // String replaces E, so only String elements are accepted.
        QueueADT<String> queue = new LinkedQueue<String>();
        queue.enqueue("A"); // First arrival and current front.
        queue.enqueue("B"); // Joins behind A.
        queue.enqueue("C"); // Joins at the rear.

        System.out.println("Front: " + queue.first());
        System.out.println("Dequeued: " + queue.dequeue());
        System.out.println("New front: " + queue.first());
        System.out.println("Size: " + queue.size());

        queue.dequeue();
        queue.dequeue();
        System.out.println("Dequeue from empty: " + queue.dequeue());
    }
}

/*
Expected output:
Front: A
Dequeued: A
New front: B
Size: 2
Dequeue from empty: null
*/
    /** Returns true when the queue contains no nodes. */
    /** Returns the front value without changing links. */
