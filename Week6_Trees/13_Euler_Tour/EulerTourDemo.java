/*
 * CONCEPT: An Euler tour conceptually visits each binary node three times.
 * Left event = preorder, Below event = inorder, Right event = postorder.
 */
public class EulerTourDemo {
    private static class Node {
        private String element; // Label displayed at each event.
        private Node left;      // Left child/subtree.
        private Node right;     // Right child/subtree.
        public Node(String value) { element = value; }
    }

    /** Walks around a tree and reports all three processing opportunities. */
    private static void addEvent(StringBuilder trace, String event) {
        if (trace.length() > 0) { trace.append(" "); } // Separate events.
        trace.append(event);                           // Add one labeled event.
    }

    /** Walks around a tree and records all three processing opportunities. */
    private static void eulerTour(Node node, StringBuilder trace) {
        if (node == null) { return; } // Base case for absent child.
        addEvent(trace, "L(" + node.element + ")"); // Preorder event.
        eulerTour(node.left, trace);                  // Walk left subtree.
        addEvent(trace, "B(" + node.element + ")"); // Inorder event.
        eulerTour(node.right, trace);                 // Walk right subtree.
        addEvent(trace, "R(" + node.element + ")"); // Postorder event.
    }

    /** Uses A with leaves B and C to keep the three-event trace readable. */
    public static void main(String[] args) {
        Node a = new Node("A");
        a.left = new Node("B");
        a.right = new Node("C");
        StringBuilder trace = new StringBuilder(); // Collect without trailing space.
        eulerTour(a, trace);
        System.out.println(trace);
    }
}

/* Expected output:
L(A) L(B) B(B) R(B) B(A) L(C) B(C) R(C) R(A)
*/
