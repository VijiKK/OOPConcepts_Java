/*
 * CONCEPT: In a proper binary tree, every internal node has exactly two
 * children. This example verifies the mathematical relationships from the deck.
 */
public class ProperBinaryPropertiesDemo {
    private static class Node {
        private Node left;  // First ordered child.
        private Node right; // Second ordered child.
    }

    /** Counts all nodes recursively. */
    private static int countNodes(Node node) {
        return node == null ? 0 : 1 + countNodes(node.left) + countNodes(node.right);
    }

    /** Counts nodes that have no children. */
    private static int countExternal(Node node) {
        if (node.left == null && node.right == null) { return 1; }
        return countExternal(node.left) + countExternal(node.right);
    }

    /** Counts nodes that have children. */
    private static int countInternal(Node node) {
        if (node.left == null && node.right == null) { return 0; }
        return 1 + countInternal(node.left) + countInternal(node.right);
    }

    /** Returns maximum root-to-leaf edge count. */
    private static int height(Node node) {
        if (node.left == null && node.right == null) { return 0; }
        return 1 + Math.max(height(node.left), height(node.right));
    }

    /** Creates a perfect seven-node tree, which is also proper. */
    public static void main(String[] args) {
        Node root = new Node();               // Level 0.
        root.left = new Node(); root.right = new Node(); // Level 1.
        root.left.left = new Node(); root.left.right = new Node();
        root.right.left = new Node(); root.right.right = new Node(); // Level 2.

        int n = countNodes(root);       // Total nodes.
        int e = countExternal(root);    // Leaf/external nodes.
        int i = countInternal(root);    // Internal nodes.
        int h = height(root);           // Maximum depth.

        System.out.println("n/e/i/h: " + n + "/" + e + "/" + i + "/" + h);
        System.out.println("e = i + 1: " + (e == i + 1));
        System.out.println("n = 2e - 1: " + (n == 2 * e - 1));
        System.out.println("e <= 2^h: " + (e <= Math.pow(2, h)));
    }
}

/* Expected output:
n/e/i/h: 7/4/3/2
e = i + 1: true
n = 2e - 1: true
e <= 2^h: true
*/
