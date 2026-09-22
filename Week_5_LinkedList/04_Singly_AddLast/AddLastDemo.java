/*
 * CONCEPT: A tail reference lets addLast() run in O(1) time.
 *
 * The old tail's next reference points to the new node, and tail moves to the
 * new node. In an empty list, both head and tail must point to the first node.
 */

class TailList<E> {
    private static class Node<E> {
        private E element;
        private Node<E> next;

        public Node(E nodeElement, Node<E> nextNode) {
            element = nodeElement;
            next = nextNode;
        }
    }

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public boolean isEmpty() {
        return size == 0;
    }

    public void addLast(E element) {
        // A last node always points to null in a singly linked list.
        Node<E> newest = new Node<E>(element, null);

        if (isEmpty()) {
            // There is no old tail. The new node is also the first node.
            head = newest;
        } else {
            // Link the old last node forward to the new last node.
            tail.next = newest;
        }

        tail = newest;
        size++;
    }

    @Override
    public String toString() {
        String result = "";
        Node<E> current = head;
        while (current != null) {
            result += current.element;
            result += current.next == null ? " -> null" : " -> ";
            current = current.next;
        }
        return result;
    }
}

public class AddLastDemo {

    public static void main(String[] args) {
        TailList<String> list = new TailList<String>();
        list.addLast("A");
        list.addLast("B");
        list.addLast("C");

        System.out.println(list);
    }
}

/*
Expected output:
A -> B -> C -> null
*/
