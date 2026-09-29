import java.util.ArrayList; // Stores a general node's children.
import java.util.List;      // Interface for ordered child collections.

/*
 * CONCEPT: Root, parent, child, sibling, internal/leaf, ancestor, descendant,
 * subtree, depth, and height describe relationships or positions in a tree.
 */
public class TreeTerminologyDemo {

    private static class Node {
        private String element;      // Label held by this node.
        private Node parent;         // null only for the root.
        private List<Node> children; // Nodes directly below this node.

        /** Creates a node and records its parent reference. */
        public Node(String nodeElement, Node parentNode) {
            element = nodeElement;            // Store the label.
            parent = parentNode;              // Link upward toward the root.
            children = new ArrayList<Node>(); // Begin with no children.
        }

        /** Adds one child whose parent is this node. */
        public Node addChild(String childElement) {
            Node child = new Node(childElement, this); // this becomes parent.
            children.add(child);                       // Link child downward.
            return child;
        }

        /** A node is internal when it has at least one child. */
        public boolean isInternal() {
            return !children.isEmpty();
        }

        /** A node is external/a leaf when it has no children. */
        public boolean isLeaf() {
            return children.isEmpty();
        }
    }

    /** Counts parent links from a node to the root. */
    private static int depth(Node node) {
        int result = 0;                  // Root depth would remain zero.
        Node current = node.parent;      // Begin with the first ancestor.
        while (current != null) {        // Stop after moving above the root.
            result++;                    // Count this ancestor.
            current = current.parent;    // Continue one level upward.
        }
        return result;
    }

    /** Returns the greatest number of edges below this node. */
    private static int height(Node node) {
        if (node.isLeaf()) {             // Base case: a leaf has no lower edge.
            return 0;
        }
        int greatestChildHeight = 0;     // Track the deepest child subtree.
        for (Node child : node.children) {
            greatestChildHeight = Math.max(greatestChildHeight, height(child));
        }
        return 1 + greatestChildHeight;  // Add the edge to that child.
    }

    /** Returns ancestor labels from parent upward to root. */
    private static String ancestors(Node node) {
        List<String> labels = new ArrayList<String>();
        Node current = node.parent;
        while (current != null) {
            labels.add(current.element); // Record this ancestor.
            current = current.parent;    // Walk upward.
        }
        return labels.toString();
    }

    /** Builds the narration's A-H tree and queries node F. */
    public static void main(String[] args) {
        Node a = new Node("A", null); // Root has no parent.
        Node b = a.addChild("B");     // B and C are siblings.
        Node c = a.addChild("C");
        b.addChild("D");              // D and E are leaves below B.
        b.addChild("E");
        Node f = c.addChild("F");     // F is internal at depth 2.
        f.addChild("G");              // G and H are sibling leaves.
        f.addChild("H");

        System.out.println("Root: " + a.element);
        System.out.println("F parent: " + f.parent.element);
        System.out.println("F children: " + f.children.get(0).element
                + ", " + f.children.get(1).element);
        System.out.println("F is internal: " + f.isInternal());
        System.out.println("F depth: " + depth(f));
        System.out.println("F ancestors: " + ancestors(f));
        System.out.println("Tree height: " + height(a));
        System.out.println("D is a leaf: " + b.children.get(0).isLeaf());
    }
}

/*
Expected output:
Root: A
F parent: C
F children: G, H
F is internal: true
F depth: 2
F ancestors: [C, A]
Tree height: 3
D is a leaf: true
*/
