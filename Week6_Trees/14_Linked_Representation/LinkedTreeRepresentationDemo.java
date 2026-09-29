/*
 * CONCEPT: A linked binary node stores references to other node objects.
 * The links do not contain copies. A leaf's left and right references are null.
 */
public class LinkedTreeRepresentationDemo {
    private static class Node<E> {
        private E element;      // Generic data stored at this node.
        private Node<E> parent; // Optional upward link.
        private Node<E> left;   // Reference to left child object.
        private Node<E> right;  // Reference to right child object.

        public Node(E value, Node<E> parentNode) {
            element = value;     // Save data of type E.
            parent = parentNode; // Save upward reference.
        }
    }

    /** Connects A to B/C and C to F/G, then inspects references. */
    public static void main(String[] args) {
        Node<String> a = new Node<String>("A", null); // Root.
        Node<String> b = new Node<String>("B", a);
        Node<String> c = new Node<String>("C", a);
        a.left = b;  // Store B's reference, not a copy of B.
        a.right = c; // Store C's reference.

        Node<String> f = new Node<String>("F", c);
        Node<String> g = new Node<String>("G", c);
        c.left = f;  // C's left field points to the F object.
        c.right = g; // C's right field points to the G object.

        System.out.println("C data: " + c.element);
        System.out.println("C parent: " + c.parent.element);
        System.out.println("C left/right: " + c.left.element + "/" + c.right.element);
        System.out.println("F is leaf: " + (f.left == null && f.right == null));
        System.out.println("A.right and C are same object: " + (a.right == c));
    }
}

/* Expected output:
C data: C
C parent: A
C left/right: F/G
F is leaf: true
A.right and C are same object: true
*/
