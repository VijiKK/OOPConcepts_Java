/* CONCEPT: Inorder visits Left subtree, then Root, then Right subtree. */
public class InorderDemo {
    private static class Node {
        private String element; // Value printed when visit occurs.
        private Node left;      // Ordered left child.
        private Node right;     // Ordered right child.
        public Node(String value) { element = value; }
    }

    /** Visits the current node between its left and right recursive calls. */
    private static void inorder(Node node, StringBuilder order) {
        if (node == null) { return; }       // Base case: no node to process.
        inorder(node.left, order);          // Left subtree comes first.
        if (order.length() > 0) { order.append(" "); } // Separate labels.
        order.append(node.element);         // Root comes in the middle.
        inorder(node.right, order);         // Right subtree comes last.
    }

    /** Builds the same A-G tree used for every traversal comparison. */
    public static void main(String[] args) {
        Node a = new Node("A");
        a.left = new Node("B"); a.right = new Node("C");
        a.left.left = new Node("D"); a.left.right = new Node("E");
        a.right.left = new Node("F"); a.right.right = new Node("G");
        StringBuilder order = new StringBuilder();
        inorder(a, order); // A appears between its complete left/right subtrees.
        System.out.println("Inorder: " + order);
    }
}

/* Expected output:
Inorder: D B E A F C G
*/
