/* CONCEPT: Postorder visits Left subtree, Right subtree, then Root. */
public class PostorderDemo {
    private static class Node {
        private String element; // Value printed after descendants.
        private Node left;      // Left subtree reference.
        private Node right;     // Right subtree reference.
        public Node(String value) { element = value; }
    }

    /** Visits the current node only after both child subtrees finish. */
    private static void postorder(Node node, StringBuilder order) {
        if (node == null) { return; }       // Base case: empty subtree.
        postorder(node.left, order);        // Finish all left descendants.
        postorder(node.right, order);       // Finish all right descendants.
        if (order.length() > 0) { order.append(" "); } // Separate labels.
        order.append(node.element);         // Root is processed last.
    }

    /** Builds the A-G tree and demonstrates descendant-before-parent order. */
    public static void main(String[] args) {
        Node a = new Node("A");
        a.left = new Node("B"); a.right = new Node("C");
        a.left.left = new Node("D"); a.left.right = new Node("E");
        a.right.left = new Node("F"); a.right.right = new Node("G");
        StringBuilder order = new StringBuilder();
        postorder(a, order); // A is added only after all six descendants.
        System.out.println("Postorder: " + order);
    }
}

/* Expected output:
Postorder: D E B F G C A
*/
