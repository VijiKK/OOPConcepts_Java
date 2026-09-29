/* CONCEPT: Preorder visits Root, then Left subtree, then Right subtree. */
public class PreorderDemo {
    private static class Node {
        private String element; // Value processed when this node is visited.
        private Node left;      // Root of the smaller left subtree.
        private Node right;     // Root of the smaller right subtree.
        public Node(String value) { element = value; }
    }

    /** Visits the root before recursively visiting either child subtree. */
    private static void preorder(Node node, StringBuilder order) {
        if (node == null) { return; }       // Base case: empty subtree.
        if (order.length() > 0) { order.append(" "); } // Separate labels.
        order.append(node.element);          // Root: visit current node first.
        preorder(node.left, order);          // Left: finish the left subtree.
        preorder(node.right, order);         // Right: finish the right subtree.
    }

    /** Builds the A-G sample tree and runs preorder. */
    public static void main(String[] args) {
        Node a = new Node("A"); // Root.
        a.left = new Node("B"); a.right = new Node("C");
        a.left.left = new Node("D"); a.left.right = new Node("E");
        a.right.left = new Node("F"); a.right.right = new Node("G");
        StringBuilder order = new StringBuilder(); // Collect without trailing space.
        preorder(a, order); // Expected visit order starts with A.
        System.out.println("Preorder: " + order);
    }
}

/* Expected output:
Preorder: A B D E C F G
*/
