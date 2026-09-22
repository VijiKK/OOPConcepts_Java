/*
 * CONCEPT: Complete generic doubly linked list using sentinel nodes.
 *
 * header and trailer simplify boundary operations. The real first element is
 * header.next; the real last element is trailer.previous. In an empty list,
 * header.next == trailer and trailer.previous == header.
 */

class DoublyLinkedList<E> {
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

    public DoublyLinkedList() {
        header = new Node<E>(null, null, null);
        trailer = new Node<E>(null, header, null);
        header.next = trailer;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E first() {
        return isEmpty() ? null : header.next.element;
    }

    public E last() {
        return isEmpty() ? null : trailer.previous.element;
    }

    public void addFirst(E element) {
        addBetween(element, header, header.next);
    }

    public void addLast(E element) {
        addBetween(element, trailer.previous, trailer);
    }

    public E removeFirst() {
        return isEmpty() ? null : remove(header.next);
    }

    public E removeLast() {
        return isEmpty() ? null : remove(trailer.previous);
    }

    private void addBetween(E element,
            Node<E> predecessor, Node<E> successor) {
        Node<E> newest = new Node<E>(element, predecessor, successor);
        predecessor.next = newest;
        successor.previous = newest;
        size++;
    }

    private E remove(Node<E> node) {
        Node<E> predecessor = node.previous;
        Node<E> successor = node.next;
        predecessor.next = successor;
        successor.previous = predecessor;
        size--;
        return node.element;
    }

    public String forwardString() {
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

    public String backwardString() {
        StringBuilder result = new StringBuilder("[");
        Node<E> current = trailer.previous;
        while (current != header) {
            result.append(current.element);
            if (current.previous != header) {
                result.append(", ");
            }
            current = current.previous;
        }
        return result.append("]").toString();
    }
}

public class DoublyLinkedListDemo {

    public static void main(String[] args) {
        DoublyLinkedList<String> list = new DoublyLinkedList<String>();
        list.addFirst("B");
        list.addFirst("A");
        list.addLast("C");
        list.addLast("D");

        System.out.println("Forward: " + list.forwardString());
        System.out.println("Backward: " + list.backwardString());
        System.out.println("First/last: " + list.first() + "/" + list.last());
        System.out.println("Removed first: " + list.removeFirst());
        System.out.println("Removed last: " + list.removeLast());
        System.out.println("Remaining: " + list.forwardString());
        System.out.println("Size: " + list.size());
    }
}

/*
Expected output:
Forward: [A, B, C, D]
Backward: [D, C, B, A]
First/last: A/D
Removed first: A
Removed last: D
Remaining: [B, C]
Size: 2
*/
