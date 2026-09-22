/*
 * CONCEPT: Delete a known node by reconnecting its two neighbors.
 *
 * Because the node stores previous and next references, deletion does not need
 * to search from the head for its predecessor. Reconnecting the links is O(1)
 * once the node to remove is known.
 */

class DeletionDoublyList<E> {
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

    public DeletionDoublyList() {
        header = new Node<E>(null, null, null);
        trailer = new Node<E>(null, header, null);
        header.next = trailer;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // Setup operation used to build the demonstration list.
    public void addLast(E element) {
        Node<E> predecessor = trailer.previous;
        Node<E> newest = new Node<E>(element, predecessor, trailer);
        predecessor.next = newest;
        trailer.previous = newest;
        size++;
    }

    private E remove(Node<E> node) {
        Node<E> predecessor = node.previous;
        Node<E> successor = node.next;

        // Bypass node in both directions.
        predecessor.next = successor;
        successor.previous = predecessor;
        size--;

        return node.element;
    }

    public E removeFirst() {
        return isEmpty() ? null : remove(header.next);
    }

    public E removeLast() {
        // trailer.previous finds the last real node immediately: O(1).
        return isEmpty() ? null : remove(trailer.previous);
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

public class DoublyDeletionDemo {

    public static void main(String[] args) {
        DeletionDoublyList<String> list =
                new DeletionDoublyList<String>();
        list.addLast("A");
        list.addLast("B");
        list.addLast("C");

        System.out.println("Removed first: " + list.removeFirst());
        System.out.println("Removed last: " + list.removeLast());
        System.out.println("Remaining: " + list);
    }
}

/*
Expected output:
Removed first: A
Removed last: C
Remaining: [B]
*/
