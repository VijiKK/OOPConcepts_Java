/*
 * CONCEPTS: A linked stack grows through nodes and a generic stack is reusable.
 *
 * The head node is the stack top. push inserts at the head and pop removes the
 * head, so both operations take O(1) time. The type parameter E lets the same
 * implementation store Integer, Float, String, or another reference type.
 */

// The ADT contract is included so this demonstration is self-contained.
interface StackADT<E> {
    int size();             // Return the number of stored E values.
    boolean isEmpty();      // Return true when size is zero.
    E top();                // Inspect the top E.
    void push(E element);   // Add an E to the top.
    E pop();                // Remove and return the top E.
}

// The same E flows through the stack class, its nodes, and all methods.
class LinkedStack<E> implements StackADT<E> {
    // static avoids giving every node a hidden reference to its outer stack.
    private static class Node<E> {
        private E element;    // Value stored in this node.
        private Node<E> next; // Reference to the node directly below it.

        /** Creates one node containing an element and a next reference. */
        public Node(E nodeElement, Node<E> nextNode) {
            element = nodeElement; // Save the supplied value.
            next = nextNode;       // Connect this node to the old top.
        }
    }

    private Node<E> topNode; // First node and current stack top.
    private int size;        // Number of linked nodes.

    /** Returns the number of linked nodes. */
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E top() {
        return isEmpty() ? null : topNode.element;
    }

    /** Inserts a new node at the head/top in O(1) time. */
    public void push(E element) {
        // The old top becomes the new node's next node.
        topNode = new Node<E>(element, topNode);
        size++; // Record the additional node.
    }

    /** Unlinks and returns the head/top node in O(1) time. */
    public E pop() {
        if (isEmpty()) {
            return null;
        }
        E removed = topNode.element; // Save the outgoing element.
        topNode = topNode.next;      // The second node becomes top.
        size--;                      // Record that one node was removed.
        return removed;
    }
}

public class LinkedStackDemo {

    /** Demonstrates that one generic implementation supports two types. */
    public static void main(String[] args) {
        // Here E is Integer.
        LinkedStack<Integer> integers = new LinkedStack<Integer>();
        integers.push(10);
        integers.push(20);

        // Here E is String; mixing Integer values would be a compile error.
        LinkedStack<String> words = new LinkedStack<String>();
        words.push("first");
        words.push("second");

        System.out.println("Integer top: " + integers.top());
        System.out.println("Integer pop: " + integers.pop());
        System.out.println("String top: " + words.top());
        System.out.println("String pop: " + words.pop());
    }
}

/*
Expected output:
Integer top: 20
Integer pop: 20
String top: second
String pop: second
*/
    /** Reports whether topNode is absent. */
    /** Returns the top element without unlinking its node. */
