/*
 * CONCEPT: An Abstract Data Type (ADT) describes behavior, not storage.
 *
 * A stack ADT specifies LIFO operations such as push and pop. A queue ADT
 * specifies FIFO operations such as enqueue and dequeue. Neither contract says
 * whether an array or linked structure must store the elements.
 */

// <E> declares a generic type parameter. E means "the element type."
interface StackADT<E> {
    int size();              // Return the number of stored elements.
    boolean isEmpty();       // Report whether the stack contains zero elements.
    E top();                 // Return the top E without removing it.
    void push(E element);    // Add one E to the top.
    E pop();                 // Remove and return the top E.
}

// This second generic contract describes FIFO queue behavior.
interface QueueADT<E> {
    int size();              // Return the number of queued elements.
    boolean isEmpty();       // Report whether the queue contains zero elements.
    E first();               // Return the front E without removing it.
    void enqueue(E element); // Add one E at the rear.
    E dequeue();             // Remove and return the front E.
}

public class ADTComparisonDemo {

    /** Program entry point that prints the two ADT contracts. */
    public static void main(String[] args) {
        // These statements describe access order, not a storage implementation.
        System.out.println("Stack rule: Last In, First Out (LIFO)");
        System.out.println("Stack operations: push, pop, top");
        System.out.println("Queue rule: First In, First Out (FIFO)");
        System.out.println("Queue operations: enqueue, dequeue, first");

        /*
         * The interfaces above contain no fields and no implementation code.
         * Later classes can satisfy these contracts with arrays or nodes.
         */
    }
}

/*
Expected output:
Stack rule: Last In, First Out (LIFO)
Stack operations: push, pop, top
Queue rule: First In, First Out (FIFO)
Queue operations: enqueue, dequeue, first
*/
