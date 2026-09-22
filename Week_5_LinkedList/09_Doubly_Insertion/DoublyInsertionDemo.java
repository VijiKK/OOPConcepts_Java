/*
 * CONCEPT: Insert between two known neighbors in a doubly linked list.
 *
 * Header and trailer are sentinel nodes. They store no user element but remove
 * many special cases: every real insertion has both a predecessor and a
 * successor, even when inserting at the front or back.
 */

class InsertionDoublyList<E> {
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

    private Node<E> header;
    private Node<E> trailer;
    private int size;

    public InsertionDoublyList() {
        header = new Node<E>(null, null, null);
        trailer = new Node<E>(null, header, null);
        header.next = trailer;
        size = 0;
    }

    private void addBetween(E element,
            Node<E> predecessor, Node<E> successor) {
        // The new node initially knows both neighboring nodes.
        Node<E> newest = new Node<E>(
                element, predecessor, successor);

        // Each neighbor must be updated to point back to the new node.
        predecessor.next = newest;
        successor.previous = newest;
        size++;
    }

    public void addFirst(E element) {
        // First real node belongs between header and the old first node.
        addBetween(element, header, header.next);
    }

    public void addLast(E element) {
        // Last real node belongs between the old last node and trailer.
        addBetween(element, trailer.previous, trailer);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        Node<E> current = header.next;
        while (current != trailer) {
            result.append(current.element);
            if (current.next != trailer) {
                result.append(", ");
            }
            current = current.next;
        }
        return result.append("]").toString();
    }
}

public class DoublyInsertionDemo {

    public static void main(String[] args) {
        InsertionDoublyList<String> list =
                new InsertionDoublyList<String>();
        list.addFirst("B");
        list.addFirst("A");
        list.addLast("C");

        System.out.println("After insertions: " + list);
    }
}

/*
Expected output:
After insertions: [A, B, C]
*/
