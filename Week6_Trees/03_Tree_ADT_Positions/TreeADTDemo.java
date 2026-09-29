import java.util.ArrayList; // Concrete collection for children and positions.
import java.util.List;      // Return type for collections of positions.

/*
 * CONCEPT: A Tree ADT describes navigation and queries through Position<E>.
 * A position exposes an element without exposing the implementation's node.
 */
public class TreeADTDemo {

    // E is the generic element type stored by a position.
    private interface Position<E> {
        E getElement(); // Return the value associated with this position.
    }

    // This contract describes what a general tree supports.
    private interface Tree<E> {
        int size();                         // Number of positions/nodes.
        boolean isEmpty();                  // Whether size is zero.
        Position<E> root();                 // Root position or null.
        Position<E> parent(Position<E> p);  // Position directly above p.
        List<Position<E>> children(Position<E> p); // Positions below p.
        int numChildren(Position<E> p);     // Number of direct children.
        boolean isInternal(Position<E> p);  // At least one child.
        boolean isExternal(Position<E> p);  // No children.
        boolean isRoot(Position<E> p);      // Whether p is root.
    }

    private static class SimpleTree<E> implements Tree<E> {
        private static class Node<E> implements Position<E> {
            private E element;           // Value visible through Position.
            private Node<E> parent;       // Implementation detail.
            private List<Node<E>> children = new ArrayList<Node<E>>();

            public Node(E value, Node<E> parentNode) {
                element = value;         // Store the generic value.
                parent = parentNode;     // Store the upward link.
            }

            public E getElement() {
                return element;
            }
        }

        private Node<E> root; // Internal root node.
        private int size;     // Number of nodes created.

        /** Creates a tree containing one root. */
        public SimpleTree(E rootElement) {
            root = new Node<E>(rootElement, null);
            size = 1;
        }

        /** Adds a child under a position and returns its abstract position. */
        public Position<E> addChild(Position<E> p, E element) {
            Node<E> parentNode = (Node<E>) p; // Convert our own position back.
            Node<E> child = new Node<E>(element, parentNode);
            parentNode.children.add(child);   // Link child to parent.
            size++;
            return child;
        }

        public int size() { return size; }
        public boolean isEmpty() { return size == 0; }
        public Position<E> root() { return root; }
        public Position<E> parent(Position<E> p) { return ((Node<E>) p).parent; }

        public List<Position<E>> children(Position<E> p) {
            List<Position<E>> result = new ArrayList<Position<E>>();
            result.addAll(((Node<E>) p).children); // Upcast nodes to positions.
            return result;
        }

        public int numChildren(Position<E> p) { return ((Node<E>) p).children.size(); }
        public boolean isInternal(Position<E> p) { return numChildren(p) > 0; }
        public boolean isExternal(Position<E> p) { return numChildren(p) == 0; }
        public boolean isRoot(Position<E> p) { return p == root; }
    }

    /** Uses only positions and Tree ADT methods to query B. */
    public static void main(String[] args) {
        SimpleTree<String> tree = new SimpleTree<String>("A");
        Position<String> a = tree.root();
        Position<String> b = tree.addChild(a, "B");
        tree.addChild(a, "C");
        tree.addChild(b, "D");
        tree.addChild(b, "E");

        System.out.println("Size: " + tree.size());
        System.out.println("B parent: " + tree.parent(b).getElement());
        System.out.println("B child count: " + tree.numChildren(b));
        System.out.println("B is internal: " + tree.isInternal(b));
        System.out.println("A is root: " + tree.isRoot(a));
    }
}

/*
Expected output:
Size: 5
B parent: A
B child count: 2
B is internal: true
A is root: true
*/
