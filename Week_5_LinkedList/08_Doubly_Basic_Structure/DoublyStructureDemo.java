/*
 * CONCEPT: A doubly linked node stores both previous and next references.
 *
 * The extra previous reference supports traversal in both directions. It uses
 * more memory per node than a singly linked list, but makes it possible to move
 * from a node directly to its predecessor.
 */
public class DoublyStructureDemo {

    private static class Node<E> {
        private E element;
        private Node<E> previous;
        private Node<E> next;

        public Node(E nodeElement, Node<E> previousNode, Node<E> nextNode) {
            element = nodeElement;
            previous = previousNode;
            next = nextNode;
        }
    }

    public static void main(String[] args) {
        Node<String> first = new Node<String>("A", null, null);
        Node<String> second = new Node<String>("B", first, null);
        Node<String> third = new Node<String>("C", second, null);

        // Complete the forward links after constructing the nodes.
        first.next = second;
        second.next = third;

        StringBuilder forward = new StringBuilder();
        Node<String> current = first;
        while (current != null) {
            if (forward.length() > 0) {
                forward.append(" ");
            }
            forward.append(current.element);
            current = current.next;
        }
        System.out.println("Forward: " + forward);

        StringBuilder backward = new StringBuilder();
        current = third;
        while (current != null) {
            if (backward.length() > 0) {
                backward.append(" ");
            }
            backward.append(current.element);
            current = current.previous;
        }
        System.out.println("Backward: " + backward);
    }
}

/*
Expected output:
Forward: A B C
Backward: C B A
*/
