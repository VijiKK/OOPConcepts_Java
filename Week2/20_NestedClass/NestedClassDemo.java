// The outer class groups the Node helper with the structure that uses it.
class LinkedListExample {
    // Node is declared inside LinkedListExample because it is a helper for it.
    // static means a Node does not require a LinkedListExample object to exist.
    static class Node {
        // Each node stores data and a reference to the next node.
        String data;
        Node next;

        Node(String data) {
            // Initialize this node's data; next remains null until it is linked.
            this.data = data;
        }
    }

    // This method creates just enough structure to demonstrate linked nodes.
    void showTwoNodes() {
        // These are two separate Node objects.
        Node first = new Node("Alice");
        Node second = new Node("Ben");
        // Connecting first to second creates a tiny two-node chain.
        first.next = second;

        // Follow fields directly, then follow the next reference to the second node.
        System.out.println("First node: " + first.data);
        System.out.println("Next node: " + first.next.data);
    }
}

public class NestedClassDemo {
    // main() asks the outer class to create and display its nodes.
    public static void main(String[] args) {
        // Create an object of the outer class.
        LinkedListExample example = new LinkedListExample();
        // Call the outer object's demonstration method.
        example.showTwoNodes();
    }
}

/* Expected output:
First node: Alice
Next node: Ben
*/
