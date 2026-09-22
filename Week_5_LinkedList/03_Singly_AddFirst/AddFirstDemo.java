/*
 * CONCEPT: addFirst() creates a node before the current head in O(1) time.
 *
 * The new node's next reference points to the old head. Then head changes to
 * the new node. No traversal and no shifting are required.
 */

class FrontList<E> {
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

    public void addFirst(E element) {
        // The old head becomes the next node of the newly created node.
        head = new Node<E>(element, head);

        // Special case: the first node is simultaneously head and tail.
        if (size == 0) {
            tail = head;
        }

        size++;
    }

    public E first() {
        return size == 0 ? null : head.element;
    }

    public E last() {
        return size == 0 ? null : tail.element;
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

public class AddFirstDemo {

    public static void main(String[] args) {
        FrontList<String> list = new FrontList<String>();

        list.addFirst("C"); // Empty-list special case: head and tail are C.
        list.addFirst("B"); // B becomes head; C remains tail.
        list.addFirst("A"); // A becomes head.

        System.out.println(list);
        System.out.println("First: " + list.first());
        System.out.println("Last: " + list.last());
    }
}

/*
Expected output:
A -> B -> C -> null
First: A
Last: C
*/
