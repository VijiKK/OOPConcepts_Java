/*
 * CONCEPT: removeLast() is O(n) in a singly linked list.
 *
 * tail points to the last node, but that node has no reference backward to its
 * predecessor. The method must walk from head until current.next == tail.
 */

class SinglyTailRemovalList<E> {
    private static class Node<E> {
        private E element;
        private Node<E> next;

        public Node(E nodeElement) {
            element = nodeElement;
            next = null;
        }
    }

    private Node<E> head;
    private Node<E> tail;
    private int size;
    private int lastTraversalSteps;

    public void addLast(E element) {
        Node<E> newest = new Node<E>(element);
        if (size == 0) {
            head = newest;
        } else {
            tail.next = newest;
        }
        tail = newest;
        size++;
    }

    public E removeLast() {
        lastTraversalSteps = 0;

        if (size == 0) {
            return null;
        }

        E removedElement = tail.element;

        if (size == 1) {
            // Removing the only node empties the list.
            head = null;
            tail = null;
        } else {
            Node<E> current = head;

            // Stop at the node immediately before tail.
            while (current.next != tail) {
                current = current.next;
                lastTraversalSteps++;
            }

            // current becomes the new tail and must point to null.
            current.next = null;
            tail = current;
        }

        size--;
        return removedElement;
    }

    public int getLastTraversalSteps() {
        return lastTraversalSteps;
    }

    public E last() {
        return size == 0 ? null : tail.element;
    }
}

public class RemoveLastDemo {

    public static void main(String[] args) {
        SinglyTailRemovalList<String> list =
                new SinglyTailRemovalList<String>();
        list.addLast("A");
        list.addLast("B");
        list.addLast("C");
        list.addLast("D");

        System.out.println("Removed: " + list.removeLast());
        System.out.println("New last: " + list.last());
        System.out.println("Forward traversal steps: "
                + list.getLastTraversalSteps());
    }
}

/*
Expected output:
Removed: D
New last: C
Forward traversal steps: 2
*/
