import java.util.ArrayList; // Resizable collection for a node's children.
import java.util.List;      // General interface used for child collections.

/*
 * CONCEPT: A tree represents hierarchical data through parent-child links.
 * Unlike an array or linked list, one node can branch to several children.
 */
public class TreeHierarchyDemo {

    // A general-tree node can have any number of children.
    private static class Node {
        private String element;      // Information stored at this node.
        private List<Node> children; // References to child node objects.

        /** Creates a leaf node whose child list starts empty. */
        public Node(String nodeElement) {
            element = nodeElement;              // Save the supplied label.
            children = new ArrayList<Node>();   // No children initially.
        }

        /** Creates, connects, and returns one new child. */
        public Node addChild(String childElement) {
            Node child = new Node(childElement); // Allocate a separate object.
            children.add(child);                 // Link it below this node.
            return child;                        // Let the caller extend it.
        }
    }

    /** Prints a node and recursively prints every smaller child subtree. */
    private static void printTree(Node node, int depth) {
        System.out.println("  ".repeat(depth) + node.element); // Indent by level.
        for (Node child : node.children) { // Visit children from left to right.
            printTree(child, depth + 1);   // Child subtree is one level deeper.
        }
    }

    /** Builds and displays an organization hierarchy. */
    public static void main(String[] args) {
        Node ceo = new Node("CEO");         // Root at depth/level 0.
        Node sales = ceo.addChild("Sales"); // First department at level 1.
        Node engineering = ceo.addChild("Engineering");
        ceo.addChild("HR");

        sales.addChild("Regional Sales");   // Level 2 below Sales.
        engineering.addChild("Software");   // Level 2 below Engineering.
        engineering.addChild("Quality Assurance");

        printTree(ceo, 0); // Begin the recursive display at the root.
    }
}

/*
Expected output:
CEO
  Sales
    Regional Sales
  Engineering
    Software
    Quality Assurance
  HR
*/
