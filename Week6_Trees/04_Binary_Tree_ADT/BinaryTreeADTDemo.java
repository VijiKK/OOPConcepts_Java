/*
 * CONCEPT: A binary node has at most two ordered child positions: left/right.
 * Swapping the same two child values changes the binary-tree structure.
 */
public class BinaryTreeADTDemo {

    private static class Node<E> {
        private E element;      // Value stored at this position.
        private Node<E> parent; // Upward reference; null for root.
        private Node<E> left;   // Ordered left-child position.
        private Node<E> right;  // Ordered right-child position.

        public Node(E value, Node<E> parentNode) {
            element = value;    // Store the caller's value.
            parent = parentNode; // Record the parent relationship.
        }
    }

    /** Returns p's sibling, or null for a root/only child. */
    private static <E> Node<E> sibling(Node<E> p) {
        if (p.parent == null) {             // Root has no parent or sibling.
            return null;
        }
        if (p == p.parent.left) {           // p occupies the left position.
            return p.parent.right;          // Sibling occupies the right.
        }
        return p.parent.left;               // Otherwise return the left child.
    }

    /** Creates a binary tree and demonstrates ordered child access. */
    public static void main(String[] args) {
        Node<String> a = new Node<String>("A", null); // Root.
        Node<String> b = new Node<String>("B", a);    // Left child of A.
        Node<String> c = new Node<String>("C", a);    // Right child of A.
        a.left = b;  // The left position itself has meaning.
        a.right = c; // The right position itself has meaning.

        b.left = new Node<String>("D", b);  // left(B) = D.
        b.right = new Node<String>("E", b); // right(B) = E.

        System.out.println("left(A): " + a.left.element);
        System.out.println("right(A): " + a.right.element);
        System.out.println("sibling(B): " + sibling(b).element);
        System.out.println("left(B): " + b.left.element);
        System.out.println("right(B): " + b.right.element);

        Node<String> temporary = a.left; // Save B before overwriting its link.
        a.left = a.right;                // C moves to the left position.
        a.right = temporary;             // B moves to the right position.
        System.out.println("After swap left/right: "
                + a.left.element + "/" + a.right.element);
    }
}

/*
Expected output:
left(A): B
right(A): C
sibling(B): C
left(B): D
right(B): E
After swap left/right: C/B
*/
