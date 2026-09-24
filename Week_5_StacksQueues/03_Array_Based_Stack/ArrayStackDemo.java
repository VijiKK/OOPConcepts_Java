import java.util.Arrays; // Supplies Arrays.toString() for displaying storage.

/*
 * CONCEPT: Implement the Stack ADT with a fixed-length array.
 *
 * top stores the index of the current top element. An empty stack uses -1.
 * push increments top before storing; pop reads and clears the current cell,
 * then decrements top. Each operation uses O(1) time and no shifting.
 */

// The ADT contract is repeated here so this folder compiles independently.
interface StackADT<E> {
    int size();             // Number of elements currently stored.
    boolean isEmpty();      // true when the stack has no elements.
    E top();                // Inspect the newest element without removal.
    void push(E element);   // Add an element at the top.
    E pop();                // Remove and return the top element.
}

// <E> makes this one class reusable for String, Integer, Student, and so on.
class ArrayStack<E> implements StackADT<E> {
    private E[] data; // Fixed-length array that stores references of type E.
    private int top;  // Index of top element; -1 means there is no element.

    /** Creates an empty stack with the requested fixed capacity. */
    @SuppressWarnings("unchecked")
    public ArrayStack(int capacity) {
        // Java cannot directly create new E[], so create Object[] and cast.
        data = (E[]) new Object[capacity];
        top = -1; // No valid array index is currently the stack top.
    }

    /** Returns the logical number of stack elements. */
    @Override
    public int size() {
        // If top is -1, size is 0; if top is 0, size is 1, and so on.
        return top + 1;
    }

    /** Returns true exactly when no valid top index exists. */
    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    /** Returns the top element without changing the stack. */
    @Override
    public E top() {
        // The conditional operator prevents an invalid data[-1] access.
        return isEmpty() ? null : data[top];
    }

    /** Adds one element in O(1) time, or throws when the array is full. */
    @Override
    public void push(E element) {
        if (size() == data.length) {
            // Capacity belongs to this implementation, not the Stack ADT.
            throw new IllegalStateException("Stack is full");
        }

        top++;               // Move to the next unused array position.
        data[top] = element; // Store the new top element in that position.
    }

    /** Removes and returns the top element in O(1) time. */
    @Override
    public E pop() {
        if (isEmpty()) {
            return null;
        }

        E removed = data[top]; // Save the value before clearing its cell.
        data[top] = null; // Release the object reference for garbage collection.
        top--;             // The preceding element becomes the new top.
        return removed;    // Give the saved element to the caller.
    }

    /** Returns the physical array and top index for classroom inspection. */
    public String storageView() {
        return Arrays.toString(data) + ", top index = " + top;
    }
}

public class ArrayStackDemo {

    /** Builds a capacity-three String stack and exercises its boundaries. */
    public static void main(String[] args) {
        // String replaces E, so this object accepts and returns only Strings.
        ArrayStack<String> stack = new ArrayStack<String>(3);
        System.out.println("Initially: " + stack.storageView());

        stack.push("A"); // Stored at index 0.
        stack.push("B"); // Stored at index 1.
        stack.push("C"); // Stored at index 2; the array is now full.
        System.out.println("Full stack: " + stack.storageView());
        System.out.println("Top: " + stack.top());

        try { // Run an operation that may throw an exception.
            stack.push("D");
        } catch (IllegalStateException exception) { // Handle the full condition.
            System.out.println("Push D failed: " + exception.getMessage());
        }

        System.out.println("Popped: " + stack.pop());
        System.out.println("After pop: " + stack.storageView());
    }
}

/*
Expected output:
Initially: [null, null, null], top index = -1
Full stack: [A, B, C], top index = 2
Top: C
Push D failed: Stack is full
Popped: C
After pop: [A, B, null], top index = 1
*/
