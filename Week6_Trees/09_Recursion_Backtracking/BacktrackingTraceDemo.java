/*
 * CONCEPT: Recursive calls go down into subtrees and return to their caller.
 * D never calls E. D returns to B; then the waiting B call invokes E.
 */
public class BacktrackingTraceDemo {
    private static class Node {
        private String element; // Node label used in the trace.
        private Node left;      // First recursive destination.
        private Node right;     // Second recursive destination.
        public Node(String value) { element = value; }
    }

    /** Traces preorder call entry, child calls, and function return. */
    private static void tracePreorder(Node node) {
        if (node == null) { return; } // Missing children immediately return.
        System.out.println("Enter " + node.element + " and visit it");

        if (node.left != null) {
            System.out.println(node.element + " calls " + node.left.element);
            tracePreorder(node.left); // Caller waits until subtree returns.
            System.out.println("Returned to " + node.element);
        }

        if (node.right != null) {
            System.out.println(node.element + " calls " + node.right.element);
            tracePreorder(node.right);
            System.out.println("Returned to " + node.element);
        }
        System.out.println("Finish " + node.element); // Return to parent call.
    }

    /** Uses A with B's leaf children D and E for a compact trace. */
    public static void main(String[] args) {
        Node a = new Node("A");
        a.left = new Node("B");
        a.left.left = new Node("D");
        a.left.right = new Node("E");
        tracePreorder(a);
    }
}

/* Expected output:
Enter A and visit it
A calls B
Enter B and visit it
B calls D
Enter D and visit it
Finish D
Returned to B
B calls E
Enter E and visit it
Finish E
Returned to B
Finish B
Returned to A
Finish A
*/
