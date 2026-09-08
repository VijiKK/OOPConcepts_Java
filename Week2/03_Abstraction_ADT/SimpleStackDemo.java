// SimpleStack is a small Abstract Data Type (ADT) with three public operations.
class SimpleStack {
    // These implementation details are hidden from users of SimpleStack.
    private int[] values = new int[5];
    // size is the item count and also the index of the next open position.
    private int size = 0;

    // push() adds one value to the top of the stack.
    public void push(int value) {
        // Store the value at the next open position.
        values[size] = value;
        size++; // Increase the item count after storing the value.
    }

    // pop() removes and returns the current top value.
    public int pop() {
        // Move back one position, then return the removed top value.
        size--;
        return values[size];
    }

    // top() returns the top value but does not change the stack.
    public int top() {
        // Look at the top value without removing it.
        return values[size - 1];
    }
}

public class SimpleStackDemo {
    // main() uses only the ADT operations, not the private implementation.
    public static void main(String[] args) {
        // The public operations are WHAT the stack can do.
        // The caller does not need to know HOW the internal array works.
        SimpleStack stack = new SimpleStack();
        // A stack is Last In, First Out: 20 will be removed before 10.
        stack.push(10);
        stack.push(20);
        System.out.println("Top: " + stack.top());
        System.out.println("Popped: " + stack.pop());
        System.out.println("New top: " + stack.top());
    }
}

/* Expected output:
Top: 20
Popped: 20
New top: 10
*/
